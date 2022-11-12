from string import ascii_lowercase

ans = []
alphabet_list = list(ascii_lowercase)
word = input()

for alphabet in alphabet_list:
    ans.append(word.find(alphabet))

print(' '.join(map(str, ans)))
