최소공배수
===

문제 링크 : https://www.acmicpc.net/problem/1934

<br>

### 풀이

최대공약수, 최소공배수를 구할 땐 유클리드 호제법이란걸 사용하는 것 같다.

유클리드 호제법은 두 수의 최대공약수를 구하는 방법인데

> 두 정수 a, b에 대해 a를 b로 나눈 나머지인 r을 이용해 최종적인 나머지가 0이 될 때까지 반복하는것
이라고 한다..

아무튼 그걸 코드로 나타내면 다음과 같다.

```Python
def get_gcd(num1: int, num2: int):
    if num2 == 0:
        return num1
    else:
        return get_gcd(num2, num1 % num2)
```

여기서 두 수의 곱에 최대공약수를 나눠주면 최소공배수가 나온다.

```Python
def get_lcm(num1: int, num2: int):
    return num1 * num2 // get_gcd(num1, num2)
```