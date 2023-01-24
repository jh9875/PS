import sys

ans = []
t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    number_list = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    even_number_list = list(filter(lambda n: n % 2 == 0, number_list))
    ans.append(' '.join(map(str, [sum(even_number_list), min(even_number_list)])))

print('\n'.join(ans))
