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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head1 = list1;
        int i = 1;
        while(i < a){
            head1 = head1.next;
            i++;
        }
        
        ListNode temp = head1;
        while(i <= b){
            temp = temp.next;
            i++;
        }
        
        head1.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        
        list2.next = temp.next;
        return list1;
    }
}
