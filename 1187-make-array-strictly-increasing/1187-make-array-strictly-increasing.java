class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        int answer = helper(0, -1, arr1, arr2);
        
        return answer < Integer.MAX_VALUE-100 ? answer : -1;
    }
    
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
    private int helper(int i, int prev, int[] arr1, int[] arr2) {
        if (i == arr1.length) {
            return 0;
        }
        if (dp.containsKey(new Pair<>(i, prev))) {
            return dp.get(new Pair<>(i, prev));
        }

        int operation = Integer.MAX_VALUE-100;

        
        if (arr1[i] > prev) {
            operation = helper(i + 1, arr1[i], arr1, arr2);
        }

       
        int idx = binarySearch(arr2, prev);

        
        if (idx < arr2.length) {
            operation = Math.min(operation, 1 + helper(i + 1, arr2[idx], arr1, arr2));
        }

        dp.put(new Pair<>(i, prev),operation);
        return operation;
    }
    
    private static int binarySearch(int[] arr, int value) {
        int left = 0, right = arr.length-1;
        while (left <= right) {
            int mid = left+(right-left) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        return left;
    } 
}