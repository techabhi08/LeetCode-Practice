class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(findDist(p1, p2));
        set.add(findDist(p1, p3));
        set.add(findDist(p1, p4));
        set.add(findDist(p2, p3));
        set.add(findDist(p2, p4));
        set.add(findDist(p3, p4));
        
        return !set.contains(0) && set.size() == 2;
    }
    
    public int findDist(int[] p1, int[] p2){
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}