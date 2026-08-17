class Solution {
    
    List<List<Integer>> a = new ArrayList<>();
    Integer[][] cache;
    
    
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        
        int n = edges.length;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] > edges[i][1]) {
                int tt = edges[i][0];
                edges[i][0] = edges[i][1];
                edges[i][1] = tt;
            }
        }
        
        
        for (int i = 0; i < n + 1; i++) {
            a.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int snd = edges[i][1];
            a.get(first).add(snd);
        }
        
        System.out.println(a);
        
        cache = new Integer[n+ 1][30];
        
        int ans = walk_tree(0, 0, edges, coins, k);
        
        return ans;        
    }
    
    public int walk_tree(int currentNode, int secondChosenCnt, int[][] edges, int[] coins, int k) {
        
        secondChosenCnt = Math.min(secondChosenCnt, 15);
        if (cache[currentNode][secondChosenCnt] != null) {
            return cache[currentNode][secondChosenCnt];
        }
        
        int coinValue = coins[currentNode];
        int divider = 1;
        for (int i = 0; i < Math.min(secondChosenCnt, 15); i++) {
            divider *= 2;
        }
        
        
        int collectOption1 = (int) Math.floor(coinValue / divider) - k;
        int collectOption2 = (int) Math.floor(Math.floor(coinValue / 2.0) / divider);
        
        for (int otherNode : a.get(currentNode)) {
            
            int subTask1 = walk_tree(otherNode, secondChosenCnt, edges, coins, k);
            
            int subTask2 = walk_tree(otherNode, secondChosenCnt + 1, edges, coins, k);
            
            collectOption1 += subTask1;
            collectOption2 += subTask2; 
            
                
        }
        
        int ans = Math.max(collectOption1, collectOption2);
        
        cache[currentNode][secondChosenCnt] = ans;
        
        return ans;
    }
    
}
