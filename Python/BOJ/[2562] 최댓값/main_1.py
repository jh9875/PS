import sys

max_number = 0
numbers = list()

for i in range(9):
    n = int(sys.stdin.readline())
    numbers.append(n)
    if max_number < n:
        max_number = n

print(max_number)
print(numbers.index(max_number) + 1)
