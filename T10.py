s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
string  = input()
a = ""
for i in range(26):
    for st in string:
        if st in s:
            idx = s.index(st)-i
            a+= s[idx]
    print(i)
    print(a)
    a = ""    
        
