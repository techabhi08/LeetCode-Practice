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
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        
        int nodes = size / k;
        int extras = size % k;
        ListNode[] result = new ListNode[k];
        int index = 0;
        
        temp = head;
        while(temp != null){
            ListNode curr = temp;
            int diff = extras > 0 ? 1 : 0;
            
            for(int i = 0; i < nodes + diff - 1; i++){
                temp = temp.next;
            }
            
            ListNode nex = temp.next;
            temp.next = null;
            temp = nex;
            
            extras--;
            result[index++] = curr;
        }
        return result;
    }
}