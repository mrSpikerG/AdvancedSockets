package ua.thespiker.sockets.common.helpers;

public class DataHelper {
    public static <T> T create(Class<T> clazz) throws Exception {
        T result = (T)clazz.getConstructor().newInstance();
        return result;
    }
}
