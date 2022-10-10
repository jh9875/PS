import sys
from io import StringIO

def execute_mars_math(math_expression):
    mars_ath_result = float(math_expression[0])
    for e in math_expression[1:]:
        if '@' == e:
            mars_ath_result *= 3
        elif '%' == e:
            mars_ath_result += 5
        elif '#' == e:
            mars_ath_result -= 7
    return mars_ath_result


ans_list = list()
T = int(sys.stdin.readline())
for i in range(T):
    case = sys.stdin.readline().split()
    result = execute_mars_math(case)
    ans_list.append(format(result, '.2f'))

print('\n'.join(ans_list))
