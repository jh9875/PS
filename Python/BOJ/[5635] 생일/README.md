생일
===

문제 링크 : https://www.acmicpc.net/problem/5635

<br>

### 풀이

각 라인을 list(tuple() .. )에 저장한 다음 정렬하면 된다.

일단 데이터는 다음과 같이 받았다.

```Python
students = list()

n = int(sys.stdin.readline())

for i in range(n):
    name, day, month, year = sys.stdin.readline().split()
    students.append((name, int(day), int(month), int(year)))
```

연,월,일은 정렬해야되기 때문에 int()로 바꿔줬다.

그리고 정렬 및 출력은 다음과 같이 해줬다.

```Python
students.sort(key=lambda student: (student[3], student[2], student[1]))

print(students[len(students) - 1][0])
print(students[0][0])
```

정렬은 list의 함수인 sort()로 해줬다.

정렬 조건을 정해주기 위해서 key를 지정할 수 있는데 lambda를 사용한다.

: 뒤에 조건을 적어줄 수 있는데, 다중일 경우 튜플 안에 순서대로 정렬 조건을 적어주면 된다.