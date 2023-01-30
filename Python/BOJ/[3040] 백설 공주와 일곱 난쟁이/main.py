import sys

number_list = []

for _ in range(9):
    num = int(sys.stdin.readline().rstrip())
    number_list.append(num)

number_list_sum = sum(number_list)

for index1 in range(9):
    for index2 in range(index1 + 1, 9):
        value1 = number_list[index1]
        value2 = number_list[index2]
        if number_list_sum - value1 - value2 == 100:
            number_list.remove(value1)
            number_list.remove(value2)
            break
    if len(number_list) < 9:
        break

print('\n'.join(map(str, number_list)))
