#!/bin/bash

# Navigate to the project directory
cd "$(dirname "$0")"

# Compile the Java source files
javac -d bin -cp "lib/*" src/com/example/*.java

# Run the application
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml -Dprism.order=sw -Dprism.verbose=true -cp "lib/*:bin" com.example.TextProcessorApp
