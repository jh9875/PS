import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Document {
		int index;
		int priority;

		Document(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public int solution(int[] priorities, int location) {
		Queue<Document> documentQueue = getDocumentQueue(priorities);
		int answer = 0;

		while (!documentQueue.isEmpty()) {
			Document nowDocument = documentQueue.peek();
			int maxPriority = maxValueInQueue(documentQueue);

			if (nowDocument.priority == maxPriority) {
				documentQueue.poll();
				answer++;
				if (nowDocument.index == location)
					break;
			} else {
				documentQueue.add(documentQueue.poll());
			}
		}

		return answer;
	}

	public Queue<Document> getDocumentQueue(int[] priorities) {
		Queue<Document> queue = new LinkedList<>();
		int prioritiesLen = priorities.length;

		for (int i = 0; i < prioritiesLen; i++) {
			queue.add(new Document(i, priorities[i]));
		}

		return queue;
	}

	public int maxValueInQueue(Queue<Document> queue) {
		int max = 0;
		Iterator<Document> it = queue.iterator();

		while (it.hasNext()) {
			int priority = it.next().priority;
			if (priority > max)
				max = priority;
		}

		return max;
	}
}