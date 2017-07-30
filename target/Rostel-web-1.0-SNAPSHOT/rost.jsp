<%--
  Created by IntelliJ IDEA.
  User: jz36
  Date: 29.07.17
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<h1>Hello! Hi!</h1>
    <div id="search">
        <input name="name" placeholder="Имя">
        <input name="second_name" placeholder="Фамилия">
        <input name="third_name" placeholder="Отчество">
        <input name="cityname" placeholder="Город">
        <input name="mark" placeholder="Марка машины">
        <input name="model" placeholder="Модель">
        <input name="gov_number" placeholder="Номер">
        <input name="gov_number2" placeholder="Регион">
        <button id="getHuman">Найти</button>
    </div>
    <div id="result">
        <div id="resultDiv"></div>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
    $('#getHuman').click(function (e) {
        document.getElementById('resultDiv').parentNode.removeChild(document.getElementById('resultDiv'));
        var ready = false;
        $('input').each(function () {
            if($(this).val().length != 0){
                ready = true;
            }
        })
        if (ready){
            dataString = '';
            $('input').each(function () {
                dataString += $(this)[0].name + '=' + $(this).val() + '&';
            })
            $.post(
                "FindHuman",
                dataString,
                function (answer) {
                    $('#result').append("<div id='resultDiv'>");
                    answerArray = answer.split(';');
                    for(i=0; i < answerArray.length; i++){
                        $('#resultDiv').append("<p>" + answerArray[i] + "</p>");
                    }
                    $('#result').append("</div>");
                }
            )
        }
        else{
            $('#result').append("<div id='resultDiv'>Необходимо заполнить хотя бы одно поле!</div>");
        }
    })
})
    </script>
</body>
</html>
