class Barcode{
    int val;
    int count;
    Barcode(int val, int count){
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] ans = new int[barcodes.length];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < barcodes.length; i++){
            freq.put(barcodes[i], freq.getOrDefault(barcodes[i], 0) + 1);
        }
        
        PriorityQueue<Barcode> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for(int key : freq.keySet()){
            pq.add(new Barcode(key, freq.get(key)));
        }
        
        int index = 0;
        while(!pq.isEmpty()){
            Barcode curr = pq.poll();
            int count = curr.count;
            
            while(count-- != 0){
                ans[index] = curr.val;
                index += 2;
                
                if(index >= barcodes.length){
                    index = 1;
                }
            }
        }
        return ans;
    }
}