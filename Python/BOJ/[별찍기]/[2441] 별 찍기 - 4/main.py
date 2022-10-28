def print_star_4(n: int):
    stars = list()

    for i in range(n):
        line = (' ' * i) + ('*' * (n - i))
        stars.append(line)

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_4(input_n)
