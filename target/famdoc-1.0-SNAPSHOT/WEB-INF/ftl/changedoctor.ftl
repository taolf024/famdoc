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
                    个人中心 ><a href="/doctors"> 用户信息 </a> ><a href="/changedoctor"> 修改信息 </a>
                </div>
                <form action="/changedoc" method="post">
                    <fieldset>
                        <legend>修改信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名:</td>
                                <td>
                                    <input id="name" name="name"  value="<#if currentDoctor.doc_name??>${currentDoctor.doc_name}</#if>" type="text" readonly />
                                </td>
                            </tr>
                            <tr>
                                <td>生日:</td>
                                <td>
                                    <input id="birth" name="birth" type="date" value="<#if currentDoctor.doc_birth??>${currentDoctor.doc_birth}</#if>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>性别:</td>
                                <td>
                                    <input id="sex" name="sex" type="text" value="<#if currentDoctor.doc_sex??>${currentDoctor.doc_sex}</#if>" readonly />
                                </td>
                            </tr>
                            <tr>
                                <td>电话:</td>
                                <td>
                                    <input id="tel" name="tel" type="text" maxlength="11"  value="<#if currentDoctor.doc_tel??>${currentDoctor.doc_tel}</#if>"/>
                                </td>
                            </tr>
                            <tr>
                                <td>身份证号:</td>
                                <td>
                                    <input id="idnum" name="idnum" type="text" maxlength="18" value="<#if currentDoctor.doc_idnum??>${currentDoctor.doc_idnum}</#if>" readonly/>
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