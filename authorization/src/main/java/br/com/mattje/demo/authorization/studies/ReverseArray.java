package br.com.mattje.demo.authorization.studies;

import java.util.Arrays;
import java.util.List;

public class ReverseArray {

    public static List<Integer> reverse (List<Integer> a) {
        int listSize = a.size();
        int middle = listSize / 2;
        List<Integer> reversed = Arrays.asList(new Integer[listSize]);
        for (int i = 0; i < middle; i++) {
            reversed.set(i, a.get(listSize - 1 - i));
            reversed.set(listSize - 1 - i, a.get(i));
        }
        reversed.set(middle, a.get(listSize - 1 - middle));
        return reversed;
    }

    public static void main(String[] args) {
        reverse(List.of(5833, 9919, 6731)).forEach(System.out::println);
    }

}
