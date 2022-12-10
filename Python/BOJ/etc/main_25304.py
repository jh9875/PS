import sys

X = int(sys.stdin.readline().rstrip())

N = int(sys.stdin.readline().rstrip())

for _ in range(N):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    X -= (a * b)

if X:
    print('No')
else:
    print("Yes")
