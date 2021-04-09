class Twitter {
    Map<Integer,List<Pair<Integer,Integer>>> tweets;
    Map<Integer,Set<Integer>> followers;
    int time;
    
    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        int time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer,Integer>> existing = tweets.getOrDefault(userId, new ArrayList<>());
        existing.add(new Pair<Integer,Integer>(tweetId, time));
        tweets.put(userId, existing);
        time++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = followers.getOrDefault(userId, new HashSet<>());
        following.add(userId);

        List<Pair<Integer,Integer>> pos = new ArrayList<>();
        for (int f : following) {
            for (Pair<Integer,Integer> p : tweets.getOrDefault(f, new ArrayList<>())) {
                pos.add(p);
            }
        }
        
        Collections.sort(pos, (Pair<Integer,Integer> t1, Pair<Integer,Integer> t2) -> -(t1.getValue() - t2.getValue()));
        
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < Math.min(10, pos.size()); i++) {
            output.add(pos.get(i).getKey());
        }
        
        return output;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> existing = followers.getOrDefault(followerId, new HashSet<>());
        existing.add(followeeId);
        followers.put(followerId, existing);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> existing = followers.getOrDefault(followerId, new HashSet<>());
        existing.remove(followeeId);
        followers.put(followerId, existing);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */