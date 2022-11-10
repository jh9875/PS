def print_star_20(n: int):
    stars = []

    for i in range(1, n + 1):
        stars.append(('* ' if i % 2 else ' *') * n)

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_20(input_n)
