def print_star_12(n: int):
    stars = []

    for i in range(1, n + 1):
        stars.append((' ' * (n - i)) + ('*' * i))

    for i in range(1, n):
        stars.append((' ' * i) + ('*' * (n - i)))

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_12(input_n)
