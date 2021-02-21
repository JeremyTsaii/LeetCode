class Node:
    def __init__(self):
        self.chars = [None] * 26
        self.end = False

class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.node = Node()

    def addWord(self, word: str) -> None:
        cur = self.node
        for c in word:
            num = ord(c) - ord('a')
            if not cur.chars[num]:
                cur.chars[num] = Node()
            cur = cur.chars[num]
        
        cur.end = True

    def search(self, word: str) -> bool:
        def search2(word, node, i):
            if i >= len(word):
                return node.end
            elif word[i] == ".":
                for char in node.chars:
                    if char and search2(word, char, i + 1):
                        return True
                return False
            elif not node.chars[ord(word[i]) - ord('a')]:
                return False
            return search2(word, node.chars[ord(word[i]) - ord('a')], i + 1)
        
        
        return search2(word, self.node, 0)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)