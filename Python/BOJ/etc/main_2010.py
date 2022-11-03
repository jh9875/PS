import sys

ans = 0
N = int(sys.stdin.readline())

for _ in range(N):
    n = int(sys.stdin.readline())
    ans += (n - 1)

print(ans + 1)
