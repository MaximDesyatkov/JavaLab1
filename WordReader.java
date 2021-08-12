package ru.nsu.ccfit.desyatkov.lab1;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordReader {
    private int total;
    private FileReader in;
    private Map<String, Integer> words;

    WordReader(){
        words = new HashMap<>();
        total = 0;
    }

    Map<String, Integer> readAndCalc(FileReader in) throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = in.read()) != -1) {
            char cc = (char) c;
            if (Character.isLetterOrDigit(cc)) {
                sb.append(cc);
            } else if (sb.length() > 0) {
                words.compute(sb.toString(), (key, freq) -> freq == null ? 1 : freq + 1);
                sb.setLength(0);
                total++;
            }
        }
        if (sb.length() > 0) {
            words.compute(sb.toString(), (key, freq) -> freq == null ? 1 : freq + 1);
            total++;
        }
        return words;
    }
    int getTotal(){
        return total;
    }
}