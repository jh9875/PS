N = int(input())
divisor = 2
ans = list()

while N > 1:
    if N % divisor == 0:
        ans.append(str(divisor))
        N //= divisor
    else:
        divisor += 1

print('\n'.join(ans))
