str = input()
word = input()
newstr =''

for i in range(len(str)):
    if word != str[i]:
        newstr += str[i]

print(newstr)