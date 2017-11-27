#!/bin/bash
CERTIFICATE_HOME_DIR=/usr/local/certificateGenerator
PATH=$PATH:$CERTIFICATE_HOME_DIR
export PATH
JVM_OPTION="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

case "$1" in
  start)
    echo "Starting certificate generator..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CERTIFICATE_HOME_DIR/cache" $CERTIFICATE_HOME_DIR/certificate-generator.jar -d"$CERTIFICATE_HOME_DIR">> $CERTIFICATE_HOME_DIR/log &
    echo $! > $CERTIFICATE_HOME_DIR/pid
    ;;
  stop)
    echo "Stopping certificate generator"
    PID=$(cat $CERTIFICATE_HOME_DIR/pid)
    kill -9 $PID
    ;;
  restart)
    echo "Stopping certificate generator..."
    PID=$(cat $CERTIFICATE_HOME_DIR/pid)
    kill -9 $PID
    sleep 2;
    echo "Starting certificate generator..."
    java -jar ${JVM_OPTION} -Djava.io.tmpdir="$CERTIFICATE_HOME_DIR/cache" $CERTIFICATE_HOME_DIR/certificate-generator.jar -d"$CERTIFICATE_HOME_DIR">> $CERTIFICATE_HOME_DIR/log &
    echo $! > $CERTIFICATE_HOME_DIR/pid
    ;;
  *)
    echo "Usage: $0 {start|stop|restart}"
    ;;
esac

exit 0
