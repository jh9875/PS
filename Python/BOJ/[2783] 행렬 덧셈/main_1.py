import sys

array1 = []
array2 = []

n, m = map(int, sys.stdin.readline().split())

for i in range(n):
    columns = list(map(int, sys.stdin.readline().split()))
    array1.append(columns)

for i in range(n):
    columns = list(map(int, sys.stdin.readline().split()))
    array2.append(columns)

result = [[0 for col in range(m)] for row in range(n)]

for i in range(n):
    for j in range(m):
        result[i][j] = array1[i][j] + array2[i][j]

for i in range(n):
    print(' '.join(map(str, result[i])))
