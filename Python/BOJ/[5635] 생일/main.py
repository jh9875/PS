import sys

students = list()

n = int(sys.stdin.readline())

for i in range(n):
    name, day, month, year = sys.stdin.readline().split()
    students.append((name, int(day), int(month), int(year)))

students.sort(key=lambda student: (student[3], student[2], student[1]))

print(students[len(students) - 1][0])
print(students[0][0])
