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
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int size = 0;
        int ans = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        
        node = head;
        size--;
        while(node != null){
            ans += Math.pow(2, size) * node.val;
            size--;
            node = node.next;
        }
        
        return ans;
        
        
    }
}
