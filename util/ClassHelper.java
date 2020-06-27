import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassHelper {

    //https://blog.csdn.net/u011082160/article/details/101025884

    /**
     * 获取接口上的泛型T
     *
     * @param o     接口
     * @param typeIndex 泛型索引
     */
    public static Class<?> getInterfaceT(Object o, int typeIndex,int typeArgumentsIndex) {
        Type[] types = o.getClass().getGenericInterfaces();
        ParameterizedType parameterizedType = (ParameterizedType) types[typeIndex];
        Type type = parameterizedType.getActualTypeArguments()[typeArgumentsIndex];
        return checkType(type, typeArgumentsIndex);
    }

    /**
     * 获取类上的泛型T
     *
     * @param o     接口
     * @param index 泛型索引
     */
    public static Class<?> getClassT(Object o, int index) {
        Type type = o.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type actType = parameterizedType.getActualTypeArguments()[index];
            return checkType(actType, index);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType"
                    + ", but <" + type + "> is of type " + className);
        }
    }

    private static Class<?> checkType(Type type, int index) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type t = pt.getActualTypeArguments()[index];
            return checkType(t, index);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType"
                    + ", but <" + type + "> is of type " + className);
        }
    }

    public static Class<?> getIntArr_One_TypeName() {
        int[] arrOne = new int[0];
        return arrOne.getClass();
    }
}
