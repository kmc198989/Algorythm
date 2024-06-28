import java.util.*;

class Solution {
    public int partitionString(String s) {
        Set<Character> seen = new HashSet<>();
        int partitions = 1;
        
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                partitions++;
                seen.clear();
            }
            seen.add(c);
        }
        
        return partitions;
    }
}
