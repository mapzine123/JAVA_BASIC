package org.un.alg;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PointStar {
    private void solution1(int a, int b) {
        long start = AlgUtils.start();

        for(int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        AlgUtils.end(start);
    }

    private void solution2(int a, int b) {
        long start = AlgUtils.start();

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
        AlgUtils.end(start);
    }

    public static void main(String[] args) {
        PointStar ps = new PointStar();
//        ps.solution1(10000, 10000); // 소요시간 : 173초
        ps.solution2(10000, 10000); // 소요시간 : 1.192초
    }

}
