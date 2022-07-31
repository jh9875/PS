import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 100000;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);     // 수빈이의 위치
        final int K = Integer.parseInt(input[1]);     // 동생의 위치

        System.out.println(this.getMinimumTimeOfFindBrother(N, K));

        br.close();
    }

    private int getMinimumTimeOfFindBrother(final int SUBIN_START_POS, final int BROTHER_POS) {
        int ret = Integer.MAX_VALUE;
        int[] visitCount = new int[MAX_POSITION + 1];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(SUBIN_START_POS);
        visitCount[SUBIN_START_POS] = 1; // 시작 위치를 다시 찾아갈 수 있기 때문에 1로 설정.

        while (!queue.isEmpty()) {
            int curPos = queue.poll();

            if (curPos == BROTHER_POS) {
                ret = visitCount[curPos] - 1;
                break;
            }
            int[] nextPositions = this.getNextPositions(curPos);
            for (int nextPos : nextPositions) {
                if (isInRange(nextPos) && visitCount[nextPos] == 0) {
                    visitCount[nextPos] = visitCount[curPos] + 1;
                    queue.add(nextPos);
                }
            }
        }

        return ret;
    }

    private int[] getNextPositions(int pos) {
        int[] nextPositions = new int[3];

        nextPositions[0] = pos - 1;
        nextPositions[1] = pos + 1;
        nextPositions[2] = pos * 2;

        return nextPositions;
    }

    private boolean isInRange(int pos) {
        if (MIN_POSITION <= pos && pos <= MAX_POSITION)
            return true;
        return false;
    }

    public static void main(String[] args) {
        try {
            new Main().solution();
        } catch (Exception e) {
            System.out.println("solution exception");
        }
    }
}

