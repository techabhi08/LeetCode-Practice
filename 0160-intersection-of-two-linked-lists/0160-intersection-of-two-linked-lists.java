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
        
        ListNode temp = headA;
        while(temp != null){
            sizeA++;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            sizeB++;
            temp = temp.next;
        }
        
        if(sizeA > sizeB){
            while(sizeA != sizeB){
                headA = headA.next;
                sizeA--;
            }
        }else{
            while(sizeA != sizeB){
                headB = headB.next;
                sizeB--;
            }
        }
        
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}