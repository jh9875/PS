import sys

n = int(sys.stdin.readline().rstrip())
number_list = []

for _ in range(n):
    number_list.append(int(sys.stdin.readline().rstrip()))

number_list.sort()

print('\n'.join(map(str, number_list)))
