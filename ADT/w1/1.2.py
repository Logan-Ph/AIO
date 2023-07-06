array = [7, 6, 9, 3, 2, 5] 
l = array[0]
temp = float('inf')
for i in range(1, len(array)):
    if l<array[i]:
        temp = l
        l = array[i]
print(temp)
