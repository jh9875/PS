import sys

ans = []
T = int(sys.stdin.readline().rstrip())

for _ in range(T):
    index_str, string = sys.stdin.readline().rstrip().split()
    index = int(index_str) - 1

    ans.append(string[0: index] + string[index + 1: len(string)])

print('\n'.join(ans))
