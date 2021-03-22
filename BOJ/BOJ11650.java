import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point> {
		int x, y;

		Point(int x, int y) {
			this.x =x;
			this.y =y;
		}

		@Override
		public int compareTo(Point p) {
			if(this.x ==p.x)
				return this.y -p.y;
			else
				return this.x -p.x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		Point[] points;

		N =Integer.parseInt(br.readLine());
		points =new Point[N];
		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			points[i] =new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(points);
		
		for(Point p : points)
			bw.write(p.x + " " +p.y +"\n");
		bw.flush();
	}
}
