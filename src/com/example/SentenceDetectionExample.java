package com.example;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class SentenceDetectionExample {
    public static void main(String[] args) {
        try {
            // Load the sentence detection model
            InputStream modelIn = new FileInputStream("models/en-sent.bin");
            SentenceModel model = new SentenceModel(modelIn);
            
            // Initialize the sentence detector
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
            
            // Sample paragraph
            String paragraph = "Hello! This is a test. We are testing sentence detection.";
            
            // Detect sentences
            String[] sentences = sentenceDetector.sentDetect(paragraph);
            
            // Print the sentences
            for (String sentence : sentences) {
                System.out.println(sentence);
            }
            
            // Close the model input stream
            modelIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
