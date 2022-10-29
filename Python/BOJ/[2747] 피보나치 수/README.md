피보나치 수
===

문제 링크 : https://www.acmicpc.net/problem/2747

<br>

### 풀이

파이썬에서 처음으로 재귀 함수를 사용하는 문제를 풀어봤다.

일단 안될 것 같지만 가장 기본적으로 생각나는 피보나치 함수를 작성해봤다.

```Python
def fibonacci(n: int):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
```

역시 작은 수의 입력에는 동작하지만 큰 수에서는 동작하지 않는다.

수가 커질수록 중복 계산해서 동작하는 부분이 많기 때문이다.

그래서 캐시를 써봤다.

```Python
cache = [0 for i in range(46)]


def fibonacci(n: int):
    ret = 0
    if n == 0:
        return 0
    if n == 1:
        return 1
    if cache[n]:
        return cache[n];
    else:
        cache[n] = fibonacci(n - 1) + fibonacci(n - 2)
        return cache[n]
```

이 것의 원리는 fibonacci() 함수를 호출할 때 중복 계산 되는 부분을 하지 않게 캐시?를 사용하는 것이다. (캐시라고 표현하는게 맞는지 모르겠지만. 계산 결과를 메모리에 넣어둔다.)

그리고 계산된 값이 없없다면 계산하여 cache에 넣어두고, 아니면 계산된 cache를 사용해서 반환한다.

물론 반복문으로도 충분히 해결 가능한 문제이다.

그리고 Python에선 배열이란 개념이 없는 것 같은데, 크기가 고정된 list를 선언하려면

위와 같이 cache = [0 for i in range(46)] 이렇게 초기화가 가능하다.

여기서 0으로 초기화 해줬는데, 파이썬에선 0이 거짓을 의미하므로 그렇게 해줬다.

```Python
n = int(input())
fibonacci_list = [0, 1]

for i in range(2, n + 1):
    fibonacci_list.append(fibonacci_list[i - 1] + fibonacci_list[i - 2])

print(fibonacci_list[n])
```
