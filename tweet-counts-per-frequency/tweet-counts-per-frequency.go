type TweetCounts struct {
    timeMap map[string][]int
}
​
​
func Constructor() TweetCounts {
    timeMap := make(map[string][]int)
    return TweetCounts{timeMap}
}
​
​
func (this *TweetCounts) RecordTweet(tweetName string, time int)  {
    this.timeMap[tweetName] = append(this.timeMap[tweetName], time)
}
​
​
func (this *TweetCounts) GetTweetCountsPerFrequency(freq string, tweetName string, startTime int, endTime int) []int {
    sec := 60
    if freq == "hour" {
        sec = 3600
    } else if freq == "day" {
        sec = 86400
    }
    
    output := make([]int, (endTime - startTime) / sec + 1)
    arr, _ := this.timeMap[tweetName]
    for _, num := range arr {
        if num >= startTime && num <= endTime {
            output[(num - startTime) / sec] += 1
        }
    }
    
    return output
}
​
​
/**
 * Your TweetCounts object will be instantiated and called as such:
 * obj := Constructor();
 * obj.RecordTweet(tweetName,time);
 * param_2 := obj.GetTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
