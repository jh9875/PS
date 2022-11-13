import sys

num_list = list(map(int, sys.stdin.readline().split()))

ans = 0

for num in num_list:
    ans += pow(num, 2)

print(ans % 10)
