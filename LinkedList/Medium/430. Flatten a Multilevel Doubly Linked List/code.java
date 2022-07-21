/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp != null){
            if(temp.child != null){
                Node tail = findEnd(temp.child);
                if(temp.next != null){
                    temp.next.prev = tail;
                }
                tail.next = temp.next;
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }
            temp = temp.next;
        }
        return head;
    }
    
    public Node findEnd(Node node){
        while(node.next != null){
            node = node.next;
        }
        return node;
    }
}
