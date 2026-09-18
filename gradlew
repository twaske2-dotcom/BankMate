#!/bin/sh
##############################################################################
# Gradle start up script for UN*X
##############################################################################
DIR="$(cd "$(dirname "$0")" && pwd)"
GRADLE_WRAPPER_JAR="$DIR/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
  echo "gradle-wrapper.jar not found."
  echo "Open this project in Android Studio and it will regenerate the wrapper automatically,"
  echo "or run: gradle wrapper --gradle-version 8.4"
  exit 1
fi

exec java -jar "$GRADLE_WRAPPER_JAR" "$@"
