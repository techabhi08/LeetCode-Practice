/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        
        while(temp1 != null){
            sizeA++;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            sizeB++;
            temp2 = temp2.next;
        }
        
        int difference = Math.abs(sizeA - sizeB);
        
        for(int i = 1; i <= difference; i++){
            if(sizeA > sizeB){
                headA = headA.next;
            }else{
                headB = headB.next;
            }
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
