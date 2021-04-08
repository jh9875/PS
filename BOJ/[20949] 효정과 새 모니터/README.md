효정과 새 모니터
===

문제 링크 : https://www.acmicpc.net/problem/20949

<br>

### 풀이

모든 모니터의 크기는 77인치로 동일.

W^2 + H^2의 크기 순으로 정렬해야함.

~~~java
static class Monitor implements Comparable<Monitor> {
	int index;
	long ppi;

	Monitor(int index, long ppi) {
		this.index = index;
		this.ppi = ppi;
	}

	@Override
	public int compareTo(Monitor m) {
		if (this.ppi == m.ppi) {
			return this.index - m.index;
		} else {
			return (int) (m.ppi - this.ppi);
		}
	}
}
~~~

Comparable을 이요해서 ppi 크기가 같은 경우는 모니터 번호가 작은 것 순으로 정렬되게 함.