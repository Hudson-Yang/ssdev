<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
<%@ include file="../include/main_header.jsp"%>
<%@ include file="../include/left_column.jsp"%>
	<section class="content container-fluid">
		<div class="col-lg-12">
			<form role="form" id="writeForm" method="post"
				action="${path}/article/modify">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">게시글 작성</h3>
					</div>
					<div class="box-body">
						<input type="hidden" name="articleNo" value="${article.articleNo}">
						<input type="hidden" name="page" value="${criteria.page}">
						<input type="hidden" name="perPageNum" value="${criteria.perPageNum}">
						<input type="hidden" name="searchType" value="${criteria.searchType}"> 
						<input type="hidden" name="keyword" value="${criteria.keyword}">
						<div class="form-group">
							<label for="title">제목</label> <input class="form-control"
								id="title" name="title" placeholder="제목을 입력해주세요"
								value="${article.title}">
						</div>
						<div class="form-group">
							<label for="content">내용</label>
							<textarea class="form-control" id="content" name="content"
								rows="30" placeholder="내용을 입력해주세요" style="resize: none;">${article.content}</textarea>
						</div>
						<div class="form-group">
							<label for="writer">작성자</label> <input class="form-control"
								id="writer" name="writer" value="${article.writer}" readonly>
						</div>
					</div>
					<div class="box-footer">
						<button type="button" class="btn btn-primary">
							<i class="fa fa-list"></i> 목록
						</button>
						<div class="pull-right">
							<button type="button" class="btn btn-warning cancelBtn">
								<i class="fa fa-trash"></i> 취소
							</button>
							<button type="submit" class="btn btn-success modBtn">
								<i class="fa fa-save"></i> 수정 저장
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>
<%@ include file="../include/main_footer.jsp"%>
<%@ include file="../include/plugin_js.jsp"%>
	<script>
		$(document).ready(function() {

			var formObj = $("form[role='form']");
			console.log(formObj);

			$(".modBtn").on("click", function() {
				formObj.submit();
			});

			$(".cancelBtn").on("click", function() {
				history.go(-1);
			});

			$(".listBtn").on("click", function() {
				self.location = "/article/list?page=${criteria.page}"
								+ "&perPageNum=${criteria.perPageNum}"
								+ "&searchType=${criteria.searchType}"
								+ "&keyword=&{criteria.keyword}";
			});

		});
	</script>
</body>
</html>