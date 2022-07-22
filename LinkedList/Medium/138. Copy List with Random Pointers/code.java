/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        
        Node temp = head;
        while(temp != null){
            Node n = new Node(temp.val);
            n.next = temp.next;
            temp.next = n;
            temp = temp.next.next;
        }
        
        temp = head;
        while(temp != null){
            if(temp.random == null){
                temp.next.random = null;
            }else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        temp = head;
        Node copyNode = head.next;
        Node ansHead = copyNode;
        while(temp != null){
            temp.next = temp.next.next;
            if(copyNode.next != null){
                copyNode.next = copyNode.next.next;
            }
            temp = temp.next;
            copyNode = copyNode.next;
        }
        return ansHead;
    }
}
