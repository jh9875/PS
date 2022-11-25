import math


def is_prime_number(num: int) -> bool:
    if num == 1:
        return False
    sqrt = int(math.sqrt(num))
    for i in range(2, sqrt + 1):
        if num % i == 0:
            return False
    return True


if __name__ == '__main__':
    N = int(input())
    input_number_list = list(map(int, input().split()))

    ans = 0

    for input_number in input_number_list:
        if is_prime_number(input_number):
            ans += 1

    print(ans)
