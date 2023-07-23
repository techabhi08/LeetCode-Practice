class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean negative = (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) ? true : false;
        long num = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        long quo = num /deno;
        sb.append(quo);
        
        num %= deno;
        
        if(num != 0){
            sb.append(".");
        }
        
        int quoIndex = 0;
        while(num != 0){
            num *= 10;
            quo = Math.abs(num / deno);
            if(!map.containsKey(num)){
                map.put(num, quoIndex++);
                sb.append(quo);
            }else{
                int firstIndex = 1 + map.get(num) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            num %= deno;
        }
        
        if(negative){
            sb.insert(0, "-");
        }
        
        return sb.toString();
    }
}