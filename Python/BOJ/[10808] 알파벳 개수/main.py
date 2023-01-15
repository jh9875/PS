# 'a' ascii code
A_LOWER_CASE_ASCII_CODE = 97

# a~z 26 alphabets
alphabet_counter = [0 for _ in range(26)]

word = input()

for ch in list(word):
    index = ord(ch) - A_LOWER_CASE_ASCII_CODE
    alphabet_counter[index] += 1

# print(' '.join(map(str, alphabet_counter)))
print(*alphabet_counter)
