package com.itheima.main;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFreeMarker {

    public static void main(String[] args) throws Exception {
// 第一步：创建一个 Configuration 对象，直接 new 一个对象。构造方法的参数就是 freemarker的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());

// 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(new File("D:\\ideaProjects\\85\\freemarkerDemo\\src\\main\\webapp\\ftl"));

// 第三步：设置模板文件使用的字符集。一般就是 utf-8。
        configuration.setDefaultEncoding("UTF-8");

// 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("test.ftl");

// 第五步：创建一个模板使用的数据集，可以是 pojo 也可以是 map。一般是 Map。
        Map<String, Object> map = new HashMap();
        map.put("name", "张无忌");
        map.put("message", "传智播客");
        // 添加数据
        map.put("flag", true);
        // 添加集合数据
        List<Map> list = new ArrayList<Map>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("username", "冯小刚");
        map1.put("age", 50);
        map1.put("address", "深圳");

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("username", "范冰冰");
        map2.put("age", 20);
        map2.put("address", "北京");
        list.add(map1);
        list.add(map2);
        map.put("list", list);

// 第六步：创建一个 Writer 对象，一般创建 FileWriter 对象，指定生成的文件名。
        Writer writer = new FileWriter(new File("D:\\ideaProjects\\85\\freemarkerDemo\\src\\main\\webapp\\pages\\test_1.html"));

// 第七步：调用模板对象的 process 方法输出文件（格式，定义html）。
        template.process(map, writer);

// 第八步：关闭流。
        writer.flush();
        writer.close();
    }
}
