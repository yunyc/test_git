<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />

<title>수강신청 홈페이지</title>
<link href="/lms/resources/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- 반복 -->
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand" href="index.html">명지대학교 수강신청</a>
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="userDropdown" href="#"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user fa-fw"></i>
					${login.name}님 환영합니다
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="/lms/personal_update">개인정보 수정</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/lms/logout">로그아웃</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/lms/quit">탈퇴하기</a>
				</div></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">메인</div>
						<a class="nav-link" href="/lms/sugangsincheong">수강신청</a>

						<div class="sb-sidenav-menu-heading">강좌목록</div>
						<a class="nav-link" href="/lms/sincheong?fileName=miridamgi">미리담기된 강좌</a> 
						<a class="nav-link" href="/lms/sincheong?fileName=sincheong">수강신청된 강좌</a>

						<div class="sb-sidenav-menu-heading">기타</div>
						<a class="nav-link" href="/lms/board">건의사항</a>
					</div>
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
			<div class="container-fluid">
				<div class="card mb-4" style="margin-top:20px">
					<div class="card-header">
						<c:choose>
							<c:when test="${param.fileName eq 'miridamgi'}">
							미리 담기된 강좌
							</c:when>
							<c:otherwise>
							수강 신청된 강좌
							</c:otherwise>
						</c:choose>
						
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
								<div class="row">
									<div class="col-sm-12">
										<table class="table table-bordered dataTable" id="dataTable" width="100%" cellspacing="0" role="grid" style="width: 100%;">
											<thead>
												<tr role="row">
													<th  style="width: 6%;">번호</th>
													<th  style="width: 25%;">강좌명</th>
													<th  style="width: 6%;">학점</th>
													<th  style="width: 12%;">시간</th>
													<th  style="width: 12%;">교수명</th>
													<th style="width: 6%;">신청</th>
													<th style="width: 5%;"></th>
												</tr>
											</thead>
											<tbody id="gangjwa">
											<c:forEach items="${gangjwaList}" var="list">
											<tr role="row">
													<td>${list.id}</td>
													<td>${list.gangjwaName}</td>
													<td>${list.hakjeom}</td>
													<td>${list.time}</td>
													<td>${list.gyosuName}</td>
													<td>${list.sincheong}</td>
													<td><a href="/lms/sincheong/delete?id=${list.id}&fileName=${list.fileName}">삭제</a></td>
												</tr>
											</c:forEach>
												<!--  
												<tr role="row" class="odd">
													<td class="sorting_1">1421</td>
													<td>건축고고학실습</td>
													<td>3</td>
													<td>목0900-1150</td>
													<td>최종규</td>
													<td>0</td>
													<td>담기</td>
													<td>신청</td>
												</tr>
												-->
												
											</tbody>
										</table>
									</div>
								</div>
				</div>

			</div>
			</main>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<script src="/lms/resources/js/scripts.js"></script>

	
</body>
</html>
