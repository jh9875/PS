과제 안 내신 분..?
===

문제 링크 : https://www.acmicpc.net/problem/5597

<br>

### 풀이

1~30의 수 중 문제의 입력으로 28개의 수가 주어진다.

여기서 입력되지 않은 수를 구하는 문제이다.

단순하게 생각해봤을 때 Boolean list를 이용하면 구할 수 있다.

```Python
is_checked_number = [False for i in range(31)]

for i in range(28):
    index = int(sys.stdin.readline().rstrip())
    is_checked_number[index] = True
```

가장 먼저 위와같이 30개의 Fasle로 채워진 list를 만들어 주면서 시작해봤다.

그리고 문제에 입력되는 수들을 True로 바꿔준다.

```Python
ans = []

for i in range(1, 31):
    if not is_checked_number[i]:
        ans.append(i)

print('\n'.join(map(str, ans)))
```

그 다음으로 is_checked_number 배열에서 False 인 것들을 출력해주면 된다.