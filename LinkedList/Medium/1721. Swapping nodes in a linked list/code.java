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
    public ListNode swapNodes(ListNode head, int k) {
        // Solution 1 
//         ListNode temp = head;
//         int count = 0;
        
//         while(temp != null){
//             temp = temp.next;
//             count++;
//         }
        
//         ListNode start = head;
//         ListNode end = head;
        
//         for(int i = 0; i < count - k; i++){
//             end = end.next;
//         }
        
        
//         for(int i = 0; i < k - 1; i++){
//             start = start.next;
//         }
        
//         int tempVal = start.val;
//         start.val = end.val;
//         end.val = tempVal;
//         return head;
        
        // Solution 2
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode rightPrev = dummy;
        ListNode right = head;
        ListNode leftPrev = dummy;
        ListNode left = head;
        
        // Counting the number of nodes
        ListNode temp = head;
        int count = 0;     
        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        // Making the left point to the kth node from left
        for(int i = 0; i < k - 1; i++){
            left = left.next;
            leftPrev = leftPrev.next;
        }
        
        ListNode tempNode = left.next;
        
        // Right pointing to the kth node from the right
        for(int i = 0; i < count - k; i++){
            right = right.next;
            rightPrev = rightPrev.next;
        }
        
        if(left == rightPrev){
            left.next = right.next;
            leftPrev.next = right;
            right.next = left;
        }else if(leftPrev == right){
            rightPrev.next = left;
            left.next = right;
            right.next = tempNode;
        }else{
            left.next = right.next;
            leftPrev.next = right;
            rightPrev.next = left;
            right.next = tempNode;
        }
        return dummy.next;
    }
}
