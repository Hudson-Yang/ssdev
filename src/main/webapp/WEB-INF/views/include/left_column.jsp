<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<script>
	var a = ${login.userImg};
	alert(a);
</script>
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">

		<!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<c:if test="${empty login}">
				<div class="pull-left image">
					<img src="/dist/img/default-user.png" class="img-circle"
						alt="User Image">
				</div>
				<div class="pull-left info">
					<p>Guest</p>
					<%-- Status --%>
					<a href="#"><i class="fa fa-circle text-danger"></i> OFFLINE</a>
				</div>
			</c:if>
			<c:if test="${not empty login}">
				<div class="pull-left image">
					<img src="${login.userImg}" class="img-circle" alt="User Image">
				</div>
				<div class="pull-left info">
					<p>${login.userName}</p>
					<%-- Status --%>
					<a href="#"><i class="fa fa-circle text-success"></i> ONLINE</a>
				</div>
			</c:if>
		</div>

		<!-- Sidebar Menu -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">게시판</li>
			<li class="treeview"><a href="#"><i class="fa fa-edit"></i>
					<span>게시판</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="${path}/article/write"><i
							class="fa fa-pencil"></i> 게시글 쓰기</a></li>
					<li><a href="${path}/article/list"><i class="fa fa-list"></i>
							게시글 목록</a></li>
				</ul></li>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>