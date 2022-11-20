최댓값
===

문제 링크 : https://www.acmicpc.net/problem/2566

<br>

### 풀이

2차원 배열이지만 순서대로 입력된다.

각 입력마다 최댓값은 얼마이고, 어떤 순서에 입력됐는지 찾는 방법으로 해결해봤다.

```Python
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

```