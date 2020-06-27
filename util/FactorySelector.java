/**
 * 工厂选择器
 *
 */
public class FactorySelector {

    private ClassHelper classHelper;
    private Class<?> intArr_One_Class;//一维数组的class

    public FactorySelector() {
        classHelper = new ClassHelper();
        intArr_One_Class = classHelper.getIntArr_One_TypeName();
    }

    public TestHelperFactory getFactory(Class<?> className) {
        if (className.equals(intArr_One_Class)) {
            return new IntArr_One_Factory();
        }
        return null;
    }
}
