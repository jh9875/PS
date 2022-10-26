def print_one_to_n(n: int):
    numbers = range(1, n + 1)
    print('\n'.join(map(str, numbers)))


if __name__ == '__main__':
    input_n = int(input())
    print_one_to_n(input_n)
