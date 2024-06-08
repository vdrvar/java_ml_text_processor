package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class TextProcessorApp extends Application {

    private TextArea inputArea;
    private TextArea outputArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java ML Text Processor");

        // Input area
        inputArea = new TextArea();
        inputArea.setPromptText("Enter text here...");

        // Output area
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Buttons
        Button tokenizeButton = new Button("Tokenize");
        tokenizeButton.setOnAction(e -> tokenizeText());

        Button sentenceDetectButton = new Button("Detect Sentences");
        sentenceDetectButton.setOnAction(e -> detectSentences());

        Button posTagButton = new Button("POS Tagging");
        posTagButton.setOnAction(e -> posTagging());

        Button nerButton = new Button("NER");
        nerButton.setOnAction(e -> namedEntityRecognition());

        Button exportButton = new Button("Export Results");
        exportButton.setOnAction(e -> exportResults(primaryStage));

        // Layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(
                new Label("Input Text:"),
                inputArea,
                tokenizeButton,
                sentenceDetectButton,
                posTagButton,
                nerButton,
                exportButton,
                new Label("Output:"),
                outputArea
        );

        Scene scene = new Scene(vbox, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void tokenizeText() {
        try {
            InputStream modelIn = new FileInputStream("models/en-token.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            TokenizerME tokenizer = new TokenizerME(model);

            String text = inputArea.getText();
            String[] tokens = tokenizer.tokenize(text);

            outputArea.clear();
            for (String token : tokens) {
                outputArea.appendText(token + "\n");
            }

            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void detectSentences() {
        try {
            InputStream modelIn = new FileInputStream("models/en-sent.bin");
            SentenceModel model = new SentenceModel(modelIn);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);

            String text = inputArea.getText();
            String[] sentences = sentenceDetector.sentDetect(text);

            outputArea.clear();
            for (String sentence : sentences) {
                outputArea.appendText(sentence + "\n");
            }

            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void posTagging() {
        try {
            InputStream modelIn = new FileInputStream("models/en-pos-maxent.bin");
            POSModel model = new POSModel(modelIn);
            POSTaggerME posTagger = new POSTaggerME(model);

            String text = inputArea.getText();
            String[] tokens = text.split("\\s+");
            String[] tags = posTagger.tag(tokens);

            outputArea.clear();
            for (int i = 0; i < tokens.length; i++) {
                outputArea.appendText(tokens[i] + " - " + tags[i] + "\n");
            }

            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void namedEntityRecognition() {
        try {
            InputStream modelIn = new FileInputStream("models/en-ner-person.bin");
            TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
            NameFinderME nameFinder = new NameFinderME(model);

            String text = inputArea.getText();
            String[] tokens = text.split("\\s+");
            Span[] names = nameFinder.find(tokens);

            outputArea.clear();
            for (Span name : names) {
                outputArea.appendText("Name: " + name.toString() + ", Entity: "
                        + String.join(" ", java.util.Arrays.copyOfRange(tokens, name.getStart(), name.getEnd())) + "\n");
            }

            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exportResults(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Results");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                out.print(outputArea.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
