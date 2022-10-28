def get_gcd(num1: int, num2: int):
    if num2 == 0:
        return num1
    else:
        return get_gcd(num2, num1 % num2)


def get_lcm(num1: int, num2: int):
    return num1 * num2 // get_gcd(num1, num2)


if __name__ == '__main__':
    a, b = map(int, input().split())
    print(get_gcd(a, b))
    print(get_lcm(a, b))