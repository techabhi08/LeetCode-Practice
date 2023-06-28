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
        while(temp.next != null && temp.next.next != null){
            int val = temp.val;
            temp.val = temp.next.val;
            temp.next.val = val;
            
            temp = temp.next;
        }
        
        if(temp.next != null){
            temp.val = temp.next.val;
        }
        temp.next = null;
    }
}