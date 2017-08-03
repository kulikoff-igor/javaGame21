<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Игра в XXI очко</title>
    <link rel="shortcut icon" href="icon.png">
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/jumbotron-narrow.css" rel="stylesheet">
    <script src="js/jquery-3.1.0.min.js"></script>
    <script>

        $(document).ready(function () {
            $("#startGame").click(function () {
                $("#summa").html(" ");
                $("#kartySopernika").html(" ");
                $("#kolich").html(36);
                document.getElementById("divSummaSopernika").style.display = 'none';
                document.getElementById("winnerIgrok").style.display = 'none';
                document.getElementById("winnerSopernik").style.display = 'none';
                document.getElementById("loserIgrok").style.display = 'none';
                document.getElementById("loserSopernik").style.display = 'none';
                document.getElementById("startGame").style.display = 'none';
                document.getElementById("vzatKartu").style.display = '';
                document.getElementById("xvatit").style.display = '';

                $.post("GamesStartController", function (dataGame) {
                    game = JSON.parse(dataGame);
                    kartyIgroka(game.plauer1CardList);
                    dataOutput();
                    $("#kartySopernika").html("<img src='koloda.gif' class='img-rounded imgCard'> <img src='koloda.gif' class='img-rounded imgCard'>");
                });
            });
            $("#vzatKartu").click(function () {
                $.post("ControllerTakingNewCard", function (dataGame) {
                    game = JSON.parse(dataGame);
                    kartyIgroka(game.plauer1CardList);
                    dataOutput();
                });
            });
            $("#xvatit").click(function () {
                $.post("GameEndController", function (dataGame) {
                    game = JSON.parse(dataGame);
                    document.getElementById("divSummaSopernika").style.display = '';
                    $("#summaSopernika").html(game.plauer2CardCount);
                    kartyIgroka(game.plauer1CardList);
                    kartySopernika(game.plauer2CardList);
                    document.getElementById("startGame").style.display = '';
                    document.getElementById("vzatKartu").style.display = 'none';
                    document.getElementById("xvatit").style.display = 'none';
                    if(game.winner=="player1"){
                        document.getElementById("loserSopernik").style.display = '';
                        document.getElementById("winnerIgrok").style.display = '';
                    }
                    if(game.winner=="player2"){
                        document.getElementById("winnerSopernik").style.display = '';
                        document.getElementById("loserIgrok").style.display = '';
                    }
                    if(game.winner=="draw"){
                        document.getElementById("loserSopernik").style.display = '';
                        document.getElementById("loserIgrok").style.display = '';
                    }
                    dataOutput();
                });
            });
        });
        function dataOutput() {
            $("#kolich").html(" ");
            $("#kolich").html(36 - game.plauer1CardList.length - game.plauer2CardList);

            $("#summa").html(" ");
            $("#summa").html(game.plauer1CardCount);
        }
        function kartySopernika(plauer2CardList) {
            var createDiv = "";
            for (i = 0; i < plauer2CardList.length; i++) {
                createDiv += createsStringKartyIgroka(plauer2CardList, i)
            }
            $("#kartySopernika").html(" ");
            $("#kartySopernika").html(createDiv);
        }
        function kartyIgroka(plauer1CardList) {
            var createDiv = "";
            for (i = 0; i < plauer1CardList.length; i++) {
                createDiv += createsStringKartyIgroka(plauer1CardList, i)
                console.log(plauer1CardList[i]);
            }
            $("#kartyIgroka").html(" ");
            $("#kartyIgroka").html(createDiv);
        }
        function createsStringKartyIgroka(plauer1CardList, i) {

            var Div = "";
            Div = "<img src=" +
                    plauer1CardList[i] + " class='img-rounded imgCard'>";
            return Div;
        }
    </script>

</head>

<body>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li><a href="developer.jsp">О Разработчике</a></li>
        </ul>
        <h4 class="text-muted">Игра в XXI очко</h4>
    </div>

    <div class="jumbotron">
        <div class="row" style="margin-top: -4%">
            <div class="col-md-2" id="winnerSopernik" style="display: none">
                <img src="Winner.png" class="img-rounded" style="width: 80%; padding-top: 10%">
            </div>
            <div class="col-md-2" id="loserSopernik" style="display: none">
                <img src="loser.png" class="img-rounded" style="width: 90%; padding-top: 10%">
            </div>
            <div class="col-md-10" id="kartySopernika">

            </div>
        </div>
        <div class="row" style="margin-bottom: -6%; display: none " id="divSummaSopernika">
            <div class="col-md-12">
                Общая сумма карт соперника :
                <summa id="summaSopernika"></summa>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 col-md-offset-4" style="padding-top: 10%">
                <p>
                    <button class="btn btn-success btn-lg" type="button" id="startGame">НАЧАТЬ ИГРУ</button>
                    <button class="btn btn-success " type="button" id="vzatKartu" style="display: none">Взять Карту
                    </button>
                    <button class="btn btn-warning" type="button" id="xvatit" style="display: none">Хватит</button>

                </p>
            </div>

            <div class="col-md-3 col-md-offset-1" style="padding-top: 2%; padding-bottom: 2% ; margin-left: 4%">
                <img src="koloda.gif" class="img-rounded" style="width: 60%">
            </div>

        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-8" style="padding-top: 2%; padding-bottom: 2%">
                <p>Карт в колоде :
                    <kolich id="kolich">36</kolich>
                </p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-2" id="winnerIgrok" style="display: none">
                <img src="Winner.png" class="img-rounded" style="width: 80%; padding-top: 10%">
            </div>
            <div class="col-md-2" id="loserIgrok" style="display: none">
                <img src="loser.png" class="img-rounded" style="width: 90%; padding-top: 10%">
            </div>
            <div class="col-md-10" id="kartyIgroka">

            </div>
        </div>

        <div class="row" style="margin-bottom: -6%">
            <div class="col-md-12">
                Общая сумма карт :
                <summa id="summa">0</summa>
            </div>
        </div>

    </div>


    <div class="footer">
        <p>© Азартные Игры 2016</p>
    </div>

</div>

</body>
</html>