#include "iostream"
#include "string"

using namespace std;

class Node{
public:
    Node* next{};
    Node* prev{};
    int value{};
    explicit Node(int value) : value(value) {}
};

void printForward(Node *node){
    while (node != nullptr){
        cout << node->value << "->";
        node = node->next;
    }
}

void printBackWard(Node *node){
    while (node != nullptr){
        cout << node->value << "->";
        node = node->prev;
    }
}

void insertNode(Node *head, Node *tail, Node *priorNode, Node *newNode) {
    if (priorNode == nullptr){
        newNode->next = head;
        head->prev = newNode;
    }else if (priorNode == tail){
        tail->next = newNode;
        newNode ->prev = tail;
    }else{
        newNode->next = priorNode->next;
        priorNode->next->prev = newNode;
        priorNode->next = newNode;
        newNode->prev = priorNode;
    }
}

void deleteNode(Node *&head, Node *&tail, Node *delNode){
    if (tail == delNode){
        tail->prev->next = nullptr;
        delete tail;
        tail = nullptr;
    }else if (head == delNode){
        head->next->prev = nullptr;
        delete head;
        head = nullptr;
    } else{
        Node *currentNode = head;
        while (currentNode!= nullptr){
            if (currentNode == delNode){
                currentNode->prev->next = currentNode->next;
                currentNode->next->prev = currentNode->prev;
                break;
            }
            currentNode =  currentNode->next;
        }
    }
}


void swap(Node*& head, Node*& tail, Node* Node1, Node* Node2)
{
    // Edge Cases
    if (head == nullptr || head->next == nullptr || Node1 == Node2) return;

    // Swapping Node1 and Node2
    Node* temp = Node1->next;
    Node1->next = Node2->next;
    Node2->next = temp;

    if (Node1->next != nullptr)
        Node1->next->prev = Node1;
    if (Node2->next != nullptr)
        Node2->next->prev = Node2;

    temp = Node1->prev;
    Node1->prev = Node2->prev;
    Node2->prev = temp;

    if (Node1->prev != nullptr)
        Node1->prev->next = Node1;
    if (Node2->prev != nullptr)
        Node2->prev->next = Node2;
}

int findLength(Node *&head){
    Node *current = head;
    int n = 0;
    while (current!= nullptr){
        n+=1;
        current = current->next;
    }
    return n;
}

void sortLinkedList(Node *&head){
    int i, j;
    int n = findLength(head);
    bool swapped;
    int arr[n];

    Node *temp = head;
    int z = 0;
    while (temp!= nullptr){
        arr[z] = temp->value;
        temp = temp->next;
        z++;
    }

    for (i = 0; i < n - 1; i++) {
        swapped = false;
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }
        }
        if (!swapped)
            break;
    }

    temp = head;
    z = 0;
    while (temp!= nullptr){
        temp->value = arr[z];
        temp = temp->next;
        z++;
    }

}

template <typename T>
void myFunction(T myParam){
    cout << "The value of the parameter is : " << myParam << endl;
}

int main(){
    Node *head = new Node(8);
    Node *node2 = new Node(5);
    Node *node3 = new Node(3);
    Node *tail = new Node(6);

    head->next = node2;
    node2->next = node3;
    node3->next = tail;

    tail->prev = node3;
    node3->prev = node2;
    node2->prev = head;

    printForward(head);
    cout << endl;
    sortLinkedList(head);
    printForward(head);
}