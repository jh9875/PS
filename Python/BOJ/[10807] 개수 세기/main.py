num_count = dict()

N = int(input())

number_list = map(int, input().split())

for num in number_list:
    if num in num_count:
        num_count[num] += 1
    else:
        num_count[num] = 1

v = int(input())

if v in num_count:
    print(num_count[v])
else:
    print(0)
