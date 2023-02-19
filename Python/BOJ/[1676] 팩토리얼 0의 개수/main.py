import math
import sys

n = int(sys.stdin.readline().rstrip())
result = math.factorial(n)

ans = 0
divisor = 10
quotient = 0

while quotient == 0:
    quotient = result % divisor

    if quotient == 0:
        ans += 1
        divisor *= 10

print(ans)
