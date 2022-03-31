<!DOCTYPE html>
<html>

<head>
    <title>家庭医生健康管理系统</title>
    <link rel="stylesheet" href="styles/common.css" />
    <script src="https://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script src="https://cdn.highcharts.com.cn/highcharts/modules/oldie.js"></script>
</head>

<body>
    <#include './top.ftl'>
    <div class="page-body">
        <div class="page-sidebar">
            <#include './leftMenu.ftl'>
        <div class="page-content">
            <div class="content-nav">
                信息统计 > <a href="/pathealthview"> 身体健康分析 </a>
            </div>

            <div id="container" style="min-width:400px;height:400px"></div>
<#--            <form action="/pathealthvie" method="get">-->
            <script>
                // JS 代码 
                var chart = Highcharts.chart('container', {
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: '近期健康数据'
                    },
                    xAxis: {
                        categories: [<#if befor6Inf??>${befor6Inf.daytime?string('yyyyMMdd')}</#if>,
                            <#if befor5Inf??>${befor5Inf.daytime?string('yyyyMMdd')}</#if>,
                            <#if befor4Inf??>${befor4Inf.daytime?string('yyyyMMdd')}</#if>,
                            <#if befor3Inf??>${befor3Inf.daytime?string('yyyyMMdd')}</#if>,
                            <#if befor2Inf??>${befor2Inf.daytime?string('yyyyMMdd')}</#if>,
                            <#if befor1Inf??>${befor1Inf.daytime?string('yyyyMMdd')}</#if>,
                            <#if todayInf??>${todayInf.daytime?string('yyyyMMdd')}</#if>]
                    },
                    yAxis: {
                        title: {
                            text: '数值'
                        }
                    },
                    plotOptions: {
                        line: {
                            dataLabels: {
                                // 开启数据标签
                                enabled: true
                            },
                            // 关闭鼠标跟踪，对应的提示框、点击事件会失效
                            enableMouseTracking: false
                        }
                    },
                    series: [{
                        name: '高血压',
                        data: [ <#if befor6Inf??>${befor6Inf.hprs}</#if>,
                            <#if befor5Inf??>${befor5Inf.hprs}</#if>,
                            <#if befor4Inf??>${befor4Inf.hprs}</#if>,
                            <#if befor3Inf??>${befor3Inf.hprs}</#if>,
                            <#if befor2Inf??>${befor2Inf.hprs}</#if>,
                            <#if befor1Inf??>${befor1Inf.hprs}</#if>,
                            <#if todayInf??>${todayInf.hprs}</#if>]
                    }, {
                        name: '低血压',
                        data: [ <#if befor6Inf??>${befor6Inf.lprs}</#if>,
                            <#if befor5Inf??>${befor5Inf.lprs}</#if>,
                            <#if befor4Inf??>${befor4Inf.lprs}</#if>,
                            <#if befor3Inf??>${befor3Inf.lprs}</#if>,
                            <#if befor2Inf??>${befor2Inf.lprs}</#if>,
                            <#if befor1Inf??>${befor1Inf.lprs}</#if>,
                            <#if todayInf??>${todayInf.lprs}</#if>]
                    }, {
                        name: '体重（kg）',
                        data: [ <#if befor6Inf??>${befor6Inf.weight}</#if>,
                            <#if befor5Inf??>${befor5Inf.weight}</#if>,
                            <#if befor4Inf??>${befor4Inf.weight}</#if>,
                            <#if befor3Inf??>${befor3Inf.weight}</#if>,
                            <#if befor2Inf??>${befor2Inf.weight}</#if>,
                            <#if befor1Inf??>${befor1Inf.weight}</#if>,
                            <#if todayInf??>${todayInf.weight}</#if>]
                    }]
                });

            </script>
<#--            </form>-->
        </div>
    </div>
        <#include './under.ftl'>
</body>

</html>