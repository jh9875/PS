1, 2, 3 더하기
===

문제 링크 : https://www.acmicpc.net/problem/9095

<br>

### 풀이

일단 단순하게 해결할 수 있는 방법으로 구해봤다.

각 경우마다 1, 2, 3을 더해서 얻을 수 있는 방법의 수.

문제의 예제를 보니 1 1 2, 2 1 1 과 같이 다른 숫자여도 순서가 다르다면 다른 경우로 세는 문제이다.

```Python
ont_two_three = [1, 2, 3]


def get_number_of_sum(now: int, target: int) -> int:
    if now == target:
        return 1

    ret = 0

    for i in ont_two_three:
        if now + i <= target:
            ret += get_number_of_sum(now + i, target)

    return ret
```

일단 함수에서 now는 현재 더하고 있는 수이고, target은 입력으로 받은 1,2,3 합으로 만들어야 하는 수이다.

함수의 처음에 now == target인 경우 1가지 경우로 세면 되므로 1을 반환한다.

그게 아니라면 현재 수에 1,2,3을 각각 더해서 나올 수 있는 경우를 모두 더해준다.