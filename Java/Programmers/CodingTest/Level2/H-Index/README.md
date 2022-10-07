H-Index
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747

<br>

### 풀이

논문 n 편 중, h 번 이상 인용된논문이 h 편 이상. => h >= (h번 이상 인용된 논문의 수)

~~~java
int total = citations.length;
Arrays.sort(citations);

for(int index = 0; index < total; index++) {
	int h = citations[index];
	int count = total - index;
	if (h >= count)
		return count;
}
~~~