import sys

n, m = map(int, sys.stdin.readline().split())
result = [[0 for _ in range(m)] for _ in range(n)]

for row in range(n * 2):
    columns = list(map(int, sys.stdin.readline().split()))
    result[row % n] = [x + y for x, y in zip(columns, result[row % n])]

ans = []
for row in range(n):
    ans.append(' '.join(map(str, result[row])))

print('\n'.join(map(str, ans)))
