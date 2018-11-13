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
<style>
	.error {
		color: #ff0000;
		font-weight: bold;
		margin-top: -20px!important;
		text-align: left!important;
	}
	.text-center {
    	text-align: left!important;
	}
	.btn-login{
		background-color: #0072BC!important;
	}
	
	
	.goLogin{
		margin-top: 14px;
	}
	
	
input:hover {
    box-shadow: inset 0px 0px 16px -6px #007739!important;
    border: 1px solid #00A651!important;
    background: #fff;
}


.user-account input {
    margin-bottom: 6px!important;
}

.user-account .btn {
    padding: 10px 69px 7px!important;
    margin-top: 0px!important;
}

.user-account .btn.btn-primary {
    font-weight: 600;
}



.user-account .checkbox, .radio {
    margin-top: 0px!important;
    margin-bottom: 13px!important;
}
	
	
	
	
	
	
	
	
	
	
	
	.inner-addon {
  position: relative;
}


.left-addon .far, .fas {
    left: 0px;
    font-size: 20px;
    color: #00A651;
}

.inner-addon .far, .fas {
    position: absolute;
    padding: 12px;
    pointer-events: none;
}

.left-addon input {
    padding-left: 38px;
}

/* .user-account input { */
/*     margin-bottom: 15px!important; */
/* } */


</style>
<div class="page">
	<div class="container">
		<br />
		<div class="row text-center">
			<!-- user-login -->
			<div class="col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2">
				<div class="user-account">
					<h2 class="center">ব্যবহারকারীর রেজিস্ট্রেশন</h2>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="find-job">
							<form:form action="${pageContext.request.contextPath}/UserRegistration" method="POST" id="userRegistration" commandName="user">
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="far fa-user"></i>  
										      <input type="text" name="firstNameEng" id="firstNameEng" class="form-control" placeholder="নামের প্রথম অংশ" />
										    </div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="far fa-user"></i>
										      <input type="text" name="lastNameEng" id="lastNameEng" class="form-control" placeholder="নামের শেষাংশ" />
										    </div>
										</div>
									</div>
								</div>
								
								
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-12">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="far fa-user-circle"></i>
										      <input type="text" name="username" id="username" class="form-control" placeholder="ইউজারনেম" />
										    </div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-unlock-alt"></i>
										      <input type="password" name="password" id="password" class="form-control" placeholder="পাসওয়ার্ড" />
										    </div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-unlock-alt"></i>
										      <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="পাসওয়ার্ড নিশ্চিত করুন" />
										    </div>
										</div>
									</div>
								</div>
								
								
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="far fa-envelope"></i>
										      <input type="text" name="email" id="email" class="form-control" placeholder="ইমেইল" />
										    </div>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<div class="inner-addon left-addon">
										      <i class="fas fa-mobile-alt"></i>
										      <input type="text" name="phone" id="phone" class="form-control" placeholder="মোবাইল নম্বর" />
										    </div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
										<p class="goLogin">আপনি কি ইতিমধ্যে নিবন্ধভুক্ত ? <a href="/bits/Login">লগইন করুন</a></p>
										</div>
									</div>
									<div class="col-xs-12 col-sm-6 col-md-6">
										<div class="form-group">
											<button type="submit" class="btn btn-primary">রেজিস্ট্রেশন করুন</button>
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