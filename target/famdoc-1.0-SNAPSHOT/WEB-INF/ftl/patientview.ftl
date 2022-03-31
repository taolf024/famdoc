<!DOCTYPE html>
<html>

<head>
    <title>家庭医生健康管理系统</title>
    <link rel="stylesheet" href="styles/common.css" />
    <style type="text/css">

    </style>
    <script src="https://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
</head>

<body>
<#include './top.ftl'>
    <div class="page-body">
        <div class="page-sidebar">
        <#include './leftMenu.ftl'>
        <div class="page-content">
            <div class="content-nav">
                信息统计 > <a href="/patientview"> 患者健康分析 </a>
            </div>
            <div id="container" style="min-width:400px;height:400px"></div>
            <form action="/patientview" method="get">
            <script>
                // JS 代码
                var chart = Highcharts.chart('container', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: '今日患者健康状态'
                    },
                    // subtitle: {
                    //     text: '数据来源: WorldClimate.com'
                    // },
                    xAxis: {
                        categories: [
                            <#if currentDay??>${currentDay}</#if>
                        ],
                        crosshair: true
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '人数'
                        }
                    },
                    tooltip: {
                        // head + 每个 point + footer 拼接成完整的 table
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:.1f} 位</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            borderWidth: 0
                        }
                    },
                    series: [{
                        name: '高血压患者',
                        data: [<#if hprsnum??>${hprsnum}</#if>]
                    }, {
                        name: '低血压患者',
                        data: [<#if lprsnum??>${lprsnum}</#if>]
                    }, {
                        name: '超重患者',
                        data: [<#if ownum??>${ownum}</#if>]
                    }]
                });
            </script>
            </form>
        </div>
    </div>
<#include './under.ftl'>
</body>

</html>