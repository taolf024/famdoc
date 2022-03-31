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
                    健康管理 ><a href="/personhealth"> 个人健康档案 </a> ><a href="/changehealth"> 修改健康信息 </a>
                </div>
                <form action="/changeheal" method="post">
                    <fieldset>
                        <legend>修改健康信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>身高:</td>
                                <td>
                                    <input id="height" name="height" value="<#if currentPatHeal.height??>${currentPatHeal.height}</#if>" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>体重:</td>
                                <td>
                                    <input id="weight" name="weight" value="<#if currentPatHeal.weight??>${currentPatHeal.weight}</#if>" type="text" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <td>过敏史:</td>
                                <td>
                                    <input id="allergy" name="allergy" value="<#if currentPatHeal.allergy??>${currentPatHeal.allergy}</#if>" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>高血压：</td>
                                <td>
                                    <input id="hbloodprs" name="hbloodprs" value="<#if currentPatHeal.hbloodprs??>${currentPatHeal.hbloodprs}</#if>" type="text" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <td>低血压：</td>
                                <td>
                                    <input id="lbloodprs" name="lbloodprs" value="<#if currentPatHeal.lbloodprs??>${currentPatHeal.lbloodprs}</#if>" type="text" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <td>过往病史</td>
                                <td>
                                    <input id="pastmedicalhistory" name="pastmedicalhistory" value="<#if currentPatHeal.pastmedicalhistory??>${currentPatHeal.pastmedicalhistory}</#if>" type="text"/>
                                </td>
                            </tr>
                            <tr>
                                <td>备注</td>
                                <td>
                                    <input id="other" name="other" value="<#if currentPatHeal.other??>${currentPatHeal.other}</#if>" type="text"/>
                                </td>
                            </tr>

                            <div style="color: #ff0114">${error!''}</div>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton"/>
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