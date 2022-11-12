ans = []
start, end = ord('a'), ord('z')
word = input()

for i in range(start, end + 1):
    ans.append(word.find(chr(i)))

print(' '.join(map(str, ans)))
