ans = []
T = int(input())

for _ in range(T):
    N = int(input())
    sum_of_line = sum(list(map(int, input().split())))
    ans.append(sum_of_line)

print('\n'.join(map(str, ans)))
