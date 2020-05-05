function showAll() {
    layui.use(['table','laydate'], function () {
        let table = layui.table,
            laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#start'
        });
        laydate.render({
            elem: '#end'
        });
        table.render({
            elem: '#test'
            , height: 'full-68'
            , url: 'http://localhost:8080/rpaLog/findAll/'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print']
            , title: 'RPA运行记录表'
            , cols: [[
                {
                    field: 'rpalogId',
                    title: '运行记录ID',
                    width: 120,
                    fixed: 'left',
                    unresize: true,
                    sort: true
                }
                , {field: 'company', title: '公司', width: 120}
                , {field: 'name', title: 'RPA名称'}
                , {field: 'startTime', title: '开始运行时间', sort: true}
                , {field: 'endTime', title: '结束运行时间', sort: true}
                , {field: 'runTime', title: '运行时长', sort: true}
                , {field: 'result', title: '运行结果', sort: true}
            ]]
            , page: true
            , response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
            , parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表
                };
            }
        });
    });
}

function show(result) {
    layui.use(['table','laydate'], function () {
        let table = layui.table
            laydate = layui.laydate;

        //常规用法
        laydate.render({
            elem: '#start'
        });
        laydate.render({
            elem: '#end'
        });

        table.render({
            elem: '#test'
            , height: 'full-68'
            , url: 'http://localhost:8080/rpaLog/findByResult/'
            , method: 'post'
            , where: {'result': result}
            , request: {
                pageName: 'currentPage'
                , limitName: 'limit'
            }
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print']
            , title: 'RPA运行记录表'
            , cols: [[
                {
                    field: 'rpalogId',
                    title: '运行记录ID',
                    width: 120,
                    fixed: 'left',
                    unresize: true,
                    sort: true
                }
                , {field: 'company', title: '公司', width: 120}
                , {field: 'name', title: 'RPA名称'}
                , {field: 'startTime', title: '开始运行时间', sort: true}
                , {field: 'endTime', title: '结束运行时间', sort: true}
                , {field: 'runTime', title: '运行时长', sort: true}
                , {field: 'result', title: '运行结果', sort: true}
            ]]
            , page: true
            , response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
            , parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表
                };
            }
        });
    });
}