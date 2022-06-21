package zadanie5;

import java.util.ArrayList;

public class calc {
    Item item = new Item();

    public void calcult(){
        int count = item.getWeights().length;
        int[][] A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[Safe.getMaxWeight() + 1];
        }

        for (int k = 0; k <= count; k++) {
            for (int s = 0; s <= Safe.getMaxWeight(); s++) {
                if (k == 0 || s == 0) {
                    A[k][s] = 0;
                } else {
                    if (s >= item.getWeights()[k - 1]) {
                        A[k][s] = Math.max(A[k - 1][s], A[k - 1][s - item.getWeights()[k - 1]] + item.getPrices()[k - 1]);
                    } else {
                        A[k][s] = A[k - 1][s];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        Result(A, item.getWeights(), count, Safe.getMaxWeight(), result);

        System.out.println("Оптимальное содержимое сейфа:");
        for(Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void Result(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k -1][s] == A[k][s]) {
            Result(A, weight, k - 1, s, result);
        } else {
            Result(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }

}

