class Solution {
    public double average(int[] salary) {
        int max_salary = Integer.MIN_VALUE;
        int min_salary = Integer.MAX_VALUE;
        double total = 0;
        
        for(int i : salary){
            if(i > max_salary){
                max_salary = i;
            }
            if(i < min_salary){
                min_salary = i;
            }
            total += i;
        }
        
        total -= (max_salary + min_salary);
        return (total / (salary.length - 2));
    }
}
