changes = [500, 100, 50, 10, 5, 1]

rest = 1000 - int(input())
ans = 0

for change in changes:
    ans += rest // change
    rest %= change

print(ans)
