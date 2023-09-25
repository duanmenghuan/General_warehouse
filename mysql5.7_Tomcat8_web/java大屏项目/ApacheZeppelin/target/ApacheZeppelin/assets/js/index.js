$(function(){
    function loadData(option) {
        $.ajax({
            type : 'post',	//传输类型
            async : false,	//同步执行
            url : 'bar.do',	//web.xml中注册的Servlet的url-pattern
            data : {},
            dataType : 'json', //返回数据形式为json
            success : function(result) {
                if (result) {
                    //初始化xAxis[0]的data
                    option.xAxis[0].data = [];
                    for (var i=0; i<result.length; i++) {
                        option.xAxis[0].data.push(result[i].name);
                    }
                    //初始化series[0]的data
                    option.series[0].data = [];
                    for (var i=0; i<result.length; i++) {
                        option.series[0].data.push(result[i].num);
                    }
                }
            },
            error : function(errorMsg) {
                alert("加载数据失败");
            }
        });//AJAX
    }//loadData()


    /*标准*/
    var radar = echarts.init(document.getElementById('radar'));
    option = {
        title: {
            text: ''
        },
        tooltip: {},
        legend: {

            data: ['第一推荐', '第二推荐','第三推荐'],
            x:"center",
            y:'bottom',
            textStyle:{
                color:"#fff"
            }
        },
        color: ['#4c95d9', '#f6731b', '#8cd43f'],
        radar: {
            name:{
                textStyle: {
                    //设置颜色
                    color:'#fff'
                }
            },
            indicator: [
                { name: '无要求', max: 5000},
                { name: '中职及以下', max: 5000},
                { name: '专科', max: 5000},
                { name: '本科', max: 5000},
                { name: '研究生', max: 5000},
                { name: '硕士', max: 5000}
            ],
            center: ['50%','50%'],
            radius: "58%"
        },
        series: [{
            name: '',
            type: 'radar',
            itemStyle : {
                normal : {
                    splitLine: {
                        lineStyle: {

                        }
                    },
                    label: {
                        show: false,
                        textStyle:{
                        },
                        formatter:function(params) {
                            return params.value;}
                    },
                }
            },
            data : [
                {
                    value : [240, 1000, 2800, 3500, 5000, 1900],
                    name : '第一推荐'
                },
                {
                    value : [500, 1400, 2800, 3100, 4200, 2100],
                    name : '第二推荐'
                },
                {
                    value : [600, 1400, 1800, 2100, 3200, 1100],
                    name : '第三推荐'
                }
            ]
        }]
    };
    radar.setOption(option);

    /* 飞鸟尽*/
    var graduateyear = echarts.init(document.getElementById('graduateyear'));
    option = {
        title : {
            text:"",
            x:'center',
            y:'top',
            textStyle:
            {
                color:'#fff',
                fontSize:13
            }
        },
        tooltip : {
            trigger: 'axis'
        },
        grid: {
            left: '3%',
            right: '8%',
            bottom: '5%',
            top:"13%",
            containLabel: true
        },
        color:["#72b332",'#35a9e0'],
        legend: {
            data:['学历需求(静态)','岗位数量'],
            show:true,

            right:'15%',
            y:"0",
            textStyle:{
                color:"#999",
                fontSize:'13'
            },
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['3月','4月','5月','6月'],
                splitLine:{
                    show:true,
                    lineStyle:{
                        color: '#2d3b53'
                    }
                },
                axisLabel:{
                    textStyle:{
                        color:"#fff"
                    },
                    alignWithLabel: true,
                    interval:0,
                    rotate:'15'
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                splitLine:{
                    show:true,
                    lineStyle:{
                        color: '#2d3b53'
                    }
                },
                axisLabel:{
                    textStyle:{
                        color:"#999"
                    }
                },
            }
        ],
        series : [
            {
                name:'学历需求(静态)',
                type:'line',
                smooth:true,
                symbol:'roundRect',
                data:[1168,1189,1290,1300]
            },
            {
                name:'岗位数量',
                type:'line',
                smooth:true,
                symbol:'roundRect',
                data:[2335,3010,6234,0]
            }
        ]
    };
    graduateyear.setOption(option);

    /*==*/
    var sexrate = echarts.init(document.getElementById('sexrate'));
    var total = {
        name: '性別'
    };
    option = {
        title: [{
            text: total.name,
            left: '48%',
            top: '34%',
            textAlign: 'center',
            textBaseline: 'middle',
            textStyle: {
                color: '#fff',
                fontWeight: 'normal',
                fontSize: 18
            }
        }, {
            text: total.value,
            left: '48%',
            top: '44%',
            textAlign: 'center',
            textBaseline: 'middle',
            textStyle: {
                color: '#fff',
                fontWeight: 'normal',
                fontSize: 18
            }
        }],
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        color:['#70a3ff','#ff7f4e'],
        legend: {
            orient: 'vertical',
            x:'center',
            bottom:'5%',
            selectedMode:false,
            formatter:function(name){
                var oa = option.series[0].data;
                var num = oa[0].value + oa[1].value ;
                for(var i = 0; i < option.series[0].data.length; i++){
                    if(name==oa[i].name){
                        return name + "  "+oa[i].value+"  "+ (oa[i].value / num * 100).toFixed(2) + '%';
                    }
                }
            },
            data: ['女','男'],
            show:true,
            textStyle:{
                color:'#fff',
                fontWeight:'bold'
            },
        },

        series : [
            {
                name: '性別',
                type: 'pie',
                selectedMode: 'single',
                radius: ['45%', '55%'],
                center: ['50%', '40%'],
                data: [
                    {value: 8629, name: '女'},
                    {value: 2507, name: '男'}
                ],
                label: {
                    normal: {
                        show: false,
                        position: "outer",
                        align:'left',
                        textStyle: {
                            rotate:true
                        }
                    }
                },
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    },
                    normal: {
                        label:{
                            show: true,
                            formatter: '{b} {c}'
                        }
                    }

                }
            }
        ]
    };
    sexrate.setOption(option);


    var householdrate = echarts.init(document.getElementById('householdrate'));
    var total = {
        name: '性別'
    };
    option = {
        title: [{
            text: total.name,
            left: '48%',
            top: '34%',
            textAlign: 'center',
            textBaseline: 'middle',
            textStyle: {
                color: '#fff',
                fontWeight: 'normal',
                fontSize: 18
            }
        }, {
            text: total.value,
            left: '48%',
            top: '44%',
            textAlign: 'center',
            textBaseline: 'middle',
            textStyle: {
                color: '#fff',
                fontWeight: 'normal',
                fontSize: 18
            }
        }],
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        color:['#4f9de7','#4acf79'],
        legend: {
            orient: 'vertical',
            x:'center',
            bottom:'5%',
            selectedMode:false,
            formatter:function(name){
                var oa = option.series[0].data;
                var num = oa[0].value + oa[1].value ;
                for(var i = 0; i < option.series[0].data.length; i++){
                    if(name==oa[i].name){
                        return name + "  "+oa[i].value+"  "+ (oa[i].value / num * 100).toFixed(2) + '%';
                    }
                }
            },
            data: ['男','女'],
            show:true,
            textStyle:{
                color:'#fff',
                fontWeight:'bold'
            },
        },
        series : [
            {
                name: 'FK',
                type: 'pie',
                selectedMode: 'single',
                radius: ['45%', '55%'],
                center: ['50%', '40%'],
                data: [
                    {value: 8629, name: '男'},
                    {value: 2507, name: '女'}
                ],
                label: {
                    normal: {
                        show: false,
                        position: "outer",
                        align:'left',
                        textStyle: {
                            rotate:true
                        }
                    }
                },
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    },
                    normal: {
                        label:{
                            show: true,
                            formatter: '{b} {c}'
                        }
                    }
                }
            }
        ]
    };
    householdrate.setOption(option);

    /*  =====-=*/
    var courserate = echarts.init(document.getElementById('courserate'));
    option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            right: '0',
            y:'middle',
            textStyle:{
                color:"#fff"
            },

            formatter:function(name){
                var oa = option.series[0].data;
                var num = oa[0].value + oa[1].value + oa[2].value + oa[3].value+oa[4].value+oa[5].value;
                for(var i = 0; i < option.series[0].data.length; i++){
                    if(name==oa[i].name){
                        return name +  ' '+oa[i].value;
                    }
                }
            },
            data: ['无要求','中职及以下','专科','本科','研究生','博士']
        },
        series : [
            {
                name: '学历要求',
                type: 'pie',
                radius : '65%',
                color:['#27c2c1','#9ccb63','#fcd85a','#60c1de','#0084c8','#d8514b'],
                center: ['38%', '50%'],
                data:[
                    {value:234, name:'无要求'},
                    {value:335, name:'中职及以下'},
                    {value:310, name:'专科'},
                    {value:234, name:'本科'},
                    {value:135, name:'研究生'},
                    {value:234, name:'博士'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                itemStyle: {
                    normal: {
                        label:{
                            show: true,
                            position:'outside',
                            formatter: '{b}'
                        }
                    },
                    labelLine :{show:true}
                }
            }
        ]
    };
    courserate.setOption(option);

    /* =======*/
    var professionrate = echarts.init(document.getElementById('professionrate'));
    option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            right: '0',
            y:'middle',
            textStyle:{
                color:"#fff"
            },
            data: ['3月','4月','5月','6月'],
            formatter:function(name){
                var oa = option.series[0].data;
                var num = oa[0].value + oa[1].value + oa[2].value;
                for(var i = 0; i < option.series[0].data.length; i++){
                    if(name==oa[i].name){
                        return name +  ' '+oa[i].value;
                    }
                }
            }
        },
        series : [
            {
                name: '发布时间',
                type: 'pie',
                radius : '60%',
                center: ['35%', '50%'],
                data:[
                    {value:2335, name:'3月'},
                    {value:3010, name:'4月'},
                    {value:6234, name:'5月'},
                    {value:0, name:'6月'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                itemStyle: {
                    normal: {
                        label:{
                            show: true,
                            position:'outside',
                            formatter: '  {b}'
                        }
                    },
                    labelLine :{show:true}
                }
            }
        ]
    };
    professionrate.setOption(option);

    //bar图
    var changedetail = echarts.init(document.getElementById('changedetail'));
    let base = +new Date(1968, 9, 3);
    let oneDay = 24 * 3600 * 1000;
    let date = [];
    let data = [Math.random() * 300];
    for (let i = 1; i < 20000; i++) {
        var now = new Date((base += oneDay));
        date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'));
        data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
    }
    option = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: ''
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date,
            shadowColor: 'rgba(241,241,241,0.5)'
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%'],
            shadowColor: 'rgba(241,232,232,0.89)'
        },
        dataZoom: [
            {
                type: 'inside',
                start: 0,
                end: 10
            },
            {
                start: 0,
                end: 10
            }
        ],
        series: [
            {
                name: 'Fake Data',
                type: 'line',
                symbol: 'none',
                sampling: 'lttb',
                itemStyle: {
                    color: 'rgb(255, 70, 131)'
                },
                areaStyle: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                            offset: 0,
                            color: 'rgb(255, 158, 68)'
                        },
                        {
                            offset: 1,
                            color: 'rgb(255, 70, 131)'
                        }
                    ])
                },
                data: data
            }
        ]
    };
    //加载数据到option
    loadData(option);
    //设置option
    changedetail.setOption(option);

})


// //分页导航栏设置
// //初始化页面
// $(function(){
//     initpage();
// })
// //分页设置
// function initpage() {
//     var totalpage = "${pages}";
//     totalpage = parseInt(totalpage);
//     if (totalpage == 0)
//     {
//         return;
//     }
//     var currentpage = "1";
//     currentpage = parseInt(currentpage);
//     $.jqPaginator(
//         '#pagination',
//         {
//             totalPages : totalpage,
//             visiblePages : 5,
//             currentPage : currentpage,
//             wrapper : '<ul class="pagination lastspan"></ul>',
//             first : '<li class="first"><a href="javascript:void(0);">首页</a></li>',
//             prev : '<li class="prev"><a href="javascript:void(0);">&laquo;</a></li>',
//             next : '<li class="next"><a href="javascript:void(0);">&raquo;</a></li>',
//             last : '<li class="last"><a href="javascript:void(0);">尾页</a></li>',
//             page : '<li class=""><a href="javascript:void(0);">{{page}}</a></li>',
//             onPageChange : function(num) {
//                 search(num);
//             }
//         });
// }