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
    public int[] nextLargerNodes(ListNode head) {
        //Solution using stack
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        
        int[] ans = new int[list.size()];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < list.size(); i++){
            while(!st.isEmpty() && list.get(i) > list.get(st.peek())){
                ans[st.pop()] = list.get(i);
            }
            st.push(i);
            // System.out.println(Arrays.toString(ans));
        }
        return ans;
        
        //Solution using ArrayList
//         ArrayList<Integer> ans = new ArrayList<>();
//         ListNode temp = head;
//         int i = 0;
        
//         while(temp != null){
//             boolean iIncremented = false;
//             ListNode nex = temp.next;
//             int value = temp.val;
//             while(nex != null){
//                 if(nex.val > value){
//                     ans.add(nex.val);
//                     i++;
//                     iIncremented = true;
//                     break;
//                 }
//                 nex = nex.next;
//             }
//             if(!iIncremented){
//                 ans.add(0);
//                 i++;
//             }
//             temp = temp.next;
//         }
        
//         int[] result = new int[ans.size()];
//         int j = 0;
//         for(int n : ans){
//             result[j++] = n;
//         }
        
//         return result;
    }
}
