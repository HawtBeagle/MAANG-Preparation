package com.codingshuttle.doubts.Doubts;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExplore {

    static List<Integer> l = Arrays.asList(4,6,2,8,10,1,42,65,23,null,null);
    static Stream<Integer> data = l.stream()
            .filter(Objects::nonNull);



    public static void print() {
        data.forEach(num -> System.out.println(num));
    }
}
