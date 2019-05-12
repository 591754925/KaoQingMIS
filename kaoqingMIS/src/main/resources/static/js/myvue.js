/* myvue.js */
//自定义头部导航栏
Vue.component('n-navbar', {
    props: [],
    template: `
	    <div class="banner">
            <div class="bgh">
                <div class="page">
                    <div id="logo">
                        <a href="index.html" title="首页">
                            <img src="images/logo.gif" alt="logo" width="165" height="48" />
                        </a>
                    </div>
                    <div class="topxx">
                    <span>欢迎您！管理员</span>
                    <a href="javascript:if(confirm('你确认退出登录吗?'))location=''"
					style="color: red;">安全退出</a>
                    </div>
                    <div class="blog_nav">
                        <ul>
                            <li><a href="#">操作须知</a></li>
                            <li><a href="#">关于系统</a></li>
                            <li><a href="#">查看日志</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
		`,
});

//自定义左侧导航栏
Vue.component('n-navbar-left', {
    props: ['list'],
    template: `
    <div class="leftbox">
        <div class="l_nav2">
            <div class="ta1">
                <strong>成员管理</strong>
                <div class="leftbgbt"></div>
            </div>
            <div class="cdlist">
                <div v-for="(item, index) in list">
                    <a href="javascript:;" v-on:click="$emit('dept_go', index)" >{{item.d_name}}</a>
                </div>
            </div>
            <div class="ta1">
                <strong>账号管理</strong>
                <div class="leftbgbt2"></div>
            </div>
            <div class="cdlist">
                <div>
                    <a href="javascript:;" v-on:click="$emit('page_go', 'admin')">账号管理</a>
                </div>
                <div>
                    <a href="javascript:;" v-on:click="$emit('page_go', 'dept')">部门管理</a>
                </div>
            </div>
            <div class="ta1">
                <strong>审核管理</strong>
                <div class="leftbgbt2"></div>
            </div>
            <div class="cdlist">
                <div>
                    <a href="javascript:;" v-on:click="$emit('page_go', 'score')">审核记录</a>
                </div>
                <div>
                    <a href="javascript:;" v-on:click="$emit('updatescore', 'addScore')">加分审核</a>
                </div>
                <div>
                    <a href="javascript:;" v-on:click="$emit('updatescore', 'delScore')">减分审核</a>
                </div>
            </div>
            <div class="ta1">
                <strong>文件管理</strong>
                <div class="leftbgbt2"></div>
            </div>
            <div class="cdlist">
                <div>
                    <a href="javascript:;" v-on:click="$emit('page_go', 'excel')">Excel文件</a>
                </div>
                
            </div>
        </div>
    </div>
		`,
});

//右侧内容页面-home
Vue.component('n-right-home', {
    props: [],
    template: `
    <div class="rightbox">
        <h6 class="mbx">
            * <span style="color: green; font-size: 20px;">欢迎使用学生考勤系统</span>&nbsp;&nbsp;&nbsp;&nbsp;
        </h6>
        <div class="dhbg">
            <a href="javascript:;" v-on:click="$emit('dept_go', 0)">
                <div class="dh1" style="margin: 0 27px 0 0;">
                    <div class="dhwz">
                        <p>成员管理</p>
                    </div>
                </div>
            </a> <a href="javascript:;" v-on:click="$emit('page_go', 'admin')">
                <div class="dh1">
                    <div class="dhwz">
                        <p>账号管理</p>
                    </div>
                </div>
            </a> <a href="javascript:;" v-on:click="$emit('page_go', 'score')">
                <div class="dh1" style="margin: 0 27px 15px 0;">
                    <div class="dhwz">
                        <p>审核管理</p>
                    </div>
                </div>
            </a> <a href="javascript:;" v-on:click="$emit('page_go', 'excel')">
                <div class="dh1">
                    <div class="dhwz">
                        <p>文件管理</p>
                    </div>
                </div>
            </a>
        </div>
    </div>
		`,
});


