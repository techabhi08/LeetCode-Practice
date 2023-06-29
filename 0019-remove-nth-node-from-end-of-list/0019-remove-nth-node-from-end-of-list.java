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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        
        while(temp != null){
            temp = temp.next;
            size++;
        }
        
        int index = size - n;
        temp = head;
        while(index-- > 1){
            temp = temp.next;
        }
        
        if(n == size){
            head = temp.next;
        }else{
            temp.next = temp.next.next;
        }
        return head;
    }
}