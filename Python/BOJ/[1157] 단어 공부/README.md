단어 공부
===

문제 링크 : https://www.acmicpc.net/problem/1157

<br>

### 풀이

처음엔 그냥 set을 이용해서 단어에 포함된 각 알파벳의 수를 count로 세고, 중복이 있으면 ?를 출력하고 아니면 알파벳을 출력하도록 했다.

```Python
word = input().upper()

alphabet_set = set(word)
alphabet_count_dict = dict()

for alphabet in alphabet_set:
    alphabet_count_dict[alphabet] = word.count(alphabet)

sorted_word_list = sorted(alphabet_count_dict.items(), key=lambda x: x[1])

if len(sorted_word_list) > 1:
    if sorted_word_list[-1][1] == sorted_word_list[-2][1]:
        print('?')
    else:
        print(sorted_word_list[-1][0])
else:
    print(sorted_word_list[0][0])

```

근데 뭔가 난잡하고, sorted_word_list의 길이를 검사하는 부분이 깔끔하지가 않다..

그래서 다른 사람의 코드를 찾아봤는데 아스키 코드를 이용해서 풀었다.

대문자 A~Z까지 아스키 코드로 검사한 후 중복수가 1 이상이면 알파벳 출력, 아니면 ?출력이다.

```Python
word = input().upper()

alphabet_count_list = []

for i in range(65, 91):
    alphabet_count_list.append(word.count(chr(i)))

max_count = max(alphabet_count_list)

if alphabet_count_list.count(max_count) > 1:
    print('?')
else:
    print(chr(65 + alphabet_count_list.index(max_count)))

```