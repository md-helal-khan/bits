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
<style>
/*     .right {  */
/*     	margin-left:30px!important */
/*     } */
table tr td:nth-child(1) {
    text-align: right;
    font-weight: bold;
}
.table-striped>tbody>tr:nth-of-type(odd) {
    background-color: #eff7f3;
}
</style>
<div class="page">
	<div class="container">
		<br />
		<div class="section latest-jobs-ads">
			<div class="section-title tab-manu">
				<h4>User profile</h4>
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#recent-jobs"
						data-toggle="tab" aria-expanded="true">View profile</a></li>
					<li role="presentation" class=""><a href="#popular-jobs"
						data-toggle="tab" aria-expanded="false">Update profile</a></li>
				</ul>
			</div>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade active in" id="recent-jobs">
					<div class="personal-info">
					<br/>
						<table class="table table-striped">
						    <tbody>
						      <tr>
						        <td>Full Name:</td>
						        <td>Jhon Doe</td>
						      </tr>
						      <tr>
						        <td>Father's Name:</td>
						        <td>Robert Doe</td>
						      </tr>
						      <tr>
						        <td>Mother's Name:</td>
						        <td>Ismatic Roderos Doe</td>
						      </tr>
						      <tr>
						        <td>Full Name:</td>
						        <td>Jhon Doe</td>
						      </tr>
						      <tr>
						        <td>Father's Name:</td>
						        <td>Robert Doe</td>
						      </tr>
						      <tr>
						        <td>Mother's Name:</td>
						        <td>Ismatic Roderos Doe</td>
						      </tr>
						      <tr>
						        <td>Full Name:</td>
						        <td>Jhon Doe</td>
						      </tr>
						      <tr>
						        <td>Father's Name:</td>
						        <td>Robert Doe</td>
						      </tr>
						      <tr>
						        <td>Mother's Name:</td>
						        <td>Ismatic Roderos Doe</td>
						      </tr>
						    </tbody>
						  </table>
					</div>

				</div>
				
				
				
				
				
				
				

				<div role="tabpanel" class="tab-pane fade" id="popular-jobs">
				
					<div class="profile job-profile">
				<div class="user-pro-section">
					<!-- profile-details -->
					<div class="profile-details section">
<!-- 						<h2>Profile Details</h2> -->
						<form action="#">
							<div class="form-group">
								<label>Username</label>
								<input type="text" class="form-control" placeholder="Jhon Doe">
							</div>

							<div class="form-group">
								<label>Email ID</label>
								<input type="email" class="form-control" placeholder="jhondoe@mail.com">
							</div>

							<div class="form-group">
								<label>Mobile</label>
								<input type="text" class="form-control" placeholder="+213 1234 56789">
							</div>

							<div class="form-group">
								<label>Your City</label>
								<select class="form-control">
									<option value="#">Los Angeles, USA</option>
									<option value="#">Dhaka, BD</option>
									<option value="#">Shanghai</option>
									<option value="#">Karachi</option>
									<option value="#">Beijing</option>
									<option value="#">Lagos</option>
									<option value="#">Delhi</option>
									<option value="#">Tianjin</option>
									<option value="#">Rio de Janeiro</option>
								</select>
							</div>	

							<div class="form-group">
								<label>You are a</label>
								<select class="form-control">
									<option value="#">Employer</option>
									<option value="#">Employee</option>
								</select>
							</div>								
						</form>				
					</div><!-- profile-details -->

					<!-- change-password -->
					<div class="change-password section">
						<h2>Change password</h2>
						<!-- form -->
						<div class="form-group">
							<label>Old Password</label>
							<input type="password" class="form-control">
						</div>
						
						<div class="form-group">
							<label>New password</label>
							<input type="password" class="form-control">	
						</div>
						
						<div class="form-group">
							<label>Confirm password</label>
							<input type="password" class="form-control">
						</div>															
					</div><!-- change-password -->
					
					<!-- preferences-settings -->
					<div class="preferences-settings section">
						<h2>Preferences Settings</h2>
						<!-- checkbox -->
						<div class="checkbox">
							<label class=""><input type="checkbox" name="logged">Comments are enabled on my Resume</label>
							<label><input type="checkbox" name="receive">I want to receive newsletter.</label>
							<label><input type="checkbox" name="want">I want to receive advice on portfolio</label>
						</div><!-- checkbox -->

						<div class="buttons">
							<a href="#" class="btn">Update Profile</a>
							<a href="#" class="btn cancle">Cancle</a>
						</div>												
					</div><!-- preferences-settings -->
				</div><!-- user-pro-edit -->
			</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>