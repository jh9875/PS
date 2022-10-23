import sys

ans = list()
test_case_input = int(input())

for case in range(test_case_input):
    total_y, total_k = 0, 0

    for inning in range(9):
        score_y, score_k = map(int, sys.stdin.readline().split())

        total_y += score_y
        total_k += score_k

    if total_y > total_k:
        ans.append('Yonsei')
    elif total_y < total_k:
        ans.append('Korea')
    else:
        ans.append('Draw')

print('\n'.join(ans))
