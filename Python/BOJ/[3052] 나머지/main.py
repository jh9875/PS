num_of_set = set()

for _ in range(10):
    num = int(input())
    num_of_set.add(num % 42)

print(len(num_of_set))
