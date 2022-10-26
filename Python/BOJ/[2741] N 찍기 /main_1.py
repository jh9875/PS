def print_one_to_n(n: int):
    numbers = list()

    for num in range(1, n + 1):
        numbers.append(num)

    print('\n'.join(map(str, numbers)))


if __name__ == '__main__':
    input_n = int(input())
    print_one_to_n(input_n)
