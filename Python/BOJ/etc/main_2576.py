num_list = []

for _ in range(7):
    num_list.append(int(input()))

ans_list = list(filter(lambda n: n % 2 == 1, num_list))

if ans_list:
    print(sum(ans_list))
    print((min(ans_list)))
else:
    print(-1)