//右侧内容页面-student
Vue.component('n-right-student', {
    props: ['now_dept', 'dept_pages', 'dept_nums', 'dept_limit', 'addstudent_tagle', 'addstudent', 'updatestudent'],
    template: `
        <div class="rightbox">
            <div v-show="addstudent_tagle == 'home'">
                <h2 class="mbx">
                    学生考勤系统 &gt; 成员管理 &nbsp;&gt;&nbsp;{{now_dept.d_name}}
                </h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong>添加成员：</strong><span style="color: blue;"> <a href="javascript:;" v-on:click="$emit('change_addstudent', 0)" title="添加新成员" >[点击添加]</a></span>
                        </div>
                    </div>
                    <div class="cztable">
                        
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                                <tr style="height: 25px;" align="center">
                                    <th scope="col" style="width: 11%;">学号</th>
                                    <th scope="col" style="width: 8%;">姓名</th>
                                    <th scope="col" style="width: 9%;">班级</th>
                                    <th scope="col" style="width: 12%;">部门</th>
                                    <th scope="col" style="width: 8%;">职位</th>
                                    <th scope="col" style="width: 12%;">手机号</th>
                                    <th scope="col" style="width: 5%;">分数</th>
                                    <th scope="col" style="width: 5%;">签到</th>
                                    <th scope="col" style="width: 5%;">迟到</th>
                                    <th scope="col" style="width: 5%;">缺勤</th>
                                    <th scope="col" style="width: 5%;">请假</th>
                                    <th scope="col" style="width: 10%;">操作</th>
                                </tr>
                                <tr align="center" v-for="(stu, i) in now_dept.student" v-show="i < dept_limit.now_dept_page*dept_limit.line && i >= (dept_limit.now_dept_page-1)*dept_limit.line">
                                    <td>{{stu.s_no}}</td>
                                    <td>{{stu.s_name}}</td>
                                    <td>{{stu.s_class}}</td>
                                    <td>{{stu.dept.d_name}}</td>
                                    <td>{{stu.greed_name}}</td>
                                    <td>{{stu.telephone}}</td>
                                    <td>{{stu.score}}</td>
                                    <td>{{stu.onTimes}}</td>
                                    <td>{{stu.lateTimes}}</td>
                                    <td>{{stu.outTimes}}</td>
                                    <td>{{stu.leaveTimes}}</td>
                                    <td><a href="javascript:;" v-on:click="$emit('change_updatestudent', i)" style="color: blue;">[修改]
                                        </a> <a href="javascript:;" v-on:click="$emit('student_remove', stu.s_no)" style="color: red;">[刪除]
                                        </a></td>
                                </tr>


                            </tbody>
                        </table>
                        <div class="MainStyle">
                            <div>
                                <a href="javascript:;" v-on:click="$emit('dept_page', 'first')">首页</a>
                            </div>
                            <div>
                                <a href="javascript:;" v-on:click="$emit('dept_page', 'pre')">上一页</a>
                            </div>
                            <div v-for="item in dept_pages">
                                <div v-if="item == dept_limit.now_dept_page" class="NowItemStyle">
                                    <a href="javascript:void(0)">{{item}}</a>
                                </div>
                                <div v-else>
                                    <a href="#" v-on:click="$emit('dept_page', item)">{{item}}</a>
                                </div>

                            </div>
                            
                            <div>
                                <a href="javascript:;" v-on:click="$emit('dept_page', 'next')">下一页</a>
                            </div>
                            <div >
                                <a href="javascript:;" v-on:click="$emit('dept_page', 'last')">尾页</a>
                            </div>
                            <div>
                                共<b> {{dept_nums}} </b>条数据
                            </div>
                            <div>
                                <b>{{dept_limit.line}} </b>条/页
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div v-show="addstudent_tagle == 'add'">
                <h2 class="mbx">
                    学生考勤系统 > 成员管理 &nbsp;&gt;&nbsp;{{now_dept.d_name}}&nbsp;&gt;&nbsp; 添加成员
                </h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong style="color: red;">注意：</strong><span style="color: blue;">*部门随进入页面的部门而定  *</span>
                        </div>
                    </div>
                    <div class="cztable">
                        <form action="" method ="post">
                            <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">
                                <tr>
                                    <td width="15%" align="right"><div align="right">学号： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addstudent.no"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">姓名： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addstudent.name"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">班级： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addstudent.class"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">部门： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" :value="now_dept.d_name" readonly="readonly" /></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">职位等级： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addstudent.greed"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">职位： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addstudent.greed_name"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">手机号： </div></td>
                                    <td><input id="Ctitle" size="30" class="input_2" v-model="addstudent.telephone"/></td>
                                </tr>
                                
                                <tr>
                                    <td width="15%" align="right"><div align="right">分数： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="addstudent.score"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">签到： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="addstudent.onTimes"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">迟到： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="addstudent.lateTimes"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">缺勤： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="addstudent.outTimes"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">请假： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="addstudent.leaveTimes"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <div align="center">
                                            <input type="button" v-on:click="$emit('student_add', addstudent)" value="确认" class="input2" />
                                            <input v-on:click="$emit('change_addstudent', 1)" type="button" value="返回" class="input2" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <div v-show="addstudent_tagle == 'update'">
                <h2 class="mbx">
                    学生考勤系统 > 成员管理 &nbsp;&gt;&nbsp;{{now_dept.d_name}}&nbsp;&gt;&nbsp; 修改成员
                </h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong style="color: red;">注意：</strong><span style="color: blue;">*  *</span>
                        </div>
                    </div>
                    <div class="cztable">
                        <form action="" method ="post">
                            <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">
                                <tr>
                                    <td width="15%" align="right"><div align="right">学号： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updatestudent.s_no" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">姓名： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updatestudent.s_name"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">班级： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updatestudent.s_class"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">部门： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" :value="now_dept.d_name" readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">职位等级： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updatestudent.s_greed"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">职位： </div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updatestudent.greed_name"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">手机号： </div></td>
                                    <td><input id="Ctitle" size="30" class="input_2" v-model="updatestudent.telephone"/></td>
                                </tr>
                                
                                <tr>
                                    <td width="15%" align="right"><div align="right">分数： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="updatestudent.score"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">签到： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="updatestudent.onTimes"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">迟到： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="updatestudent.lateTimes"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">缺勤： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="updatestudent.outTimes"/></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">请假： </div></td>
                                    <td><input id="Ctitle" size="10" class="input_2" v-model="updatestudent.leaveTimes"/></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <div align="center">
                                            <input type="button" v-on:click="$emit('student_update', updatestudent)" value="确认" class="input2" />
                                            <input v-on:click="$emit('change_addstudent', 1)" type="button" value="返回" class="input2" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
		`,
});


