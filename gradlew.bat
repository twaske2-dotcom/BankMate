@echo off
set DIR=%~dp0
set WRAPPER_JAR=%DIR%gradle\wrapper\gradle-wrapper.jar

if not exist "%WRAPPER_JAR%" (
  echo gradle-wrapper.jar not found.
  echo Open this project in Android Studio and it will regenerate the wrapper automatically,
  echo or run: gradle wrapper --gradle-version 8.4
  exit /b 1
)

java -jar "%WRAPPER_JAR%" %*
