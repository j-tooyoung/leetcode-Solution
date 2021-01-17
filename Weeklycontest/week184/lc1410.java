package week184;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname lc1410
 * @Description
 * @Date 2021/1/16 14:16
 * @Created by j-tooyoung
 */
public class lc1410 {

    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        String c1 = "\"";
        map.put("&quot;", c1);
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");

        String[] s = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(map.getOrDefault(s[i], s[i]));
            if (i == s.length - 1) {
                continue;
            }
            sb.append(" ");
        }
        return sb.toString();
//        String s1 = text.replaceAll("&quot;", "\"").
//                replaceAll("&apos;", "'").
//                replaceAll("&amp;", "&")
//                .replaceAll("&gt;", ">")
//                .replaceAll("&lt;", "<")
//                .replaceAll("&frasl;", "/");
//        return s1;
//
    }
}
