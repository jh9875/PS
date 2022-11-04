def print_star_8(n: int):
    stars = []

    for i in range(1, n + 1):
        stars.append(('*' * i) + (' ' * (2 * n - (2 * i))) + ('*' * i))

    for i in range(1, n):
        stars.append('*' * (n - i) + (' ' * (2 * i)) + ('*' * (n - i)))

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_8(input_n)
