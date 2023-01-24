import sys

ans = []
n = int(sys.stdin.readline().rstrip())

for _ in range(n):
    sentence = sys.stdin.readline().rstrip()
    ans.append(sentence[:1].upper() + sentence[1:])

print('\n'.join(ans))
