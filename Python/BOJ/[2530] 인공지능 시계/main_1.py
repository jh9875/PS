import sys

HOUR_DIVISOR = 60 * 60
MINUTE_DIVISOR = 60

hour, minute, second = map(int, sys.stdin.readline().split())
added_second = int(sys.stdin.readline())

# 1시간 = 60분, 1분 = 60초
total_second = (hour * HOUR_DIVISOR) + (minute * MINUTE_DIVISOR) + second + added_second

end_hour = (total_second // HOUR_DIVISOR) % 24 if total_second // HOUR_DIVISOR % 24 != 0 else 0
total_second %= HOUR_DIVISOR
end_minute = (total_second // MINUTE_DIVISOR) % 60 if total_second // MINUTE_DIVISOR % 60 != 0 else 0
end_second = total_second % MINUTE_DIVISOR

print(end_hour, end_minute, end_second)
