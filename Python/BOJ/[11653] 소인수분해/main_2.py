import math

N = int(input())
divisor = 2
ans = list()

sqrt = int(math.sqrt(N))

while divisor <= sqrt:
    if N % divisor == 0:
        ans.append(str(divisor))
        N //= divisor
    else:
        divisor += 1

if N > 1:
    ans.append(str(N))
print('\n'.join(ans))
