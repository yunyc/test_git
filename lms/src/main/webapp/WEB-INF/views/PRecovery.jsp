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
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">아이디/비밀번호 찾기</h3></div>
                                    <div class="card-body">
                                        <div class="small mb-3 text-muted">회원 가입시 입력했던 전화번호를 입력하세요.</div>
                                        <form:form>
                                            <div class="form-group">
                                            <label class="small mb-1" for="phone">전화번호</label>
                                            <input name="phone" class="form-control py-4" id="phone" type="text" placeholder="전화번호" />
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                            <a class="small" href="/lms/login">로그인 화면으로 돌아가기</a>
                                            <button type="submit" class="btn btn-primary">아이디/비밀번호 찾기</button>
                                            </div>
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
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/lms/resource/js/scripts.js"></script>
    </body>
</html>
