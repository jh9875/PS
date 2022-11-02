내 학점을 구해줘
===

문제 링크 : https://www.acmicpc.net/problem/10984

<br>

### 풀이

평점 구하는 방법을 알면 쉽게 풀 수 있다.

일단 총 학점은 모든 학점을 더하면 된다.

총 평점은 학점 x 평점의 합에 전체 평점 / 전체 학점으로 구하면 된다...

```Python
    total_credit, total_grade = 0, 0.0

    for _ in range(n):
        input_line = sys.stdin.readline().split()
        credit = int(input_line[0])
        grade = float(input_line[1])
        total_credit += credit
        total_grade += credit * grade

    gpa = total_grade / total_credit
    ans.append("{0} {1}".format(total_credit, "%0.1f" % gpa))
```

이 문제를 풀면서 몰랐던 사실을 알았다..

파이썬에서 의미없는 변수를 사용할 때 언더바를 사용하기도 한다..
위와 같이 for문에 의미없는 i 변수를 사용할 때 그러면 된다..

그리고 그 외에도 다른 용도가 있는 것 같다.
