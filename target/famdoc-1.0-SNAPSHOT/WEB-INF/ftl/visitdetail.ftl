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
                    健康管理 ><a href="/searchpatient"> 患者健康档案 </a> ><a href="/visitdetail"> 家访申请 </a>
                </div>
                <form action="/dovisit" method="post">
                    <fieldset>
                        <legend>家访申请</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>
                                    <input id="patid" name="patid" value="<#if patient.patient_id??>${patient.patient_id}</#if>" type="hidden" readonly  />
                                </td>
                            </tr>
                            <tr>
                                <td>姓名:</td>
                                <td>
                                    <input id="name" name="name" value="<#if patient.patient_name??>${patient.patient_name}</#if>" type="text" readonly  />
                                </td>
                            </tr>
                            <tr>
                                <td>家访时间:</td>
                                <td>
                                    <input id="time" name="time"  type="date"/>
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