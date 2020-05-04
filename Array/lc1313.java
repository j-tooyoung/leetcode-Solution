/**
 * 1313. 解压缩编码列表
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 */
public class lc1313 {

    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] res = new int[len];
        int idx = 0;
        for (int i = 1; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i - 1]; j++) {
                res[idx++] = nums[i];
            }
        }
        return res;
    }
}
