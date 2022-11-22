word = input().upper()

alphabet_count_list = []

for i in range(65, 91):
    alphabet_count_list.append(word.count(chr(i)))

max_count = max(alphabet_count_list)

if alphabet_count_list.count(max_count) > 1:
    print('?')
else:
    print(chr(65 + alphabet_count_list.index(max_count)))
