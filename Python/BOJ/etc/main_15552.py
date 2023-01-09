import sys

ans = []
t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    a, b = map(int, sys.stdin.readline().rstrip().split(' '))
    ans.append((a + b))

print('\n'.join(map(str, ans)))