//右侧内容页面-admin
Vue.component('n-right-admin', {
    props: ['admins', 'addadmin_tagle', 'addadmin', 'updateadmin'],
    template: `
        <div class="rightbox">
            <div v-show="addadmin_tagle == 'home'">
                <h2 class="mbx">学生考勤系统 > 账号管理</h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis">
                            <strong style="color: red;">注意：</strong>管理员账号请<span style="color: red;"> 谨慎操作 </span>
                            <a href="javascript:;" v-on:click="$emit('change_addadmin', 0)"  >&nbsp;[申请账号]</a>
                        </div>
                        
                    </div>
                    <div class="cztable">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: center;">
                            <tr>
                                <th width="30%">账号</th>
                                <th style="width: 25%; text-align: center;">身份</th>
                                <th style="width: 30%; text-align: center;">操作</th>
                            </tr>
                            <tr v-for="(item, i) in admins">
                                <td>{{item.userid}}</td>
                                <td>{{item.username}}</td>
                                <td>
                                    <a v-if="item.id == 1" href="javascript:;" v-on:click="$emit('change_updateadmin', i)"  style="color: blue;">[修改]</a>
                                    <div v-else>
                                        <a href="javascript:;" v-on:click="$emit('change_updateadmin', i)" style="color: blue;">[修改]</a>
                                        &nbsp;&nbsp;
                                        <a href="javascript:;" v-on:click="$emit('admin_remove', item.id)" style="color: red;">[删除]</a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div v-show="addadmin_tagle == 'add'">
                <h2 class="mbx">学生考勤系统 > 账号管理  > 添加账号</h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong style="color: red;">注意：</strong><span style="color: blue;">*审核原因尽量简短  *</span>
                        </div>
                    </div>
                    <div class="cztable">
                        <form method="post">
                            <input type="hidden" name="action" value="updateScore" />
                            <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">
                                <tr>
                                    <td width="15%" align="right"><div align="right">账号：</div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addadmin.userid" /></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">身份：</div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="addadmin.username" /></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <div align="center">
                                            <input type="button" v-on:click="$emit('admin_add', addadmin)" value="确认" class="input2" /> 
                                            <input type="button" v-on:click="$emit('change_addadmin', 1)" value="返回" class="input2" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
            <div v-show="addadmin_tagle == 'update'">
                <h2 class="mbx">学生考勤系统 > 账号管理  > 修改账号</h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong style="color: red;">注意：</strong><span style="color: blue;">*审核原因尽量简短  *</span>
                        </div>
                    </div>
                    <div class="cztable">
                        <form method="post">
                            <input type="hidden" name="action" value="updateScore" />
                            <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">
                                <tr>
                                    <td width="15%" align="right"><div align="right">账号：</div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updateadmin.userid" /></td>
                                </tr>
                                <tr>
                                    <td width="15%" align="right"><div align="right">身份：</div></td>
                                    <td v-if="updateadmin.id == 1">
                                        <input  id="Ctitle" size="20" class="input_2" v-model="updateadmin.username" readonly="readonly" />*管理员账号无法修改该信息
                                    </td>
                                    <td v-if="updateadmin.id != 1">
                                        <input id="Ctitle" size="20" class="input_2" v-model="updateadmin.username" />
                                    </td>

                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <div align="center">
                                            <input type="button" v-on:click="$emit('admin_update', updateadmin)" value="确认" class="input2" /> 
                                            <input type="button" v-on:click="$emit('change_addadmin', 1)" value="返回" class="input2" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
		`,
});

