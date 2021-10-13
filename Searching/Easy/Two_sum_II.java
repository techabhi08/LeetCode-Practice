class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int arr[] = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum < target){
                start++;
            } else if(sum > target) {
                end--;
            } else{
                arr[0] = start + 1;
                arr[1] = end + 1;
                return arr;
            }
        }
        return null;
    }
}
