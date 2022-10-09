import sys

a, b = map(int, sys.stdin.readline().split())
c = int(sys.stdin.readline())

new = 60 * a + b + c
print(new // 60 % 24, new % 60)
