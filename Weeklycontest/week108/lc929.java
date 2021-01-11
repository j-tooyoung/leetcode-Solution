package week108;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname lc929
 * @Description
 * @Date 2021/1/11 13:38
 * @Created by j-tooyoung
 */
public class lc929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            int i = email.lastIndexOf("@");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                if (email.charAt(j) == '+') {
                    break;
                } else if (email.charAt(j) == '.') {
                    continue;
                }
                sb.append(email.charAt(j));
            }
            sb.append(email.substring(i ));
            System.out.println(sb.toString());

            set.add(sb.toString());
        }
        return set.size();
    }

}
