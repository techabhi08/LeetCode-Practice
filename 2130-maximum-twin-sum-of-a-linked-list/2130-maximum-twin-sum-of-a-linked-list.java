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
    public int pairSum(ListNode head) {
        int size = 0;
        ListNode temp = head;
        
        Stack<Integer> stack = new Stack<>();
        while(temp != null){
            stack.push(temp.val);
            size++;
            temp = temp.next;
        }
        
        ListNode curr = head;
        int max = 0;
        for(int i = 0; i <= size / 2; i++){
            int top = stack.pop();
            int sum = curr.val + top;
            curr = curr.next;
            max = Math.max(max, sum);
        }
        return max;
    }
}