//右侧内容页面-dept
Vue.component('n-right-dept', {
    props: ['list', 'adddept_tagle', 'adddept', 'updatedept'],
    template: `
        <div class="rightbox">
            <div v-show="adddept_tagle == 'home'">
            <h2 class="mbx">学生考勤系统 > 部门管理</h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis">
                        <span style="color: red;">添加部门：</span> <span style="color: blue;"><a
                        href="javascript:;" v-on:click="$emit('change_adddept', 0)">[点击添加]</a></span>
                        </div>
                    </div>
                    <div class="cztable">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: center;">
                            <tr>
                                <th width="20%">部门编号</th>
                                <th width="35%">部门</th>
                                <th style="width: 45%; text-align: center;">操作</th>
                            </tr>
                            <tr v-for="item in list">
                                <td>{{item.d_no}}</td>
                                <td>{{item.d_name}}</td>
                                <td>
                                <a href="javascript:;" v-on:click="$emit('change_updatedept', item)" style="color: blue;">[修改]</a>
                                &nbsp;&nbsp;
                                <a style="color: red;" href="javascript:;" v-on:click="$emit('dept_remove', item.d_no)">[删除]</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div v-show="adddept_tagle == 'add'">
                <h2 class="mbx">学生考勤系统 > 部门管理  > 添加部门</h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong style="color: red;">注意：</strong><span style="color: blue;">*审核原因尽量简短  *</span>
                        </div>
                    </div>
                    <div class="cztable">
                        <form method="post">
                            <input type="hidden" name="action" value="updateScore" />
                            <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">
                                <tr>
                                    <td width="15%" align="right"><div align="right">部门名称：</div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="adddept"/></td>
                                </tr>
                                
                                <tr>
                                    <td colspan="2" align="center">
                                        <div align="center">
                                            <input type="button" v-on:click="$emit('dept_add', adddept)" value="确认" class="input2" /> 
                                            <input type="button" v-on:click="$emit('change_adddept', 1)" value="返回" class="input2" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>

            <div v-show="adddept_tagle == 'update'">
                <h2 class="mbx">学生考勤系统 > 部门管理  > 修改部门</h2>
                <div class="fllist">
                    <div class="feilei">
                        <div class="tis red">
                            <strong style="color: red;">注意：</strong><span style="color: blue;">*审核原因尽量简短  *</span>
                        </div>
                    </div>
                    <div class="cztable">
                        <form method="post">
                            <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">

                                <tr>
                                    <td width="15%" align="right"><div align="right">部门：</div></td>
                                    <td><input id="Ctitle" size="20" class="input_2" v-model="updatedept.d_name" /></td>
                                </tr>
                                
                                <tr>
                                    <td colspan="2" align="center">
                                        <div align="center">
                                            <input type="button" v-on:click="$emit('dept_update', updatedept.d_no, updatedept.d_name)" value="确认" class="input2" /> 
                                            <input type="button" v-on:click="$emit('change_adddept', 1)" value="返回" class="input2" />
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
		`,
});


//右侧内容页面-score
Vue.component('n-right-score', {
    props: ['scores', 'score_nums', 'score_limit', 'score_pages'],
    template: `
        <div class="rightbox">
            <h2 class="mbx">学生考勤系统 > 审核记录管理</h2>
            <div class="fllist">
                <div class="feilei">
                    <span style="color: red;">分类：</span> 
                    <span style="color: blue;"><a href="admin.php?action=score">全部 &nbsp; | &nbsp; </a></span>
                    <span style="color: blue;"><a href="admin.php?action=score&time=1"> 一周内 &nbsp; |  &nbsp; </a></span>
                    <span style="color: blue;"><a href="admin.php?action=score&time=2"> 一月内  &nbsp; | &nbsp; </a></span>
                    <span style="color: blue;"><a href="admin.php?action=score&time=3"> 三月内    </a></span>
                </div>
                <div class="cztable">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: center;">
                        <tr>
                            <th width="5%">编号</th>
                            <th width="10%">学号</th>
                            <th width="10%">学号</th>
                            <th width="7%">当前分数</th>
                            <th width="15%">审核时间</th>
                            <th width="7%">审核类型</th>
                            <th width="25%">审核理由</th>
                            <th width="7%">变动分数</th>
                            <th width="8%">操作</th>
                        </tr>
                        <tr v-for="(item, i) in scores" v-show="i < score_limit.now_score_page*score_limit.line && i >= (score_limit.now_score_page-1)*score_limit.line" >
                            <td>{{item.id}}</td>
                            <td>{{item.student.s_no}}</td>
                            <td>{{item.student.s_name}}</td>
                            <td>{{item.score}}</td>
                            <td>{{item.time}}</td>
							<td v-if="item.addScore != 0" style="color:green;">加分</td>
							<td v-if="item.addScore != 0">{{item.addCause}}</td>
							<td v-if="item.addScore != 0" style="color:green;">+ {{item.addScore}}</td>
							<td v-if="item.delScore != 0" style="color:red;">减分</td>
							<td v-if="item.delScore != 0">{{item.delCause}}</td>
							<td v-if="item.delScore != 0" style="color:red;">- {{item.delScore}}</td>
                            <td> 
                                <a style="color: blue;" href="javascript:;" v-on:click="$emit('score_remove', item.id)">[删除]</a>
                            </td>
							</tr>
                    </table>
                    <div class="MainStyle">
                        <div>
                            <a href="javascript:;" v-on:click="$emit('score_page', 'first')">首页</a>
                        </div>
                        <div>
                            <a href="javascript:;" v-on:click="$emit('score_page', 'pre')">上一页</a>
                        </div>
                        <div v-for="item in score_pages">
                            <div v-if="item == score_limit.now_score_page" class="NowItemStyle">
                                <a href="javascript:void(0)">{{item}}</a>
                            </div>
                            <div v-else>
                                <a href="javascript:;" v-on:click="$emit('score_page', item)">{{item}}</a>
                            </div>
                        </div>
                        <div>
                            <a href="javascript:;" v-on:click="$emit('score_page', 'next')">下一页</a>
                        </div>
                        <div >
                            <a href="javascript:;" v-on:click="$emit('score_page', 'last')">尾页</a>
                        </div>
                        <div>
                            共<b> {{score_nums}} </b>条数据
                        </div>
                        <div>
                            <b>{{score_limit.line}} </b>条/页
                        </div>
                    </div>
                </div>
            </div>
        </div>
		`,
});


