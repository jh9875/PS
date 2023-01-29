import sys

ans = []
k = int(sys.stdin.readline().rstrip())

for _ in range(k):
    taken_seat_numbers = set()
    p, m = map(int, sys.stdin.readline().rstrip().split(' '))
    for _ in range(p):
        taken_seat_numbers.add(int(sys.stdin.readline().rstrip()))

    ans.append(p - len(taken_seat_numbers))

print('\n'.join(map(str, ans)))
