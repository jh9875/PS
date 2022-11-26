소수
===

문제 링크 : https://www.acmicpc.net/problem/2581

<br>

### 풀이

소수를 빨리 찾는 알고리즘이다.

범위를 두고 소수를 판별해야하는 문제라 에라토스테네스의 체를 이용했다.

```Python
def get_sieve_of_eratosthenes_list(max_value: int):
    prime_number_list = [True for _ in range(max_value + 1)]
    prime_number_list[1] = False

    sqrt = int(math.sqrt(max_value))
    for num in range(2, sqrt + 1):
        if prime_number_list[num]:
            multiply = 2
            while num * multiply <= max_value:
                prime_number_list[num * multiply] = False
                multiply += 1

    return prime_number_list
```


백준 온라인 저지에서 이 문제에 관한 질문들을 보면 1에 관한 예외를 처리하지 못한 경우를 많이 본 것 같다.

그 점을 주의해주면 될 것 같다.