완전제곱수
===

문제 링크 : https://www.acmicpc.net/problem/1977

<br>

### 풀이

문제의 입력으로 나오는 수 범위에 해당되는 완전 제곱수를 찾고, 거기서 합과 최소값을 구하면 된다.

일단 특정 범위의 완전제곱수를 구하는 코드는 다음과 같이 만들어줬다.

```Python
def get_perfect_square_list(min_range: int, max_range: int):
    result = list()

    for num in range(min_range, max_range + 1):
        if num % math.sqrt(num) == 0:
            result.append(num)

    return result
```

원래 수와 제곱수의 나머지 연산을 이용해서 0이면 완전제곱수가 된다.

이 결과에서 null이 아니면 sum()과 첫 번째 수를 출력해줬다.