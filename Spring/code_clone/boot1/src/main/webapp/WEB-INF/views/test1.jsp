<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8"/>
        <title>Ajax Test01</title>
        <script type="text/javascript">
             src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
        </script>
        <script>
            $(function() {
                $("#seq").on("keyup", function(){
                    $.ajax({
                        url: "../ajax1/search1.do",
                        type: "GET",
                        data: {seq : $("#seq".val()},  // getval()??
                        success: function(data) {
                            var html = "";
                            html += "<form id='ajax'>";
                            html += "번호 <input name='seq' value='"+data.seq+"'>";
                            html += "이름 <input name='name' value='"+data.name+"'>";
                            html += "주소 <input name='addr' value='"+data.addr+"'>";
                            html += "날짜 <input name='rdate' value='"+data.rdate+"'>";
                            html += "</form>"

                            $("#name").val("");
                            $("#container").html(html);
                        },
                        error: function (data) {
                            $("container").html("존재하지 않는 seq");
                        }
                    });
                });

                $("#btnName").on("click", function() {
                    $.ajax({
                        url: "../ajax1/search2.do",
                        type: "POST",
                        data: {name: $("#name").val()},
                        success: function(data) {
                            var html = "";
                            html += "<table border='1' width='50%'>";
                            html += "<tr>";
                            html += "<th>번호</th>";
                            html += "<th>이름</th>";
                            html += "<th>주소</th>";
                            html += "<th>날짜</th>";
                            html += "</tr>";

                            if(data.length == 0) {
                                html += "<tr>";
                                html += "<td colspan='4' align='center'>그런 이름을 가진 멤버는 없음</td>";
                                html += "</tr>";
                            } else {
                                for(let address of data) {
                                    html += "<tr>";
                                    html += "<td align='center'>"+address.seq+"</td>";
                                    html += "<td align='center'>"+address.name+"</td>";
                                    html += "<td align='center'>"+address.addr+"</td>";
                                    html += "<td align='center'>"+address.rdate+"</td>";
                                    html += "</tr>";
                                }
                            }
                            html += "</table>"

                            $("#seq").val("");
                            $("#container").html(html);
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <h2>(방법1) response객체에 JSON문자열 담기</h2>
	    
	    번호: <input type="text" name="seq" id="seq"/>
	    <input type="button" value="번호 검색" id="btnSeq"/>
	    <br/>
	    
	    이름: <input type="text" name="name" id="name"/>
	    <input type="button" value="이름 검색" id="btnName"/>
	 
        <br/><br/>
		<div id="container"></div>
		<br/><br/>
		
		<a href="../">인덱스</a><br/><br/>
    </body>
</html>