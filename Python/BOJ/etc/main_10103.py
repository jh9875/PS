import sys

if __name__ == '__main__':
    total_a, total_b = 100, 100

    round_number = int(sys.stdin.readline())

    for i in range(round_number):
        a, b = map(int, sys.stdin.readline().split())

        if a > b:
            total_b -= a
        elif a < b:
            total_a -= b

    print('{0}\n{1}'.format(total_a, total_b))

