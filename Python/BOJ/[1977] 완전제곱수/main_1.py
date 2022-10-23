import math


def get_perfect_square_list():
    result = list()

    for num in range(1, 101):
        result.append(int(math.pow(num, 2)))

    return result


if __name__ == '__main__':

    perfect_square_list = get_perfect_square_list()

    min_range = int(input())
    max_range = int(input())

    target = list()

    for perfect_square in perfect_square_list:
        if min_range <= perfect_square <= max_range:
            target.append(perfect_square)

    if target:
        print(sum(target))
        print(target[0])
    else:
        print('-1')
