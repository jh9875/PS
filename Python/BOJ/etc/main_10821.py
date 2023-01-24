line = input()

ans = 0
number_list = line.split(',')

for number in number_list:
    if number.find('.') == -1:
        ans += 1

print(ans)
