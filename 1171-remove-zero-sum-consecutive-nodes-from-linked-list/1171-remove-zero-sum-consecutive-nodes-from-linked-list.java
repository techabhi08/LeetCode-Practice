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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> sumMap = new HashMap<>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        sumMap.put(0, dummy);
        
        ListNode curr = head;
        int sum = 0;
        
        while(curr != null){
            sum += curr.val;
            if(sumMap.containsKey(sum)){
                ListNode nodeWithSameSum = sumMap.get(sum);
                ListNode nodeToRemove = nodeWithSameSum.next;
                int nodeSum = sum;
                
                while(nodeToRemove != curr){
                    nodeSum += nodeToRemove.val;
                    sumMap.remove(nodeSum);
                    nodeToRemove = nodeToRemove.next;
                }
                nodeWithSameSum.next = curr.next;
            }else{
                sumMap.put(sum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}