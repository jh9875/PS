import sys


def get_factor_list(num: int):
    result = list()

    for i in range(1, num - 1):
        if num % i == 0:
            result.append(i)

    return result


def is_perfect_number(num: int, factors: list):
    if sum(factors) == num:
        return True
    return False


if __name__ == '__main__':
    ans = list()

    while True:
        input_num = int(sys.stdin.readline())

        if input_num == -1:
            break

        factor_list = get_factor_list(input_num)

        if is_perfect_number(input_num, factor_list):
            ans.append('{0} = {1}'.format(str(input_num), ' + '.join(map(str, factor_list))))
        else:
            ans.append('{0} is NOT perfect.'.format(input_num))

    print('\n'.join(ans))
