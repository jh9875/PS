import sys

ans = list()
input_test_case = int(sys.stdin.readline())

for case in range(input_test_case):
    num_of_person = int(sys.stdin.readline())

    max_price = 0
    max_price_name = str()

    for num in range(num_of_person):
        line = sys.stdin.readline().split()
        price = int(line[0])
        name = line[1]

        if price > max_price:
            max_price = price
            max_price_name = name

    ans.append(max_price_name)

print('\n'.join(ans))
