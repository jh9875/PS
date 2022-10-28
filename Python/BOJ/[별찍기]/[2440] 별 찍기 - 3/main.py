def print_star_3(n: int):
    stars = list()

    for i in range(n):
        stars.append('*' * (n - i))

    print('\n'.join(stars))


if __name__ == '__main__':
    input_n = int(input())
    print_star_3(input_n)
