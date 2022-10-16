import sys

x_set = set()
y_set = set()

for i in range(3):
    x, y = map(int, sys.stdin.readline().split())
    if x in x_set:
        x_set.remove(x)
    else:
        x_set.add(x)
    if y in y_set:
        y_set.remove(y)
    else:
        y_set.add(y)

print(x_set.pop(), y_set.pop())
