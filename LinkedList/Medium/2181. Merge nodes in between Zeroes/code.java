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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        ListNode curr = head;
        
        int sum = 0;
        while(curr != null){
            if(curr.val == 0 && sum != 0){
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            sum += curr.val;
            curr = curr.next;
        }
        return ans.next;
    }
}
