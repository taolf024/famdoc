<!DOCTYPE html>
<html>
    <head>
        <title>家庭医生健康管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
    <#include './top.ftl'>
        <div class="page-body">
            <div class="page-sidebar">
                <#include './leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 ><a href="/users"> 用户信息 </a>
                </div>
                <table class="listtable">
                    <caption>用户信息:</caption>
                    <tr class="listheader">
                        <th>用户名</th>
                        <th>身份</th>
                        <th>操作</th>
                    </tr>
                    <#if users??>
                        <#list users as user>
                            <tr>
                                <td>${user.username}</td>
                                <#if currentUser??>
                                    <#if currentUser.status=="0">
                                        <td>医生</td>
                                    <#else >
                                        <td>患者</td>
                                    </#if>
                                </#if>
                                <td>
                                    <a class="clickbutton" href="/changepassword">修改密码</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                </table>
                <div>
                    (*注意：密码修改成功后会退出系统重新登录！)
                </div>
            </div>
        </div>
    <#include './under.ftl'>
    </body>
</html>