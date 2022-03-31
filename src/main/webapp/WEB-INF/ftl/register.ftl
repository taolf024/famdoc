<!DOCTYPE html>
<html>
    <head>
        <title>家庭医生健康管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
        </style>
    </head>
    <body>
    <div class="page-header">
        <div class="header-banner">
            <img src="images/tou1.png"  alt="health"/>
        </div>
        <div class="header-title">
            欢迎访问家庭医生健康管理系统
        </div>
    </div>
        <div class="page-body">
            <div class="page-content">
                <form action="/doReg" method="post">
                    <fieldset>
                        <legend>用户注册</legend>
                        <table class="formtable" style="width:50%">
                            （*为必填项）
                            <tr>
                                <td>*身份:</td>
                                <td>
                                    <select name="status" >
                                        <option selected="selected" value="0">医生</option>
                                        <option value="1">患者</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>*用户名：</td>
                                <td>
                                    <input name="username"
                                           type="text"
                                           id="accountname"
                                           maxlength="10"
                                           placeholder="使用字母及数字"
                                           onchange="checkname()"/>
                                    <div style="color: red" id="confirmname"></div>
                                </td>
                            </tr>

                            <tr>
                                <td>*姓名：</td>
                                <td>
                                    <input name="name" type="text" id="name" maxlength="10" />
                                </td>
                            </tr>

                            <tr>
                                <td>*性别:</td>
                                <td>
                                    <select name="sex">
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td>电话：</td>
                                <td>
                                    <input name="tel" type="text" id="telephone" maxlength="11" onchange="checktel()" />
                                    <div style="color: red" id="confirmtel"></div>
                                </td>
                            </tr>

                            <tr>
                                <td>*身份证号：</td>
                                <td>
                                    <input name="idnum" type="text" id="idnumber" maxlength="18" onchange="checkidnum()" />
                                    <div style="color: red" id="confirmidnum"></div>
                                </td>
                            </tr>

                            <tr>
                                <td>*密码：</td>
                                <td>
                                    <input name="password" type="password" id="password" maxlength="18" placeholder="请输入密码（18位以内）"/>
                                </td>
                            </tr>
                            <tr>
                                <td>*确认密码：</td>
                                <td>
                                    <input type="password" id="confirm" maxlength="18" placeholder="请再次确认密码" onchange="check()"/>
                                    <div style="color: red" id="confirmInfo"></div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="注册"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <#include './under.ftl'>

    <script>//判断两次密码
        function check() {
            var password = document.getElementById('password');
            var confirm = document.getElementById('confirm');
            var confirmInfo = document.getElementById('confirmInfo');
            if (password.value != confirm.value) {
                confirmInfo.innerHTML = '两次输入密码不一致';
            } else {
                confirmInfo.innerHTML = '';
            }
        }
        function checkname() {
            var reg = /^[0-9a-zA-Z]+$/
            var str = document.getElementById("accountname").value;
            var confirmname = document.getElementById('confirmname');
            if (!reg.test(str)) {
                // alert("你输入的字符不是数字或者字母")
                confirmname.innerHTML = '您的用户名必须为数字或者字母';
            } else {
                confirmname.innerHTML = '';
            }
        }
        function checktel() {
            var tel = document.getElementById('telephone');
            var regName = /^\d[0-9]+$/;
            var str = tel.value.substr(0, 1)
            if (tel.value.length != 11 || !regName.test(tel.value) || str != '1') {
                confirmtel.innerHTML = '您的手机号码输入格式错误';
            } else {
                confirmtel.innerHTML = '';
            }
        }
        function checkidnum() {
            var idnum = document.getElementById('idnumber');
            var regName = /^\d[0-9]+$/;
            if (idnum.value.length != 18 || !regName.test(idnum.value)) {
                confirmidnum.innerHTML = '您的身份证号输入格式错误';
            } else {
                confirmidnum.innerHTML = '';
            }
        }
    </script>

    </body>
</html>