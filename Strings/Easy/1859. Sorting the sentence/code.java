class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] temp = new String[arr.length];

        String result = "";

        for(int i = 0; i < arr.length; i++){
            int index = arr[i].charAt(arr[i].length() - 1) - '0';
            temp[index - 1] = arr[i].substring(0, arr[i].length() - 1);
        }

        for(int i = 0; i < temp.length; i++){
            result += temp[i];
            result += " ";
        }
        
        return result.trim();
        
    }
}
