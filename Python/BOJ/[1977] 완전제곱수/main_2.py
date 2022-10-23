import math


def get_perfect_square_list(min_range: int, max_range: int):
    result = list()

    for num in range(min_range, max_range + 1):
        if num % math.sqrt(num) == 0:
            result.append(num)

    return result


if __name__ == '__main__':
    input_min_range = int(input())
    input_max_range = int(input())

    perfect_square_list = get_perfect_square_list(input_min_range, input_max_range)

    if perfect_square_list:
        print(sum(perfect_square_list))
        print(perfect_square_list[0])
    else:
        print('-1')
