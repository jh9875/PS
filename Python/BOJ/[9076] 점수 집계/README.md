점수 집계
===

문제 링크 : https://www.acmicpc.net/problem/9076

<br>

### 풀이

문제에 나와있는대로 구현만 하면 된다.

그 요구사항에 만족하는 함수를 다음과 같이 만들어봤다.

```Python
def get_total_score(score_list: list):
    score_list.sort()
    diff = score_list[3] - score_list[1]

    if diff >= 4:
        return 'KIN'
    else:
        return str(sum(score_list[1:4]))
```

1. 정렬
2. 2번째 4번째 차이 구하기
3. 차이 벼교
4. 결과에 따라서 부분 합 또는 KIN 반환.
