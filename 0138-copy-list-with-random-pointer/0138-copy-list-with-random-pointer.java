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
        
        //Creating the duplicate nodes in the same list
        Node temp = head;
        while(temp != null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        
        temp = head;
        while(temp != null){
            if(temp.random != null){
                temp.next.random = temp.random.next;
            }else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        
        temp = head;
        Node ansNode = head.next;
        Node ans = ansNode;
        
        while(temp != null){
            temp.next = temp.next.next;
            if(ansNode.next != null){
                ansNode.next = ansNode.next.next;
            }
            temp = temp.next;
            ansNode = ansNode.next;
        }
        return ans;
    }
}