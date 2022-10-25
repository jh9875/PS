import sys

ONE_MINUTE = 60
ONE_HOUR = (ONE_MINUTE * 60)
ONE_DAY = (ONE_HOUR * 24)


def get_total_seconds(time_list: list):
    total_second = time_list[2] + (time_list[1] * ONE_MINUTE) + (time_list[0] * ONE_HOUR)
    return total_second


def get_diff_seconds(before_seconds: int, after_seconds: int):
    if before_seconds >= after_seconds:
        return ONE_DAY - before_seconds + after_seconds
    else:
        return after_seconds - before_seconds


def convert_to_time(seconds: int):
    time_list = list()

    time_list.append(str(seconds // ONE_HOUR).zfill(2))
    seconds %= ONE_HOUR
    time_list.append(str(seconds // ONE_MINUTE).zfill(2))
    seconds %= ONE_MINUTE
    time_list.append(str(seconds).zfill(2))

    return ':'.join(time_list)


if __name__ == '__main__':
    now_time_list = list(map(int, sys.stdin.readline().split(':')))
    start_time_list = list(map(int, sys.stdin.readline().split(':')))

    diff = get_diff_seconds(get_total_seconds(now_time_list), get_total_seconds(start_time_list))
    print(convert_to_time(diff))
