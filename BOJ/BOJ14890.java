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
				if(Math.abs(prev-now) !=1) return false;		//���̰� 1�� �ƴϸ� ����
				if(set[i]) return false;						//�̹� ���ΰ� ��ġ �Ǿ� �ִ� ���.

				if(prev <now) {									//���� ������ ���� ������
					if(i-L <0) return false;					//���θ� ���� �� ���� ���

					for(int j =i-1; j >=i-L; --j) {
						if(prev !=path.get(j) || set[j]) return false;	
						set[j] =true;
					}
				}else if(prev >now) {							//���� ������ ���� ������
					if(i+L >N) return false;					//���θ� ���� �� ���� ���

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
