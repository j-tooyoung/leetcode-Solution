/**
 * 字符串转换为数组
 */
public class StringToArratyutil {


    //替换左右方括号
    public static String toArrayString(String s) {
        return s.replaceAll("\\[", "{").replaceAll("\\]", "}");
    }

    public static void main(String[] args) {

    }

}
