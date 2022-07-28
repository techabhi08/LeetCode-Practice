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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head == null){
            return ans;
        }
        
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        
        temp = head;
        int arrLength = size / k;
        int extraLength = size % k;
        int index = 0;
        
        while(temp != null){
            ListNode curr = temp;
            
            int diff = extraLength > 0 ? 1 : 0;
            for(int i = 0; i < arrLength + diff - 1; i++){
                temp = temp.next;
            }
            
            ListNode nex = temp.next;
            temp.next = null;
            temp = nex;
            
            extraLength--;
            ans[index++] = curr;
        }
        return ans;
    }
}
