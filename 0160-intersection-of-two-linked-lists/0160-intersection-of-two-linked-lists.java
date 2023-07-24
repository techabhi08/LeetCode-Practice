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
        int sizeA = 0, sizeB = 0;
        ListNode temp = headA;
        while(temp != null){
            temp = temp.next;
            sizeA++;
        }
        temp = headB;
        while(temp != null){
            temp = temp.next;
            sizeB++;
        }
        
        ListNode tempA = headA, tempB = headB;
        if(sizeA > sizeB){
            while(sizeA-- != sizeB){
                tempA = tempA.next;
            }
        }else{
            while(sizeB-- != sizeA){
                tempB = tempB.next;
            }
        }
        
        while(tempA != null && tempB != null){
            if(tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}