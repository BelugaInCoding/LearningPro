package com.beluga.controllers;
/**
 * @author Beluga
 * @createTime 2023/1/7 -- 20:38
 */

import com.beluga.utils.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DispatcherServlet", value = "*.do")
public class DispatcherServlet extends HttpServlet {

    private Map<String, Object> beanMap = new HashMap<>();
    /*
    这个构造器相当重要 帮助后续理解框架
    这个构造器去解析了applicationCont~ext.xml
    将配置文件中的所有<bean>结点的id和其对应的class类的一个实例全部解析放在了beanMap中
     */
    public DispatcherServlet(){
//      try {
//            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
//            // 1.搞一个factory实例
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            // 2.搞到bulider实例
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            // 3.搞一个document实例
//            Document document = documentBuilder.parse(inputStream);
//            // 4.获取applicationContext.xml里面的所有<bean>结点
//            NodeList beanNodeList = document.getElementsByTagName("bean");
//            // 遍历所有 bean 结点 放在hashMap里
//            for (int i=0; i<beanNodeList.getLength(); i++){
//                Node beanNode = beanNodeList.item(i);
//                if (beanNode.getNodeType() == Node.ELEMENT_NODE){
//                    Element beanElement = (Element) beanNode;
//                    String beanId = beanElement.getAttribute("id");
//                    String className = beanElement.getAttribute("class");
//                    Class  controllerBeanClass= Class.forName(className);
//                    Object beanObj = controllerBeanClass.newInstance();
//
//                    Field servletContextFild = controllerBeanClass.getDeclaredField("servletContext");
//                    servletContextFild.setAccessible(true);
//                    servletContextFild.set(beanObj, this.getServletContext());
//
//                    beanMap.put(beanId, beanObj);
//                }
//            }
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }

        public void init() {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            // 1.搞一个factory实例
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            // 2.搞到bulider实例
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // 3.搞一个document实例
            Document document = documentBuilder.parse(inputStream);
            // 4.获取applicationContext.xml里面的所有<bean>结点
            NodeList beanNodeList = document.getElementsByTagName("bean");
            // 遍历所有 bean 结点 放在hashMap里
            for (int i=0; i<beanNodeList.getLength(); i++){
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE){
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    Class  controllerBeanClass= Class.forName(className);
                    Object beanObj = controllerBeanClass.newInstance();

                    Method setServletContext = controllerBeanClass.getDeclaredMethod("setServletContext", ServletContext.class);
                    setServletContext.invoke(beanObj, this.getServletContext());

                    beanMap.put(beanId, beanObj);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        int lastDotIndex = servletPath.lastIndexOf(".do");
        servletPath = servletPath.substring(1, lastDotIndex);

        // 直接通过获取的前端要访问的servlet的path 到构造器放了数据的beanMap
        // 里面直接去拿对应的Servlet实例
        Object controllerBeanObj = beanMap.get(servletPath);

        String operate = request.getParameter("operate");
        if (!StringUtils.isNotEmpity(operate)){
            operate = "index";
        }

        try {
            // 直接通过operate去拿对应方法 不用去遍历所有方法
            Method method = controllerBeanObj.getClass().getDeclaredMethod(operate, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null){
                method.setAccessible(true);
                method.invoke(controllerBeanObj, request, response);
            }else {
                throw new RuntimeException("operate非法");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        Method[] methods = controllerBeanObj.getClass().getDeclaredMethods();
//        for (Method m: methods){
//            String methodName = m.getName();
//            if (operate.equals(methodName)){
//                try {
//                    m.invoke(this, request, response);
//                    return;
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//      throw new RuntimeException("operate非法");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
