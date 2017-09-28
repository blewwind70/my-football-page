<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Insert Your Title</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(function() {
  		var $rankTableTr = $("#rank-table tbody tr");
  		
  		$rankTableTr.each(function() {
  			var win = parseInt($(this).find("td.win-td").text());
  			var draw = parseInt($(this).find("td.draw-td").text());
  			var lose = parseInt($(this).find("td.lose-td").text());
  			
  			$(this).find("td.round-td").text(win + draw + lose);
  			$(this).find("td.points-td").text(win * 3 + draw);
  			
  			var gf = parseInt($(this).find("td.gf-td").text());
  			var ga = parseInt($(this).find("td.ga-td").text());
  			
  			$(this).find("td.gd-td").text(gf - ga);
  		});
  		
  		$rankTableTr.find("td.points-td").sort(function(a,b) {
  			return a-b;
  		});
  	});
  </script>
</head>
<body>
	<%@ include file="../common/navi.jsp" %>
	<div class="container">
		<div class="page-header">
			<h1>경기 조회</h1>
		</div>
		
		<div class="col-sm-2">
			<%@ include file="left-menu.jsp" %>
		</div>
		
		<div class="col-sm-10">
			<div class="row">
				<table class="table table-hover" id="rank-table">
					<thead>
						<tr>
							<th>Position</th><th>Team</th><th>Round</th>
							<th>W</th><th>D</th><th>L</th>
							<th>GF</th><th>GA</th><th>GD</th>
							<th>Points</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="forTeam" items="${teamRank }">
						<tr>
							<td class="position-td"></td>
							<td>${forTeam.name }</td>
							<td class="round-td"></td>
							<td class="win-td">${forTeam.win }</td>
							<td class="draw-td">${forTeam.draw }</td>
							<td class="lose-td">${forTeam.lose }</td>
							<td class="gf-td">${forTeam.gf }</td>
							<td class="ga-td">${forTeam.ga }</td>
							<td class="gd-td"></td>
							<td class="points-td"></td>
						</tr>					
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>