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
                健康管理 > <a href="visit">家访管理</a>
            </div>
            <form action="visit" method="get">
                <fieldset>
                    <legend>家访时间查询</legend>
                    <table class="formtable">
                        <tr>
                            <td>家访时间：
                                <input name= "visittime" type="date" id="tel" />
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
                        共<span class="info-number"><#--${total}--></span>条结果，
                        分成<span class="info-number"><#--${pagenum}--></span>页显示，
                        当前第<span class="info-number"><#--${page}--></span>页
                    </div>
                    <div class="header-nav">
                        <a type="button" class="clickbutton" href="searchpatient?page=1">首页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#--<#if page!=1>${page-1}</#if>-->">上页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#--<#if page!=pagenum>${page+1}</#if>-->">下页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#--${pagenum}-->">末页</a>
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
                    <th>家访时间</th>
                </tr>
                <#if dvisits??>
                    <#list dvisits as dvisit>
                        <tr>
                            <td><#if dvisit.patient_name??>${dvisit.patient_name}</#if></td>
                            <td><#if dvisit.visit_time??>${dvisit.visit_time}</#if></td>
                        </tr>
                    </#list>
                </#if>
            </table>
        </div>
    </div>
<#include './under.ftl'>
</body>

</html>