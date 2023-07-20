/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = null;
        
        while(temp.next != null){
            int v = temp.val;
            temp.val = temp.next.val;
            temp.next.val = v;
            prev = temp;
            temp = temp.next;
        }
        
        if(prev != null){
            prev.next = prev.next.next;
        }
    }
}