//右侧内容页面-updateScore
Vue.component('n-right-updatescore', {
    props: ['score_limit', 'now_score'],
    template: `
        <div class="rightbox">
            <h2 class="mbx">学生考勤系统 > 审核管理 > <span v-if="score_limit.tagle == 'addScore'"> 加分审核</span>
                <span v-if="score_limit.tagle == 'delScore'"> 减分审核</span></h2>
            <div class="fllist">
                <div class="feilei">
                <div class="tis red">
                    <strong style="color: red;">注意：</strong><span style="color: blue;">*审核原因尽量简短  *</span>
                </div>
                </div>
                <div class="cztable">
                    <form action="" method="post">
                        <input type="hidden" name="action" value="updateScore" />
                        <table width="100%" cellpadding="0" cellspacing="0" class="ks_tb">
                            <tr>
                                <td width="15%" align="right"><div align="right">学号：
                                    </div></td>
                                <td><input id="Ctitle" size="20" 
                                    class="input_2" v-model="now_score.s_no" /></td>
                            </tr>
                            
                            <tr v-if="score_limit.tagle == 'addScore' ">
                                <td width="15%" align="right"><div align="right" style="color: green;">加分原因：
                                    </div></td>
                                <td><input id="Ctitle" size="30" 
                                    class="input_2" v-model="now_score.addCause" />
                                    <input type="hidden" name="tagle" value="add" />
                                </td>
                            </tr>
                            
                            <tr v-if="score_limit.tagle == 'addScore' ">
                                <td width="15%" align="right"><div align="right">变动分数：
                                    </div></td>
                                <td><input id="Ctitle" size="10" name="addScore"
                                    class="input_2" v-model="now_score.addScore" /></td>
                            </tr>
                            
                            <tr v-if="score_limit.tagle == 'delScore' ">
                                <td width="15%" align="right"><div align="right" style="color: red;">减分原因：
                                    </div></td>
                                <td><input id="Ctitle" size="30" name="delCause"
                                    class="input_2" v-model="now_score.delCause" />
                                    <input type="hidden" name="tagle" value="del" />
                                </td>
                            </tr>
                            <tr v-if="score_limit.tagle == 'delScore' ">
                                <td width="15%" align="right"><div align="right">变动分数：
                                    </div></td>
                                <td><input id="Ctitle" size="10" name="delScore"
                                    class="input_2" v-model="now_score.delScore" /></td>
                            </tr>

                            <tr>
                                <td width="15%" align="right"><div align="right" style="color: green;">时间：
                                    </div></td>
                                <td><input id="Ctitle" size="30" 
                                    class="input_2" v-model="now_score.time" />
                                </td>
                            </tr>
                            
                            <tr>
                                <td colspan="2" align="center">
                                    <div align="center">
                                        <input type="button" v-on:click="$emit('score_add', now_score)" value="确认" class="input2" /> 
                                        <input type="button" v-on:click="$emit('score_add', now_score)"  value="重置" class="input2" />
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
		`,
});

