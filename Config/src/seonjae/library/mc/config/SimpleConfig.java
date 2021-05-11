package seonjae.library.mc.config;

import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Field;

public class SimpleConfig extends Config {

    public SimpleConfig(File file) {
        super(file);
    }
    public SimpleConfig(File file, String name) {
        super(new File(file, name));
    }

    @Override
    @SneakyThrows(Exception.class)
    public SimpleConfig load() {
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (field.getAnnotation(ConfigFieldExclude.class) == null) {

                String name;
                ConfigFieldName fieldName = field.getAnnotation(ConfigFieldName.class);

                if (fieldName != null) name = fieldName.name();
                else name = field.getName();

                if (isSet(name)) field.set(this, get(name));
            }
        }
        return this;
    }

    @Override
    @SneakyThrows(Exception.class)
    public SimpleConfig save() {
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (field.getAnnotation(ConfigFieldExclude.class) == null) {

                String name;
                ConfigFieldName fieldName = field.getAnnotation(ConfigFieldName.class);

                if (fieldName != null) name = fieldName.name();
                else name = field.getName();

                set(name, field.get(this));
            }
        }
        super.save();
        return this;
    }
}
