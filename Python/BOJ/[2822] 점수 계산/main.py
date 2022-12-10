score_list = []

for _ in range(8):
    score_list.append(int(input()))

copy_score_list = score_list.copy()

copy_score_list.sort(reverse=True)

total = 0
order = []
for score in copy_score_list[0:5]:
    total += score
    order.append(score_list.index(score) + 1)

print(total)
print(' '.join(map(str, sorted(order))))