//右侧内容页面-excel
Vue.component('n-right-excel', {
    props: ['excel'],
    template: `
        <div class="rightbox">

            <h2 class="mbx">
                学生考勤系统 > 文件管理 &gt; <a href="#">Excel文件</a>
            </h2>
            <div class="feilei">
                <a href="#"><strong>Excel文件</strong></a>
            </div>
            
            <form action="api/v2/file/fileUpload" method="post" enctype="multipart/form-data">
                <div style="margin: 10px 0px; float: right;">
                    <div style="display: inline;">
                        <span style="color:blue; font-size:15px;">注意：该选项会将数据保存为名为Students的文件! &nbsp;</span><a href="javascript:;" v-on:click="$emit('file_excel')"  style="color: red;padding:0px;font-size:16px;" title="点击导出数据">[导出数据]</a>
                    </div>
                    <div style="width:400px; display: inline; float: right; ">
                        <input type="file" name="file" style="width: 45%; margin-left: 150px;" /> 
                        <input type="submit" value="上传文件" />
                    </div>
                </div>
            </form>
            <div class="fllist">
                <div class="cztable">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: center;">
                        <tr>
                            <th width="10%">资料</th>
                            <th width="40%">资料名称</th>
                            <th style="width: 20%; text-align: center;">资料类型</th>
                            <th style="width: 30%; text-align: center;">操作</th>
                        </tr>
                    
                        <tr v-for="item in excel">
                            <td><img src='images/excel.png' /></td>
                            <td class="xxleft" style="text-align: center">{{item}}</td>
                            <td>Excel文件</td>
                            
                            <td>
                                <a :href="'/api/v2/file/dowlond?name='+item"  target="_blank" title="点击下载"> 
                                    <img src="images/down.png" alt="点击下载" />
                                </a> &nbsp;&nbsp;&nbsp;&nbsp; 
                                <a href="javascript:;" v-on:click="$emit('file_remove', item)"  title="点击删除">
                                    <img src="images/delete.png" alt="点击删除" />
                                </a>&nbsp;&nbsp;&nbsp;&nbsp; 
                                <a href="javascript:;" v-on:click="$emit('file_write', item)" style="color: blue;" title="点击导入">[导入数据]</a>
                            </td>
                        </tr>

                    </table>
                </div>
            </div>

        </div>
		`,
});

//右侧内容页面-img
Vue.component('n-right-img', {
    props: [''],
    template: `
        
		`,
});


