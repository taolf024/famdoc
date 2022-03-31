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
                        健康管理 > <a href="healthinquiry">健康咨询</a>
                    </div>
                    <table class="listtable">

                        <caption>问诊信息：</caption>
                        <tr class="listheader">
                            <th>询问号</th>
                            <th>患者问题</th>
                            <th>咨询时间</th>
                            <th>医生回复</th>
                            <th>回复时间</th>
                        </tr>

                        <#if infs??>
                            <#list infs as inf>
                        <tr>
                                <td><#if inf.message_id??>${inf.message_id}</#if></td>
                                <td><#if inf.message_user??>${inf.message_user}</#if></td>
                                <td><#if inf.message_usertime??>${inf.message_usertime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                                <td><#if inf.message_doc??>${inf.message_doc}</#if></td>
                                <td><#if inf.message_doctime??>${inf.message_doctime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
                        </tr>
                            </#list>
                        </#if>

                    </table>
                    <form action="/submessage" method="post">
                    <div>
                        <input style="width:780px;height:111px" id="message" name="message" type="text" value="请在此处留言..."/>
                    </div>
                    <div>
                        <input style="margin:0px 150px 0px 250px;" type="submit" class="clickbutton" value="提交" />
                        <input style="margin:0px 250px 0px  50px;" type="reset" class="clickbutton" value="重置" />
                    </div>
                    </form>
                </div>
            </div>
        <#include './under.ftl'>
        </body>
</html>