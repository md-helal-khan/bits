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
	<div class="container" onload='document.f.username.focus();'>
		<div class="row main">
			<!-- user-login -->
			<div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
				<div class="user-account">
					<h2 class="center">পাসওয়ার্ডটি পূনরায় সেট করুন</h2>
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
					<form action="${pageContext.request.contextPath}/forgot-password" method="POST" id="forgotPassword" name='forgotPassword'>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="inner-addon left-addon">
										<i class="fas fa-envelope auth-icon"></i>
										<input type="text" name="email" id="email" class="form-control" placeholder="আপনার ইমেইল এড্রেসটি লিখুন" />
										<c:if test="${status=='notExistance'}">
											<span class="error">এই ইমেইল এ কোনো ব্যাবহারকারী খুঁজে পাওয়া যায়নি</span>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<div class="row center">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block">সাবমিট করুন </button>
								</div>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
					<div class="row center">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<div class="checkbox">
									<p class="goLogin">আপনি কি ইতিমধ্যে নিবন্ধনকৃত ? <a href="${pageContext.request.contextPath}/Login">লগইন করুন</a></p>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-5 col-md-5 col-md-offset-1">
							<div class="form-group">
								<p class="goLogin">আপনি কি অনিবন্ধনকৃত ? 
									<a href="${pageContext.request.contextPath}/UserRegistration">নিবন্ধন করুন</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- user-login -->
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>
<script>

$(function() {
	if($("#forgotPassword #email").next("span").length > 0) {
		$("#email").css("cssText", "    margin-bottom: 10px!important;");
	}
// 	else {
// 		$("#email").css("cssText", "    margin-bottom: 40px!important;");
// 	}
});
/*
$(function() {
	$.forgotPassword = {
	    init: function () {
	    	this.events.bindEvent();
	    },
	    events: {
	        bindEvent: function () {
	        	$.forgotPassword.events.submitMailForReset();
	        },
	        submitMailForReset: function(){
				$(document).off('submit', '#forgotPassword').on('submit', '#forgotPassword', function(e){
					e.preventDefault();
					alert(this);
					
// 					$.validation.url = $('input[name="url-check-username"]').val();
// 					$.get($.validation.url, { username: this.value } )
// 					 .done(function( response ) {
// 						 if(JSON.parse(response).data){
// 							$('#userRegistration #username').next('label').remove();
// 	                		$('#userRegistration #username').after('<label id="username-error" class="error" for="username"><fmt:message key="DuplicateKey.user.username" /></label>');
// 				 		}
// 				  	  })
// 				  	 .fail(function() {
// 				  		 console.log("Username can't check");
// 				  	  });
				});
			}
		    
	    }
	}
	$.forgotPassword.init();
});*/
</script>