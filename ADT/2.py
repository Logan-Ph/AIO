array = [6, 8, 10, 11, 6, 10]
new_array=[0]*20

for i in array:
    if new_array[i]==0:
        print(i,end=" ")
        new_array[i]+=1
    else:
        continue



array = [6, 8, 10, 11, 6, 10]
new_array=set(array)
print(list(new_array))