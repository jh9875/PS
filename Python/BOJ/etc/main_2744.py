import sys

ans = []
word = sys.stdin.readline().rstrip()

for ch in word:
    if ch.isupper():
        ans.append(ch.lower())
    elif ch.islower():
        ans.append(ch.upper())

print(''.join(ans))
