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
                    个人中心 ><a href="/users"> 用户信息 </a> ><a href="/changepassword"> 修改密码 </a>
                </div>
                <form action="/dochange" method="post">
                    <fieldset>
                        <legend>修改密码</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号:</td>
                                <td>
                                    <input id="username" name="username" value="<#if currentUser.username??>${currentUser.username}</#if>"
                                           type="text"
                                           readonly />
                                </td>
                            </tr>
                            <tr>
                                <td>原密码:</td>
                                <td>
                                    <input id="origin" maxlength="18" name="password" type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td>新密码:</td>
                                <td>
                                    <input id="new" maxlength="18" name="newpassword" type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td>确认新密码：</td>
                                <td>
                                    <input id="confirm" maxlength="18" type="password" onchange="check()"/>
                                    <div style="color: red" id="confirmInfo"></div>
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
                        <div>
                            (*注意：密码修改成功后会退出系统重新登录！)
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

            <#include './under.ftl'>
            <script>//判断两次密码
                function check() {
                    var password = document.getElementById('new');
                    var confirm = document.getElementById('confirm');
                    var confirmInfo = document.getElementById('confirmInfo');
                    if (password.value != confirm.value) {
                        confirmInfo.innerHTML = '两次输入密码不一致';
                    } else {
                        confirmInfo.innerHTML = '';
                    }
                }
            </script>
    </body>
</html>