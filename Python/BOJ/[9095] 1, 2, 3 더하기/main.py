import sys

ont_two_three = [1, 2, 3]


def get_number_of_sum(now: int, target: int) -> int:
    if now == target:
        return 1

    ret = 0

    for i in ont_two_three:
        if now + i <= target:
            ret += get_number_of_sum(now + i, target)

    return ret


if __name__ == '__main__':
    ans = []

    t = int(sys.stdin.readline().rstrip())

    for _ in range(t):
        number = int(sys.stdin.readline().rstrip())
        ans.append(get_number_of_sum(0, number))

    print('\n'.join(map(str, ans)))
