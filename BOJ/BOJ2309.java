import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfArray = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            dwarfArray[i] = Integer.parseInt(br.readLine());
            sum += dwarfArray[i];
        }

        this.markFakeDwarf(dwarfArray, sum);
        this.printSortedDwarfArray(dwarfArray);
    }

    /**
     * 9명의 난쟁이 중 진짜 난쟁이가 아닌 2명의 난쟁이의 키를 -1로 표시한다.
     * <p>
     * 를param dwarfArray
     *
     * @param sum
     */
    private void markFakeDwarf(int[] dwarfArray, int sum) {
        boolean isFound = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwarfArray[i] - dwarfArray[j] == 100) {
                    dwarfArray[i] = -1;
                    dwarfArray[j] = -1;
                    isFound = true;
                    break;
                }
            }
            if (isFound)
                break;
        }
    }

    /**
     * 정렬된 진짜 난쟁이들의 키를 출력한다.
     *
     * @param dwarfArray
     */
    private void printSortedDwarfArray(int[] dwarfArray) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(dwarfArray);

        for (int i = 2; i < 9; i++) {
            sb.append(dwarfArray[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        try {
            new Main().solution();
        } catch (Exception e) {
            System.out.println("solution exception");
        }
    }
}


