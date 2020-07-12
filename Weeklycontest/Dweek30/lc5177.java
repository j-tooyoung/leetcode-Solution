package Dweek30;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class lc5177 {
    public String reformatDate(String date) {

        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        StringBuilder sb = new StringBuilder();
        String[] s = date.split(" ");
//        for (int i = s.length - 1; i >= 0; i--) {
//            s[i].substring(0, 2);
//        }
        int len = date.length() - 1;
        sb.append(date.substring(len - 3)).append("-");
        int month = len - 7;
        // int len2 = date.substring(month, month + 3).length();                System.out.println(len2 );

        // System.out.println(date.substring(month, month + 3)+" ," + len2 );
        sb.append(map.get(date.substring(month, month + 3))).append("-");
        int i;
        for (i = 0; i < len; i++) {
            if (!Character.isDigit(date.charAt(i))) {
                break;
            }
        }
        if (i == 1) sb.append('0');
        sb.append(date.substring(0, i));
        return sb.toString();
    }
}
