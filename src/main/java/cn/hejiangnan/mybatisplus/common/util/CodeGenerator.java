package cn.hejiangnan.mybatisplus.common.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: CodeGenerator
 * @Description: 代码生成器
 * @Author: hejiangnan
 * @Date: 2020/8/3
 */
public class CodeGenerator {

    /**
     * 读取控制台内容
     *
     * @return java.lang.String
     * @author hejiangnan
     * @date 2020/8/3
     */
    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + "表名，多个表以','分割" + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (!ObjectUtils.isEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + "表名，多个表以','分割" + "！");
    }

    /**
     * 代码生成器
     *
     * @param args
     * @return void
     * @author hejiangnan
     * @date 2020/8/3
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("hejiangnan");
        gc.setOpen(true);
        // 是否覆盖文件
        gc.setFileOverride(true);
        // xml resultmap
        gc.setBaseResultMap(true);
        // xml columlist
        gc.setBaseColumnList(true);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/cms?useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true&serverTimezone=GMT%2b8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if (fieldType.toLowerCase().contains("datetime")) {
                    return DbColumnType.LOCAL_DATE_TIME;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }

        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.hejiangnan.mybatisplus");
        /*String packgeName = scanner("包名");
        pc.setController("controller."+packgeName);
        pc.setEntity("entity." + packgeName);
        pc.setService("service." + packgeName);
        pc.setServiceImpl("service." + packgeName +".impl");
        pc.setMapper("dao." + packgeName);*/
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        // 公共父类
        // 写于父类中的公共字段
        strategy.setInclude(scanner().split(","));
        strategy.setControllerMappingHyphenStyle(true);
        // 去除表前缀
        strategy.setTablePrefix("cms_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
