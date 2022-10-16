네 번째 점
===

문제 링크 : https://www.acmicpc.net/problem/3009

<br>

### 풀이

네 좌표가 정사각형이 되려면 평행해야되니까 좌표 값이 일치하는 값이 나온다.

x, y 각 좌표값의 모임을 set으로 만들고, 남은 수를 좌표 값으로 사용하도록 했다.

```Python

x_set = set()
y_set = set()

for i in range(3):
    x, y = map(int, sys.stdin.readline().split())
    if x in x_set:
        x_set.remove(x)
    else:
        x_set.add(x)
    if y in y_set:
        y_set.remove(y)
    else:
        y_set.add(y)

print(x_set.pop(), y_set.pop())

```