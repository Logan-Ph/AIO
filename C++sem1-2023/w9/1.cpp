#include <iostream>
#include <string>

using namespace std;

class Node{
public:
    int value;
    Node *next = nullptr;
    Node *prev = nullptr;
    Node(int value):value{value}{};
    Node(int value, Node *next): value{value}, next{next}{};
    Node(int value, Node *next, Node *prev): value{value}, next{next}, prev{prev}{};
};

void printForward(Node *head){
    for (Node* temp = head; temp; temp = temp->next){
        if (temp->next == nullptr){
            cout << temp->value << endl;
        }else{
            cout << temp->value << " -->  ";
        }
    }
}

void printBackward(Node *tail){
    for (Node* temp = tail; temp; temp = temp->prev){
        if (temp->prev == nullptr){
            cout << temp->value << endl;
        }else{
            cout << temp->value << " -->  ";
        }
    }
}

void insertNode(Node *&head, Node *&tail, Node *priorNode, Node *newNode){
    Node *temp = head;
    if (!priorNode){
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
        return;
    }

    if (priorNode == tail){
        tail->next = newNode;
        newNode->prev = tail;
        tail = newNode;
        return;
    }

    while (temp)
    {   
        if (temp == priorNode){
            newNode->next= temp->next;
            newNode->prev = temp;
            temp->next->prev = newNode;
            temp->next = newNode;
            break;
        }
        temp = temp->next;
    }
}

void deleteNode(Node *&head, Node *&tail, Node *delNode){
    if (delNode==head){
        head = head->next;
        head->prev = nullptr;
        delete delNode;
        delNode = nullptr;
        return;
    }

    if (delNode == tail){
        tail = tail->prev;
        tail->next = nullptr;
        delete delNode;
        delNode = nullptr;
        return;
    }

    Node *temp = head;
    while (temp)
    {
        if (temp->next == delNode){
            temp->next = delNode->next;
            temp->next->prev = temp;
            delete delNode;
            delNode = nullptr;
            return;
        }
        temp = temp->next;
    }
}

void swapNode(Node *&head, Node *&tail, Node *node1, Node *node2){
    if (!node1 || !node2 || node1 == node2){
        return;
    }

    Node *temp = node1->next;
    node1->next = node2->next;
    node2->next = temp;
    if (node1->next != nullptr){
        node1->next->prev = node1;
    }else{
        tail = node1;
    }

    if (node2->next != nullptr){
        node2->next->prev = node2;
    }else{
        tail = node2;
    }

    temp = node1->prev;
    node1->prev = node2->prev;
    node2->prev = temp;

    if (node1->prev != nullptr){
        node1->prev->next = node1;
    }else{
        head = node1;
    }

    if (node2->prev != nullptr){
        node2->prev->next = node2;
    }else{
        head = node2;
    }
}

Node *findNode(Node *& head, int index){
    int i =0;
    Node *temp = head;
    while (temp)
    {
        if (i == index){
            return temp;
        }
        i++;
        temp = temp->next;
    }
    return nullptr;
}

void bubbleSort(Node *&head, Node *&tail, int n){
    int i,j;
    bool swapped;
    Node *temp = head;
    for (i = 0; i < n - 1; i++){
        swapped = false;
        for (j = 0; j < n - i - 1; j++){
            Node *node1 = findNode(head,j);
            Node *node2 = node1->next;
            if (node1->value > node2->value){
                swapNode(head,tail,node1,node2);
                swapped = true;
            }
        }
        if (!swapped){
            break;
        }
    }
}

int findLength(Node *&head){
    int i;
    Node *temp = head;
    while (temp)
    {
        temp = temp->next;
        i++;
    }
    return i;
}

int main(){
    Node *head = new Node(8);
    Node *node1 = new Node(5);
    Node *node2 = new Node(3);
    Node *node3 = new Node(6);
    Node *tail = new Node(12);

    head->next = node1;
    node1->next = node2;
    node1->prev = head;
    node2->next = node3;
    node2->prev = node1;
    node3->next = tail;
    node3->prev = node2;
    tail->prev = node3;

    printForward(head);
    bubbleSort(head,tail,findLength(head));
    printBackward(tail);
}