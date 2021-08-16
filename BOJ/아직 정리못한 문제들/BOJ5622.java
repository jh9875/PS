import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		String input = br.readLine();
		for(int i = 0, length = input.length(); i < length; i++) {
			sum += convertChToInt(input.charAt(i));
		}
		bw.write(sum + "\n");
		bw.flush();
	}

	private static int convertChToInt(char ch) {
		if(ch == 'A' || ch == 'B' || ch == 'C')
			return 3;
		else if(ch == 'D' || ch == 'E' || ch == 'F')
			return 4;
		else if(ch == 'G' || ch == 'H' || ch == 'I')
			return 5;
		else if(ch == 'J' || ch == 'K' || ch == 'L')
			return 6;
		else if(ch == 'M' || ch == 'N' || ch == 'O')
			return 7;
		else if(ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S')
			return 8;
		else if(ch == 'T' || ch == 'U' || ch == 'V')
			return 9;
		else if(ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z')
			return 10;
		return 0;
	}
}
