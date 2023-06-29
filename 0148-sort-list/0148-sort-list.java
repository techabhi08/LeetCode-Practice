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
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        temp = head;
        ListNode curr = dummy;
        
        int i = 0;
        while(curr != null && i < list.size()){
            curr.next = new ListNode(list.get(i++));
            curr = curr.next;
        }
        return dummy.next;
    }
}