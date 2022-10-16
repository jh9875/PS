import sys

K, N, M = map(int, sys.stdin.readline().split())

result = K * N - M
print(result if result >= 0 else 0)
