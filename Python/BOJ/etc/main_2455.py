import sys

total_num_of_people, ans = 0, 0

for _ in range(4):
    outgoing, incoming = map(int, sys.stdin.readline().split())
    total_num_of_people += (incoming - outgoing)
    ans = max(ans, total_num_of_people)

print(ans)
