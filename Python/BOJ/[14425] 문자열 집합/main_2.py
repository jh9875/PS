import sys

word_set = set()

ans = 0
N, M = map(int, sys.stdin.readline().rstrip().split())

for _ in range(N):
    word_set.add(sys.stdin.readline().rstrip())

for _ in range(M):
    word = sys.stdin.readline().rstrip()
    if word in word_set:
        ans += 1

print(ans)
