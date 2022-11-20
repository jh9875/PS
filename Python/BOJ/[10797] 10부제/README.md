10부제
===

문제 링크 : https://www.acmicpc.net/problem/10797

<br>

### 풀이

문제는 아주 단순한 문제다. 그냥 일치하는 숫자만 비교해보면 된다.

```Python
unit_digit_of_day = int(input())
unit_digit_of_car_numbers = list(map(int, input().split()))

ans = 0

for num in unit_digit_of_car_numbers:
    if unit_digit_of_day == num:
        ans += 1

print(ans)

```

근데 뭔가 파이썬 문법을 이용해서 문제를 해결해보고 싶다.

그래서 리스트 컴프리헨션이란걸 이용해서 풀어봤다.

```Python
unit_digit_of_day = int(input())
unit_digit_of_car_numbers = list(map(int, input().split()))

ans = len([num for num in unit_digit_of_car_numbers if num == unit_digit_of_day])

print(ans)

```

여기서 핵심은 4번째 줄에 있다.

일단 리스트 컴프리헨션을 이용한 부분은 다음과 같다.

```Python
num for num in unit_digit_of_car_numbers
```

위 코드에서 해석해보면 num이라는 변수 뒤에 일반적으로 알고있는 for 문이 나오는데,

for에서 뽑은 수들을 각각 num이라는 변수에 할당하는 것 같다. (내 추측..)

그리고 그 뒤에는 조건부 표현식을 사용해봤다.

```Python
num for num in unit_digit_of_car_numbers if num == unit_digit_of_day
```

for문 뒤에 조건부 표현식을 적었는데 간단하게 if 문을 한 줄로 표현할 수 있다.

대략적으로 다음과 같이 표현하는 것 같다.

(True일 경우 값) if (식) else (false일 경우 값) 

그리고 []를 이용해서 리스트로 만들어줬고, len을 이용해서 수를 구해봤다.

처음엔 어색하겠지만 익숙해지면 매우 간결하게 코드를 작성할 수 있을 것 같다.