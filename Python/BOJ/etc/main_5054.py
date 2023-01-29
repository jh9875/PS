import sys

ans = []
t = int(sys.stdin.readline().rstrip())

for _ in range(t):
    n = int(sys.stdin.readline().rstrip())
    stores = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    stores.sort()
    min_distance = 0

    for store_index in range(1, len(stores)):
        min_distance += (stores[store_index] - stores[store_index - 1])

    ans.append(min_distance + stores[len(stores) - 1] - stores[0])

print('\n'.join(map(str, ans)))
