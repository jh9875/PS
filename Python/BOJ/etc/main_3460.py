T = int(input())

ans = []

for _ in range(T):
    num = int(input())
    binary_element_list = list(str(bin(num))[2:])

    binary_element_list.reverse()
    binary_list = []
    for i in range(len(binary_element_list)):
        if binary_element_list[i] == '1':
            binary_list.append(i)

    ans.append(' '.join(map(str, binary_list)))

print('\n'.join(ans))
