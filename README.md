# Java ML Text Processor

This project demonstrates text processing capabilities using Apache OpenNLP and JavaFX, featuring a simple interactive GUI for educational purposes. The application performs tokenization, sentence detection, part-of-speech tagging, and named entity recognition, showcasing basic NLP techniques with machine learning models.

## Features

- **Tokenization**: Splits text into individual tokens (words).
- **Sentence Detection**: Identifies and separates sentences within the text.
- **Part-of-Speech Tagging**: Tags each token with its corresponding part of speech.
- **Named Entity Recognition (NER)**: Detects and labels named entities (such as people, organizations, etc.).
- **Export Results**: Allows users to export processed text or results to a local file.

## Prerequisites

- Java 17 or higher
- JavaFX SDK 22.0.1
- Apache OpenNLP library

## Setup Instructions

### Step 1: Clone the Repository

```bash
git clone https://github.com/vdrvar/java_ml_text_processor.git
cd java_ml_text_processor
```

### Step 2: Set Up JavaFX
Download the JavaFX SDK from [Gluon](https://gluonhq.com/products/javafx/) and place it in your preferred directory. Ensure the necessary environment variables are set if needed.


### Step 3: Run the Application

#### Using the Shell Script (Linux/macOS)
1. Make the script executable:
```bash
chmod +x run.sh
```
2. Run the script:
```bash
./run.sh
```
#### Using the Batch Script (Windows)
1. Run the batch script:
```bash
run.bat
```

This will compile the Java source files and then run the application.

## Setup Instructions

## Usage
### Input Text
Enter the text you want to process in the input area.

### Tokenize
Click the Tokenize button to split the input text into individual tokens.

### Detect Sentences
Click the Detect Sentences button to identify and separate sentences within the input text.

### POS Tagging
Click the POS Tagging button to tag each token with its corresponding part of speech.

### NER
Click the NER button to detect and label named entities in the input text.

### Export Results
Click the Export Results button to save the processed results to a file.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Apache OpenNLP](https://opennlp.apache.org/)
- [JavaFX](https://openjfx.io/)
- [SLF4J](http://www.slf4j.org/)

