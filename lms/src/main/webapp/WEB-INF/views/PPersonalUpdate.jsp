<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>수강신청 홈페이지</title>
<link href="/lms/resources/css/styles.css" rel="stylesheet" />
<link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- 반복 -->
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<a class="navbar-brand" href="index.html">명지대학교 수강신청</a>
		
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" id="userDropdown" href="#"
				role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
				<i class="fas fa-user fa-fw"></i>
					${login.name}님 환영합니다
			</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="/lms/personal_info">개인정보 수정</a>
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
					<div class="card-header">개인정보</div>
					<div class="card-body">
						<form:form modelAttribute="vPersonalInfo" action="/lms/personal_update">
						<input name="id" type="hidden" value="${vPersonalInfo.id}"/>
                                            <div class="form-group">
                                            	<label class="small mb-1" for="id">아이디(5자리 이상)</label>
                                            	<input name="userId" class="form-control py-4" id="userId" type="text" placeholder="아이디" value="${vPersonalInfo.userId}" />
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                    <label class="small mb-1" for="password">비밀번호(영문/숫자 포함, 8자리 이상)</label>
                                                    <input name="password" class="form-control py-4" id="password" type="text" placeholder="비밀번호" value="${vPersonalInfo.password}"/></div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                    <label class="small mb-1" for="passwordConfirm">비밀번호 확인</label>
                                                    <input name="confirm" class="form-control py-4" id="passwordConfirm" type="text" placeholder="비밀번호 확인" value="${vPersonalInfo.password}" /></div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                            <label class="small mb-1" for="name">닉네임</label>
                                            <input name="name" id="name" class="form-control py-4" type="text" placeholder="닉네임" value="${vPersonalInfo.name}"/></div>
                                            <div class="form-group">
                                            <label class="small mb-1" for="phone">전화번호</label>
                                            <input name="phone" class="form-control py-4" id="phone" type="text" placeholder="전화번호" value="${vPersonalInfo.phone}" /></div>
                                            
                                            <div class="form-group mt-4 mb-0"><button type="submit" class="btn btn-primary btn-block">수정</button></div>
                                        </form:form>
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
