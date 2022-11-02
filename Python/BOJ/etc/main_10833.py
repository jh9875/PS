import sys

n = int(input())
ans = 0

for i in range(n):
    num_of_students, num_of_apples = map(int, sys.stdin.readline().split())
    ans += num_of_apples % num_of_students;

print(ans)
