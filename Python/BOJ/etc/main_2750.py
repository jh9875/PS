import sys

N = int(sys.stdin.readline().rstrip())
num_list = []

for _ in range(N):
    num_list.append(int(sys.stdin.readline().rstrip()))

print('\n'.join(map(str, sorted(num_list))))
