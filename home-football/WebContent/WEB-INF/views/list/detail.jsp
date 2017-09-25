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
			$("#btn-updateform").on("click", function() {
				$("#update-form").css("display", "");
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
	            <div class="panel panel-info">
	                <div class="panel-heading text-center">
	                    <h3>
	                    	${matchTeam.homeTeam.name }
	                    	<span>${matchTeam.homeScore } - ${matchTeam.awayScore }</span>
	                    	${matchTeam.awayTeam.name }
	                    	<button class="btn btn-xs" id="btn-updateform">점수 수정</button>
	                    </h3>
	                </div>
	                <div class="panel-body">
	                	<form method="post" action="update.home" style="display:none;" id="update-form">
	                		<div class="row pull-right">
	                			<div class="form-group">
			                		<input type="hidden" name="mno" value="${matchTeam.no }"/>
			                		<div class="col-sm-2">
				                		<input type="number" name="homescore" value="${matchTeam.homeScore }" class="form-control"/>
			                		</div>
			                		<div class="col-sm-1">
				                		<label class="control-label"> - </label>
			                		</div>
			                		<div class="col-sm-2">
				                		<input type="number" name="awayscore" value="${matchTeam.awayScore }" class="form-control"/>
			                		</div>
			                		<button class="btn btn-success btn-xm">수정</button>
	                			</div>
	                		</div>
	                	</form>
	                    <table class="table table-hover">
	                        <colgroup>
	                            <col width="15%">
	                            <col width="35%">
	                            <col width="15%">
	                            <col width="35%">
	                        </colgroup>
	                        <tbody>
	                        	<tr>
	                            </tr>                        
	                        </tbody>
	                    </table>
	                </div>
	            </div>
		    </div>
		</div>
	</div>
</body>
</html>