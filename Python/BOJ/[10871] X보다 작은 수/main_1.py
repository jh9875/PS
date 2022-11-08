ans = []
n, x = map(int, input().split())

num_list = map(int, input().split())

for num in num_list:
    if num < x:
        ans.append(num)

print(' '.join(map(str, ans)))
