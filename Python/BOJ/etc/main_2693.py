import sys

ans = []
t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    number_list = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    ans.append(sorted(number_list, reverse=True)[2])

print('\n'.join(map(str, ans)))
