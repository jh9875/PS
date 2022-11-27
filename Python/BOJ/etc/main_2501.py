def get_factor_list(num: int):
    result = []

    for divisor in range(1, num + 1):
        if not num % divisor:
            result.append(divisor)

    return result


if __name__ == '__main__':
    N, K = map(int, input().split())
    factor_list = get_factor_list(N)

    if len(factor_list) < K:
        print(0)
    else:
        print(sorted(factor_list)[K - 1])
