import sys

now_people, max_people = 0, 0

for _ in range(10):
    outgoing, incoming = map(int, sys.stdin.readline().rstrip().split())
    now_people += incoming - outgoing
    if now_people > max_people:
        max_people = now_people

print(max_people)
