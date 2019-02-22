def binary_search(collection, target):

    def inner(collection, target):
        if not collection:
            return False
        middle_index = len(collection)//2
        candidate = collection[middle_index]
        if candidate[1] == target:
            return candidate[0]
        if candidate[1] > target:
            return inner(collection[:middle_index], target)
        if candidate[1] < target: 
            return inner(collection[middle_index+1:], target)

    return inner(list(enumerate(collection)), target)


# TEST
my_list = list(range(10000))
assert binary_search(my_list, 5555) == 5555
