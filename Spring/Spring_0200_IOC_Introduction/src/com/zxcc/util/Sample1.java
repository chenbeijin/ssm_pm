package com.zxcc.util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.List;

public class Sample1 {

    public static void main(String[] args) throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(Sample1.class.getClassLoader().getResourceAsStream("test.xml"));
        Element root = document.getRootElement();//找到根目录
        List list = root.getChildren("disk");//找到标签为disk读取
        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String name = element.getAttributeValue("name");
            String capcaity = element.getChildText("capcaity");
            String directories = element.getChildText("directories");
            String files = element.getChildText("files");
            System.out.printf("name = %s, capcaity = %s, directories = %s, files = %s\n", name, capcaity, directories, files);
        }
    }
}
