import sys

N = int(sys.stdin.readline().rstrip())
result_list = list(map(int, sys.stdin.readline().rstrip().split()))

count = 1
ans = 0

for result in result_list:
    if result:
        ans += count
        count += 1
    else:
        count = 1

print(ans)
