public class lc58_i {

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
//            System.out.println(s1[i] + s1[i].length());
            if (s1[i].equals("")) continue;
            String tmp = swap(s1[i], 0, s1[i].length() - 1);
            sb.append(tmp).append(" ");
        }
        return sb.reverse().toString().trim();
    }

    private static String swap(String s, int i, int j) {
         char[] ch = s.toCharArray();
        while (i < j) {
            char c1 = ch[i];
            ch[i] = ch[j];
            ch[j] = c1;
            i++;
            j--;
        }
        //
//        return ch.toString();
        return new String(ch);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 =  "  hello world!  ";
        String s2 = "a good   example";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }
}
