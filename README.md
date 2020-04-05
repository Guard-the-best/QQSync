# QQSync
 This is a Web-project

## 构建
1. 构建运行 gradle appRun 或 gradle tomcatRun
2. 清除构建 gradle clean
3. 更多功能查看idea gradle栏的build与gretty中的Tasks

## 问题
1. idea编译错误的提示信息乱码: 
   
   菜单栏-Help-Edit Custom VM Options,加入一行:
   
   -Dfile.encoding=UTF-8
   
   然后重启idea

## 工具
+ swagger接口文档 : <http://localhost:8080/swagger-ui.html>
+ swagger注解使用 : <https://zhuanlan.zhihu.com/p/49996147> , <https://zhuanlan.zhihu.com/p/76991268>
+ lombok: 简化pojo代码、java语法(idea需安装插件)
+ *mockito : mock测试(测试组件需要调用未完成的接口的可以用mock简单实现)
+ *selenium : 功能测试

## 参考
+ idea中文乱码 : <https://www.kissman.cn/articles/2019/08/15/1565873654250.html>
+ gradle构建参考资料 : <https://guides.gradle.org/building-java-web-applications/>
