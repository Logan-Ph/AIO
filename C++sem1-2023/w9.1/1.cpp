#include <iostream>

using namespace std;

class Node
{
public:
    int value;
    Node *next;
    Node *prev;
    Node(int value, Node *next_ = nullptr, Node *prev_ = nullptr) : value(value), next{next_}, prev{prev_} {};
};

void printForward(Node *head)
{
    for (Node *temp = head; temp != nullptr; temp = temp->next)
    {
        cout << temp->value << "-->";
    }
    cout << endl;
}

void printBackward(Node *tail)
{
    for (Node *temp = tail; temp != nullptr; temp = temp->prev)
    {
        cout << temp->value << "-->";
    }
    cout << endl;
}

void insertNode(Node *&head, Node *&tail, Node *priorNode, Node *newNode)
{
    if (priorNode == nullptr)
    {
        newNode->next = head;
        head->prev = newNode;
        return;
    }

    if (priorNode == tail)
    {
        tail->next = newNode;
        newNode->prev = tail;
        return;
    }

    priorNode->next->prev = newNode;
    newNode->next = priorNode->next;
    newNode->prev = priorNode;
    priorNode->next = newNode;
    return;
}

void deletNode(Node *&head, Node *&tail, Node *delNode)
{
    if (delNode == head)
    {
        Node *temp = head;
        head->next->prev = nullptr;
        head = head->next;
        delete temp;
        return;
    }

    if (delNode == tail)
    {
        Node *temp = tail;
        tail->prev->next = nullptr;
        tail = tail->prev;
        delete temp;
        return;
    }

    delNode->prev->next = delNode->next;
    delNode->next->prev = delNode->prev;
    delete delNode;
    return;
}

void swapNode(Node *&head, Node *&tail, Node *node1, Node *node2)
{
    if (!node1 || !node2 || node1 == node2)
    {
        return;
    }

    Node *temp = node1->next;
    node1->next = node2->next;
    node2->next = temp;
    if (node1->next != nullptr)
    {
        node1->next->prev = node1;
    }
    else
    {
        tail = node1;
    }

    if (node2->next != nullptr)
    {
        node2->next->prev = node2;
    }
    else
    {
        tail = node2;
    }

    temp = node1->prev;
    node1->prev = node2->prev;
    node2->prev = temp;

    if (node1->prev != nullptr)
    {
        node1->prev->next = node1;
    }
    else
    {
        head = node1;
    }

    if (node2->prev != nullptr)
    {
        node2->prev->next = node2;
    }
    else
    {
        head = node2;
    }
}

int main(int argc, char const *argv[])
{
    Node *node8 = new Node(8);
    Node *node5 = new Node(5);
    Node *node3 = new Node(3);
    Node *node6 = new Node(6);

    node8->next = node5;
    node5->next = node3;
    node3->next = node6;

    node6->prev = node3;
    node3->prev = node5;
    node5->prev = node8;

    // Node *temp = new Node(2);
    // insertNode(node8, node6, node3, temp);
    // deletNode(node8, node6, node6);
    printForward(node8);
    printBackward(node6);
    swapNode(node8, node6, node5, node3);
    printForward(node8);
    printBackward(node6);
    return 0;
}
