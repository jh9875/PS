전자레인지
===

문제 링크 : https://www.acmicpc.net/problem/10162

<br>

### 풀이

요리 시간이 주어졌을 때 큰 시간부터 작은 시간까지 쇼요된 시간들의 합을 구하면 된다.

나는 처음에 각 횟수를 더하면 된다고 생각하고 다음과 같이 구현해봤다.

```Python
def get_press_button_count(cooking_time: int):
    result = {'A': 0, 'B': 0, 'C': 0}

    while cooking_time > 0:
        if cooking_time >= A_BUTTON_SECOND:
            result['A'] += cooking_time // A_BUTTON_SECOND
            cooking_time %= A_BUTTON_SECOND
        elif cooking_time >= B_BUTTON_SECOND:
            result['B'] += cooking_time // B_BUTTON_SECOND
            cooking_time %= B_BUTTON_SECOND
        elif cooking_time >= C_BUTTON_SECOND:
            result['C'] += cooking_time // C_BUTTON_SECOND
            cooking_time %= C_BUTTON_SECOND
        else:
            return None
    return result
```

뭐.. 문제는 없이 동작한다. 근데 가만 생각해보니 이렇게 반복적인 뺄셈 연산은 나누기와 나머지 연산으로 해결할 수 있다는 것을 깨달았다.

그래서 다음과 같이 수정해봤다.

```Python
def get_press_button_count(cooking_time: int):
    result = list()

    result.append(cooking_time // A_BUTTON_SECOND)
    cooking_time %= A_BUTTON_SECOND
    result.append(cooking_time // B_BUTTON_SECOND)
    cooking_time %= B_BUTTON_SECOND
    result.append(cooking_time // C_BUTTON_SECOND)
    cooking_time %= C_BUTTON_SECOND

    return result if cooking_time == 0 else None
```

이것도 문제없이 동작한다.

지금 이 문제에선 둘의 시간 및 메모리 자원 소모가 거의 동일하지만

입력 수의 범위가 최대 10000으로 많이 크지 않은 수여서 그런 것 같다.

수가 커질 수 있으니 나누기와 나머지 연산을 활용하는게 좋을듯 하다.