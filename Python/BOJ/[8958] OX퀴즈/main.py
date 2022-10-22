import sys


def get_ox_quiz_result_score(ox_result: str):
    total_score = 0
    score = 0

    for ch in ox_result:
        if 'O' == ch:
            score += 1
            total_score += score
        elif 'X' == ch:
            score = 0

    return total_score


ans = list()
num_of_test_case = int(input())

for i in range(num_of_test_case):
    ox_result_input = input()
    ans.append(get_ox_quiz_result_score(ox_result_input))

print('\n'.join(map(str, ans)))
