public class StringArr_Factory implements TestHelperFactory<String[]> {

    @Override
    public String[] produce(String s) {
        String temp1 = s.replace("\"", "");
        String temp2 = temp1.replace("[", "");
        String temp3 = temp2.replace("]", "");
        String[] res = temp3.split(",");
        return res;
    }
}
