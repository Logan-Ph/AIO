def create_file(name):
    print("new_{} was created successfully.".format(name))
    new_file_path  = "C:\\Users\\phamp\\code\\github\\code\\new_{}".format(name)
    return new_file_path

def modify_file(name,new_file_path):
    file_path = "C:\\Users\\phamp\\code\\github\\code\\{}".format(name)
    number = 1
    try:
        with open(file_path) as f:
            with open(new_file_path,'w') as n:
                for line in f:
                        n.write(("{1}{0} ".format(line,number)).strip()+"\n")        
                        number += 1
    except:
        print("file name does not exist")


def main():
    name = input("Enter the name of your text file: ")
    new_file_path = create_file(name)
    modify_file(name,new_file_path)


main()