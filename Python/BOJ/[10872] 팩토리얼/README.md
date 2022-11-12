팩토리얼
===

문제 링크 : https://www.acmicpc.net/problem/10872

<br>

### 풀이

반복문으로 1부터 n까지 곱하면 해결할 수 있는 문제이다.

```Python
import math

n = int(input())

ans = 1

for i in range(1, n + 1):
    ans *= i;

print(ans)

```

뭔가 파이썬에 내장함수로 팩토리얼을 계산하는것이 있을것 같아서 math 라이브러리를 찾아봤다.

역시나 있었다. 그래서 사용해봤는데..

```Python
import math

n = int(input())

print(math.factorial(n))

```

결과가 좀 이상했다..

반복문으로 제출했던 코드가 걸린 시간이 68ms라면 math.factorial로 제출했던 코드는 100ms가 나왔다..

전혀 예상치 못했던 결과다.. 내장함수라면 빠를 줄 알았는데.. 내가 사용을 잘못한건지 생각보다 느렸다..