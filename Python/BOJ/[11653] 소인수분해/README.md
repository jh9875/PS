소인수분해
===

문제 링크 : https://www.acmicpc.net/problem/11653

<br>

### 풀이

소인수분해를 구현하면 된다.

평소에 수학에 관심이 없기때문에 소인수 분해를 단순하게 구현해봤다.

```Python
while N > 1:
    if N % divisor == 0:
        ans.append(str(divisor))
        N //= divisor
    else:
        divisor += 1
```

제출했는데 속도가 굉장히 느렸다.

그래서 다른 해결 방법이 있는지 검색해봤더니 더 빠른 방법이 있었다.

그 원리는 나누는 수를 가운데 약수 까지만 나누는 것이다.

1 x 16 = 16
2 x 8 = 16
4 x 4 = 16
8 x 2 = 16
16 x 1 = 16

2 x 8과 8 x 2는 대칭이다. 즉 나누는 수를 가운데 약수까지만 사용해서 확인을 하면 반복문의 범위를 줄일 수 있다.

```Python
sqrt = int(math.sqrt(N))

while divisor <= sqrt:
    if N % divisor == 0:
        ans.append(str(divisor))
        N //= divisor
    else:
        divisor += 1

if N > 1:
    ans.append(str(N))
```

그리고 마지막에 N이 1이상일 때 추가해주는 것도 잊지 말아야한다.

참고 : https://devmath.tistory.com/61

