input_result = 1
for _ in range(3):
    input_result *= int(input())

input_number_list = list(str(input_result))

ans = []

for num in range(10):
    ans.append(input_number_list.count(str(num)))

print('\n'.join(map(str, ans)))
