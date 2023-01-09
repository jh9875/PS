import sys

ans = []
word = sys.stdin.readline().rstrip()

length = len(word)
for i in range(0, length, 10):
    ans.append(word[i:i + 10])

print('\n'.join(ans))
