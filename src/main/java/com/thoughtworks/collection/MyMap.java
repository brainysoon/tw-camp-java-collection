package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream()
                .map(value -> value * 3)
                .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return this.array.stream()
                .map(index -> letters[index - 1])
                .collect(Collectors.toList());

    }

    public List<String> mapLetters() {
        return this.array.stream()
                .map(index -> {
                    int jumpIndex = index - 1;
                    String firstLetter = jumpIndex / 26 > 0 ? letters[jumpIndex / 26 - 1] : "";
                    String secondLetter = jumpIndex % 26 >= 0 ? letters[jumpIndex % 26] : "";
                    return firstLetter + secondLetter;
                })
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return this.array.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return this.array.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());
    }
}
