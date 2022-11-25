소수 찾기
===

문제 링크 : https://www.acmicpc.net/problem/1978

<br>

### 풀이

일단 알고리즘 문제에서 소수 관련 문제는 에라스토테네스의 체로 풀면 된다고 생각하면 되겠다.

일단.. 알고리즘은 인터넷에 검색하면 엄청나게 많이 나온다.

알고리즘은 다음과 같다.

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

원리를 이해한다고 했지만 나중에 볼때마다 까먹게 된다.. 확인하는 범위를 제곱수만큼 줄인다는 것만 이해해두겠다..