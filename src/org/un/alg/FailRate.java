package org.un.alg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    n : 스테이지 갯수
    stages : 현재 유저들이 플레이하고 있는 stage 번호
*/

public class FailRate {
    public int[] solotion1(int n, int[] lastStages) {
        int nPlayers = lastStages.length; // 플레이어 수
        int[] nStagePlayers = new int[n + 2];
        for(int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<Stage>();
        for(int id = 1; id <= n; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id, double failure) {
            this.id = id;
            this.failure = failure;
        }
        @Override
        public int compareTo(Stage o) {
            if(failure < o.failure) {
                return -1;
            } else if(failure > o.failure) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[] solution(int n, int[] stages) {
        int[] answer = new int[n];
        double[] stage = new double[n + 1];

        for(int i : stages) {
            if(i == n + 1) {
                continue;
            }
            stage[i]++;
        }

        ArrayList<Double> fail = new ArrayList<Double>();

        double num = stages.length;
        double temp = 0;

        for(int i = 1; i < stage.length; i++) {
            temp = stage[i];
            if(num == 0) {
                stage[i] = 0;
            } else {
                stage[i] = stage[i] / num;
                num = num - temp;
            }
            fail.add(stage[i]);
        }

        Collections.sort(fail, Collections.reverseOrder());

        for(int i = 0; i < fail.size(); i++) {
            for(int j = 1; j < stage.length; j++) {
                if(fail.get(i) == stage[j]) {
                    answer[i] = j;
                    stage[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
