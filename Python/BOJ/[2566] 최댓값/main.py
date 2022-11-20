import sys

max_value = 0
col, row = 0, 0

for row_num in range(9):
    row_line = list(map(int, sys.stdin.readline().rstrip().split()))
    max_value_in_row = max(row_line)
    if max_value < max_value_in_row:
        max_value = max_value_in_row
        col = row_line.index(max_value_in_row)
        row = row_num

print(max_value)
print(row + 1, col + 1)
