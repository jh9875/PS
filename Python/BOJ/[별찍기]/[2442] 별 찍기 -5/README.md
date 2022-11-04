별 찍기 - 5
===

문제 링크 : https://www.acmicpc.net/problem/2442

<br>

### 풀이

각 라인에 별이 2*n - 1 개 만큼이 출력된다.

그리고 예제 출력 1을 자세히 보면 빈칸이 라인마다 4, 3, 2, 1, 0개 찍혀있는걸 확인할 수 있다.

그래서 라인수를 i(i는 1부터 시작)라고 한다면 n - i개 만큼의 빈칸이 있다.

그래서 다음과 같이 풀 수 있다.

```Python
def print_star_5(n: int):
    stars = []

    for i in range(1, n + 1):
        stars.append((' ' * (n - i)) + ('*' * (2 * i - 1)))

    print('\n'.join(stars))
```