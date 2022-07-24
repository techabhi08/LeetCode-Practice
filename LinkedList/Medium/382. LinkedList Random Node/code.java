/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head;
    int size;
    
    public Solution(ListNode head) {
        this.head = head;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        int num = (int)(Math.random() * size);
        ListNode node = head;
        while(num != 0){
            node = node.next;
            num--;
        }
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
