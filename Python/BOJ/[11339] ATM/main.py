N = int(input())
P = list(map(int, input().split()))

P.sort()

ans = 0

for i in range(len(P)):
    ans += sum(P[0:i + 1])

print(ans)
