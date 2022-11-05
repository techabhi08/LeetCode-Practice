class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(countDiff(date1) - countDiff(date2));
    }
    
    public int countDiff(String date){
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] curr = date.split("-");
        int year = Integer.parseInt(curr[0]);
        int month = Integer.parseInt(curr[1]);
        int days = Integer.parseInt(curr[2]);
        int ans = days;
        
        for(int i = 1971; i < year; i++){
            if(isLeapYear(i)){
                ans += 366;
            }else{
                ans += 365;
            }
        }
        
        for(int i = 0; i < month - 1; i++){
            ans += months[i];
        }
        
        if(month > 2 && isLeapYear(year)){
            ans += 1;
        }
        
        return ans;
    }
    
    public boolean isLeapYear(int i){
        return (i % 400 == 0 || (i % 100 != 0 && i % 4 == 0));
    }
}
