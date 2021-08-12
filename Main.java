package ru.nsu.ccfit.desyatkov.lab1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1 || args.length == 2) {
            try (FileReader in = new FileReader(args[0])) {
                WordReader wr = new WordReader();
                WordSorter ws = new WordSorter();
                CSVwriter cw = new CSVwriter();
                if (args.length == 2) {
                    FileWriter out = new FileWriter(args[1]);
                    cw.writeToFile(out, ws.getSortedList((wr.readAndCalc(in))), wr.getTotal());
                    out.close();
                } else {
                    cw.writeToFile(ws.getSortedList((wr.readAndCalc(in))), wr.getTotal());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}