import sys


def get_minimum_diff(num_list: list) -> int:
    ret = 0
    for index in range(1, len(num_list)):
        diff = num_list[index] - num_list[index - 1]
        ret = diff if diff > ret else ret

    return ret


if __name__ == '__main__':

    ans = []
    k = int(sys.stdin.readline().rstrip())

    for class_number in range(k):
        ans.append('Class ' + str((class_number + 1)))
        number_list = list(map(int, sys.stdin.readline().rstrip().split(' ')))[1:]
        number_list.sort()
        gap = get_minimum_diff(number_list)

        ans.append(f'Max {max(number_list)}, Min {min(number_list)}, Largest gap {gap}')

    print('\n'.join(ans))
