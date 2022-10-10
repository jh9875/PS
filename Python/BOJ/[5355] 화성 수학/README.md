화성 수학
===

문제 링크 : https://www.acmicpc.net/problem/5355

<br>

### 풀이

문제는 각 테스트 케이스마다 데이터를 입력받아서 연산한 결과를 출력하는 문제이다.

결과를 계산하는 함수는 다음과 같이 만들었다.

```Python
def execute_mars_math(math_expression):
    mars_ath_result = float(math_expression[0])
    for e in math_expression[1:]:
        if '@' == e:
            mars_ath_result *= 3
        elif '%' == e:
            mars_ath_result += 5
        elif '#' == e:
            mars_ath_result -= 7
    return mars_ath_result
```


여기서 소수점 2자리 까지 출력해주기 위해서 format이란 함수를 사용해봤다.

```Python
format(result, '.2f')
```

그리고 (테스트 케이스 수가 많지 않아서 문제가 되지 않지만) 여러 번 출력하기 위해서
Java에선 StringBuilder와 같은것을 사용하지만 파이썬에선 어떻게하면 효율적으로 할 수 있는지 찾아보다가 보통 2가지 방법을 사용한다고 한다.

1. join함수
   ```Python
    ans_list = list()
    T = int(sys.stdin.readline())
    for i in range(T):
        case = sys.stdin.readline().split()
        result = execute_mars_math(case)
        ans_list.append(format(result, '.2f'))

    print('\n'.join(ans_list))
   ```

   위와 같이 배열을 사용해서 결과 값들을 모은 후 join 함수를 이용해서 출력하는 것이다.
2. StringIO
   ```Python
    from io import StringIO

    ..

    ans = StringIO()
    T = int(sys.stdin.readline())
    for i in range(T):
        case = sys.stdin.readline().split()
        result = execute_mars_math(case)
        ans.write(format(result, '.2f'))
        ans.write('\n')

    print(ans.getvalue())
   ```
   StringIO를 이용하는 방법이다..
   자세한 원리는 아직 모르나 위와같이 사용할 수 있다..