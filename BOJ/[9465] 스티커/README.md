스티커
===

문제 링크 : https://www.acmicpc.net/problem/9465

<br>

### 풀이

어떤 열에있는 스티커를 뜯으면 인접한 스티커는 사용하지 못하므로 대각선에있는 스티커를 뜯어야한다.

아니면 해당 열에 있는 스티커를 뜨지 않으면 된다.

~~~java
cache[row][col] = Math.max(search((row + 1) % 2, col + 1) + sticker[row][col],
				Math.max(search(row, col + 1), search((row + 1) % 2, col + 1)))
~~~

현재 스티커 기준으로 대각선 스티커를 뽑거나, 해당 열은 건너 뛰거나