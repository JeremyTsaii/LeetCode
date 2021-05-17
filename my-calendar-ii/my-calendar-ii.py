class MyCalendarTwo:

    def __init__(self):
        self.overlaps = []
        self.books = []

    def book(self, start: int, end: int) -> bool:
        for s, e in self.overlaps:
            if not (start >= e or s >= end):
                return False
        
        for s, e in self.books:
            if not (start >= e or s >= end):
                self.overlaps.append((max(start, s), min(end, e)))
                
        self.books.append((start, end))
        return True


# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)