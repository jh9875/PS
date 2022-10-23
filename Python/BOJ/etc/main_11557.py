import sys

if __name__ == '__main__':
    ans = list()
    input_test_case = int(sys.stdin.readline())

    for case in range(input_test_case):
        n = int(sys.stdin.readline())
        max_univ = str()
        max_consumption = 0

        for i in range(n):
            input_line = sys.stdin.readline().split()
            univ = input_line[0]
            consumption = int(input_line[1])

            if consumption > max_consumption:
                max_univ = univ
                max_consumption = consumption

        ans.append(max_univ)

    print('\n'.join(ans))
