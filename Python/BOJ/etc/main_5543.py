burgers = []
beverages = []

for _ in range(3):
    burgers.append(int(input()))

for _ in range(2):
    beverages.append(int(input()))

burgers.sort()
beverages.sort()

print(burgers[0] + beverages[0] - 50)
