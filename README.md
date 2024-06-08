# java_ml_text_processor

This project demonstrates text processing capabilities using Apache OpenNLP and JavaFX, featuring a simple interactive GUI for educational purposes. The application performs tokenization, sentence detection, part-of-speech tagging, and named entity recognition, showcasing basic NLP techniques with machine learning models.

## Features
- **Tokenization:** Splits text into individual tokens (words).
- **Sentence Detection:** Identifies and separates sentences within the text.
- **Part-of-Speech Tagging:** Tags each token with its corresponding part of speech.
- **Named Entity Recognition (NER):** Detects and labels named entities (such as people, organizations, etc.).
- **Export Results:** Allows users to export processed text or results to a local file.

## Setup Instructions

### Prerequisites
- Java 8 or higher
- JavaFX SDK
- Apache OpenNLP library

### Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/java_ml_text_processor.git
   cd java_ml_text_processor

   Set Up JavaFX:

2. **Set Up Apache OpenNLP:**
   - Download the Apache OpenNLP library from Apache OpenNLP.
   - Add the OpenNLP library to your project’s build path.

3. **Download OpenNLP Models:**
   - Tokenizer model: en-token.bin
   - Sentence detection model: en-sent.bin
   - Part-of-speech tagging model: en-pos-maxent.bin
   - Named entity recognition model: en-ner-person.bin

4. **Add OpenNLP Models to Your Project:**
   - Place the downloaded model files in the appropriate directory within your project.

5. **Run the Application:**
   - Run the Main class to start the application.

6. **Usage:**
   - Enter text in the input area and click "Process Text" to see the results.
   - Processed results will appear in the output area.
   - Results can be exported to a file named results.txt.

7. **License**
   - This project is licensed under the MIT License.
