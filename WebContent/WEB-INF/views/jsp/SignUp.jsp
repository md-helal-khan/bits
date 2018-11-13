<%-- 
    Document   : Home
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<section class="clearfix job-bg user-page">
	<div class="container">
		<div class="row text-center">
			<!-- user-login -->
			<div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
				<div class="user-account">
					<h2>ব্যবহারকারীর রেজিস্ট্রেশন</h2>


					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="find-job">
							<form action="#">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="নাম">
								</div>
								<div class="form-group">
									<input type="email" class="form-control" placeholder="ইমেইল">
								</div>
								<div class="form-group">
									<input type="password" class="form-control"
										placeholder="পাসওয়ার্ড">
								</div>
								<div class="form-group">
									<input type="password" class="form-control"
										placeholder="পাসওয়ার্ড নিশ্চিত">
								</div>
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="মোবাইল নম্বর">
								</div>
								<!-- select -->
								<select class="form-control">
									<option value="#">Select City</option>
									<option value="#">London UK</option>
									<option value="#">Newyork, USA</option>
									<option value="#">Seoul, Korea</option>
									<option value="#">Beijing, China</option>
								</select>
								<!-- select -->

								<div class="checkbox">
									<label class="pull-left checked" for="signing"><input
										type="checkbox" name="signing" id="signing"> একটি অ্যাকাউন্টের জন্য সাইন আপ করে আপনি আমাদের শর্তাবলী এবং শর্তাবলী সাথে একমত </label>
								</div>
								<!-- checkbox -->
								<button type="submit" class="btn">রেজিস্ট্রেশন করুন</button>
							</form>
						</div>
					</div>

				</div>
			</div>
			<!-- user-login -->
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</section>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>