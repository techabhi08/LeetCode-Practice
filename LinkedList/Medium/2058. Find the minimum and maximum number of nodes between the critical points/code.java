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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }
        
        int minDistance = Integer.MAX_VALUE;
        int firstCriticalIndex = Integer.MAX_VALUE;
        ListNode temp = head;
        
        int index = 1;
        int lastCriticalIndex = 0;
        
        while(temp.next.next != null){
            if((temp.next.val > temp.val && temp.next.next.val < temp.next.val) || 
               (temp.next.val < temp.val && temp.next.next.val > temp.next.val)){
                if(lastCriticalIndex != 0){
                    minDistance = Math.min(index - lastCriticalIndex, minDistance);
                }
                firstCriticalIndex = Math.min(firstCriticalIndex, index);
                lastCriticalIndex = index;
            }
            temp = temp.next;
            index++;
        }
        if(minDistance == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        
        return new int[]{minDistance, lastCriticalIndex - firstCriticalIndex};
    }
}
