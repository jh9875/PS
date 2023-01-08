import sys

is_checked_number = [False for i in range(31)]

for i in range(28):
    index = int(sys.stdin.readline().rstrip())
    is_checked_number[index] = True

ans = []

for i in range(1, 31):
    if not is_checked_number[i]:
        ans.append(i)

print('\n'.join(map(str, ans)))

