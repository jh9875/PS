def print_score(grade_input: str):
    if 'A+' == grade_input:
        print('4.3')
    elif 'A0' == grade_input:
        print('4.0')
    elif 'A-' == grade_input:
        print('3.7')
    elif 'B+' == grade_input:
        print('3.3')
    elif 'B0' == grade_input:
        print('3.0')
    elif 'B-' == grade_input:
        print('2.7')
    elif 'C+' == grade_input:
        print('2.3')
    elif 'C0' == grade_input:
        print('2.0')
    elif 'C-' == grade_input:
        print('1.7')
    elif 'D+' == grade_input:
        print('1.3')
    elif 'D0' == grade_input:
        print('1.0')
    elif 'D-' == grade_input:
        print('0.7')
    elif 'F' == grade_input:
        print('0.0')


grade = input()
print(print_score(grade))
