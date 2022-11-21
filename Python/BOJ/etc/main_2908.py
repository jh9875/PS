def get_reversed_str(string: str):
    return ''.join(reversed(list(string)))


if __name__ == '__main__':
    num1, num2 = input().split()
    print(max(int(get_reversed_str(num1)), int(get_reversed_str(num2))))
