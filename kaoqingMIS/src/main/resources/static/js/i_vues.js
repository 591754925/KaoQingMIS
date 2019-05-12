//底部导航栏
Vue.component('n-nav-footer', {
    props: ['page'],
    template: `
    <div class="weui-tabbar footer">

        <a v-if="page=='kaoqing'" href="i_kaoqing.html" class="weui-tabbar__item weui-bar__item--on">
            <div class="weui-tabbar__icon">
                <img src="images/icon_nav_kc.png" alt="">
            </div>
            <p class="weui-tabbar__label">学生考勤</p>
        </a>
        <a v-if="page!='kaoqing'" href="i_kaoqing.html" class="weui-tabbar__item">
            <div class="weui-tabbar__icon">
                <img src="images/icon_nav_kc.png" alt="">
            </div>
            <p class="weui-tabbar__label">学生考勤</p>
        </a>

        
        <a v-if="page=='home'" href="index.html" class="weui-tabbar__item weui-bar__item--on">
            <span class="weui-badge" style="position: absolute; top: -.4em; right: 1em;">8</span>
            <div class="weui-tabbar__icon">
                <img src="images/door.jpg" alt="">
            </div>
            <p class="weui-tabbar__label">首页</p>
        </a>
        <a v-if="page!='home'" href="index.html" class="weui-tabbar__item">
            <span class="weui-badge" style="position: absolute; top: -.4em; right: 1em;">8</span>
            <div class="weui-tabbar__icon">
                <img src="images/door.jpg" alt="">
            </div>
            <p class="weui-tabbar__label">首页</p>
        </a>


        <a v-if="page=='students'" href="i_dept.html" class="weui-tabbar__item weui-bar__item--on">
            <div class="weui-tabbar__icon">
                <img src="images/user.jpg" alt="">
            </div>
            <p class="weui-tabbar__label">成员管理</p>
        </a>
        <a v-if="page!='students'" href="i_dept.html" class="weui-tabbar__item">
            <div class="weui-tabbar__icon">
                <img src="images/user.jpg" alt="">
            </div>
            <p class="weui-tabbar__label">成员管理</p>
        </a>

        

    </div>
		`,
});