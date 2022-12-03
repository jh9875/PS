import sys

winner_number, winner_score = 0, 0

for i in range(5):
    total_score = sum(map(int, sys.stdin.readline().rstrip().split()))
    if winner_score < total_score:
        winner_number = i + 1
        winner_score = total_score

print(winner_number, winner_score)
