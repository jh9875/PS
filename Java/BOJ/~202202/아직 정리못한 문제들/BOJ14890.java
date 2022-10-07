import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, L;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		L =Integer.parseInt(st.nextToken());
		map =new int[N][N];

		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			for(int j =0; j <N; ++j) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}

		bw.write(getNumOfPath() +"\n");
		bw.flush();
	}

	static int getNumOfPath() {
		int ret =0;

		for(int i =0; i <N; ++i) {
			List<Integer> list1 =new ArrayList<>();
			List<Integer> list2 =new ArrayList<>();

			for(int j =0; j <N; ++j) {
				list1.add(map[i][j]);
				list2.add(map[j][i]);
			}
			if(isPath(list1)) ++ret;
			if(isPath(list2)) ++ret;
		}

		return ret;
	}

	static boolean isPath(List<Integer> path) {
		boolean[] set =new boolean[N];
		int prev =path.get(0);
		
		for(int i =1; i <N; ++i) {
			int now =path.get(i);

			if(prev !=now) {
				if(Math.abs(prev-now) !=1) return false;		//차이가 1이 아니면 실패
				if(set[i]) return false;						//이미 경사로가 설치 되어 있는 경우.

				if(prev <now) {									//낮은 곳에서 높은 곳으로
					if(i-L <0) return false;					//경사로를 놓을 수 없는 경우

					for(int j =i-1; j >=i-L; --j) {
						if(prev !=path.get(j) || set[j]) return false;	
						set[j] =true;
					}
				}else if(prev >now) {							//높은 곳에서 낮은 곳으로
					if(i+L >N) return false;					//경사로를 놓을 수 없는 경우

					for(int j =i; j <i+L; ++j) {
						if(now !=path.get(j) || set[j]) return false;
						set[j] =true;
					}
					
				}
				prev =now;
			}
		}

		return true;
	}
}
