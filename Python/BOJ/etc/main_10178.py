import sys

MESSAGE_FORMAT = 'You get {0} piece(s) and your dad gets {1} piece(s).'

ans = []
test_case = int(sys.stdin.readline())

for _ in range(test_case):
    candies, brothers = map(int, sys.stdin.readline().split())
    ans.append(MESSAGE_FORMAT.format(candies // brothers, candies % brothers))

print('\n'.join(ans))