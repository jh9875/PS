import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        String result = new StringBuilder()
                .append(this.getRemainder1(a, b, c)).append("\n")
                .append(this.getRemainder2(a, b, c)).append("\n")
                .append(this.getRemainder3(a, b, c)).append("\n")
                .append(this.getRemainder4(a, b, c)).append("\n")
                .toString();
        System.out.println(result);
        br.close();
    }

    private int getRemainder1(int a, int b, int c) {
        return (a + b) % c;
    }

    private int getRemainder2(int a, int b, int c) {
        return ((a % c) + (b % c)) % c;
    }

    private int getRemainder3(int a, int b, int c) {
        return (a * b) % c;
    }

    private int getRemainder4(int a, int b, int c) {
        return ((a % c) * (b % c)) % c;
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
