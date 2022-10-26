def print_star_1(n: int):
    stars = list()

    for i in range(1, n + 1):
        stars.append('*' * i)

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_1(input_n)
