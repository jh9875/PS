첫 글자를 대문자로
===

문제 링크 : https://www.acmicpc.net/problem/4458

<br>

### 풀이

파이썬 문자열 관련 함수를 찾아보니 제일 앞글자만 대문자로 바꿔주는 함수는 없는 것 같았다.
그래서 제일 첫번째 글자랑 나머지 글자랑 분리해서 제일 첫글짜를 대문자로 변경한 다음 붙여줬다.

```Python
ans.append(sentence[:1].upper() + sentence[1:])
```