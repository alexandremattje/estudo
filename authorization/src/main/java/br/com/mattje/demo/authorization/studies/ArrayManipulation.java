package br.com.mattje.demo.authorization.studies;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 2];

        for (List<Integer> query: queries) {
            int start = query.get(0);
            int end = query.get(1);
            int value = query.get(2);
            int middle = (start + end) / 2;
            int pos = middle - start;

            for (int i = 0; i < pos; i++) {
                arr[i + start] = arr[i + start] + value;
                arr[i + middle] = arr[i + middle] + value;
            }
            arr[end] = arr[end] + value;
        }
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            List<List<Integer>> queries = new ArrayList<>();

            IntStream.range(0, m).forEach(i -> {
                try {
                    queries.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            long result = arrayManipulation(n, queries);

            System.out.println(result);
            bufferedReader.close();

    }
}
