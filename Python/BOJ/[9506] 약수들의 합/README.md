약수들의 합
===

문제 링크 : https://www.acmicpc.net/problem/9506

<br>

### 풀이

문제는 3가지 문제를 해결하면 된다.

1. 수의 약수들 구하기.
2. 수가 완전수인지 판단하기.
3. 문제 형식에 맞게 출력하기.


우선 수의 약수들을 구해본다.

내가 사용한 방법은 그냥 반복문으로 돌면서 나눠지는 수면 약수로 판단했다.

여기서 약수들이 오름차순으로 반환하면 좋기 때문에 1부터 차례대로 확인해보고 list로 반환해줬다.

그리고 어짜피 for문으로 수를 증가시키니 중복될 경우도 없고..

```Python
def get_factor_list(num: int):
    result = list()

    for i in range(1, num - 1):
        if num % i == 0:
            result.append(i)

    return result
```

그리고 완전수인지 판단하는건 그냥 sum() 함수로 확인하면 됐다.

```Python
def is_perfect_number(num: int, factors: list):
    if sum(factors) == num:
        return True
    return False
```


그리고 마지막으로 문제 형식에 맞게 출력하면 된다.

완전수가 아니면 그냥 format을 사용하면 되는데, 완전수인 경우 ~ + ~ + ~ .. 이런 형식으로 해줘야했다.

그래서 어떻게 할지 찾아보다가 join이란 함수를 사용하게됐다.

join 함수는 문자열을 합칠 때 사용하는 함수이다.

```Python
if is_perfect_number(input_num, factor_list):
    ans.append('{0} = {1}'.format(str(input_num), ' + '.join(map(str, factor_list))))
else:
    ans.append('{0} is NOT perfect.'.format(input_num))
```

위와 같이 ' + '.join( .. ) 이런 식으로 사용했는데, 결과의 사이 사이 +가 삽입된다.

