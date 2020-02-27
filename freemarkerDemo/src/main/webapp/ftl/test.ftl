<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
你好：${name},欢迎来到${message}
<hr>
<#--静态文本，与HTML方式一致-->
<input type="text" name="username"/><br>
<hr>

<#--Freemarker相关指令-->
    <#--4.4.1.  assign指令：用来定义一个变量（数值，json）-->
            <#assign linkman = "张三">
            ${linkman}<br>
            <hr>
            <#assign user = {"username":"李四","address":"北京","age":22}>
            ${user.username}<br>
            ${user.address}<br>
            ${user.age}<br>
            <hr>
    <#--4.4.2.  include指令：用来嵌套另一个ftl文件-->
           项目介绍：<br>
           <#include "test1.ftl">
           <hr>
    <#--4.4.3.  if指令：用来判断
        注意（1）
            if指令：需要闭合
            else指令：不需要闭合
        注意（2）
            if中使用==（习惯），也可以使用=
    -->
             <#assign success=false>
             <#if success == true>
                 显示数据
             <#else >
                 不显示数据
             </#if>
             <hr>
             <#--传递flag，map.put("flag",true);-->
             <#if flag == true>
                 显示用户列表
             <#else >
                 显示客户列表
             </#if>
             <hr>
    <#--4.4.4.  list指令：用于遍历-->
              <#list list as user>
                  ${user.username}--${user.age}--${user.address}<br>
              </#list>
              <hr>
              <table border="1">
                  <tr>
                      <td>用户名</td>
                      <td>用户年龄</td>
                      <td>用户地址</td>
                  </tr>
                  <#list list as user>
                      <tr>
                          <td>${user.username}</td>
                          <td>${user.age}</td>
                          <td>${user.address}</td>
                      </tr>
                  </#list>
              </table>
</body>
</html>