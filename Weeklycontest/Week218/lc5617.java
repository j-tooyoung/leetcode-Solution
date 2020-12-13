package Week218;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname lc5666
 * @Description
 * @Date 2020/11/15 23:44
 * @Created by j-tooyoung
 */
public class lc5617 {

    public String interpret(String command) {
//        command = command.replaceAll("(al)", "al");
//        command = command.replaceAll("()", "o");
//        return command;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); ) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if (command.charAt(i) == '(') {
                if (i + 1 < command.length() && command.charAt(i + 1) == 'a') {
                    sb.append("al");
                    i += 4;
                } else {
                    sb.append('o');
                    i += 2;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "G()()()()(al)";
        System.out.println(s.replaceAll("(al)", "al"));

        System.out.println(s.replaceAll("()", "o"));


    }

}
