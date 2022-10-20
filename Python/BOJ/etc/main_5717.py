import sys

a, b = 0, 0
ans = list()

while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == 0 and b == 0:
        break
    ans.append(a + b)

print('\n'.join(map(str, ans)))
