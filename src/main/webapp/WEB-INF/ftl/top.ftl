<div class="page-header">
    <div class="header-banner">
        <img src="images/tou1.png"
             alt="tou1"/>
    </div>
    <div class="header-title">
        欢迎访问家庭医生健康管理系统
    </div>
    <div class="header-quicklink">
        欢迎您，
        <#if currentUser??>
            <#if currentUser.status=="0">
                <strong>医生：${currentUser.username!""}</strong>
            <#else >
                <strong>用户：${currentUser.username!""}</strong>
            </#if>
        </#if>
        <a href="/logout">[退出系统]</a>
    </div>
</div>