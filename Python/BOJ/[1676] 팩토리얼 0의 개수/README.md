팩토리얼 0의 개수
===

문제 링크 : https://www.acmicpc.net/problem/1676

<br>

### 풀이

팩토리얼을 구하고, 팩토리얼 결과 두에 0이 몇 개 있는지 찾는 문제이다.

팩토리얼 결과를 문자열로 변경한 다음 '0'의 수를 셀 수 있지만, 문제에서 0의 개수를 구하는 것이기 때문에 나눗셈으로 해결할 수 있다.

일단 파이썬에서는 math.factorial로 팩토리얼 결과를 구할 수 있다.

```Python
n = int(sys.stdin.readline().rstrip())
result = math.factorial(n)
```

그리고 다음과 같이 나누는 수를 10을 시작으로 10배로 늘려가면서 하면 뒤에 자리가 0인지 아닌지 확인할 수 있다.

```Python
ans = 0
divisor = 10
quotient = 0

while quotient == 0:
    quotient = result % divisor

    if quotient == 0:
        ans += 1
        divisor *= 10
```