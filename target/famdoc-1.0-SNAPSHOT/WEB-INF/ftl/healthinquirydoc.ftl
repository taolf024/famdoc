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
                健康管理 > <a href="/healthinquirydoc">患者健康咨询评估</a>
            </div>
           <form action="/healthinquirydoc" method="get">
                <fieldset>
                    <legend>搜索未回复信息</legend>
                        <input name= "kong" type="hidden" id="name" maxlength="20"  />
                            <td colspan="6" class="command">
                                <input type="submit" class="clickbutton" value="查询" />
                                <a href ="/healthinquirydoc" >  <input type="button" class="clickbutton" value="重置"></a>
                            </td>
                </fieldset>
            </form>
            <div>
                <h3 style="text-align:center;color:black">查询结果</h3>
                <div class="pager-header">
                    <div class="header-info">
                        共<span class="info-number"><#if totle??>${total}</#if></span>条结果，
                        分成<span class="info-number"><#if pagenum??>${pagenum}</#if></span>页显示，
                        当前第<span class="info-number"><#if page??>${page}</#if></span>页
                    </div>
                    <div class="header-nav">
                        <a type="button" class="clickbutton" href="searchpatient?page=1">首页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#if page??><#if page!=1>${page-1}</#if></#if>">上页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#if page??><#if page!=pagenum>${page+1}</#if></#if>">下页</a>
                        <a type="button" class="clickbutton"
                           href="searchpatient?page=<#if pagenum??>${pagenum}</#if>">末页</a>
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
                    <th style="width:60px">患者</th>
                    <th>询问号</th>
                    <th>患者留言</th>
                    <th>咨询时间</th>
                    <th>医生回复</th>
                    <th>回复时间</th>
                    <th style="width:60px">回复 </th>
                </tr>

                <#if dinfs??>
                    <#list dinfs as dinf>
                        <tr>
                            <td><#if dinf.patient_name??>${dinf.patient_name}</#if></td>
                            <td><#if dinf.message_id??>${dinf.message_id}</#if></td>
                            <td><#if dinf.message_user??>${dinf.message_user}</#if></td>
                            <td><#if dinf.message_usertime??>${dinf.message_usertime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                            <td><#if dinf.message_doc??>${dinf.message_doc}</#if></td>
                            <td><#if dinf.message_doctime??>${dinf.message_doctime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                            <td>
                                <a   class="clickbutton" href="/replypat?messageId=${dinf.message_id}">回复</a>
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