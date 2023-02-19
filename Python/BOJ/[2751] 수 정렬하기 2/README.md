수 정렬하기 2
===

문제 링크 : https://www.acmicpc.net/problem/2751

<br>

### 풀이

수를 정렬하는 문제이다.

보통 모든 언어마다 리스트 자료형에 정렬하는 함수가 구현되어있다.

이미 있는걸 사용하는게 빠를것 같으니 그걸 사용해주고, 출력할때는 하나씩 출력하지 않도록 주의해준다.

java 같은 경우는 StringBuilder와 같이 문자열들을 한번에 출력할 수 있는 것이 있다.

python에서는 string에 join이라는 메소드를 이용하면된다.

```Python
print('\n'.join(map(str, number_list)))
```

개행 문자인 '\n'을 join 메소드로 호출하고 정렬된 숫자 list를 인자로 넣어준다.

단 주의할 점은 join으로 할 경우 str 타입으로 들어가야 한다. 만약 아니라면 map으로 str로 변경 해주면 된다.