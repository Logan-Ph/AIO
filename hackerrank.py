s = input()
s = s[1:len(s)-1]
p = input()
p = p[1:len(p)-1]
list_p = []
[list_p.append(i) for i in p]
if len(s) == len(p):
    print("true")
elif list_p[len(list_p)-1] == "*":
    print("true")
elif "." in list_p and list_p[len(list_p)-1] == "*":
    print("true")
elif "." in list_p:
    s.pop()
    if len(s) == len(p):
        print("true")
    else:
        print("false")
else:
    print("false")