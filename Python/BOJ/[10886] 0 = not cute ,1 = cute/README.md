0 = not cute / 1 = cute
===

문제 링크 : https://www.acmicpc.net/problem/10886

<br>

### 풀이

문제의 입력에 따른 수를 계산하면 된다.

수가 0 또는 1로 입력되기 때문에 수를 합친 다음 귀엽다는 의견이 반 이상이면 귀여운거다.

```Python

cute_rate = 0

for i in range(N):
    cute_rate += int(sys.stdin.readline())

if cute_rate > N // 2:
    print('Junhee is cute!')
else:
    print('Junhee is not cute!')

```