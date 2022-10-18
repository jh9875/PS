# 필요 없으니 그냥 버림 ㅎ
input()
vote_input = input()

num_of_a = vote_input.count('A')
num_of_b = vote_input.count('B')

if num_of_a > num_of_b:
    print('A')
elif num_of_a < num_of_b:
    print('B')
else:
    print('Tie')
