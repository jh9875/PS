import sys

a, b = 0, 0
ans = list()

while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == 0 and b == 0:
        break

    if b % a == 0:
        ans.append('factor')
    elif a % b == 0:
        ans.append('multiple')
    else:
        ans.append('neither')

print('\n'.join(map(str, ans)))
