#!/bin/bash
CERTIFICATE_HOME_DIR=/usr/local/certificateGenerator
PATH=$PATH:$CERTIFICATE_HOME_DIR
export PATH
JVM_OPTION="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

function doCache()
{
  case "$1" in
      stat)
        java -jar $CERTIFICATE_HOME_DIR/certificate-generator.jar -cstat_cache
        ;;
      *)
    echo "Usage: $0 cache {stat}"
    ;;
  esac
}

case "$1" in
  start)
    echo "Starting certificate generator..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CERTIFICATE_HOME_DIR/cache" $CERTIFICATE_HOME_DIR/certificate-generator.jar -d"$CERTIFICATE_HOME_DIR">> $CERTIFICATE_HOME_DIR/log &
    ;;
  stop)
    echo "Stopping certificate generator"
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator.jar -cshutdown > /dev/null
    ;;
  cache)
    doCache $2
    ;;
  restart)
    echo "Stopping certificate generator..."
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator.jar -cshutdown > /dev/null;
    sleep 2;
    echo "Starting certificate generator..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CERTIFICATE_HOME_DIR/cache" $CERTIFICATE_HOME_DIR/certificate-generator.jar -d"$CERTIFICATE_HOME_DIR">> $CERTIFICATE_HOME_DIR/log &
    ;;
  *)
    echo "Usage: $0 {start|stop|reload|zones|config|restart|cache}"
    ;;
esac

exit 0
