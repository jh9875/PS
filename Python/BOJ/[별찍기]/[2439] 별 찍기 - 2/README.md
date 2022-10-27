별 찍기 - 2
===

문제 링크 : https://www.acmicpc.net/problem/2439

<br>

### 풀이

별 찍기 - 1과 달리 공백이 있다.

각 라인에 공백을 더해주면 된다.!

```Python
def print_star_2(n: int):
    stars = list()

    for i in range(1, n + 1):
        line = (' ' * (n - i)) + ('*' * i)
        stars.append(line)

    print('\n'.join(stars))
```