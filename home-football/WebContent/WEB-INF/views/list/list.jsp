<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Match</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("#match-date").on("change", function() {
				$("#date-form").submit();
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
	            <form method="get" action="list.home" class="form-horizontal" id="date-form">
	                <div class="form-group">
	                    <label class="label-control sr-only">날짜 :</label>
	                    <div class="col-md-offset-3 col-md-6">
	                        <input type="date" name="matchdate" value="${matchdate }" class="form-control" id="match-date"/>
	                    </div>
	                </div>
	            </form> 
		    </div>
		    <div class="row">
	            <div class="panel panel-primary">
	                <div class="panel-heading">
	                    <label>EPL</label>
	                </div>
	                <div class="panel-body">
	                    <table class="table table-hover">
	                        <colgroup>
	                            <col width="15%">
	                            <col width="35%">
	                            <col width="15%">
	                            <col width="35%">
	                        </colgroup>
	                        <tbody>
	                        <c:forEach var="forMatch" items="${matchList }">
	                        	<tr>
		                            <td>${forMatch.result }</td>
		                            <td>${forMatch.hometeam.name }</td>
		                            <td>
		                            <c:if test="${forMatch.homeScore ne null }">
		                            	<a href="detail.home?mno=${forMatch.no }">${forMatch.homeScore } - ${forMatch.awayScore }</a>
		                            </c:if>
		                            </td>
		                            <td class="text-right">${forMatch.awayteam.name }</td>
	                            </tr>                        
	                        </c:forEach>
	                        </tbody>
	                    </table>
	                </div>
	            </div>
		    </div>
		</div>
	</div>
</body>
</html>