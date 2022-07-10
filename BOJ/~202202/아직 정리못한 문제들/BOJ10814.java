import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static class Member implements Comparable<Member> {
		int order;
		int age;
		String name;

		public Member(int order, int age, String name) {
			this.order = order;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Member m) {
			if (this.age == m.age) {
				return Integer.compare(this.order, m.order);
			} else {
				return Integer.compare(this.age, m.age);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Member[] members = new Member[N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int age = Integer.parseInt(input[0]);
			String name = input[1];

			members[i] = new Member(i, age, name);
		}

		printOrderedMembers(members);
	}

	private static void printOrderedMembers(Member[] members) {
		Arrays.sort(members);

		StringBuilder sb = new StringBuilder();

		for (Member member : members) {
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}

		System.out.println(sb.toString());
	}

}