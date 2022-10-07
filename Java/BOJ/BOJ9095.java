import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(this.getSumOf123(n)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private int getSumOf123(int n) {
        if (n == 0)
            return 1;
        int ret = 0;

        if (n - 1 > -1)
            ret += this.getSumOf123(n - 1);
        if (n - 2 > -1)
            ret += this.getSumOf123(n - 2);
        if (n - 3 > -1)
            ret += this.getSumOf123(n - 3);

        return ret;
    }

    public static void main(String[] args) {
        try {
            new Main().solution();
        } catch (Exception e) {
            System.out.println("solution exception");
        }
    }
}

