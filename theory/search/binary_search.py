def recursion_binary_search(arr, start, end, key):
    if start > end:
        return -1
    mid = start + (end - start) / 2
    if arr[mid] > key:
        return recursion_binary_search(arr, start, end - 1, key)
    if arr[mid] < key:
        return recursion_binary_search(arr, start + 1, end, key)
    return mid

def loop_binary_search(arr, start, end, key):
    while start <= end:
        mid = start + (end - start) / 2
        if arr[mid] > key:
            end = mid - 1
        elif arr[mid] < key:
            start = mid + 1
        else:
            return mid
    return -1
