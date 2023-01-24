import sys

ans = []

n = int(sys.stdin.readline().rstrip())
# 보유 여부만 판단하면 되므로 set 사용
card_number_set = set(sys.stdin.readline().rstrip().split(' '))

m = int(sys.stdin.readline().rstrip())
# 순서를 생각해야 하므로 list 사용
number_list = list(sys.stdin.readline().rstrip().split(' '))

for number in number_list:
    ans.append("1" if number in card_number_set else "0")

print(' '.join(ans))
