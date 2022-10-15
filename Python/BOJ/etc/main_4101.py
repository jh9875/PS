import sys

ans = list()
a, b = 0, 0

while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == 0 and b == 0:
        break
    ans.append('Yes' if a > b else 'No')

print('\n'.join(ans))
