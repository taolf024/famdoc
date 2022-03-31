<!DOCTYPE html>
<html>
    <head>
        <title>家庭医生健康管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style>
            .image {
                width: 250px;
                height: 250px;
                margin: 0px 200px;
            }
        </style>
    </head>
    <body>
       <#include './top.ftl'>
        <div class="page-body">
            <div class="page-sidebar">
            <#include './leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    系统首页 > <a href="home">首页</a>
                </div>
                <div class="image">
                    <img src="../../images/home1.jpg"  alt="">
                </div>
            </div>
        </div>
            <#include './under.ftl'>
    </body>
</html>