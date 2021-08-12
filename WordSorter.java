package ru.nsu.ccfit.desyatkov.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordSorter {
    private List<Map.Entry<String, Integer>> list;
    List<Map.Entry<String, Integer>> getSortedList(Map<String, Integer> words) {
        list = new ArrayList<>(words.entrySet());
        list.sort((a, b) -> {
            int rs = b.getValue().compareTo(a.getValue());
            if (rs == 0) {
                rs = b.getKey().compareTo(a.getKey());
            }
            return rs;
        });
        return list;
    }
}