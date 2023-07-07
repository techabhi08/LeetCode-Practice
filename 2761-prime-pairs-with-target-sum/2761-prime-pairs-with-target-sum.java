class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
       List<List<Integer>> outerList = new ArrayList<>();
       List<Integer> primes = primesList(n);
       int len = primes.size();
       int i=0,j=len-1;
       while(i<=j) {
           List<Integer> innerList = new ArrayList<>();
           if(primes.get(i) + primes.get(j) == n) {
               innerList.add(primes.get(i));
               innerList.add(primes.get(j));
               outerList.add(innerList);
               i++;
               j--;
           } else if(primes.get(i) + primes.get(j) > n) j--;
           else i++;
       }
       return outerList;
    }
    public List<Integer> primesList(int n) {
        List<Integer> primeList = new ArrayList<>();
        boolean[] primes = new boolean[n+1];
        for(int i=0;i<n;i++) primes[i] = true;
        for(int i=2; i*i <= n; i++) {
            if(primes[i] == true) {
                for(int j=i*i;j<=n;j+=i) {
                    primes[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++) {
            if(primes[i] == true) {
                primeList.add(i);
            }
        }
        return primeList;
    }
}