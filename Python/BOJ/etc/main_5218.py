import sys


def get_dist_list(w1: str, w2: str) -> list:
    dist_list = []

    length = len(w1)
    for index in range(length):
        x = ord(w1[index])
        y = ord(w2[index])
        if x <= y:
            dist_list.append(y - x)
        else:
            dist_list.append(y + 26 - x)

    return dist_list


if __name__ == '__main__':
    ans = []
    t = int(sys.stdin.readline().rstrip())

    for _ in range(t):
        word1, word2 = sys.stdin.readline().rstrip().split(' ')
        distances = get_dist_list(word1, word2)

        ans.append("Distances: " + ' '.join(map(str, distances)))

    print('\n'.join(ans))
