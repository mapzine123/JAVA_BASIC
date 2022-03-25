package org.un.alg;

public class AlgUtils {
    public static long start() {
        long start = System.currentTimeMillis();
        return start;
    }

    public static void end(long start) {
        start();
        long end = System.currentTimeMillis() - start;
        System.out.println("소요시간 : " + end * 0.001 + "초");
    }
}
