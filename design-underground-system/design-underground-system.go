type UndergroundSystem struct {
    timeMap map[string]int
    countMap map[string]int
    tripLocMap map[int]string
    tripTimeMap map[int]int
}
​
​
func Constructor() UndergroundSystem {
    timeMap := make(map[string]int)
    countMap := make(map[string]int)
    tripLocMap := make(map[int]string)
    tripTimeMap := make(map[int]int)
    return UndergroundSystem{timeMap, countMap, tripLocMap, tripTimeMap}
}
​
​
func (this *UndergroundSystem) CheckIn(id int, stationName string, t int)  {
    this.tripLocMap[id] = stationName
    this.tripTimeMap[id] = t
}
​
​
func (this *UndergroundSystem) CheckOut(id int, stationName string, t int)  {
    loc, _ := this.tripLocMap[id]
    time, _ := this.tripTimeMap[id]
    
    delete(this.tripLocMap, id)
    delete(this.tripTimeMap, id)
    
    key := loc + stationName
    this.timeMap[key] += t - time
    this.countMap[key] += 1
}
​
​
func (this *UndergroundSystem) GetAverageTime(startStation string, endStation string) float64 {
    key := startStation + endStation
    time, _ := this.timeMap[key]
    count, _ := this.countMap[key]
    return float64(time) / float64(count)
}
​
​
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * obj := Constructor();
 * obj.CheckIn(id,stationName,t);
 * obj.CheckOut(id,stationName,t);
 * param_3 := obj.GetAverageTime(startStation,endStation);
 */
