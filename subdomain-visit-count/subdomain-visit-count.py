class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        counts = {}
        
        for domain in cpdomains:
            words = domain.split(" ")
            count = int(words[0])
            subs = words[1].split(".")
        
            
            
            for i in range(len(subs)):
                sub = ".".join(subs[i:])
                counts[sub] = counts.get(sub, 0) + count
            
        
        output = []
        
        for key in counts:
            output.append(str(counts[key]) + " " + key)
        
        return output