행렬 덧셈
===

문제 링크 : https://www.acmicpc.net/problem/2783

<br>

### 풀이

파이썬 문법에 익숙하지 않은 나는 2차원 배열에 도전해봤다.

그래서 처음엔 최대한 단순하게 풀어보려고 했다.

첫 번째 알고리즘 : 두개의 2차원 배열을 받고 결과 2차월 배열에 더한 후 출력한다.

```Python
import sys

array1 = []
array2 = []

n, m = map(int, sys.stdin.readline().split())

for i in range(n):
    columns = list(map(int, sys.stdin.readline().split()))
    array1.append(columns)

for i in range(n):
    columns = list(map(int, sys.stdin.readline().split()))
    array2.append(columns)

result = [[0 for col in range(m)] for row in range(n)]

for i in range(n):
    for j in range(m):
        result[i][j] = array1[i][j] + array2[i][j]

for i in range(n):
    print(' '.join(map(str, result[i])))

```

음.. 이렇게 해보긴 했는데 너무 난잡하다.. 깔끔하지가 않다. 그래서 결과 배열만 선언하고 거기에 입력만 더하는 형식으로 바꿔봤다.

그리고 2개의 배열을 입력 받을 때 동일한 코드가 입력된다. 그래서 나머지 연산자를 사용해서 1개의 반복문으로 2개의 배열을 입력 받도록 변경해봤다.

```Python
import sys

n, m = map(int, sys.stdin.readline().split())
result = [[0 for _ in range(m)] for _ in range(n)]

for row in range(n * 2):
    columns = list(map(int, sys.stdin.readline().split()))
    result[row % n] = [x + y for x, y in zip(columns, result[row % n])]

ans = []
for row in range(n):
    ans.append(' '.join(map(str, result[row])))

print('\n'.join(map(str, ans)))

```

여기서 한 row의 컬럼 값들을 더할 때 zip()이라는 내장 항수를 사용해봤다.

여기서 zip()이라는 함수는 길이가 같은 iterable 자료형을 묶을 때 사용하는데 결과값에 입력값을 더하는 식으로 사용해봤다.
