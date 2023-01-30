import sys

number_list = []
k = int(sys.stdin.readline().rstrip())

for _ in range(k):
    num = int(sys.stdin.readline().rstrip())

    if num:
        number_list.append(num)
    else:
        number_list.pop()

print(sum(number_list))
