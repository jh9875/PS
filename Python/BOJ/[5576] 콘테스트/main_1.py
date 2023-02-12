import sys

w_univ_scores = []
k_univ_scores = []

w_univ_scores = [int(sys.stdin.readline().rstrip()) for _ in range(10)]
k_univ_scores = [int(sys.stdin.readline().rstrip()) for _ in range(10)]

w_univ_scores.sort(reverse=True)
k_univ_scores.sort(reverse=True)

ans = [sum(w_univ_scores[:3]), sum(k_univ_scores[:3])]

print(' '.join(map(str, ans)))
