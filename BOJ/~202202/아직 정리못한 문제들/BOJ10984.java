import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int totalCredit = 0;
			double totalGrade = 0.0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int credit = Integer.parseInt(st.nextToken());
				double grade = Double.parseDouble(st.nextToken());
				
				totalCredit += credit;
				totalGrade +=credit * grade;
			}
			totalGrade /= totalCredit;
			bw.write(totalCredit + " " + String.format("%.1f", totalGrade) + "\n");
		}
		bw.flush();
	}

}
