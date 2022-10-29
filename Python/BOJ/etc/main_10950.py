import sys

input_test_case = int(sys.stdin.readline())
ans = []

for i in range(input_test_case):
    a, b = map(int, sys.stdin.readline().split())
    ans.append(a + b)

print('\n'.join(map(str, ans)))