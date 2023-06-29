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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    public ListNode findMid(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    
    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        
        while(left != null && right != null){
            if(left.val < right.val){
                head.next = left;
                left = left.next;
            }else{
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        
        if(left != null){
            head.next = left;
        }
        if(right != null){
            head.next = right;
        }
        
        return dummy.next;
    }
}