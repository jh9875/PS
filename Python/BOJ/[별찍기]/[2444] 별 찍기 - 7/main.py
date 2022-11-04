def print_star_7(n: int):
    stars = []

    for i in range(1, n + 1):
        stars.append((' ' * (n - i)) + ('*' * (2 * i - 1)))

    for i in range(1, n):
        stars.append((' ' * i) + ('*' * (2 * n - (2 * i + 1))))

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_7(input_n)
