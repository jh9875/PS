import sys

ans = 0
num_list = list(map(int, sys.stdin.readline().split()))
num_list.sort()

if num_list[0] == num_list[1] == num_list[2]:
    ans = 10000 + num_list[0] * 1000
elif num_list[0] == num_list[1]:
    ans = 1000 + num_list[0] * 100
elif num_list[1] == num_list[2]:
    ans = 1000 + num_list[1] * 100
else:
    ans = num_list[2] * 100

print(ans)
