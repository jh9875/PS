import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ;i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ;i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(this.getReslut(arrayA, arrayB, n));

        br.close();
    }

    private int getReslut(int[] arrayA, int[] arrayB, int n) {
        int result = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        for (int i = 0; i < n; i++) {
            result += arrayA[i] * arrayB[n - 1 - i];
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

