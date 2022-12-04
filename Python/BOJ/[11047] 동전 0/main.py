import sys

coins = []
N, K = map(int, sys.stdin.readline().rstrip().split())

for _ in range(N):
    coins.append(int(sys.stdin.readline().rstrip()))

ans = 0

coins.sort(reverse=True)

for coin in coins:
    if K == 0:
        break
    if K >= coin:
        ans += K // coin
        K %= coin

print(ans)
