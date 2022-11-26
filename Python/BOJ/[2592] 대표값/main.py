count_dict = dict()

for _ in range(10):
    num = int(input())

    if num in count_dict:
        count_dict[num] += 1
    else:
        count_dict[num] = 1

print(sum(map(lambda x: x[0] * x[1], count_dict.items())) // 10)
print(sorted(count_dict.items(), key=lambda x: x[1], reverse=True)[0][0])
