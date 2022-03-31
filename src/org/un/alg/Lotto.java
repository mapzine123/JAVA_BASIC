package org.un.alg;

import java.util.Arrays;

public class Lotto {
    public int[] solution(int[] lottos, int[] winNums) {
        int zero = 0;
        int matched = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            } else {
                for (int winNum : winNums) {
                    if (lotto == winNum) {
                        matched++;
                        break;
                    }
                }
            }
        }

        int min = matched;
        int max = matched + zero;

        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        return answer;
    }
}