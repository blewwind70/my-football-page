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
			var $nationSelector = $("#nation-selector");
			var $leagueSelector = $("#league-selector");
			
			$nationSelector.on("change", function() {
				$leagueSelector.empty();
				$leagueSelector.append("<option value='' selected>선택</option>");
				
				$.ajax({
					type:"GET",
					url:"nation.find",
					data:{nation:$nationSelector.val()},
					dataType:"json",
					success: function(result) {
						$(result).each(function() {
							$leagueSelector.append("<option value=" + this.no + ">" + this.name + "</option>"); 
						});
					}, 
					error: function() {
						console.log("league fail");	
					}
				});
			});
			
			$("#round-input").on("change", function() {
				if($(this).val() > 38 || $(this).val() <= 0) {
					alert("옳지 않은 라운드 값입니다.");
					$(this).val("");
				}
			});
			
			$leagueSelector.on("change", function() {
				var $homeTeam = $(".hometeam-selector");
				var $awayTeam = $(".awayteam-selector");
				
				$homeTeam.empty().append("<option value='' selected>선택</option>");
				$awayTeam.empty().append("<option value='' selected>선택</option>");
				
				$.ajax({
					type:"GET",
					url:"team.find",
					data:{league:$leagueSelector.val()},
					dataType:"json",
					success: function(result) {
						$(result).each(function() {
							$homeTeam.append("<option value=" + this.no + ">" + this.name + "</option>")
							$awayTeam.append("<option value=" + this.no + ">" + this.name + "</option>")
						});
					},
					error: function() {
						console.log("team fail");
					}
	
				});
			});
			
			$("#team-table span#btn-add").on("click", function() {
				$("#team-table tbody").append($("#team-table tbody tr:first").clone().show());
			});
			
			$("#team-table").on("click", "span.btn-delete", function() {
				$(this).parents("tr").remove();
			});
			
			$("#match-form").on("submit", function(event) {
				var hometeamNo = "";
				$(".hometeam-selector:not(:first)").each(function() {
					hometeamNo += $(this).val() + ",";
				});
				$(":input[name=hometeam]").val(hometeamNo);
				
				var awayteamNo = "";
				$(".awayteam-selector:not(:first)").each(function() {
					awayteamNo += $(this).val() + ",";
				});
				$(":input[name=awayteam]").val(awayteamNo);
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
			<form method="post" action="add.home" class="form-horizontal" id="match-form">
				<div class="row">
					<div class="form-group col-sm-5">
						<label class="control-label col-sm-3">대회 국가</label>
						<div class="col-sm-9">
							<select name="nation" class="form-control" id="nation-selector">
								<option value="" selected="selected">선택</option>
								<option value="1">World</option>
								<option value="2">Euro</option>
								<option value="3">England</option>
								<option value="4">Spain</option>
								<option value="5">Germany</option>
								<option value="6">Italy</option>
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
							<input type="number" name="round" class="form-control" min="0" max="38" id="round-input"/>
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
					<table class="table table-condensed table-striped" id="team-table">
						<colgroup>
							<col width="5%">							
							<col width="45%">							
							<col width="45%">							
							<col width="5%">							
						</colgroup>
						<thead>
							<tr>
								<th><span class="glyphicon glyphicon-plus-sign btn" id="btn-add"></span></th><th>Home</th><th>Away</th><th></th>
							</tr>
						</thead>
						<tbody>
							<tr style="display:none;">
								<td></td>
								<td>
									<select class="form-control hometeam-selector">
										<option value="" selected>선택</option>
									</select>
								</td>
								<td>
									<select class="form-control awayteam-selector">
										<option value="" selected>선택</option>
									</select>
								</td>
								<td><span class="glyphicon glyphicon-minus-sign btn btn-delete"></span></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<select class="form-control hometeam-selector">
										<option value="" selected>선택</option>
									</select>
								</td>
								<td>
									<select class="form-control awayteam-selector">
										<option value="" selected>선택</option>
									</select>
								</td>
								<td><span class="glyphicon glyphicon-minus-sign btn btn-delete"></span></td>
							</tr>
						</tbody>
					</table>
				</div>
				<input type="hidden" name="hometeam" />
				<input type="hidden" name="awayteam" />
				<button type="submit" class="btn btn-success pull-right">등록</button>
			</form>
		</div>
	</div>
</body>
</html>