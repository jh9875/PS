import sys

prices = []

for i in range(10):
    prices.append(int(sys.stdin.readline()))

print(prices[0] - sum(prices[1:10]))