new Vue({
    el: '#app',
    //数据
    data: {
        user: {         //用户信息
            id: '',         //用户编号
            userid: '',     //用户账号
            username: ''   //用户身份
        },
        now_page: 'home',
        now_dept: {},      //当前部门
        dept_limit: {       //部门分页参数
            line: 10,       //每页多少行数据
            now_dept_page: 1,   //当前部门页数
        },
        addstudent_tagle: 'home',     //成员管理-->添加学生-->状态
        addstudent: {                //成员管理-->添加学生
            no: '1625123188',
            name: 'test',
            class: 'test',
            dept: '',
            greed: 1,
            greed_name: 'test',
            telephone: '1822198565',
            score: 0,
            onTimes: 0,
            lateTimes: 0,
            outTimes: 0,
            leaveTimes: 0
        },
        updatestudent: {                //成员管理-->修改学生
            no: '',
            name: '',
            class: '',
            dept: '',
            greed: 0,
            greed_name: '',
            telephone: '',
            score: 0,
            onTimes: 0,
            lateTimes: 0,
            outTimes: 0,
            leaveTimes: 0
        },
        addadmin_tagle: 'home',       //账号管理-->添加账号-->状态
        addadmin: {                  //账号管理-->添加账号
            id: '',
            userid: '',
            username: '',
        },
        updateadmin: {},             //账号管理-->修改账号


        adddept_tagle: 'home',        //部门管理-->添加部门-->状态
        adddept: '',            //部门管理-->添加部门
        updatedept: {},

        now_score: {
            s_name: 'yhj',
            s_no: '1625123101',
            time: '2019-3-2 13:19',
            addScore: 0,
            addCause: '',
            delScore: 0,
            delCause: ''
        },

        score_limit: {       //审核记录分页参数
            tagle: '',
            line: 5,
            now_score_page: 1,   //当前审核记录页数
        },
        now_student: '',
        admins: [],            //账号信息
        list: [],         //部门列表
        scores: [],        //审核记录列表

        excel: [],           //excel文件



    },
    //方法
    methods: {
        //部门分页跳转
        dept_page: function (tagle) {
            if (tagle == 'next') {
                if (this.dept_limit.now_dept_page < this.dept_pages) {
                    this.dept_limit.now_dept_page++;
                }
            } else if (tagle == 'pre') {
                if (this.dept_limit.now_dept_page > 1) {
                    this.dept_limit.now_dept_page--;
                }
            } else if (tagle == "first") {
                if (this.dept_limit.now_dept_page > 1) {
                    this.dept_limit.now_dept_page = 1;
                }
            } else if (tagle == "last") {
                if (this.dept_limit.now_dept_page < this.dept_pages) {
                    this.dept_limit.now_dept_page = this.dept_pages;
                }
            } else {
                this.dept_limit.now_dept_page = tagle;
            }

        },

        //审核记录分页跳转
        score_page: function (tagle) {
            if (tagle == 'next') {
                if (this.score_limit.now_score_page < this.score_pages) {
                    this.score_limit.now_score_page++;
                }
            } else if (tagle == 'pre') {
                if (this.score_limit.now_score_page > 1) {
                    this.score_limit.now_score_page--;
                }
            } else if (tagle == "first") {
                if (this.score_limit.now_score_page > 1) {
                    this.score_limit.now_score_page = 1;
                }
            } else if (tagle == "last") {
                if (this.score_limit.now_score_page < this.score_pages) {
                    this.score_limit.now_score_page = this.score_pages;
                }
            } else {
                this.score_limit.now_score_page = tagle;
            }

        },
        //部门跳转
        dept_go: function (index) {
            this.now_page = 'student';
            this.now_dept = this.list[index];
            this.dept_limit.now_dept_page = 1;
            this.addstudent_tagle = 'home';
        },
        //跳转管理
        page_go: function (page) {
            this.now_page = page;

        },
        //审核记录跳转
        updatescore: function (tagle) {
            this.now_page = 'scoreupdate';
            this.score_limit.tagle = tagle;

        },

        //成员管理-----> 添加学生
        change_addstudent: function (tagle) {
            if (tagle === 0) {
                this.addstudent_tagle = 'add';
            } else if (tagle === 1) {
                this.addstudent_tagle = 'home';
            }
        },
        //成员管理-----> 修改学生
        change_updatestudent: function (index) {
            this.updatestudent = this.now_dept.student[index];

            console.log(this.updatestudent);
            this.addstudent_tagle = 'update';
        },

        //账号管理-->添加账号
        change_addadmin: function (tagle) {
            if (tagle === 0) {
                this.addadmin_tagle = 'add';
            } else if (tagle === 1) {
                this.addadmin_tagle = 'home';
            }
        },
        //账号管理-->修改账号
        change_updateadmin: function (index) {
            this.updateadmin = this.admins[index];
            this.addadmin_tagle = 'update';
        },

        //部门管理-->添加部门
        change_adddept: function (tagle) {
            if (tagle === 0) {
                this.adddept_tagle = 'add';
            } else if (tagle === 1) {
                this.adddept_tagle = 'home';
            }
        },

        //部门管理-->修改部门
        change_updatedept: function (dept) {
            this.updatedept = dept;
            this.adddept_tagle = 'update';

        },

        //---------------------------请求-学生--------------------------------//

        dowlond: function (name) {
            axios.post('/api/v2/file/dowlond', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('学生修改成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.addstudent_tagle = 'home';
                        } else {
                            toastr.warning('学生修改失败');
                        }

                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },


        //添加学生信息
        student_add: function (stu) {
            let s = new URLSearchParams();
            s.append('s_no', stu.no);
            s.append('s_name', stu.name);
            s.append('s_class', stu.class);
            s.append('dept', this.now_dept.d_no);
            s.append('s_greed', stu.greed);
            s.append('greed_name', stu.greed_name);
            s.append('telephone', stu.telephone);
            s.append('score', stu.score);
            s.append('onTimes', stu.onTimes);
            s.append('lateTimes', stu.lateTimes);
            s.append('outTimes', stu.outTimes);
            s.append('leaveTimes', stu.leaveTimes);
            axios.post('/api/v2/student/add', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('学生添加成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;

                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.addstudent_tagle = 'home';
                        } else {
                            toastr.warning('学生添加失败');
                        }

                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //修改学生信息
        student_update: function (stu) {
            console.log(stu);

            axios.post('/api/v2/student/update', stu)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('学生修改成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.addstudent_tagle = 'home';
                        } else {
                            toastr.warning('学生修改失败');
                        }

                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //删除学生
        student_remove: function (s_no) {
            console.log(s_no);
            axios.get('/api/v2/student/remove?s_no='+s_no)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('删除成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else {
                            toastr.warning('删除失败');
                        }

                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //-----------------------------部门----------------------------------//

        //添加部门
        dept_add: function (d_name) {
            let s = new URLSearchParams();
            s.append('d_name', d_name);
            axios.post('/api/v2/dept/add', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('部门添加成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.adddept_tagle = false;
                        } else {
                            toastr.warning('部门添加失败');
                        }

                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //修改部门
        dept_update: function (d_no, d_name) {
            let s = new URLSearchParams();
            s.append('d_no', d_no);
            s.append('d_name', d_name);
            axios.post('/api/v2/dept/update', s)
                .then(
                    (res) => {
                        console.log(res.data);
                        if (res.data) {
                            toastr.success('部门修改成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.adddept_tagle = 'home';
                        } else {
                            toastr.warning('部门修改失败');
                        }
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //删除部门
        dept_remove: function (d_no) {
            let s = new URLSearchParams();
            s.append('d_no', d_no);
            axios.post('/api/v2/dept/remove', s)
                .then(
                    (res) => {
                        console.log(res.data);
                        if (res.data) {
                            toastr.success('部门删除成功');
                            axios.get('/api/v2/data/deptlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.list = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else {
                            toastr.warning('部门删除失败');
                        }
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //-----------------------------账号----------------------------------//
        //添加账号
        admin_add: function (admin) {
            let s = new URLSearchParams();
            s.append('userid', admin.userid);
            s.append('username', admin.username);
            axios.post('/api/v2/admin/add', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('账号添加成功');
                            axios.get('/api/v2/data/adminlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.admins = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.addadmin_tagle = 'home';
                        } else
                            toastr.warning('账号添加失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //修改账号
        admin_update: function (admin) {
            let s = new URLSearchParams();
            s.append('id', admin.id);
            s.append('userid', admin.userid);
            s.append('username', admin.username);
            axios.post('/api/v2/admin/update', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('账号修改成功');
                            axios.get('/api/v2/data/adminlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.admins = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                            this.addadmin_tagle = 'home';
                        } else
                            toastr.warning('账号修改失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //注销账号
        admin_remove: function (id) {
            let s = new URLSearchParams();
            s.append('id', id);
            axios.post('/api/v2/admin/remove', s)
                .then(
                    (res) => {

                        if (res.data) {
                            toastr.success('账号注销成功');
                            axios.get('/api/v2/data/adminlist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.admins = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else
                            toastr.warning('账号注销失败');


                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //-----------------------------审核记录----------------------------------//
        score_remove: function (id) {
            let s = new URLSearchParams();
            s.append('id', id);
            axios.post('/api/v2/score/remove', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('审核记录删除成功');
                            axios.get('/api/v2/data/scorelist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.scores = res.data;
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else
                            toastr.warning('审核记录删除失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //添加审核记录
        score_add: function (score) {
            let s = new URLSearchParams();
            s.append('s_no', score.s_no);

            s.append('time', score.time);
            if (score.addScore != 0) {
                s.append('tagle', 'add');
                s.append('score', score.addScore);
                s.append('cause', score.addCause);
            } else if (score.delScore != 0) {
                s.append('tagle', 'del');
                s.append('score', score.delScore);
                s.append('cause', score.delCause);
            }

            axios.post('/api/v2/score/add', s)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('操作成功');
                            axios.get('/api/v2/data/scorelist')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.scores = res.data;
                                        this.now_page = 'score';
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else
                            toastr.warning('操作失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },
        //-----------------------------文件操作----------------------------------//
        //文件写入
        file_write: function(name) {
            axios.post('/api/v2/file/write', name)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('写入成功');
                        } else
                            toastr.warning('写入失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //excel表格生成
        file_excel: function() {
            axios.get('/api/v2/file/excel')
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('excel生成成功');
                            axios.get('/api/v2/file/list')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.excel = res.data; 
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else
                            toastr.warning('失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //文件下载
        file_dowlond: function(name) {
            console.log(name);
            axios.post('/api/v2/file/dowlond', name)
                .then(
                    (res) => {
                        if (res.data) {
                            
                        } else
                            toastr.warning('下载失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },

        //文件删除
        file_remove: function(name) {
            axios.post('/api/v2/file/remove', name)
                .then(
                    (res) => {
                        if (res.data) {
                            toastr.success('删除成功');
                            axios.get('/api/v2/file/list')
                                .then(
                                    (res) => {
                                        console.log(res.data);
                                        this.excel = res.data; 
                                    }
                                )
                                .catch(
                                    (error) => { console.log(error); }
                                );
                        } else
                            toastr.warning('删除失败');
                    }
                )
                .catch(
                    (error) => { console.log(error); }
                );
        },
    },
    //挂载
    mounted() {
        axios.get('/api/v2/data/deptlist')
            .then(
                (res) => {
                    console.log(res.data);
                    this.list = res.data;
                    //加载部门列表
                    this.now_dept = this.list[0];
                }
            )
            .catch(
                (error) => { console.log(error); }
            );

        axios.get('/api/v2/data/scorelist')
            .then(
                (res) => {
                    console.log(res.data);
                    this.scores = res.data;
                }
            )
            .catch(
                (error) => { console.log(error); }
            );

        axios.get('/api/v2/data/adminlist')
            .then(
                (res) => {
                    console.log(res.data);
                    this.admins = res.data;
                }
            )
            .catch(
                (error) => { console.log(error); }
            );

        axios.get('/api/v2/file/list')
            .then(
                (res) => {
                    console.log(res.data);
                    this.excel = res.data;
                }
            )
            .catch(
                (error) => { console.log(error); }
            );

    },
    //计算属性
    computed: {
        //部门总数据条数
        dept_nums: function () {
            return this.now_dept.student.length;
        },
        //部门总页数
        dept_pages: function () {
            return Math.ceil(this.now_dept.student.length / this.dept_limit.line);    //向上取整
        },
        //审核记录总条数
        score_nums: function () {
            return this.scores.length;
        },
        //审核记录总页数
        score_pages: function () {
            return Math.ceil(this.scores.length / this.score_limit.line);
        }
    }
});
