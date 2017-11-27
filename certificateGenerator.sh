#!/bin/bash
CERTIFICATE_HOME_DIR=/usr/local/certificateGenerator
PATH=$PATH:$CERTIFICATE_HOME_DIR
export PATH
JVM_OPTION="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

function doCache()
{
  case "$1" in
      stat)
        java -jar $CERTIFICATE_HOME_DIR/certificate-generator-v1.0.5.jar -cstat_cache
        ;;
      *)
    echo "Usage: $0 cache {stat}"
    ;;
  esac
}

case "$1" in
  start)
    echo "Starting certificate generator..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CERTIFICATE_HOME_DIR/cache" $CERTIFICATE_HOME_DIR/DNSBrood.jar -d"$CERTIFICATE_HOME_DIR">> $CERTIFICATE_HOME_DIR/log &
    ;;
  stop)
    echo "Stopping DNSBrood"
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator-v1.0.5.jar -cshutdown > /dev/null
    ;;
  cache)
    doCache $2
    ;;
  restart)
    echo "Stopping DNSBrood..."
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator-v1.0.5.jar -cshutdown > /dev/null;
    sleep 2;
    echo "Starting DNSBrood..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CERTIFICATE_HOME_DIR/cache" $CERTIFICATE_HOME_DIR/DNSBrood.jar -d"$CERTIFICATE_HOME_DIR">> $CERTIFICATE_HOME_DIR/log &
    ;;
  reload)
    echo "Reloading DNSBrood"
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator-v1.0.5.jar -creload > /dev/null
    ;;
  zones)
    vi $CERTIFICATE_HOME_DIR/config/zones
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator-v1.0.5.jar -creload > /dev/null
    ;;
  config)
    vi $CERTIFICATE_HOME_DIR/config/DNSBrood.conf
    java -jar $CERTIFICATE_HOME_DIR/certificate-generator-v1.0.5.jar -creload > /dev/null
    ;;
  *)
    echo "Usage: $0 {start|stop|reload|zones|config|restart|cache}"
    ;;
esac

exit 0
