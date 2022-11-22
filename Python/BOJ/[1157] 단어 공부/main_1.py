word = input().upper()

alphabet_set = set(word)
alphabet_count_dict = dict()

for alphabet in alphabet_set:
    alphabet_count_dict[alphabet] = word.count(alphabet)

sorted_word_list = sorted(alphabet_count_dict.items(), key=lambda x: x[1])

if len(sorted_word_list) > 1:
    if sorted_word_list[-1][1] == sorted_word_list[-2][1]:
        print('?')
    else:
        print(sorted_word_list[-1][0])
else:
    print(sorted_word_list[0][0])
