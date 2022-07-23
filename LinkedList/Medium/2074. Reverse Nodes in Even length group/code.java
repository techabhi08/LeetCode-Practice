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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        temp = dummy;
        
        int count = 1;
        while(temp.next != null){
            int nodes = Math.min(count ,size);
            size -= count;
            
            if(nodes % 2 == 1){
                for(int i = 0; i < nodes; i++){
                    temp = temp.next;
                }
            }else{
                temp = reverse(temp, count);
            }
            count++;
        }
        return head;
    }
    
    public ListNode reverse(ListNode temp, int count){
        ListNode prev = temp;
        ListNode end = temp.next;
        ListNode curr = temp.next;
        ListNode nex = curr.next;
        
        while(count > 0 && curr != null){
            curr.next = prev;
            prev = curr;
            curr = nex;
            if(nex != null){
                nex = nex.next;
            }
            count--;
        }
        temp.next = prev;
        end.next = curr;
        temp = end;
        return temp;
    }
    
    
}
