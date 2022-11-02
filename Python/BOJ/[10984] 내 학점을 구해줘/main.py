import sys

ans = []
test_case_input = int(sys.stdin.readline())

for _ in range(test_case_input):
    n = int(sys.stdin.readline())
    total_credit, total_grade = 0, 0.0

    for _ in range(n):
        input_line = sys.stdin.readline().split()
        credit = int(input_line[0])
        grade = float(input_line[1])
        total_credit += credit
        total_grade += credit * grade

    gpa = total_grade / total_credit
    ans.append("{0} {1}".format(total_credit, "%0.1f" % gpa))

print('\n'.join(ans))
