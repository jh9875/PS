알람 시계
===

문제 링크 : https://www.acmicpc.net/problem/2884

<br>

### 풀이

문제 난이도에 비해서 정답률이 낮다는 생각이 들었다.

단순히 시간만 45분 적으로 계산해주기 때문에 크게 어렵진 않은 문제이다.

```Pyton
def get_45_minute_early(hour: int, minute: int):
    minute -= 45

    if minute < 0:
        minute += 60
        hour -= 1
    if hour < 0:
        hour = 23

    return hour, minute
```

함수는 위와 같이 만들었다.

시와 분이 있으면 일단 45분을 뺐다.

그리고 0보다 작아지면 시에서 1을 뺀다.

이 때 주의할 점은 1을 뺐으니 60에서 음수 만큼을 뺀 수가 다시 분이 된다.

그리고 시에서 1을 빼고 음수가 되는 경우 전날의 시인 23으로 해주면 된다.