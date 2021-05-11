package seonjae.plugin.example;

import lombok.Getter;
import seonjae.library.mc.config.ConfigFieldExclude;
import seonjae.library.mc.config.ConfigFieldName;
import seonjae.library.mc.config.SimpleConfig;

import java.io.File;

public class ExampleSimpleConfig extends SimpleConfig {

    public ExampleSimpleConfig(File file) {
        super(file);
    }

    public ExampleSimpleConfig(File file, String name) {
        super(file, name);
    }

    @Getter
    @ConfigFieldName(name = "테스트")
    private String asdf = "asdf";

    @Getter
    private String qwer = "qwer";

    @Getter
    @ConfigFieldExclude
    private String zxcv = "zxcv";
}
