def get_fibonacci_number(num: int) -> int:
    if num == 0:
        return 0
    if num == 1:
        return 1
    return get_fibonacci_number(num - 1) + get_fibonacci_number(num - 2)


if __name__ == '__main__':
    input_num = int(input())
    print(get_fibonacci_number(input_num))
