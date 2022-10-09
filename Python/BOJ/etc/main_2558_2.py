import sys

input1 = int(input())
input2 = input()

for n in reversed(list(input2)):
    print(input1 * int(n))
print(input1 * int(input2))

