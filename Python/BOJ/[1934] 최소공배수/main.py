import sys


def get_gcd(num1: int, num2: int):
    if num2 == 0:
        return num1
    else:
        return get_gcd(num2, num1 % num2)


def get_lcm(num1: int, num2: int):
    return num1 * num2 // get_gcd(num1, num2)


T = int(sys.stdin.readline())
ans = list()

for i in range(T):
    a, b = map(int, sys.stdin.readline().split())
    ans.append(str(get_lcm(a, b)))

print('\n'.join(ans))
