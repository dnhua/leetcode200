package newcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的
 * 长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class Solution50 {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

    @Test
    public void test() {
        int num = longestSubStringWithoutDuplication("arabcacfrgh");
        System.out.println(num);
    }
}
