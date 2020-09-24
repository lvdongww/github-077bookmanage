$(function () {
fenye();
    $(".tijiao").click(function () {
        location.href="/toadd";
    })
})
var pageIndex=1;
var pageSize=2;
var date;
function fenye() {
    $(".table-fenye tr:gt(1)").remove();
    var json={
        pageIndex:pageIndex,
        pageSize:pageSize
    }
    $.post("selectAll",json,function (data) {
        $(".zong").text(data.data.total)
        date=data.data;
        console.log(data.data)
        $(".ye").text(data.data.pageNum+"/"+data.data.pages);
        $.each(data.data.list,function (i,v) {
            var tr=$("<tr align='center'><td>"+v.name+"</td><td>"+v.author+"</td><td>"+v.publish+"</td><td>"+v.publishdate.substring(0,10)+"</td><td>"+v.page+"</td><td>"+v.price+"</td><td>"+v.content+"</td><td><a href='chuan?id="+v.id+"'>修改</a>&nbsp&nbsp&nbsp<span hidden>"+v.id+"</span><a href='javaScript:void(0)' class='shan'>删除</a></td></tr>");
            $(".table-fenye").append(tr);
        })
        $(".shan").click(function () {
            var id=$(this).prev().text();
           $.post("/delete",{id:id},function (data) {
               if (data.success=="true"){
                   alert("删除成功")
                   fenye()
               }else{
                   alert("删除失败")
               }
           },"json")
        })
    },"json")
}

function shou(){
    if(date.isFirstPage==false){
        pageIndex=date.firstPage;
        fenye()
    }

}

function wei(){
    if(date.isLastPage==false){
        pageIndex=date.pages;
        fenye()
    }
}

function shang(){
    if(date.hasPreviousPage){
        pageIndex=date.prePage;
        fenye()
    }

}
function xia(){
    if(date.hasNextPage){
        pageIndex=date.endRow;
        fenye()
    }
}