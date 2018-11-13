<%-- 
    Document   : Home
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/style/authentication.css" type="text/css">
<div class="page">
	<div class="container">
		<div class="row main">
			<!-- user-login -->
			<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
				<div class="user-account">
					<h2 class="center">ব্যবহারকারীর নিবন্ধন</h2>
					<!-- Registration success message -->
					<c:if test="${reg}">
						<div class="alert alert-success center">
						    <strong>অভিনন্দন: </strong>আপনার নিবন্ধন সফলভাবে সম্পন্ন হয়েছে, আপনার ইমেইল এ গিয়ে সক্রিয় করুন
						</div>
					</c:if>
					<c:if test="${reg==false}">
						<div class="alert alert-danger center">
						    <strong>দুঃখিত: </strong>সার্ভার  জনিত সমস্যার কারনে আপনার নিবন্ধন অসম্পূন্ন হয়েছে, একটু পরে আবার চেষ্টা করুন
						</div>
					</c:if>
					<input type="hidden" value="${pageContext.request.contextPath}/checkUsername" name="url-check-username">
					<input type="hidden" value="${pageContext.request.contextPath}/checkEmail" name="url-check-email">
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="find-job">
							<form:form action="${pageContext.request.contextPath}/UserRegistration" method="POST" id="userRegistration" commandName="user">
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-user-alt auth-icon"></i>
										      <form:input type="text" path="userProfile.firstNameEng" name="userProfile.firstNameEng" id="firstNameEng" class="form-control" placeholder="নামের প্রথম অংশ" />
										      <form:errors path="userProfile.firstNameEng" cssClass="error" />
										    </div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-user-alt auth-icon"></i>
										      <form:input type="text" path="userProfile.lastNameEng" name="userProfile.lastNameEng" id="lastNameEng" class="form-control" placeholder="নামের শেষাংশ" />
										      <form:errors path="userProfile.lastNameEng" cssClass="error" />
										    </div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-12">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-user-circle auth-icon"></i>
										      <form:input type="text" path="username" name="username" id="username" class="form-control" placeholder="ব্যবহারকারীর নাম" />
										      <form:errors path="username" cssClass="error" />
										    </div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-key auth-icon"></i>
										      <form:input type="password" path="password" name="password" id="password" class="form-control" placeholder="পাসওয়ার্ড" />
										      <form:errors path="password" cssClass="error" />
										    </div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-key auth-icon"></i>
										      <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="পাসওয়ার্ড নিশ্চিত করুন" />
										    </div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-envelope auth-icon"></i>
										      <form:input type="text" path="email" name="email" id="email" class="form-control" placeholder="ইমেইল" />
										      <form:errors path="email" cssClass="error" />
										    </div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-phone auth-icon"></i>
										      <form:input type="text" path="phone" name="phone" id="phone" class="form-control" placeholder="মোবাইল নম্বর" />
										      <form:errors path="phone" cssClass="error" />
										    </div>
										</div>
									</div>
								</div>
								<div class="row center">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
										<p class="goLogin">আপনি কি ইতিমধ্যে নিবন্ধনকৃত ? <a href="${pageContext.request.contextPath}/Login">লগইন করুন</a></p>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-block">নিবন্ধন করুন</button>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<!-- user-login -->
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>