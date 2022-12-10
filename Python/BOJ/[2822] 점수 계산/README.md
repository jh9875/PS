행렬 덧셈
===

문제 링크 : https://www.acmicpc.net/problem/2822

<br>

### 풀이

입력받은 수들을 기존 순서를 유지해야하기 때문에 원본 배열을 카피하는 방법을 사용해봤다.

```Python
copy_score_list = score_list.copy()

copy_score_list.sort(reverse=True)
```

저렇게 .copy() 메소드를 사용하면 얕은 복사가 가능하다.

그리고 높은 순설를 확인하기위해 sort를 역순으로 해준다.

```Python
total = 0
order = []
for score in copy_score_list[0:5]:
    total += score
    order.append(score_list.index(score) + 1)
```

그리고 상위 5개에 대해서 합 값인 total을 구해주고, index() 함수를 통해 순서를 확인해준다.