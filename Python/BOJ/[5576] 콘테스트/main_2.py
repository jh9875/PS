import sys

ans = []

for _ in range(2):
    univ_scores = [int(sys.stdin.readline().rstrip()) for _ in range(10)]
    univ_scores.sort(reverse=True)

    ans.append(sum(univ_scores[:3]))

print(' '.join(map(str, ans)))
