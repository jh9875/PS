import sys

score_sum = 0

for i in range(5):
    score = int(sys.stdin.readline())
    score_sum += score if score > 40 else 40

print(score_sum // 5)
