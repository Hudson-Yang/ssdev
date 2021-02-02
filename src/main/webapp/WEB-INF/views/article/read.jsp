<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Read</title>
</head>
<body>
<%@ include file="../include/main_header.jsp"%>
<%@ include file="../include/left_column.jsp"%>
	<section class="content container-fluid">
		<div class="col-lg-12">
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">글제목 : ${article.title}</h3>
				</div>
				<div class="box-body" style="height: 700px">
					${article.content}</div>
				<div class="box-footer">
					<div class="user-block">
						<img class="img-circle img-bordered-sm"
							src="/dist/img/user1-128x128.jpg" alt="user image"> <span
							class="username"> <a href="#">${article.writer}</a>
						</span> <span class="description"><fmt:formatDate
								pattern="yyyy-MM-dd a HH:mm" value="${article.regDate}" /></span>
					</div>
				</div>
				<div class="box-footer">
					<form role="form" method="post">
						<input type="hidden" name="articleNo" value="${article.articleNo}">
						<input type="hidden" name="page" value="${criteria.page}">
						<input type="hidden" name="perPageNum" value="${criteria.perPageNum}">
					</form>
					<button type="submit" class="btn btn-primary listBtn">
						<i class="fa fa-list"></i> 목록
					</button>
					<c:if test="${login.userId == article.writer}">
					<div class="pull-right">
						<button type="submit" class="btn btn-warning modBtn">
							<i class="fa fa-edit"></i> 수정
						</button>
						<button type="submit" class="btn btn-danger delBtn">
							<i class="fa fa-trash"></i> 삭제
						</button>
					</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
<%@ include file="../include/main_footer.jsp"%>
<%@ include file="../include/plugin_js.jsp"%>
	<script>
		$(document).ready(function() {

			var formObj = $("form[role='form']");
			console.log(formObj);

			$(".modBtn").on("click", function() {
				formObj.attr("action", "/article/modify");
				formObj.attr("method", "get");
				formObj.submit();
			});

			$(".delBtn").on("click", function() {
				formObj.attr("action", "/article/remove");
				formObj.submit();
			});

			$(".listBtn").on("click", function() {
				formObj.attr("action", "/article/list");
				formObj.attr("method", "get");
				formObj.submit();
			});

		});
	</script>
</body>
</html>