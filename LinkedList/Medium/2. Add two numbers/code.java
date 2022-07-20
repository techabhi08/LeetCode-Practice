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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int digitSum = 0;
        
        while(l1 != null || l2 != null || digitSum != 0){
            if(l1 != null){
                digitSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                digitSum += l2.val;
                l2 = l2.next;
            }
            
            int rem = digitSum % 10;
            head.next = new ListNode(rem);
            head = head.next;
            digitSum /= 10;
        }
        return dummy.next;
        
        // Wrong output when long values are taken
//         long num1 = 0;
//         long num2 = 0;
//         ListNode temp = l1;
        
//         while(temp != null){
//             num1 = num1 * 10 + temp.val;
//             temp = temp.next;
//         }
        
//         temp = l2;
//         while(temp != null){
//             num2 = num2 * 10 + temp.val;
//             temp = temp.next;
//         }
        
//         num1 = reverse(num1);
//         // System.out.println(num1);
//         num2 = reverse(num2);
//         // System.out.println(num2);
//         long ans = num1 + num2;
        
        
//         if(ans == 0){
//             return new ListNode(0);
//         }
        
//         ListNode result = new ListNode(0);
//         ListNode head = result;
        
//         while(ans != 0){
//             int value = (int)(ans % 10);
//             head.next = new ListNode(value);
//             head = head.next;
//             ans /= 10;
//         }
//         return result.next;
//     }
    
//     public long reverse(long num){
//         long ans = 0;
//         while(num != 0){
//             ans = (ans * 10) + (num % 10);
//             num /= 10;
//         }
//         return ans;
    }
}
