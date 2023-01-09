number_list = []

for _ in range(5):
    number_list.append(int(input()))

print(sum(number_list) // len(number_list))
print(sorted(number_list)[2])
