ans = 0
N = int(input())

for i in range(0, N + 1):
    for j in range(i, N + 1):
        ans += i + j

print(ans)
