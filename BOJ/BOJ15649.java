import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        System.out.println(this.getNAndM1Result(N, M, 0, new int[M + 1], new boolean[N + 1]));
        br.close();
    }

    private String getNAndM1Result(int N, int M, int depth, int[] checkedOrder, boolean[] isChecked) {
        if (depth == M) {
            return this.getSeqLetters(checkedOrder);
        }
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                checkedOrder[depth + 1] = i;
                result.append(this.getNAndM1Result(N, M, depth + 1, checkedOrder, isChecked));
                isChecked[i] = false;
            }
        }

        return result.toString();
    }

    private String getSeqLetters(int[] checkedOrder) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1, length = checkedOrder.length - 1; i <= length; i++) {
            sb.append(checkedOrder[i]).append(" ");
        }

        sb.append("\n");

        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            new Main().solution();
        } catch (Exception e) {
            System.out.println("solution exception");
        }
    }
}

