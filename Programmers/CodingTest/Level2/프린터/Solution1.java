import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Doc {
		int priority;
		boolean loc;
		Doc(int priority, boolean loc) {
			this.priority =priority;
			this.loc =loc;
		}
	}

    public int solution(int[] priorities, int location) {
		int answer = 1;
		int len =priorities.length;
		Queue<Doc> queue =new LinkedList<>();

		for(int i =0; i <len; i++)
			queue.add(new Doc(priorities[i], location==i?true:false));

		while(true) {
			Doc output =queue.peek();
			Iterator<Doc> it = queue.iterator();
			boolean find =true;

			while(it.hasNext()) {
				if(it.next().priority >output.priority) {
					find =false;
					break;
				}
				
			}
			if(find) {
				if(output.loc)
					break;
				else {
					queue.poll();
					answer++;
				}
			}else {
				queue.poll();
				queue.add(output);
			}
		}
        return answer;
    }
}