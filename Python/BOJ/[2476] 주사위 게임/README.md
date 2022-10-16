주사위 게임
===

문제 링크 : https://www.acmicpc.net/problem/2476

<br>

### 풀이

각 주사위 경우에 맞는 상금 값을 계산해서 각 경우에서 최대 값을 찾는 문제이다.

일단 상금 값을 계산하는 부분은 다음과 같이 만들어봤다.

```Python
def get_reward_value(num_list: list):
    result = 0
    num_list.sort()

    if num_list[0] == num_list[1] == num_list[2]:
        result = 10000 + num_list[0] * 1000
    elif num_list[0] == num_list[1]:
        result = 1000 + num_list[0] * 100
    elif num_list[1] == num_list[2]:
        result = 1000 + num_list[1] * 100
    else:
        result = num_list[2] * 100
    return result
```

그냥 list로 들어온 수를 정렬하여 각 수를 비교해봤다.

그리고 각 결과 값들을 list에 담은 후 max() 함수를 이용해서 결과값을 출력했다.

```Python
for i in range(N):
    numbers = list(map(int, sys.stdin.readline().split()))
    result_list.append(get_reward_value(numbers))

print(max(result_list))
```