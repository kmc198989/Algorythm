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
import java.util.*;
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> q;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        goodList(nestedList);
    }

    @Override
    public Integer next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty()?true:false;
    }

    private void goodList(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                q.add(ni.getInteger());
            } else {
                goodList(ni.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */