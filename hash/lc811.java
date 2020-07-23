import java.util.*;

/**
 * 811. 子域名访问计数
 * https://leetcode-cn.com/problems/subdomain-visit-count/
 */
public class lc811 {

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            //倒序遍历
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/subdomain-visit-count/solution/zi-yu-ming-fang-wen-ji-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static List<String> subdomainVisits1(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] tmp = cpdomains[i].split(" ");
            // System.out.println(Arrays.toString(tmp));
            int num = Integer.parseInt(tmp[0]);
//            之后去网上找出现这个问题的原因，发现是split里的正则表达式写错了，在正则表达式中，小数点指的是任意字符，因此不能直接用"."来匹配小数点，需要使用"\\."来匹配小数点，因此要根据小数点分割字符串，需要下面这种写法。


            String[] split = tmp[1].split("\\.");
            // System.out.println(tmp[1]);

            // System.out.println(Arrays.toString(split));
            for (String s : split) {
                System.out.println(s);
            }

            for (int j = 0; j < split.length; j++) {
                StringBuilder sb1 = new StringBuilder();
                for (int k = j; k < split.length; k++) {
                    sb1.append(split[k]);
                    if (k < split.length - 1) {
                        sb1.append(".");
                    }
                }
                String t = sb1.toString();
                map.put(t, map.getOrDefault(t, 0) + num);
            }
        }
        for (String s : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(s)).append(" ").append(s);
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "discuss.leetcode.com";
//        String[] split = s.split(".");
//        String[] split1 = s.split("\\.");
//
//        System.out.println(Arrays.toString(split));
//        System.out.println(Arrays.toString(split1));
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        System.out.println(subdomainVisits(cpdomains).toString());

    }
}
