import sys

dot_counter = {'Q1': 0, 'Q2': 0, 'Q3': 0, 'Q4': 0, 'AXIS': 0}

n = int(sys.stdin.readline())

for i in range(n):
    x, y = map(int, sys.stdin.readline().split())

    if x > 0 and y > 0:
        dot_counter['Q1'] += 1
    elif x < 0 and y > 0:
        dot_counter['Q2'] += 1
    elif x < 0 and y < 0:
        dot_counter['Q3'] += 1
    elif x > 0 and y < 0:
        dot_counter['Q4'] += 1
    else:
        dot_counter['AXIS'] += 1

ans = list()

for item in dot_counter.items():
    ans.append('{0}: {1}'.format(item[0], item[1]))

print('\n'.join(ans))

