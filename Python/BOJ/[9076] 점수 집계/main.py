import sys


def get_total_score(score_list: list):
    score_list.sort()
    diff = score_list[3] - score_list[1]

    if diff >= 4:
        return 'KIN'
    else:
        return str(sum(score_list[1:4]))


if __name__ == '__main__':
    ans = []

    t = int(input())
    for _ in range(t):
        scores = list(map(int, sys.stdin.readline().rstrip().split(' ')))
        result = get_total_score(scores)
        ans.append(result)

    print('\n'.join(ans))
