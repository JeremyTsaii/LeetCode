class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        def permute(path, arr, string, idx):
            if len(path) == len(string):
                arr.append(path)
                return

            char = string[idx]
            if char.isalpha():
                permute(path + char.lower(), arr, string, idx + 1)
                permute(path + char.upper(), arr, string, idx + 1)
            else:
                permute(path + char, arr, string, idx + 1)
        
        output = []
        permute("", output, S, 0)
        return output