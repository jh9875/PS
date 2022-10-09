import sys

MAX_HOUR = 24
MAX_MINUTE = 60

hour, minute = map(int, sys.stdin.readline().split())
need_time = int(sys.stdin.readline())

minute += need_time

if minute >= MAX_MINUTE:
    hour += minute // MAX_MINUTE
    minute = minute % MAX_MINUTE
if hour >= MAX_HOUR:
    hour = hour % MAX_HOUR

print('{0} {1}'.format(hour, minute))

