import sys

ans = []
a, b = 0, 0

while True:
    a, b = map(int, sys.stdin.readline().split())

    if not a and not b:
        break

    ans.append(a + b)

print('\n'.join(map(str, ans)))