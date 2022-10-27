def print_star_2(n: int):
    stars = list()

    for i in range(1, n + 1):
        line = (' ' * (n - i)) + ('*' * i)
        stars.append(line)

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_2(input_n)
