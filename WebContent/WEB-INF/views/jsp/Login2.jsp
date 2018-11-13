<%-- 
    Document   : Home.jsp
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<style>
	.error{
		font-weight: bold;
		color: red;
	}
</style>
<section class="clearfix job-bg user-page" onload='document.f.username.focus();'>
		<div class="container">
			<div class="row text-center">
				<!-- user-login -->			
				<div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
					<div class="user-account">
						<h2>ব্যবহারকারীর লগইন</h2>
						<!-- form -->
						<form action="${pageContext.request.contextPath}/login" method="POST" name='f'>
							<div class="form-group">
								<input type="text" name="username" id="username" class="form-control" placeholder="ব্যবহারকারীর নাম" required="required">
							</div>
							<div class="form-group">
								<input type="password" name="password" id="password" class="form-control" placeholder="***********" required="required">
							</div>
							
							<c:if test="${param.error != null}">
								<span class="error">ইউসারনাম অথবা পাসওয়ার্ড ভুল দেয়া হয়েছে</span><br/>
							</c:if>
							
							<div class="row form-group">
								<div class="col-md-7">
									<div class="checkbox">
										<label for="logged" class=""><input type="checkbox" name="logged" id="logged"> লগইন করে রাখুন </label>
									</div>
								</div>
								<div class="col-md-5">
									<button type="submit" name="submit" class="btn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;লগইন&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form><!-- form -->
					
						<!-- forgot-password -->
						<div class="user-option">
							<div class="forgot-password">
								<a href="${pageContext.request.contextPath}/forgot-password">পাসওয়ার্ড ভুলে গেছেন?</a>
							</div>
						</div><!-- forgot-password -->
					</div>
					<a href="${pageContext.request.contextPath}/UserRegistration" class="btn-primary">রেজিস্ট্রেশন করুন</a>
				</div><!-- user-login -->			
			</div><!-- row -->	
		</div><!-- container -->
	</section>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>