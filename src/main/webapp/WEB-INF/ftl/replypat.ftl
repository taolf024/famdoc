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
                    健康管理 ><a href="/healthinquiry"> 健康咨询 </a> ><a href="/replypat"> 回复患者 </a>
                </div>
                <form action="/doreply" method="post">
                    <fieldset>
                        <legend>回复患者留言</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>
                                    <input id="id" name="messageId" type="hidden" value="<#if cms.message_id??>${cms.message_id}</#if>" type="text"/>
                                </td>
                            </tr>
                            <tr>
                                <td > 患者姓名：</td>
                                <td>${cms.patient_id}</td>
                            </tr>
                            <tr>
                                <td >患者问题：</td>
                                <td>${cms.message_user}</td>
                            </tr>
                            <tr>
                                <td >咨询时间：</td>
                                <td>${cms.message_usertime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            </tr>
                            <tr>

                            </tr>
                            <tr>
                                <td >医生回复：</td>
                                <td>
                                    <input id="reply" style="width:300px;height:111px" name="reply" value="<#if cms.message_doc??>${cms.message_doc}</#if>" type="text"/>
                                </td>
                            </tr>

                            <div style="color: #ff0114">${error!''}</div>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="回复" class="clickbutton"/>
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