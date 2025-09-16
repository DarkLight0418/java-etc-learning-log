const data = {
    "name" : $("#na").val(),  // getVal
    "addr" : $("#ad").val()
}

$.ajax({
    url: "/rest-addr/create2",
    type: "post",
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    data: JSON.stringify(data),  // JSON String으로 변환하는 것
    success: function(data) {
        console.log("data : " + data);
        alert("성공!");
    },
    error: function(error) {
        console.log("error : " + error);
        alert("실패ㅜㅜ");
    }
});

$(function() {
    $("#na").focus();
    $("#btn").on("click", function(){

        let jsObj = {name: $("#na").val(), addr:$("#ad").val()};
        let jsonData = JSON.stringify(jsObj);

        $.ajax({
            url: "create2.json",
            type: "post",
            contentType: "application/json;charset=utf-8",
            data: jsonData,
            success: function() {
                alert("성공");
            },
            error: function() {
                alert("실패");
            }
        })
    })
})