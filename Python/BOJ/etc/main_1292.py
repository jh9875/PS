A, B = map(int, input().split())

max_value = (B * (B + 1)) // 2

num_list = []
count = 0

for i in range(1, max_value):
    for j in range(i):
        num_list.append(i)
        count += 1
        if count > B:
            break

if A == 1 and B == 1:
    print(1)
else:
    print(sum(num_list[A - 1: B]))
