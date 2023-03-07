//Hour hand
//In 12 hrs -> moves 360 deg => 1 hr -> 30 deg
//For the given hrs -> hour hand will move ((hours % 12) * 30) deg due to hours and
//It will move(minutes * 0.5) deg due to the minutes

//Minutes Hand
// In 60 min -> moves 360 deg => 1 min -> 6 deg
//For given minutes it will move (minutes * 6) deg

class Solution {
    public double angleClock(int hour, int minutes) {
        //Calculating the deg of hour hand
        double hourDeg = ((hour % 12) * 30) + (minutes * 0.5);
        
        //Calculating deg of minute hand
        double minDeg = (minutes * 6);
        
        double angle = Math.abs(minDeg - hourDeg);
        
        if(angle > 180){
            angle = 360 - angle;
        }
        return angle;
    }
}
