<%-- 
    Document   : Home
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/authentication.css" type="text/css">
<div class="page">
	<div class="container">
		<div class="row main">
			<!-- user-login -->
			<div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
				<div class="user-account">
					<h2 class="center">ব্যবহারকারীর লগইন</h2>
					<c:if test="${verification}">
						<div class="alert alert-success center">
						    <strong>অভিনন্দন: </strong>আপনার নিবন্ধনটি সক্রিয় হয়েছে, এখন লগইন করুন
						</div>
					</c:if>
					<c:if test="${setNewPassword}">
						<div class="alert alert-success center">
						    <strong>অভিনন্দন: </strong>নতুন পাসওয়ার্ড সফলভাবে সেট হয়ে গেছে
						</div>
					</c:if>
					<!-- form -->
					<form action="${pageContext.request.contextPath}/login" method="POST" id="login" name='f'>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="inner-addon left-addon">
										<i class="fas fa-user-alt auth-icon"></i>
										<input type="text" name="username" id="username" class="form-control" placeholder="ব্যবহারকারীর নাম" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="inner-addon left-addon">
										<i class="fas fa-key auth-icon"></i> 
										<input type="password" name="password" id="password" class="form-control" placeholder="পাসওয়ার্ড" />
									</div>
								</div>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<div class="row center">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<div class="checkbox">
										<label for="logged" class="">
											<input type="checkbox" name="remember-me" id="logged"> লগইন করে রাখুন 
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-5 col-md-5 col-md-offset-1">
								<div class="form-group">
									<p class=""><a href="${pageContext.request.contextPath}/forgot-password">পাসওয়ার্ড ভুলে গেছেন ?</a></p>
								</div>
							</div>
						</div>
						<!-- Login error message -->
						<c:if test="${param.error != null}">
							<div class="row center">
								<div class="col-xs-12 col-sm-12 col-md-12">
									<div class="form-group">
										<span class="error">ব্যবহারকারীর নাম অথবা পাসওয়ার্ড ভুল দেয়া হয়েছে !</span>
									</div>
								</div>
							</div>
						</c:if>
						<div class="row center">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">লগ ইন </button>
								</div>
							</div>
						</div>
						<div class="row center">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<p class="goLogin">আপনি কি অনিবন্ধনকৃত ? 
										<a href="${pageContext.request.contextPath}/UserRegistration">নিবন্ধন করুন</a>
									</p>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- user-login -->
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>