ans = 0

word = input()

for ch in word:
    if ch == 'a' or ch == 'e' or ch == 'i' or ch == 'o' or ch == 'u':
        ans += 1

print(ans)
