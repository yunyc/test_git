<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <title>수강신청 홈페이지</title>
        <link href="/lms/resources/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">회원 가입</h3></div>
                                    <div class="card-body">
                                        <form:form modelAttribute="vPersonalInfo" action="/lms/personal_info">
                                            <div class="form-group">
                                            	<label class="small mb-1" for="id">아이디(5자리 이상)</label>
                                            	<input name="userId" class="form-control py-4" id="id" type="text" placeholder="아이디" value="${vPersonalInfo.id}" />
                                            </div>
                                            <div class="form-row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                    <label class="small mb-1" for="password">비밀번호(8자리 이상)</label>
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
                                            <input name="name" class="form-control py-4" id="name" type="text" placeholder="닉네임" value="${vPersonalInfo.name}"/></div>
                                            <div class="form-group">
                                            <label class="small mb-1" for="phone">전화번호</label>
                                            <input name="phone" class="form-control py-4" id="phone" type="tel"  placeholder="전화번호" value="${vPersonalInfo.phone}" /></div>
                                            
                                            <div class="form-group mt-4 mb-0"><button type="submit" class="btn btn-primary btn-block">회원 가입</button></div>
                                        </form:form>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
    </body>
</html>
