ans = []
n, x = map(int, input().split())

num_list = map(int, input().split())

print(list(filter(lambda num: num < x, num_list)))
