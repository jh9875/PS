import sys

ans = []

test_case_input = int(sys.stdin.readline())

for _ in range(test_case_input):
    total_price = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    for _ in range(n):
        num_of_options, price_or_option = map(int, sys.stdin.readline().split())
        total_price += num_of_options * price_or_option

    ans.append(total_price)

print('\n'.join(map(str, ans)))
