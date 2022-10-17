import sys


def get_45_minute_early(hour: int, minute: int):
    minute -= 45

    if minute < 0:
        minute += 60
        hour -= 1
    if hour < 0:
        hour = 23

    return hour, minute


hour_input, minute_input = map(int, sys.stdin.readline().split())
ans = get_45_minute_early(hour_input, minute_input)
print(ans[0], ans[1])
