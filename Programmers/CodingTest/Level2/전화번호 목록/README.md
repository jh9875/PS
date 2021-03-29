전화번호 목록
===

문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577

<br>

### 풀이

이전에는 이중 for문으로 통과가 되었었는데 테스트 케이스가 변경된 후 통과가 되지 않는다.

대신 배열을 정렬하고 for문 한 개로 해결할 수 있다.

Arrays.sort()로 정렬하고 만약 접두사 관계가 있다면, 현재 숫자 인덱스를 i라고 할 때 phone_book[i+1].startsWith(phone_boot[i])가 성립한다.

