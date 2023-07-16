class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < req_skills.length; i++){
            map.put(req_skills[i], i);
        }
        
        int[] count = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            List<String> l = people.get(i);
            int c = 0;
            for (String str : l) {
                if (map.containsKey(str)) {
                    c |= (1 << map.get(str));
                }
            }
            count[i] = c;
        }
        
        int n = req_skills.length;
        List<Integer>[] dp = new ArrayList[1 << n];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            int personSkills = count[i];

            for (int j = 0; j < (1 << n); j++) {
                if (dp[j] == null) {
                    continue;
                }

                int newSkills = j | personSkills;
                if (dp[newSkills] == null || dp[j].size() + 1 < dp[newSkills].size()) {
                    List<Integer> newTeam = new ArrayList<>(dp[j]);
                    newTeam.add(i);
                    dp[newSkills] = newTeam;
                }
            }
        }
        
        List<Integer> temp = dp[(1 << n) - 1];
        int[] result = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            result[i] = temp.get(i);
        }
        return result;
    }
}