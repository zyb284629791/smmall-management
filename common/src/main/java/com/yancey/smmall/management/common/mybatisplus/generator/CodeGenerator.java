package com.yancey.smmall.management.common.mybatisplus.generator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/08/08 - 10:01
 */
public class CodeGenerator {

    private static final String moduleName = "thirdpartybrands";
    private static final String moduleProject = "third-party-brands-provider";
    private static final String tableName = "third_party_brands,third_party_brands_industry";
    //    private static final String superControllerClass = "com.baomidou.ant.common.BaseController";
    private static final String baseEntityClass = "com.baomidou.ant.common.BaseEntity";
    private static final String parentPackage = "com.yancey.smmall.management";
    private static final String entityPackage = "model";

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        GlobalConfig gc = new GlobalConfig();
        String rootPath = System.getProperty("user.dir");
        String projectPath = rootPath + "/" + moduleProject;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Yb.Z");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        generator.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mall_management_brand?autoReconnectForPools=true&useUnicode=true&characterEncoding=utf8&useSSL=false");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root#root");
        generator.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setEntity(entityPackage);
        pc.setParent(parentPackage);
//        pc.setPathInfo()
        generator.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileCreate((configBuilder, fileType, filePath) -> {
            // 判断自定义文件夹是否需要创建
            if (FileType.CONTROLLER == fileType) {
                return false;
            }
//                checkDir("调用默认方法创建的目录");
            return true;
        });
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // 设置为null时则不会生成对应的文件夹
        templateConfig.setController(null);
        templateConfig.setXml(null);
        generator.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass(baseEntityClass);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass(superControllerClass);
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(tableName.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        generator.setStrategy(strategy);
//        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }
}
