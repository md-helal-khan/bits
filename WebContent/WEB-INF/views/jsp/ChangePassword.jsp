<%-- 
    Document   : Home
    Created on : Nov 5, 2018, 09:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/authentication.css" type="text/css">
<div class="page">
	<div class="container" onload='document.f.username.focus();'>
		<div class="row main">
			<!-- user-login -->
			<div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
				<div class="user-account">
					<h2 class="center">পাসওয়ার্ড পরিবর্তন করুন</h2>
					<c:if test="${status=='success'}">
						<div class="alert alert-success center">
						    <strong>অভিনন্দন: </strong>আপনার ইমেইল এ গিয়ে পাসওয়ার্ড রিসেট করুন
						</div>
					</c:if>
					<c:if test="${status=='error'}">
						<div class="alert alert-error center">
						    <strong>দুঃখিত: </strong>সার্ভার এর সমস্যার কারনে পাসওয়ার্ড পুনরায় সেট করা যাচ্ছে না, একটু পরে আবার চেষ্টা করুন
						</div>
					</c:if>
					<!-- form -->
					<form action="${pageContext.request.contextPath}/change-password" method="POST" id="changePassword">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<label for="pwd">পুরনো পাসওয়ার্ড</label>
									<div class="inner-addon left-addon">
										<i class="fas fa-key auth-icon"></i>
										<input type="password" name="a" id="a" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="pwd">নতুন পাসওয়ার্ড</label>
									<div class="inner-addon left-addon">
										<i class="fas fa-lock auth-icon"></i>
										<input type="password" name="b" id="b" class="form-control"/>
									</div>
								</div>
								<div class="form-group">
									<label for="pwd">নতুন পাসওয়ার্ড নিশ্চিত করুন</label>
									<div class="inner-addon left-addon">
										<i class="fas fa-lock auth-icon"></i>
										<input type="password" name="c" id="c" class="form-control"/>
									</div>
								</div>
							</div>
						</div>
						<div class="row center">
							<div class="col-xs-12 col-sm-12 col-md-6">
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">পরিবর্তন করুন </button>
								</div>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>
			<!-- user-login -->
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>