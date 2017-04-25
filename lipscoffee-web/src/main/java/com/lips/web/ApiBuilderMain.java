package com.lips.web;

import org.forkjoin.apikit.Analyse;
import org.forkjoin.apikit.Context;
import org.forkjoin.apikit.Manager;
import org.forkjoin.apikit.ObjectFactory;
import org.forkjoin.apikit.generator.JavaClientGenerator;
import org.forkjoin.apikit.generator.JavaScriptGenerator;
import org.forkjoin.apikit.impl.JdtAnalyse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;


public class ApiBuilderMain {
    private static final Logger log = LoggerFactory.getLogger(ApiBuilderMain.class);

    /**
     *
     */
    public static void main(String[] args) throws Exception {
        new ApiBuilderMain().buildAll();
    }

    private String personPackage = "com.lips.web.controller";
    private String personClientPackage = "com.lips.web.api.portal.client";


    private String version = "v1";
    private File dir;
    private File testDir;
    private File personJsDir;

    public ApiBuilderMain() {
        File root = new File("git-appapi");
        if (!root.exists()) {
            root = new File("appapi");
            if (!root.exists()) {
                root = new File(".");
            }
        }

        dir = new File(root, "lipscoffee-web/src/main/java/");
        log.info("代码路径:{}", dir.getAbsolutePath());

        testDir = new File(root, "lipscoffee-web/src/test/java/");
        personJsDir = new File(root, "../test/lib/api-js-sdk");

        log.info("js sdk 位置:{}, 是否存在:{}", personJsDir.getAbsolutePath(), personJsDir.exists());
    }

    private void buildAll() throws Exception {
        buildAdmin(personPackage, personClientPackage, personJsDir);
    }

    private void buildAdmin(String rootPackage, String clientPackage, File jsDir) throws Exception {
        Manager manager = new Manager();
        manager.setPath(dir.getAbsolutePath());
        manager.setRootPackage(rootPackage);
        manager.setObjectFactory(objectFactory);

        //开始处理
        manager.analyse();

        {
            JavaClientGenerator generator = new JavaClientGenerator();
            generator.setOutPath(testDir.getAbsolutePath());
            generator.setRootPackage(clientPackage);
            manager.generate(generator);
        }

        if (jsDir != null && jsDir.getParentFile().exists()) {
            JavaScriptGenerator generator = new JavaScriptGenerator();
            generator.setOutPath(jsDir.getAbsolutePath());
            generator.setVersion(version);
            manager.generate(generator);
        }
    }

    private static ObjectFactory objectFactory = new ObjectFactory() {
        @Override
        public Analyse createAnalyse() {
            return new JdtAnalyse();
        }

        @Override
        public Context createContext() {
            return new Context();
        }
    };
}
