str = input()
sub_str = input()

while sub_str in str:
    index = str.index(sub_str)
    str = str[:index] + str[index+len(sub_str):] 

print(str)






