N = int(input())
divisor_list = list(map(int, input().split()))

divisor_list.sort()

print(divisor_list[0] * divisor_list[N - 1])
