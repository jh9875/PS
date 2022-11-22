def judge_yut_result(yut_input: list) -> str:
    result = ''
    if sum(yut_input) == 3:
        result = 'A'
    elif sum(yut_input) == 2:
        result = 'B'
    elif sum(yut_input) == 1:
        result = 'C'
    elif sum(yut_input) == 0:
        result = 'D'
    elif sum(yut_input) == 4:
        result = 'E'
    return result


for _ in range(3):
    yut = list(map(int, input().split()))
    print(judge_yut_result(yut))
