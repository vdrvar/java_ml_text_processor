@echo off

REM Navigate to the project directory
cd %~dp0

REM Compile the Java source files
javac -d bin -cp "lib/*" src/com/example/*.java

REM Run the application
java --module-path "C:\path\to\your\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -Dprism.order=sw -Dprism.verbose=true -cp "lib/*;bin" com.example.TextProcessorApp
