<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>My Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			var nationSelector = $("#nation-selector");
			var leagueSelector = $("#league-selector");
			
			nationSelector.on("change", function() {
				leagueSelector.empty();
				leagueSelector.append("<option value='' selected='selected'>선택</option>");
				
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if(xhr.readyState == 4 && xhr.status == 200) {
						var leagueList = JSON.parse(xhr.responseText);
						
						for(var i=0;i<leagueList.length;i++) {
							leagueSelector.append("<option value=" + leagueList[i].no + ">" + leagueList[i].name + "</option>");
						}
						
					}
				}
				
				xhr.open("GET", "nation.find?nation=" + nationSelector.val());
				xhr.send(null);
			});
			
			$("#round-input").on("change", function() {
				if($("#round-input").val() > 38) {
					alert("옳지 않은 라운드 값입니다.");
					$("#round-input").val("");
				}
			});
			
			leagueSelector.on("change", function() {
				var homeTeam = $("#hometeam-selector");
				var awayTeam = $("#awayteam-selector");
				
				homeTeam.empty();
				awayTeam.empty();
				homeTeam.append("<option value='' selected='selected'>선택</option>");
				awayTeam.append("<option value='' selected='selected'>선택</option>");
				
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if(xhr.readyState == 4 && xhr.status == 200) {
						var teamList = JSON.parse(xhr.responseText);
						
						for(var i=0;i<teamList.length;i++) {
							homeTeam.append("<option value=" + teamList[i].no + ">" + teamList[i].name + "</option>");
							awayTeam.append("<option value=" + teamList[i].no + ">" + teamList[i].name + "</option>");
						}
						
					}
				}
				
				xhr.open("GET", "team.find?league=" + leagueSelector.val());
				xhr.send(null);
			});
		});
	</script>
</head>
<body>
	<%@ include file="../common/navi.jsp" %>
	<div class="container">
		<div class="page-header">
			<h1>경기 입력</h1>
		</div>
			
		<div class="row">
			<form method="post" action="add.home" class="form-horizontal">
				<div class="row">
					<div class="form-group col-sm-5">
						<label class="control-label col-sm-3">대회 국가</label>
						<div class="col-sm-9">
							<select name="nation" class="form-control" id="nation-selector">
								<option value="" selected="selected">선택</option>
								<option value="1">England</option>
								<option value="2">Spain</option>
								<option value="3">Germany</option>
								<option value="4">Italy</option>
							</select>
						</div>
					</div>
					
					<div class="form-group col-sm-5 pull-right">
						<label class="control-label col-sm-3">대회명</label>
						<div class="col-sm-9">
							<select name="league" class="form-control" id="league-selector">
								<option value="" selected="selected">선택</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-sm-5">
						<label class="control-label col-sm-3">라운드</label>
						<div class="col-sm-9">
							<input type="number" name="round" class="form-control" max="38" id="round-input"/>
						</div>
					</div>
					
					<div class="form-group col-sm-5">
						<label class="control-label col-sm-3">날짜</label>
						<div class="col-sm-5">
							<input type="date" name="date" class="form-control"/>
						</div>
						<div class="col-sm-4">
							<input type="time" name="time" class="form-control"/>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-sm-5">
						<label class="control-label col-sm-3">HOME</label>
						<div class="col-sm-9">
							<select name="hometeam" class="form-control" id="hometeam-selector">
								<option value="" selected="selected">선택</option>
							</select>
						</div>
					</div>
					
					<div class="form-group col-sm-5">
						<label class="control-label col-sm-3">AWAY</label>
						<div class="col-sm-9">
							<select name="awayteam" class="form-control" id="awayteam-selector">
								<option value="" selected="selected">선택</option>
							</select>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-success pull-right">등록</button>
			</form>
		</div>
	</div>
</body>
</html>