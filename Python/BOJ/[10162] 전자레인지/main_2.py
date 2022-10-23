A_BUTTON_SECOND = 60 * 5
B_BUTTON_SECOND = 60
C_BUTTON_SECOND = 10


def get_press_button_count(cooking_time: int):
    result = list()

    result.append(cooking_time // A_BUTTON_SECOND)
    cooking_time %= A_BUTTON_SECOND
    result.append(cooking_time // B_BUTTON_SECOND)
    cooking_time %= B_BUTTON_SECOND
    result.append(cooking_time // C_BUTTON_SECOND)
    cooking_time %= C_BUTTON_SECOND

    return result if cooking_time == 0 else None


if __name__ == '__main__':
    cooking_time_input = int(input())
    ans = get_press_button_count(cooking_time_input)

    if ans is None:
        print('-1')
    else:
        print(' '.join(map(str, ans)))
