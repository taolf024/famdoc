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
                    个人中心 ><a href="/patients"> 个人信息 </a>
                </div>
                <table class="listtable">
                    <caption>个人信息:</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>出生日期</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>家庭住址</th>
                        <th>身份证号</th>
                        <th>医生</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                    <#if pats??>
                        <#list pats as pat>
                                <td><#if pat.patient_name??>${pat.patient_name}</#if></td>
                                <td><#if pat.patient_birth??>${pat.patient_birth}</#if></td>
                                <td><#if pat.patient_sex??>${pat.patient_sex}</#if></td>
                                <td><#if pat.patient_tel??>${pat.patient_tel}</#if></td>
                                <td><#if pat.patient_add??>${pat.patient_add}</#if></td>
                                <td><#if pat.patient_idnum??>${pat.patient_idnum}</#if></td>
                                <td><#if yourdoc??>${yourdoc}</#if></td>
                            </#list>
                        </#if>

                                <td>
                                    <a class="clickbutton" href="/changepatient">修改信息</a>
                                </td>
                    </tr>
                </table>
            </div>
        </div>
    <#include './under.ftl'>
    </body>
</html>