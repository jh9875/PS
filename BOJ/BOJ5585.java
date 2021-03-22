import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int money;

		money =Integer.parseInt(br.readLine());
		bw.write(getNumOfChange(1000 -money) +"\n");
		bw.flush();
	}

	static int getNumOfChange(int money) {
		int []coins ={500, 100, 50, 10, 5, 1};
		int ret =0, index =0;

		while(money !=0) {
			ret +=money /coins[index];
			money %=coins[index];

			if(index <6) ++index;
		}

		return ret;
	}

}