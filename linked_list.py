class Node:
    def __init__(self,val=None,next=None):
        self.val = val
        self.next = next
    
class LinkedList:
    def __init__(self):
        self.head = None
    
    def insert_at_begining(self,val):
        node = Node(val,self.head)
        self.head = node
    
    def insert_at_the_end(self,val):
        if not self.head:
            node = Node(val,None)
            return
        
        itr = self.head
        while itr.next:
            itr = itr.next

        itr.next = Node(val,None)

    def print(self):
        if not self.head:
            print("Linked list is empty")

        itr = self.head
        llstr = ""
        while itr:
            llstr += str(itr.val) + "->"
            itr = itr.next
        print(llstr)

    def insert_values(self, val_list):
        self.head = None
        for i in val_list:
            self.insert_at_the_end(i)

    def get_length(self):
        itr = self.head
        count = 0 
        while itr:
            count +=1
            itr = itr.next

        return count

    def remove_at(self,index):
        if index < 0 or self.get_length() <= index:
            raise Exception("Invalid Index")

        if index == 0:
            self.head = self.head.next
            return

        itr = self.head
        count = 0
        while itr:
            if count == index - 1:
                itr.next = itr.next.next
                break
            itr = itr.next
            count +=1


if __name__ == "__main__":
    ll = LinkedList()
    ll.insert_values(["sang","ngoc","tin","thien","kha"])
    ll.print() 






        