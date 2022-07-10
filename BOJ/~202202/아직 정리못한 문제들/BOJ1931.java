import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class MeetingInfo implements Comparable<MeetingInfo> {
		int start, end;
		MeetingInfo(int start, int end) {
			this.start =start;
			this.end =end;
		}
		@Override
		public int compareTo(MeetingInfo m) {
			if(this.end == m.end)
				return this.start-m.start;
			else
				return this.end -m.end;
		}
	}
	
	static int N;
	static MeetingInfo[] meetings;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N =Integer.parseInt(br.readLine());
		meetings =new MeetingInfo[N];
		for(int i =0; i <N; ++i) {
			st =new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());
			meetings[i] =new MeetingInfo(start, end);
		}
		
		bw.write(solve() +"\n");
		bw.flush();
	}

	//회의가 빨리 끝나는 순으로 정렬 후 배정
	static int solve() {
		int ret =0;
		int lastEndPoint =0;

		Arrays.sort(meetings);
		for(int i =0; i <N; ++i) {
			if(meetings[i].start >=lastEndPoint) {
				++ret;
				lastEndPoint =meetings[i].end;
			}
		}
		return ret;
	}


}
