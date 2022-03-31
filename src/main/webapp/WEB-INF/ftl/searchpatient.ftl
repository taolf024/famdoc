<!DOCTYPE html>
<html>
<head>
    <title>家庭医生健康管理系统</title>
    <link rel="stylesheet" href="styles/common.css" />
    <style type="text/css">

    </style>
</head>
<body>
<#include './top.ftl'>
    <div class="page-body">
        <div class="page-sidebar">
            <#include './leftMenu.ftl'>
        <div class="page-content">
            <div class="content-nav">
                健康管理 > <a href="searchpatient">患者健康档案</a>
            </div>
            <form action="searchpatient" method="get">
                <fieldset>
                    <legend>搜索患者</legend>
                    <table class="formtable">
                        <tr>
                            <td>患者姓名：
                                <input name= "name" type="text" id="name" maxlength="20"/>
                            </td>
                            <td>患者电话：
                                <input name= "tel" type="text" id="tel" maxlength="11"/>
                            </td>
                            <td colspan="6" class="command">
                                <input type="submit" class="clickbutton" value="查询" />
                                <input type="reset" class="clickbutton" value="重置" />
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </form>
            <div>
                <h3 style="text-align:center;color:black">查询结果</h3>
                <div class="pager-header">
                    <div class="header-info">
                        共<span class="info-number">${total}</span>条结果，
                        分成<span class="info-number">${pagenum}</span>页显示，
                        当前第<span class="info-number">${page}</span>页
                    </div>
                    <div class="header-nav">
                        <a type="button" class="clickbutton" href="searchpatient?page=1">首页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#if page!=1>${page-1}</#if>">上页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#if page!=pagenum>${page+1}</#if>">下页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=${pagenum}">末页</a>
                        <form action="searchpatient"
                              style="display: inline"
                              method="get">
                            跳到第<input name="page" type="text" id="pagenum" class="nav-number"/>页
                            <input type="submit" class="clickbutton" value="跳转"/>
                        </form>
                    </div>
                </div>
            </div>
            <table class="listtable">
                <tr class="listheader">
                    <th>患者姓名</th>
                    <th>患者出生日期</th>
                    <th>患者性别</th>
                    <th>患者电话</th>
                    <th>患者地址</th>
                    <th>医生姓名</th>
                    <th>身体信息</th>
                    <th>健康信息</th>
                    <th>家访</th>
                </tr>
                <#if pats??>
                    <#list pats as pat>
                        <tr>
                            <td><#if pat.patient_name??>${pat.patient_name}</#if></td>
                            <td><#if pat.patient_birth??>${pat.patient_birth}</#if></td>
                            <td><#if pat.patient_sex??>${pat.patient_sex}</#if></td>
                            <td><#if pat.patient_tel??>${pat.patient_tel}</#if></td>
                            <td><#if pat.patient_add??>${pat.patient_add}</#if></td>
                            <td><#if yourself??>${yourself}</#if></td>
                            <td>
                                <a class="clickbutton" href="/patienthealthdetail?patientid=${pat.patient_id}">查看详情</a>
                            </td>
                            <td>
                                <a class="clickbutton" href="/pathealthview?patientid=${pat.patient_id}">查看详情</a>
                            </td>
                            <td>
                                <a class="clickbutton" href="/visitdetail?patientid=${pat.patient_id}">申请</a>
                            </td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
    </div>
<#include './under.ftl'>
</body>

</html>