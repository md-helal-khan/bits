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
					<h2 class="center">পাসওয়ার্ড রিসেট করুন</h2>
					<c:if test="${status=='error'}">
						<div class="alert alert-error center">
						    <strong>দুঃখিত: </strong>সার্ভার এর সমস্যার কারনে পাসওয়ার্ড পুনরায় সেট করা যাচ্ছে না, একটু পরে আবার চেষ্টা করুন
						</div>
					</c:if>
					<!-- form -->
					<form:form action="${pageContext.request.contextPath}/set-new-password" method="POST" id="setNewPassword" commandName="user">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="inner-addon left-addon">
										<i class="fas fa-key auth-icon"></i>									
										<form:input type="password" path="password" name="password" id="password" class="form-control" placeholder="নতুন পাসওয়ার্ড" />
								        <c:if test="${status=='validation-error'}">
										    <ul>
											  <li><b class="error">পাসওয়ার্ড অবশ্যই দিতে হবে</b></li>
											  <li><b class="error">পাসওয়ার্ড ৬ এবং ৩০ অক্ষরের মধ্যে হতে হবে</b></li>
											  <li><b class="error">পাসওয়ার্ড এ স্পেস থাকতে পারবে না</b></li>
											</ul>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="inner-addon left-addon">
										<i class="fas fa-key auth-icon"></i> 
										<input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="পাসওয়ার্ড নিশ্চিত করুন" />
									</div>
								</div>
							</div>
						</div>
						<input type="hidden" name="username" id="username" value="${user.username}">
						<input type="hidden" name="userKey" id="userKey" value="${user.userKey}">
						<div class="row center">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">সেট করুন</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<!-- user-login -->
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>