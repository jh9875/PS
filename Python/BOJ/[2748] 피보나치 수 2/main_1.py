cache = [0 for i in range(46)]


def fibonacci(n: int):
    if n == 0:
        return 0
    if n == 1:
        return 1
    if cache[n]:
        return cache[n];
    else:
        cache[n] = fibonacci(n - 1) + fibonacci(n - 2)
        return cache[n]


if __name__ == '__main__':
    input_n = int(input())
    print(fibonacci(input_n))
