평균 점수
===

문제 링크 : https://www.acmicpc.net/problem/10039

<br>

### 풀이

문제는 점수가 40미만인 수들을 40으로 바꾸고 계산하면 된다.

파이썬을 처음 배우는 입장에서 삼항연산자(?:)가 있는지 찾아봤다.

찾아보니 파이썬에선 삼항연산자가 존재하지 않고 다음과 같은 형식으로 사용한다고 한다.

> [true_value] if [condition] else [false_value]

표현이 영어식 표현이라고 하는데 그런것 같기도 하고.. 아직은 익숙하지 않지만 자주 사용할 것 같다.

```Python
import sys

score_sum = 0

for i in range(5):
    score = int(sys.stdin.readline())
    score_sum += score if score > 40 else 40

print(score_sum // 5)

```