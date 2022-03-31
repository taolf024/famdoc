<!DOCTYPE html>
<html>

<head>
    <title>家庭医生健康管理系统</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        body {
            width: 100%;
            font-family: "华文细黑";
            background: url("../../images/bg.jpg") repeat fixed top;
            background-size: cover;
        }

        #div_login {
            width: 500px;
            margin: 200px auto;
            padding: 0px;
            border-radius: 20px;
        }

        #div_title {
            width: 500px;
            height: 60px;
            background: rgba(255, 255, 255, 0.342);
            text-align: center;
            line-height: 60px;
            color: black;
            border-top-left-radius: 20px;
            border-top-right-radius: 20px;
        }

        .message {
            font-family: '微软雅黑';
            font-size: 18px;
            float: left;
            width: 100px;
            height: 30px;
            text-align: right;
            line-height: 30px;
            margin: 10px 0px;

        }

        .inputinfo {
            width: 350px;
            height: 30px;
            margin: 10px 10px 10px 0px;
            border-radius: 6px;
            border: none;
        }

        #midden {
            width: 500px;
            height: 210px;
            background: rgba(255, 255, 255, 0.342);
            border-bottom-left-radius: 20px;
            border-bottom-right-radius: 20px;
        }

        .clickbutton {
            float: left;
            width: 120px;
            height: 30px;
            margin: 10px 70px 20px 60px;
            border-radius: 8px;
            border: none;
            background-color: rgba(185, 179, 179, 0.5)
        }

        .clickbutton:hover {
            background-color: #85ca88
        }

        .clickbutton:active {
            background-color: rgba(104, 161, 107, 0.73);
            box-shadow: 0 3px #666;
            transform: translateY(2px);
        }

        .page-footer .footer {
            text-align: center;
        }
    </style>
</head>

<body>
    <div id="div_login">
        <form action="/doLogin" method="post">
            <!-- <fieldset> -->
            <div id="div_title">
                <h1>家庭医生健康管理系统</h1>
            </div>
            <div id="midden">
                <div>
                    <p class="message">账号：</p>
                    <input class="inputinfo" name="username" id="accountname" type="text" placeholder="请输入用户名">
                </div>
                <div>
                    <p class="message">密码：</p>
                    <input class="inputinfo" name="password" id="new" type="password" placeholder="请输入密码">
                </div>
                <div>
                    <p class="message">身份：</p>
                    <select name="status" class="inputinfo">
                        <option selected="selected">==请选择身份==</option>
                        <option value="0">医生</option>
                        <option value="1">患者</option>
                    </select>
                </div>
                <div colspan="2" class="command">
                    <input style="cursor:pointer;" type="submit" value="登录" class="clickbutton" onclick="window.location.href='home';" />
                    <input style="cursor:pointer;" type="button" value="注册" class="clickbutton" onclick="window.location.href='register';" />
                </div>
                <div style="color: red">${error!''}</div>
            </div>
        </form>
    </div>
    <div class="page-footer">
        <hr />
        <p class="footer">中国地质大学（武汉）计算机学院 191184班 版权所有 地址：湖北省武汉市锦程街 68号 邮编：430000</p>
        <p class="footer">如有问题请联系 &nbsp<a href="admin">管理员</a></p>
    </div>
</body>

</html>