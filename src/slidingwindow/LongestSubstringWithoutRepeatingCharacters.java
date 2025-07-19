package slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        HashSet<Character> chars = new HashSet<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            while (chars.contains(s.charAt(i))) {
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(s.charAt(i));
            maxLength = Math.max(maxLength, chars.size());
        }
        return maxLength;
    }
}
