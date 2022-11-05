ans = list()
t = int(input())

for _ in range(t):
    v, e = map(int, input().split())
    ans.append(e - v + 2)

print('\n'.join(map(str, ans)))
