import sys

word_list = []

ans = 0
N, M = map(int, sys.stdin.readline().rstrip().split())

for _ in range(N):
    word_list.append(sys.stdin.readline().rstrip())

for _ in range(M):
    word = sys.stdin.readline().rstrip()
    if word in word_list:
        ans += 1

print(ans)
