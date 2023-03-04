import sys

ans = []
t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    input_line = sys.stdin.readline().rstrip().split(',')
    ans.append(str(int(input_line[0]) + int(input_line[1])))

print('\n'.join(ans))
