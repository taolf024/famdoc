<div class="sidebar-menugroup">
    <div class="sidebar-grouptitle">系统首页</div>
    <ul class="sidebar-menu">
        <li class="sidebar-menuitem"><a href="home">首页</a></li>
    </ul>
</div>

<div class="sidebar-menugroup">
    <div class="sidebar-grouptitle">个人中心</div>
    <ul class="sidebar-menu">

        <li class="sidebar-menuitem active"><a href="./users">用户信息</a></li>
        <#if currentUser?? >
            <#if currentUser.status == "0">
                <li class="sidebar-menuitem"><a href="./doctors">个人信息</a></li>
            <#else >
                <li class="sidebar-menuitem"><a href="./patients">个人信息</a></li>
            </#if>
        </#if>

    </ul>
</div>
<div class="sidebar-menugroup">
    <div class="sidebar-grouptitle">健康管理</div>
    <ul class="sidebar-menu">
        <#if currentUser?? >
            <#if currentUser.status == "0">
                <li class="sidebar-menuitem"><a href="addpatient">签约患者</a></li>
                <li class="sidebar-menuitem"><a href="searchpatient">患者健康档案</a></li>
                <li class="sidebar-menuitem"><a href="healthinquirydoc">患者健康咨询评估</a></li>
                <li class="sidebar-menuitem"><a href="home">视频问诊</a></li>
                <li class="sidebar-menuitem"><a href="visit">家访管理</a></li>
            <#else >
                <li class="sidebar-menuitem"><a href="personhealth">个人健康档案</a></li>
                <li class="sidebar-menuitem"><a href="healthinquiry">个人健康咨询评估</a></li>
                <li class="sidebar-menuitem"><a href="home">视频问诊</a></li>
                <li class="sidebar-menuitem"><a href="visitpat">家访管理</a></li>
            </#if>
        </#if>

    </ul>
</div>
<div class="sidebar-menugroup">
    <div class="sidebar-grouptitle">信息统计</div>
    <ul class="sidebar-menu">
        <#if currentUser?? >
            <#if currentUser.status == "0">
                <li class="sidebar-menuitem"><a href="patientview">患者健康分析</a></li>
            <#else >
                <li class="sidebar-menuitem"><a href="patpatview">身体健康分析</a></li>
            </#if>
        </#if>


    </ul>
</div>
</div>