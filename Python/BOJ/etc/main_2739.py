def print_gugudan(n: int):
    result = list()
    for i in range(1, 10):
        result.append('{0} * {1} = {2}'.format(n, i, n * i))
    print('\n'.join(result))


if __name__ == '__main__':
    input_n = int(input())
    print_gugudan(input_n)
