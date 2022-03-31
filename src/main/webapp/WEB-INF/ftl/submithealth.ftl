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
                    健康管理 ><a href="/personhealth"> 个人健康档案 </a> ><a href="/submithealth"> 提交当日健康信息 </a>
                </div>
                <form action="/subheal" method="post">
                    <fieldset>
                        <legend>提交今日健康信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名:</td>
                                <td>
                                    <input id="name" name="name" value="<#if currentPatname??>${currentPatname}</#if>" type="text" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <td>体重(kg):</td>
                                <td>
                                    <input id="weight" name="weight" value="" type="text"/>
                                </td>
                            </tr>
                            <tr>
                                <td>高血压(mmHg)：</td>
                                <td>
                                    <input id="hbloodprs" name="hbloodprs" value="" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>低血压(mmHg)：</td>
                                <td>
                                    <input id="lbloodprs" name="lbloodprs" value="" type="text" />
                                </td>
                            </tr>
                            <div style="color: #ff0114">${error!''}</div>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="提交" class="clickbutton"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
            <#include './under.ftl'>
    </body>
</html>