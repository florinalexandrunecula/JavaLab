package intermediaryops;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Ex1 {

    public static void main(String[] args) {
        // limit, filter, skip, distinct, sorted, peek, map, flatmap

        IntStream is1 = IntStream.rangeClosed(1, 10)
                .skip(7);
        is1.forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 1, 4, 1, 2, 2, 3, 3);
        integers.stream().distinct().forEach(System.out::println);

        integers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
