거스름돈
===

문제 링크 : https://www.acmicpc.net/problem/5585

<br>

### 풀이

이 문제는 문제에 특정한 조건때문에 그리디 알고리즘을 사용할 수 있었다.

일단 잔돈을 줘야할 때 동전의 수를 최소한으로 해야하므로 큰 동전부터 줘야하는 규칙이 있다.

그리고 동전들이 500, 100, 50, 5, 1 이런식으로 다음수가 이전 수의 배수이므로 사용할 수 있었다.

```Python
changes = [500, 100, 50, 10, 5, 1]

rest = 1000 - int(input())
ans = 0

for change in changes:
    ans += rest // change
    rest %= change

print(ans)

```