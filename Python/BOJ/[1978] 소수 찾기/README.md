소수 찾기
===

문제 링크 : https://www.acmicpc.net/problem/1978

<br>

### 풀이

일단 알고리즘 문제에서 소수 관련 문제는 에라토스테네스의 체 아니면 소수 판별 알고리즘이 있다.

일단 이 문제는 소수 판별 알고리즘으로 풀었는데 알고리즘은 다음과 같다.

```Python
def is_prime_number(num: int) -> bool:
    if num == 1:
        return False
    sqrt = int(math.sqrt(num))
    for i in range(2, sqrt + 1):
        if num % i == 0:
            return False
    return True
```

확인해야 하는 범위를 제곱수 만큼 줄인것이다.

그러므로 당연히 O(n^1/2)로 시간복잡도가 줄어든다.