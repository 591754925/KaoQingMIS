
//幻灯片
Vue.component('n-swiper-imgs', {
    props: [''],
    template: `
    
		`,
});

//首页中间导航部分
Vue.component('n-nav-content', {
    props: ['user'],
    template: `
    <div>
        
        
    </div>
		`,
});

//学生管理
Vue.component('n-swiper-i', {
    props: [''],
    template: `
    
		`,
});

//部门列表
Vue.component('n-nav-depts', {
    props: ['list', 'now_dept', 'dept_pages'],
    template: `
    <div>
        <div id="select_wk" class="weui-grids" style="background: white; margin-top: 10px;">
            <div style="width: 100%; height: auto; margin: 3px 0px 12px 0px; padding-left: 15px;">
                <p>部门列表</p>
            </div>
            <div class="swiper-container">
                <div class="swiper-wrapper">
                    <div class="weui-grids swiper-slide" v-for="index in dept_pages" style="background: #FFFFFF;">
                        <a href="javascript:;" v-on:click="$emit('dept_go', i)" v-for="(dept, i) in list" v-if="i<index*4 && i>=(index-1)*4" class="weui-grid">
                            <div class="weui-grid__icon">
                                <img src="images/user.jpg" alt="">
                            </div>
                            <p class="weui-grid__label">{{dept.name}}{{index}}{{i}}</p>
                        </a>
                    </div>
                </div>
            </div>
            
            <div class="weui-panel__ft" style="margin-top: 0px;"></div>
        </div>
        <div class="weui-cells weui-cells_checkbox">
            <!-- 确认按钮 -->
            <div class="page__bd page__bd_spacing" style="margin-bottom: 20px; margin-top: 15px;">
                <a href="">
                    <input type="button" class="weui-btn weui-btn_primary" value="添加新成员" />
                </a>
            </div>
            <li style="border-bottom: 1px solid #DFDFDF;" v-for="(stu, i) in now_dept.student">
                <a href="javascript:;" class="weui-media-box weui-media-box_appmsg">
                    <div class="weui-media__hd">
                        <img class="weui-media__thumb" src="images/ch1.jpg" alt="头像">
                    </div>
                    <div class="weui-media__bd">
                        <h4 class="weui-media__title">
                            <span class="weui-teacher-title"> </span>
                        </h4>
                        <p class="weui-media__desc">
                            班级：{{stu.class}}
                        </p>
                        <p class="weui-media__desc">
                            职位：{{stu.greed_name}}
                        </p>
                        <p class="weui-media__desc">
                            分数：{{stu.score}}
                        </p>
                    </div>
                </a>
            </li>
        </div>
        
    </div>
		`,
});





new Vue({
    el: '#app',
    //数据
    data: {
        user: {             //用户信息
            id: '2',         //用户编号
            userid: 'member',     //用户账号
            username: 'member'   //用户身份
        },
        now_page: [
            'home',
            'students',
            'kaoqing'
        ],           //当前显示
        now_dept: {},      //当前部门
        dept_limit:{       //部门分页参数
            line: 2,       //每页多少行数据
            now_dept_page: 1,   //当前部门页数
        },  
        score_limit:{       //审核记录分页参数
            tagle: '',
            line: 2,       
            now_score_page: 1,   //当前审核记录页数
        },
        now_student: '',
       
        list: [             //部门列表
            {
                id: 1,
                name: '素拓部',
                student: [
                    {
                        no: '1625123101',
                        name: '段馨',
                        class: '软开1631',
                        dept: {
                            id: 1,
                            name: '素拓部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123102',
                        name: '袁焕金',
                        class: '软开1631',
                        dept: {
                            id: 1,
                            name: '素拓部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123105',
                        name: '王五',
                        class: '软开1631',
                        dept: {
                            id: 1,
                            name: '素拓部',
                            student: {}
                        },
                        greed: 0,
                        greed_name: '成员',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123106',
                        name: '二狗子',
                        class: '软开1631',
                        dept: {
                            id: 1,
                            name: '素拓部',
                            student: {}
                        },
                        greed: 0,
                        greed_name: '成员',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            },
            {
                id: 2,
                name: '后勤部',
                student: [
                    {
                        no: '1625123103',
                        name: '李纲',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 9,
                        greed_name: '部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                    {
                        no: '1625123104',
                        name: '张三',
                        class: '软开1631',
                        dept: {
                            id: 2,
                            name: '后勤部',
                            student: {}
                        },
                        greed: 8,
                        greed_name: '副部长',
                        telephone: '18229877879',
                        score: 10,
                        onTimes: 0,
                        lateTimes: 0,
                        outTimes: 0,
                        leaveTimes: 0

                    },
                ]
            }

        ],
        scores: [           //审核记录列表
            {
                id:1,
                s_no:'1625123101',
                score:10,
                addScore:1,
                addCause:'加分',
                delScore:0,
                delCause:'',
                time:'2019-1-21'
            },
            {
                id:2,
                s_no:'1625123101',
                score:11,
                addScore:1,
                addCause:'加分',
                delScore:0,
                delCause:'',
                time:'2019-1-21'
            },
            {
                id:3,
                s_no:'1625123101',
                score:10,
                addScore:1,
                addCause:'加分',
                delScore:0,
                delCause:'',
                time:'2019-1-21'
            },
            {
                id:4,
                s_no:'1625123101',
                score:9,
                addScore:0,
                addCause:'',
                delScore:1,
                delCause:'迟到',
                time:'2019-1-21'
            },
            {
                id:5,
                s_no:'1625123101',
                score:10,
                addScore:1,
                addCause:'加分',
                delScore:0,
                delCause:'',
                time:'2019-1-21'
            },
            {
                id:6,
                s_no:'1625123101',
                score:11,
                addScore:1,
                addCause:'加分',
                delScore:0,
                delCause:'',
                time:'2019-1-21'
            },
            {
                id:7,
                s_no:'1625123101',
                score:11,
                addScore:0,
                addCause:'',
                delScore:2,
                delCause:'迟到迟到迟到迟到迟到迟到',
                time:'2019-1-21'
            },
            {
                id:8,
                s_no:'1625123101',
                score:11,
                addScore:1,
                addCause:'加分',
                delScore:0,
                delCause:'',
                time:'2019-1-21'
            },
        ],
        


    },
    //方法
    methods: {
        
        //部门跳转
        dept_go: function(index){
            this.now_dept = this.list[index];
        },
        //页面跳转管理
        page_go: function(page){
            this.now_page = page;
        },
        //审核记录跳转
        updatescore: function(tagle){
            this.now_page = 'scoreupdate';
            this.score_limit.tagle = tagle;

        },
        
        

    },
    //挂载
    mounted() {
        //加载部门列表
        this.now_dept = this.list[0];
    },
    //计算属性
    computed: {
        //部门总数据条数
        dept_pages: function () {
            return Math.ceil(this.list.length/4);
        },
        //部门总页数
        dept_page: function () {
            return Math.ceil(this.now_dept.student.length / this.dept_limit.line);    //向上取整
        },
        //审核记录总条数
        score_nums: function(){
            return this.scores.length;
        },
        //审核记录总页数
        score_pages: function(){
            return Math.ceil(this.scores.length / this.score_limit.line);
        }
    }
});
