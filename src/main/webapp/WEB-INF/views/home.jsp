<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<%@ include file="include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini layout-boxed">

<div class="wrapper">

    <!-- Main Header -->
    <%@ include file="include/main_header.jsp"%>

    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                반갑습니다!
            </h1>
            <ol class="breadcrumb">
                <li><a href="${path}/"><i class="fa fa-dashboard"></i> home</a></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
        	<h2>공지사항</h2>
        	<p>2021.03.09 - 메인페이지 최근글 보기 & 개인정보수정기능 추가</p>
        	<p>2021.03.02 - 글보기 오류 개선</p>
            <p>2021.02.24 - 회원가입 페이지 오타 수정 및 도메인 작업 </p>
			<p>2021.02.20 - 홈페이지 오픈 </p>
        </section>
        <!-- Latest Articles -->
        <section class="content container-fluid">
        	<h2>최근게시물</h2>
        	<p>${test}</p>
        	<table>
        	<c:forEach items="${latestArticles}" var="article">
        		<tr>
        			<td colspan="2">
        				<a href="${path}/article/read?articleNo=${article.articleNo}">
        					${article.title}
        				</a>
        			</td>
        			<td>&nbsp;</td>
        			<td>
        				<fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd a HH:mm" />
        			</td>
        		</tr>
        	</c:forEach>
        	</table>
        </section>
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@ include file="include/main_footer.jsp"%>

</div>
<!-- ./wrapper -->

<%@ include file="include/plugin_js.jsp"%>

</body>

</html>