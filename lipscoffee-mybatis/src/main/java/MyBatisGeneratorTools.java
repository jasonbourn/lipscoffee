import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiang on 2017/4/24.
 */
public class MyBatisGeneratorTools {

    public static void main(String[] args) throws Exception{
        MyBatisGeneratorTools tools =new MyBatisGeneratorTools();
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(tools.getClass().getClassLoader().getResourceAsStream("config.xml"));
        config.addClasspathEntry(System.getProperty("user.dir").concat("/lipscoffee-mybatis/src/main/resources/mysql-connector-java-5.1.35.jar"));
        config.getContext("MysqlContext").getJavaModelGeneratorConfiguration().setTargetProject(System.getProperty("user.dir").concat("/lipscoffee-dao/src/main/java"));
        config.getContext("MysqlContext").getSqlMapGeneratorConfiguration().setTargetProject(System.getProperty("user.dir").concat("/lipscoffee-dao/src/main/resources"));
        config.getContext("MysqlContext").getJavaClientGeneratorConfiguration().setTargetProject(System.getProperty("user.dir").concat("/lipscoffee-dao/src/main/java"));
        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        try {
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            myBatisGenerator.generate(null);
        } catch (InvalidConfigurationException e) {
            throw e;
        }
    }

}
