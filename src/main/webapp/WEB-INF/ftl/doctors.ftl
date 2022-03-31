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
                    个人中心 > <a href="/doctors"> 个人信息 </a>
                </div>
                <form action="/doctors" method="get">
                <table class="listtable">
                    <caption>个人信息:</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>出生日期</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>身份证号</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                    <#if docs??>
                        <#list docs as doc>

                                <td><#if doc.doc_name??>${doc.doc_name}</#if></td>
                                <td><#if doc.doc_birth??>${doc.doc_birth}</#if></td>
                                <td><#if doc.doc_sex??>${doc.doc_sex}</#if></td>
                                <td><#if doc.doc_tel??>${doc.doc_tel}</#if></td>
                                <td><#if doc.doc_idnum??>${doc.doc_idnum}</#if></td>

                        </#list>
                    </#if>
                    <td>
                        <a class="clickbutton" href="/changedoctor">修改信息</a>
                    </td>
                    </tr>
                </table>
                </form>
            </div>
        </div>
    <#include './under.ftl'>
    </body>
</html>

