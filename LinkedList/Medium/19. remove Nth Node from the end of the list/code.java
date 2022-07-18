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
        if(head == null){
            return head;
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        temp = head;
        for(int i = 0; i < count - n - 1; i++){
            temp = temp.next;
        }
        
        if(count == n){
            head = temp.next;
        }else{
            temp.next = temp.next.next;
        }
        
        return head;
    }
}
