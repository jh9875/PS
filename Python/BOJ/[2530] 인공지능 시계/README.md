인공지는 시계
===

문제 링크 : https://www.acmicpc.net/problem/2530

<br>

### 풀이

2525번 오븐 시계 문제와 비슷한 문제다.

입력되는 시, 분, 초를 모두 초로 변환해서 풀어봤다.

문제의 입력에서 요리하는데 필요한 시간 D의 범위가 최대 500000이다.

이런 경우 24시간, 60분을 넘어갈 수 있으므로 나머지 연산을 잘 해줘야 한다.

```Python
total_second = (hour * HOUR_DIVISOR) + (minute * MINUTE_DIVISOR) + second + added_second

end_hour = (total_second // HOUR_DIVISOR) % 24 if total_second // HOUR_DIVISOR % 24 != 0 else 0
total_second %= HOUR_DIVISOR
end_minute = (total_second // MINUTE_DIVISOR) % 60 if total_second // MINUTE_DIVISOR % 60 != 0 else 0
end_second = total_second % MINUTE_DIVISOR
```
