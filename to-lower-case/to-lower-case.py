class Solution:
    def toLowerCase(self, s: str) -> str:
        return "".join([c.lower() if (ord('A') <= ord(c) and ord(c) <= ord('Z')) else c for c in s ])