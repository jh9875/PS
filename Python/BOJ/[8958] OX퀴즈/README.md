OX퀴즈
===

문제 링크 : https://www.acmicpc.net/problem/8958

<br>

### 풀이

각 퀴즈의 점수를 출력하면 된다.

```Python
def get_ox_quiz_result_score(ox_result: str):
    total_score = 0
    score = 0

    for ch in ox_result:
        if 'O' == ch:
            score += 1
            total_score += score
        elif 'X' == ch:
            score = 0

    return total_score
```

연속적인 점수를 저장하기위해 score라는 변수를 만들어줬다.

그리고 O이면 그에 맞게 score를 추가해주고 X면 초기화 해준다.