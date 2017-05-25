package com.howtoprogram.junit5;


public class TranslatorEngine {

    public String tranlate(String text) {
        if (text != null && text.trim().length() == 0) {
            throw new IllegalArgumentException("Translated text must not be empty.");
        }
        if ("Hello".equalsIgnoreCase(text)) {
            return "Bonjour";

        } else if ("Yes".equalsIgnoreCase(text)) {
            return "Oui";

        } else if ("No".equalsIgnoreCase(text)) {
            return "Non";

        } else if ("Goodbye".equalsIgnoreCase(text)) {
            return "Au revoir";

        } else if ("Good night".equalsIgnoreCase(text)) {
            return "Bonne nuit";

        } else if ("Thank you".equalsIgnoreCase(text)) {
            return "Merci";
        } else {
            return "Not found";
        }
    }
}
