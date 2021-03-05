/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int i;
    List<Integer> flatList;
    
    
    public NestedIterator(List<NestedInteger> nestedList) {
        i = 0;
        flatList = recurse(nestedList);
    }
    
    public List<Integer> recurse(List<NestedInteger> list) {
        List<Integer> output = new ArrayList<>();
        
        for (NestedInteger cur : list) {
            if (cur.isInteger()) {
                output.add(cur.getInteger());
            } else{
                List<Integer> nest = recurse(cur.getList());
                output.addAll(nest);
            }
        }
        
        return output;
    }

    @Override
    public Integer next() {
        return flatList.get(i++);
    }

    @Override
    public boolean hasNext() {
        return flatList.size() != i;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */