def print_star_13(n: int):
    stars = []

    for i in range(1, n + 1):
        stars.append('*' * i)

    for i in range(1, n):
        stars.append('*' * (n - i))

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_13(input_n)
