class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        
        banSet = set()
        for word in banned:
            banSet.add(word)
        
        wordDict = {}
        words = []
        max = 0
        maxWord = ""
        
        for seg in paragraph.split(","):
            for word in seg.split(" "):
                if word:
                    words.append(word)
        
        for word in words:
            word = processWord(word)
            if word not in banned:
                num = wordDict.get(word, 0) + 1
                wordDict[word] = num
                if wordDict[word] > max:
                    max = num
                    maxWord = word
        
        return maxWord        
        
def processWord(word):
    word = word.lower()
    if not word[-1].isalpha():
        word = word[:-1]
    return word
        
​
