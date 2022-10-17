def get_height_of_bowl(bowl: str):
    result = 10

    for i in range(1, len(bowl)):
        if bowl[i - 1] == bowl[i]:
            result += 5
        else:
            result += 10

    return result


bowl_input = input()
print(get_height_of_bowl(bowl_input))
