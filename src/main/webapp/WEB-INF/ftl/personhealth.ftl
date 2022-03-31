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
                    健康管理 ><a href="/personhealth"> 个人健康档案 </a>
                </div>
                <table class="listtable">
                    <caption>您的身体信息:</caption>
                    <tr class="listheader">
                        <th>身高(cm)</th>
                        <th>体重(kg)</th>
                        <th>过敏史</th>
                        <th>高血压(mmHg)</th>
                        <th>低血压(mmHg)</th>
                        <th>过往病史</th>
                        <th>备注</th>
                        <th>身体信息</th>
                        <th>健康信息</th>
                    </tr>
                    <tr>
                        <#if healths??>
                            <#list healths as health>

                                <td><#if health.height??>${health.height}</#if></td>
                                <td><#if health.weight??>${health.weight}</#if></td>
                                <td><#if health.allergy??>${health.allergy}</#if></td>
                                <td><#if health.hbloodprs??>${health.hbloodprs}</#if></td>
                                <td><#if health.lbloodprs??>${health.lbloodprs}</#if></td>
                                <td><#if health.pastmedicalhistory??>${health.pastmedicalhistory}</#if></td>
                                <td><#if health.other??>${health.other}</#if></td>
                            </#list>
                        </#if>
                        <td>
                            <a class="clickbutton" href="changehealth">修改</a>
                        </td>
                        <td>
                            <a class="clickbutton" href="submithealth">提交</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    <#include './under.ftl'>
    </body>
</html>