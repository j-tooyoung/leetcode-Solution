import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface TextInterface<I, O> {

    //调用这个进行测试
    default void test() {
        List<TextCaseHelper> list = getTestCase();
        for (TextCaseHelper<I, O> th : list) {
            I input = th.input;
            O output = testTask(input);
            O expectedRes = th.output;
            boolean isEqual = isEqual(output, expectedRes);
            if (!isEqual) {
                System.out.println("TestCase " + th.inputString + " 错误");
                System.out.println("正确的输出 " + th.outputString);
                continue;
            }
        }
    }

    //用于比较输入与测试用例的差异
    default boolean isEqual(O output, O expectedRes) {
        try {

            ClassHelper ch = new ClassHelper();
            Class<?> oClass = output.getClass();

            Class<?> intArr_One_TypeName = ClassHelper.getIntArr_One_TypeName();
            if (oClass.equals(intArr_One_TypeName)) {
                return Arrays.equals((int[]) output, (int[]) expectedRes);
            }


        } catch (Exception exception) {

        }
        return output.equals(expectedRes);
    }

    //和测试主程序进行一次组合即可
    O testTask(I input);


    default List<TextCaseHelper> getTestCase() {
        List<TextCaseHelper> list = new ArrayList<>();
        List<String[]> originalCase = getOriginalCase();
        for (String[] strArr : originalCase) {
            TextCaseHelper<I, O> textCaseHelper = new TextCaseHelper<>();
            String inputString = strArr[0];
            String outputString = strArr[1];
            textCaseHelper.input = changeInput(inputString);
            textCaseHelper.inputString = inputString;
            textCaseHelper.outputString = outputString;
            textCaseHelper.output = changeOutput(outputString);
            list.add(textCaseHelper);
        }
        return list;
    }

    //原始样例数据
    List<String[]> getOriginalCase();


    default void addToList(List<String[]> list, String input, String output) {
        String[] temp = new String[2];
        temp[0] = input;
        temp[1] = output;
        list.add(temp);
    }

    //实现转换
    default I changeInput(String input) {
        ClassHelper ch = new ClassHelper();
        Class<?> name = ch.getInterfaceT(this, 0, 0);
        FactorySelector fs = new FactorySelector();
        TestHelperFactory<I> factory = fs.getFactory(name);
        return (I) factory.produce(input);
    }

    default O changeOutput(String output) {
        ClassHelper ch = new ClassHelper();
        Class<?> name = ch.getInterfaceT(this, 0, 1);
        FactorySelector fs = new FactorySelector();
        TestHelperFactory<O> factory = fs.getFactory(name);
        return (O) factory.produce(output);
    }
}
