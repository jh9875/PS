약수
===

문제 링크 : https://www.acmicpc.net/problem/2525

<br>

### 풀이

문제를 보고 처음 생각한 풀이는 시와 분을 따로 계산하는 것이었다.

~~~Python
minute += need_time

if minute >= MAX_MINUTE:
    hour += minute // MAX_MINUTE
    minute = minute % MAX_MINUTE
if hour >= MAX_HOUR:
    hour = hour % MAX_HOUR
~~~

이런 식으로 단순하게 생각해봤다.
문제는 정답이었다.

다른 사람들은 어떻게 풀었나 찾아보다가 더 효율적인 방법을 찾았다.

~~~Python
new = 60 * a + b + c
print(new // 60 % 24, new % 60)
~~~

위와 같은 방식으로 시와 분을 모두 합쳐서 분으로 계산하는 것이었다.

1시간 = 60분이니 시간에 60을 곱해서 모두 분에 더해준다.

그리고 시간, 분 각각 나머지 연산을 이용해서 출력해준다.