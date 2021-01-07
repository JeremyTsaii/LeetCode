type Logger struct {
    m map[string]int
}
​
​
/** Initialize your data structure here. */
func Constructor() Logger {
    m := make(map[string]int)
    return Logger{m}
}
​
​
/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
func (this *Logger) ShouldPrintMessage(timestamp int, message string) bool {
    if time, found := (*this).m[message]; found && timestamp < time + 10 {
        return false
    }
    (*this).m[message] = timestamp
    return true
}
​
​
/**
 * Your Logger object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.ShouldPrintMessage(timestamp,message);
 */
