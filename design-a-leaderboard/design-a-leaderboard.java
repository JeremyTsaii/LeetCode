class Leaderboard {
    int[] scores;
    Map<Integer,Integer> map;
    
    public Leaderboard() {
        scores = new int[100001];
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        int oldScore = map.getOrDefault(playerId, 0);
        if (oldScore != 0) {
            scores[oldScore]--;
        }
        
        int newScore = oldScore + score;
        scores[newScore]++;
        map.put(playerId, newScore);
    }
    
    public int top(int K) {
        int sum = 0;
        int i = scores.length - 1;
        
        while(K > 0) {
            if (scores[i] != 0) {
                sum += i * Math.min(K, scores[i]);
                K -= Math.min(K, scores[i]);
            }
            i--;
        }
        
        return sum;
    }
    
    public void reset(int playerId) {
        int oldScore = map.get(playerId);
        scores[oldScore]--;
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */