package seonjae.library.mc.message;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MessageMap extends LinkedHashMap<String, String> {

    @Getter
    private static HashMap<String, MessageMap> extend = new HashMap();

    @SneakyThrows
    public MessageMap(SimpleMessage simpleMessage) {
        if (simpleMessage.getClass().isEnum()) {
            Method m = getMethod(simpleMessage.getClass(), "values");

            for (Object o : (Object[]) m.invoke(null, null)) {
                if (o instanceof Enum && o instanceof SimpleMessage) {
                    Enum e = (Enum) o;
                    SimpleMessage sm = (SimpleMessage) o;

                    put(e.name(), sm.getText());
                }
            }
            extend.put(simpleMessage.getClass().getName(), this);
        }
    }

    public static String search(SimpleMessage simpleMessage) {
        if (simpleMessage.getClass().isEnum()) {
            String name = simpleMessage.getClass().getName();
            if (extend.containsKey(name)) {
                MessageMap map = extend.get(name);
                Enum e = (Enum) simpleMessage;
                if (map.containsKey(e.name())) return map.get(e.name());
            }
        }
        return null;
    }


    private Method getMethod(Class clazz, String name) {
        for (Method method : clazz.getMethods()) if (method.getName().equals(name)) return method;
        return null;
    }
}
