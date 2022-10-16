import sys


def get_reward_value(num_list: list):
    result = 0
    num_list.sort()

    if num_list[0] == num_list[1] == num_list[2]:
        result = 10000 + num_list[0] * 1000
    elif num_list[0] == num_list[1]:
        result = 1000 + num_list[0] * 100
    elif num_list[1] == num_list[2]:
        result = 1000 + num_list[1] * 100
    else:
        result = num_list[2] * 100
    return result


result_list = list()
N = int(input())

for i in range(N):
    numbers = list(map(int, sys.stdin.readline().split()))
    result_list.append(get_reward_value(numbers))

print(max(result_list))
