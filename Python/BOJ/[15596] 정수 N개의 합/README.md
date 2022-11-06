정수 N개의 합
===

문제 링크 : https://www.acmicpc.net/problem/15596

<br>

### 풀이

파이썬에선 보통 함수의 파라미터와 반환 값의 타입을 지정해 주지 않지만 타입 힌트라는 것을 줄 수 있다.

```Python
def solve(a: list) -> int:
    return sum(a)
```

또는 타입 지정 없이 다음과 같이 할 수 있다.

```Python
def solve(a):
    return sum(a)
```

주로 Java를 이용해왔던 나에게는 타입이 없는것이 오히려 이상하게 느껴지지만

이왕이면 파이썬을 배우는 김에 파이썬 다운 코드를 작성해보는 것도 좋을 것 같다.