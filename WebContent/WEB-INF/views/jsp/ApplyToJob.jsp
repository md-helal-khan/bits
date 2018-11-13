<%-- 
    Document   : Home
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<style>
#uploadPhoto {
	display: none;
}

.photoContainer {
	position: relative;
	width: 100%;
}

.image {
	position: relative;
	opacity: 1;
	display: block;
	width: 100%;
	height: auto;
	transition: .5s ease;
	backface-visibility: hidden;
}

.middle {
	transition: .5s ease;
	opacity: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
}

.photoContainer:hover .image {
	opacity: 0.5;
}

.photoContainer:hover .middle {
	opacity: 1;
}

.btn-bs-file {
	position: relative;
	height: 0%;
	width: 100%;
}

.btn-bs-file input[type="file"] {
	position: absolute;
	top: -9999999;
	filter: alpha(opacity = 0);
	opacity: 2;
	width: 0;
	height: 0;
	outline: none;
	cursor: inherit;
}

.btn-primary {
	color: #fff;
	height: 0%;
}

.uploadIcon {
	color: #fff;
	width: 200%;
	height: 200%;
}
.img-thumbnail{
	border-radius: 0px!important;
}

 .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
 	     font-family: SolaimanLipi;
     font-size: 12px;
    padding: 2px!important;
    padding-left: 5px!important;
  }
</style>

<style>
.profile {
	
}

.table {
	border: 1px solid #FFFFFF;
	border-bottom: 1px solid #FFFFFF;
}

.profile-content {
	
}

.form {
	
}

.right {
	text-align: right;
}

.btn-bs-file {
	position: relative;
}

.btn-bs-file input[type="file"] {
	position: absolute;
	top: -9999999;
	filter: alpha(opacity = 0);
	opacity: 0;
	width: 0;
	height: 0;
	outline: none;
	cursor: inherit;
}

.bg {
	background-color: #EFF5FB;
}

.table>tbody>tr>td, .table>tbody>tr>th {
	border: 0px;
}

.profile-info {
	font-size: 16px;
}

.table-striped>tbody>tr:nth-child(2n+1)>td, .table-striped>tbody>tr:nth-child(2n+1)>th
	{
	background-color: #EFF5FB;
}

.errorMsg {
	color: red;
	font-weight: bold;
	margin-top: -8px;
}

/* .modal .modal-dialog { */
/* 	width: 95%; */
/* } */

.table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th {
    border: 1px solid #000!important;
    color: #000!important;
}



section {
    padding: 0px 1!important;
}

.error {
	color: #ff0000;
	font-weight: bold;
	margin-top: 10px!important;
}

.addressGroup {
    border: 1px solid #e3e3e3 !important;
    background-color: #fcfcfc !important;
    padding-left: 21px !important;
    padding-right: 21px !important;
    padding-top: 21px !important;
    padding-bottom: 0px !important;
    margin-bottom: 15px !important;
    border-radius: 5px !important;
}
.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control {
    background-color: #FCFCFC!important;
}

.job-title{
    font-size: 1.3em;
    margin-left: 0;
    margin-right: 0;
    font-weight: bold;
}
.job-info-title{
    font-size: 1.2em;
}
select .error{
	margin-bottom: 20px!important;
}
</style>
<div class="job-bg ad-details-page">
	<div class="container"><br />
		<c:if test="${error != null}">
			<div class="alert alert-danger center">
			    <strong>অভ্যন্তরীণ সার্ভারে ত্রুটি ঘটেছে - </strong>একটু পরে আবার চেষ্টা করুন
			</div>
		</c:if>
		<div class="job-postdetails post-resume">
			<input type="hidden" value="${pageContext.request.contextPath}/Ajax/GetUpazilaByDistrictId" name="url-get-upazila-by-id">
			<div class="row main">
				<div class="col-md-12 clearfix">
					<sf:form action="${pageContext.request.contextPath}/ApplyToJob?${_csrf.parameterName}=${_csrf.token}" method="POST" id="applyToJob" commandName="applicant" enctype="multipart/form-data">
						<!-- Hidden Field -->
						<input type="hidden" name="recruitmentId" id="recruitmentId" value="${recruitment.recruitmentId}">
						<input type="hidden" name="payment.recruitmentId" id="payment.recruitmentId" value="${recruitment.recruitmentId}">
						<fieldset>
							<div class="section express-yourself">
							<h2 class="title">চাকরির আবেদন ফরম</h2>
							<div class="row">
								<div class="col-xs-12 col-sm-4 col-md-4 job-title">
									O&nbsp;<span style="color: #000">পদের নাম : <i>${recruitment.designationName}</i></span>&nbsp;&nbsp;
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6 job-info-title">
									O&nbsp;<small style="color: #0D79BF">${recruitment.memorandum}</small>&nbsp;&nbsp;
								</div>
								<div class="col-xs-12 col-sm-2 col-md-2 job-info-title">
									O&nbsp;<small style="color: #00A651">তারিখ : <i class="applicationStartDate">${recruitment.applicationStartDate}</i></small>
								</div>
							</div><br/>
							<div class="row form-group">
								<label class="col-md-10 label-title">সাম্প্রতিক তোলা ছবি :</label>
								<div class="col-sm-2">
									<div class="photoContainer">
										<img src="data:image/jpg;base64, ${img}" alt="Avatar" id="userPhoto" class="img-thumbnail image">
										<div class="middle">
											<div class="text">
												<label
													class="btn-bs-file btn btn-md btn-outlined btn-block btn-primary">
													<b class="uploadIcon"> <i class="fa fa-camera"aria-hidden="true"></i></b> 
													<input type="file"id="changePhoto" name="userPhoto" />
												</label>
											</div>
										</div>
									</div>
									<c:if test="${photoError!=null}">
										<span class="error">ছবি সংযোজন করুন</span>
									</c:if>
								</div>
							</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">১. পদের নাম :</label>
									<div class="col-sm-3">
										<input type="text" name="designationName" id="designationName" class="form-control" placeholder="" value="${recruitment.designationName}" readonly="readonly">
									</div>
									<label class="col-md-3 label-title">তারিখ:</label>
									<div class="col-md-3">
										<input type="text" name="applicationStartDate" value="${recruitment.applicationStartDate}" id="applicationStartDate" class="form-control applicationStartDate" readonly="readonly">
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">২. বিজ্ঞপ্তির নম্বর :</label>
									<div class="col-sm-9">
										<input type="text" name="memorandum" id="memorandum" class="form-control"
											placeholder="" value="${recruitment.memorandum}" readonly="readonly">
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">৩. প্রার্থীর নাম (
										বাংলায় ) :</label>
									<div class="col-sm-3">
										<sf:input type="text" path="nameBan" name="nameBan" id="nameBan" class="form-control" placeholder=""/>
										<sf:errors path="nameBan" cssClass="error" />
									</div>
									<label class="col-sm-3 label-title">ইংরেজিতে ( বড় অক্ষরে ) :</label>
									<div class="col-sm-3">
										<sf:input type="text" path="nameEng" name="nameEng" id="nameEng" class="form-control" placeholder="" />
										<sf:errors path="nameEng" cssClass="error" />
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">৪. জাতীয় পরিচয় নম্বর :</label>
									<div class="col-sm-3">
										<sf:input type="number" path="nidNo" name="nidNo" id="nidNo" class="form-control" placeholder=""/>
										<sf:errors path="nidNo" cssClass="error" />
									</div>
									<label class="col-sm-3 label-title">জন্ম নিবন্ধন নম্বর</label>
									<div class="col-sm-3">
										<sf:input type="number" path="bridNo" name="bridNo" id="bridNo" class="form-control" placeholder=""/>
										<sf:errors path="bridNo" cssClass="error" />
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">৫. জন্ম তারিখ :</label>
									<div class="col-sm-3">
										<sf:input path="dob" name="dob" id="dob" class="form-control datePicker" placeholder="" readonly="readonly" />
										<sf:errors path="dob" cssClass="error" />
									</div>
									<label class="col-sm-3 label-title">৬. জন্মস্থান ( জেলা ) :</label>
									<div class="col-sm-3">
										<sf:select class="form-control" path="placeOfBirth" name="placeOfBirth" id="placeOfBirth">
											<option value="0">সিলেক্ট করুন</option>
											<c:forEach var="district" items="${districts}">
												<option value="${district.districtId}">${district.nameBan}</option>
											</c:forEach>
										</sf:select>
										<sf:errors path="placeOfBirth" cssClass="error" />
									</div>
								</div>

								<div class="row form-group">
									<label class="col-md-3 label-title">৭. বিজ্ঞপ্তিতে উল্লেখিত তারিখে প্রার্থীর বয়স:</label>
									<div class="col-md-2">
										<input type="text" name="ageYear" id="ageYear" class="form-control" placeholder="বছর" readonly="readonly">
									</div>
									<label class="col-md-1 label-title">বছর</label>

									<div class="col-md-2">
										<input type="text" name="ageMonth" id="ageMonth" class="form-control" placeholder="মাস" readonly="readonly">
									</div>
									<label class="col-md-1 label-title">মাস</label>

									<div class="col-md-2">
										<input type="text" name="ageDay" id="ageDay" class="form-control" placeholder="দিন" readonly="readonly">
									</div>
									<label class="col-md-1 label-title">দিন</label>
								</div>
								
								<div class="row form-group">
									<label class="col-md-3 label-title">৮. মাতার নাম :</label>
									<div class="col-md-3">
										<sf:input type="text" path="motherName" name="motherName" id="motherName" class="form-control" placeholder="" />
										<sf:errors path="motherName" cssClass="error" />
									</div>
									<label class="col-md-3 label-title">৯. পিতার নাম :</label>
									<div class="col-md-3">
										<sf:input type="text" path="fatherName" name="fatherName" id="fatherName" class="form-control" placeholder="" />
										<sf:errors path="fatherName" cssClass="error" />
									</div>
								</div>
								<!--Current Address -->
								<div class="addressGroup">
									<input type="hidden" name="address[0].addressType" value="0">
									<div class="row form-group">
										<label class="col-md-12">১০. বর্তমান  ঠিকানা :</label>
										<label class="col-md-3 label-title">জেলা :</label>
										<div class="col-md-3">
											<sf:select class="form-control" path="address[0].districtId" name="address[0].districtId" id="districtId0">
												<option value="0">জেলা সিলেক্ট করুন</option>
												<c:forEach var="district" items="${districts}">
													<option value="${district.districtId}">${district.nameBan}</option>
												</c:forEach>
											</sf:select>
											<sf:errors path="address[0].districtId" cssClass="error" />
										</div>
										<label class="col-md-3 label-title">উপজেলা:</label>
										<div class="col-md-3">
											<sf:select class="form-control" path="address[0].upazilaId" name="address[0].upazilaId" id="upazilaId0">
												<option value="0">উপজেলা সিলেক্ট করুন</option>
												<c:if test="${fn:length(upazilas0) gt 0}">
										    		<c:forEach var="upazila" items="${upazilas0}">
														<option value="${upazila.upazilaId}">${upazila.nameBan}</option>
													</c:forEach>
												</c:if>																						
												</sf:select>
												<sf:errors path="address[0].upazilaId" cssClass="error" />
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-3 label-title">পোস্টকোড নম্বর :</label>
										<div class="col-md-3">
											<sf:input type="number" path="address[0].postCode" name="address[0].postCode" id="postCode0" class="form-control" placeholder="বর্তমান" />
											<sf:errors path="address[0].postCode" cssClass="error" />
										</div>
										<label class="col-md-3 label-title">ডাকঘর :</label>
										<div class="col-md-3">
											<sf:input type="text" path="address[0].postOffice" name="address[0].postOffice" id="postOffice0" class="form-control" placeholder="বর্তমান" /> 
											<sf:errors path="address[0].postOffice" cssClass="error" />
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-3 label-title">ইউনিয়ন/ওয়ার্ড :</label>
										<div class="col-md-3">
											<sf:input path="address[0].unionName" name="address[0].unionName" id="unionName0" class="form-control" placeholder="বর্তমান"/> 
											<sf:errors path="address[0].unionName" cssClass="error" />
										</div>
										<label class="col-md-3 label-title">গ্রাম/পাড়া/মহল্লা :</label>
										<div class="col-md-3">
											<sf:input path="address[0].village" name="address[0].village" id="village0" class="form-control" placeholder="বর্তমান" />
											<sf:errors path="address[0].village" cssClass="error" />
										</div>
									</div>
									<div class="row form-group">
										<label class="col-md-3 label-title">বাসা ও সড়ক (নাম/ নম্বর):</label>
										<div class="col-md-9">
											<sf:input path="address[0].homeAndRoadNo" name="address[0].homeAndRoadNo" id="homeAndRoadNo0" class="form-control" placeholder="বর্তমান"/> 
											<sf:errors path="address[0].homeAndRoadNo" cssClass="error" />
										</div>
									</div>
								</div>
								<!--Permanent Address -->
								<div class="addressGroup">
									<input type="hidden" name="address[1].addressType" value="1">
									<div class="row form-group">
										<label class="col-md-12">১০. স্থায়ী  ঠিকানা :</label>
										<label class="col-md-3 label-title">জেলা :</label>
										<div class="col-md-3">
											<sf:select class="form-control" path="address[1].districtId" name="address[1].districtId" id="districtId1">
												<option value="0">জেলা সিলেক্ট করুন</option>
												<c:forEach var="district" items="${districts}">
													<option value="${district.districtId}">${district.nameBan}</option>
												</c:forEach>
											</sf:select>
											<sf:errors path="address[1].districtId" cssClass="error" />
										</div>
										<label class="col-md-3 label-title">উপজেলা:</label>
										<div class="col-md-3">
											<sf:select class="form-control" path="address[1].upazilaId" name="address[1].upazilaId" id="upazilaId1">
												<option value="0">উপজেলা সিলেক্ট করুন</option>
												<c:if test="${fn:length(upazilas1) gt 0}">
										    		<c:forEach var="upazila" items="${upazilas1}">
														<option value="${upazila.upazilaId}">${upazila.nameBan}</option>
													</c:forEach>
												</c:if>
											</sf:select>
											<sf:errors path="address[1].upazilaId" cssClass="error" />
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-3 label-title">পোস্টকোড নম্বর :</label>
										<div class="col-md-3">
											<sf:input type="number" path="address[1].postCode" name="address[1].postCode" id="postCode1" class="form-control" placeholder="স্থায়ী" />
											<sf:errors path="address[1].postCode" cssClass="error" />
										</div>
										<label class="col-md-3 label-title">ডাকঘর :</label>
										<div class="col-md-3">
											<sf:input type="text" path="address[1].postOffice" name="address[1].postOffice" id="postOffice1" class="form-control" placeholder="স্থায়ী" /> 
											<sf:errors path="address[1].postOffice" cssClass="error" />
										</div>
									</div>
									
									<div class="row form-group">
										<label class="col-md-3 label-title">ইউনিয়ন/ওয়ার্ড :</label>
										<div class="col-md-3">
											<sf:input path="address[1].unionName" name="address[1].unionName" id="unionName1" class="form-control" placeholder="স্থায়ী"/> 
											<sf:errors path="address[1].unionName" cssClass="error" />
										</div>
										<label class="col-md-3 label-title">গ্রাম/পাড়া/মহল্লা :</label>
										<div class="col-md-3">
											<sf:input path="address[1].village" name="address[1].village" id="village1" class="form-control" placeholder="স্থায়ী" />
											<sf:errors path="address[1].village" cssClass="error" />
										</div>
									</div>
									<div class="row form-group">
										<label class="col-md-3 label-title">বাসা ও সড়ক (নাম/ নম্বর):</label>
										<div class="col-md-9">
											<sf:input path="address[1].homeAndRoadNo" name="address[1].homeAndRoadNo" id="homeAndRoadNo1" class="form-control" placeholder="বর্তমান"/> 
											<sf:errors path="address[1].homeAndRoadNo" cssClass="error" />
										</div>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-md-12">১১. যোগাযোগ :</label>
									<label class="col-md-3 label-title">মোবাইল/ টেলিফোন নম্বর:</label>
									<div class="col-md-3">
										<sf:input type="number" path="user.phone" name="user.phone" id="phone" class="form-control" placeholder="মোবাইল/ টেলিফোন নম্বর" />
										<sf:errors path="user.phone" cssClass="error" />
									</div>
									<label class="col-md-3 label-title">ই - মেইল ( যদি থাকে ):</label>
									<div class="col-md-3">
										<sf:input type="text" path="user.email" name="user.email" id="email" class="form-control pull-right" placeholder="ই - মেইল ( যদি থাকে )" />
										<sf:errors path="user.email" cssClass="error" />
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">১২. জাতীয়তা :</label>
									<div class="col-sm-3">
										<sf:input type="text" path="nationality" name="nationality" id="nationality" class="form-control" value="বাংলাদেশী"/>
										<sf:errors path="nationality" cssClass="error" />
									</div>
									<label class="col-sm-2 label-title">১৩. জেন্ডার :</label>
									<div class="col-sm-4 user-type">
										<sf:radiobutton path="genderId" name="genderId" value="1" id="male"/> <label for="male">পুরুষ </label> 
										<sf:radiobutton path="genderId" name="genderId" value="2" id="female"/> <label for="female">মহিলা</label>
										<sf:radiobutton path="genderId" name="genderId" value="3" id="other"/> <label for="other">অন্যান্য</label><br/>
										<sf:errors path="genderId" cssClass="error" />
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3 label-title">১৪. ধর্ম :</label>
									<div class="col-sm-3">
										<sf:select path="religionId" name="religionId" id="religionId" class="form-control">
											<option value="0">ধর্ম সিলেক্ট করুন</option>
											<option value="1">ইসলাম</option>
											<option value="2">হিন্দু</option>
											<option value="3">বৌদ্ধ</option>
											<option value="4">খ্রীস্টান</option>
											<option value="5">অন্যান্য</option>
										</sf:select>
										<sf:errors path="religionId" cssClass="error" />
									</div>
									<label class="col-sm-3 label-title">১৫. পেশা :</label>
									<div class="col-sm-3">
										<sf:select path="occupationId" name="occupationId" id="occupationId" class="form-control">
											<option value="0">পেশা সিলেক্ট করুন</option>
											<option value="1">চাকুরীজীবি</option>
											<option value="2">ছাত্র</option>
											<option value="3">বেকার</option>
											<option value="4">অন্যান্য</option>
										</sf:select>
										<sf:errors path="occupationId" cssClass="error" />
									</div>
								</div><br/>
<!-- 							</div> -->
<!-- 							<div class="section education-background"> -->
								<div class="row form-group">
								</div>
								<h4>
									১৬. শিক্ষাগত যোগ্যতা &nbsp;
									<button type="button" id="addMoreEdu" class="btn btn-sm btn-primary pull-right">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</button>
								</h4>
								<ul class="education-list">
									<li>
										<div class="row form-group">
											<label class="col-md-2 label-title">পরীক্ষার নাম :</label>
											<div class="col-md-4">
												<sf:select class="form-control" path="educationalQualification[0].educationId" name="educationalQualification[0].educationId" id="educationId">
													<option value="0">পরীক্ষার নাম সিলেক্ট করুন</option>
													<option value="1">৫ম শ্রেণী </option>
													<option value="2">৮ম শ্রেণী </option>
													<option value="3">এস এস সি</option>
													<option value="4">এইচ এস সি</option>
													<option value="5">অনার্স</option>
													<option value="6">মাস্টার্স</option>
												</sf:select>
												<sf:errors path="educationalQualification[0].educationId" cssClass="error" />
											</div>
											<label class="col-md-2 label-title">বিষয় :</label>
											<div class="col-md-4">
												<sf:input type="text" path="educationalQualification[0].subject" name="educationalQualification[0].subject" id="subject" class="form-control" placeholder="" />
												<sf:errors path="educationalQualification[0].subject" cssClass="error" />
											</div>
										</div>
										<div class="row form-group">
											<label class="col-md-2 label-title">শিক্ষা প্রতিষ্ঠান :</label>
											<div class="col-md-4">
												<sf:input type="text" path="educationalQualification[0].institutionName" name="educationalQualification[0].institutionName" id="institutionName" class="form-control" placeholder="" />
												<sf:errors path="educationalQualification[0].institutionName" cssClass="error" />
											</div>
											<label class="col-md-2 label-title">পাশের সন :</label>
											<div class="col-md-4">
												<sf:select class="form-control passingYear" path="educationalQualification[0].passingYear" name="educationalQualification[0].passingYear" id="passingYear">
													<option value="1">2018</option>
												</sf:select>
												<sf:errors path="educationalQualification[0].passingYear" cssClass="error" />
											</div>
										</div>

										<div class="row form-group">
											<label class="col-md-2 label-title">বোর্ড/বিশ্ববিদ্যালয় :</label>
											<div class="col-md-4">
												<sf:input type="text" path="educationalQualification[0].boardOrUniversity" name="educationalQualification[0].boardOrUniversity" id="boardOrUniversity" class="form-control" placeholder=""/>
												<sf:errors path="educationalQualification[0].boardOrUniversity" cssClass="error" />
											</div>
											<label class="col-md-2 label-title">গ্রেড/শ্রেণী/বিভাগ :</label>
											<div class="col-md-4">
												<sf:input type="text" path="educationalQualification[0].gradeClassDivision" name="educationalQualification[0].gradeClassDivision" id="gradeClassDivision" class="form-control" placeholder=""/>
												<sf:errors path="educationalQualification[0].gradeClassDivision" cssClass="error" />
											</div>
										</div>
									</li>
								</ul>
<!-- 							</div> -->
<!-- 							<div class="section special-qualification"> -->
								<div class="row form-group">
									<label class="col-md-3 label-title">১৭. অতিরিক্ত যোগ্যতা (যদি থাকে ) :</label>
									<div class="col-sm-9">
										<sf:textarea path="additionalQualification" name="additionalQualification" id="additionalQualification" class="form-control" placeholder="এখানে লিখুন" rows="3" />
										<sf:errors path="additionalQualification" cssClass="error" />
									</div>
								</div>
								<div class="row form-group">
									<label class="col-md-3 label-title">১৮. অভিজ্ঞতার বিবরণ (প্রযোজ্য ক্ষেত্রে) :</label>
									<div class="col-sm-9">
										<sf:textarea path="experience" name="experience" id="experience" class="form-control" placeholder="এখানে লিখুন" rows="3"/>
										<sf:errors path="experience" cssClass="error" />
									</div>
								</div>
								<div class="row form-group">
									<label class="col-sm-3">১৯. কোটা ( টিক দিন ) :</label>
									<div class="col-sm-9 user-type">
										<sf:radiobutton path="quotaId" name="quotaId" value="1" id="1"/><label for="1">মুক্তিযোদ্ধা/ শহীদ মুক্তিযোদ্ধাদের পুত্র-কন্যা/ পুত্র-কন্যার পুত্র-কন্যা</label> 
										<sf:radiobutton path="quotaId" value="2" id="2"/><label for="2">এতিম/ শারীরিক প্রতিবন্ধী </label> 
										<sf:radiobutton path="quotaId" value="3" id="3"/><label for="3">ক্ষুদ্র নৃ গোষ্ঠী</label> 
										<sf:radiobutton path="quotaId" value="4" id="4"/><label for="4">আনসার ও গ্রাম প্রতিরক্ষা সদস্য</label> 
										<sf:radiobutton path="quotaId" value="5" id="5"/><label for="5">অন্যান্য ( উল্লেখ করুন )</label>
										<br/><sf:errors path="quotaId" cssClass="error" />
									</div>
								</div>
								<div class="addressGroup">
									<div class="row form-group">
										<label class="col-md-12 label-title">২০.</label>
										<label class="col-md-2 label-title">চালান/ ব্যাঙ্ক ড্রাফট/ পে-অর্ডার নম্বর:</label>
										<div class="col-md-4">
											<sf:input path="payment.paymentNo" name="payment.paymentNo" id="paymentNo" class="form-control" placeholder=""/>
											<sf:errors path="payment.paymentNo" cssClass="error" />
										</div>
										<label class="col-md-2 label-title">তারিখ:</label>
										<div class="col-md-4">
											<sf:input path="payment.paymentDate" name="payment.paymentDate" id="paymentDate" class="form-control datePicker" placeholder="dd/mm/yyyy"/>
											<sf:errors path="payment.paymentDate" cssClass="error" />
										</div>
									</div>
									<div class="row form-group">
										<label class="col-md-2 label-title">ব্যাংকের নাম:</label>
										<div class="col-md-4">
											<sf:input path="payment.bankName" name="payment.bankName" id="bankName" class="form-control" placeholder=""/>
											<sf:errors path="payment.bankName" cssClass="error" />
										</div>
										<label class="col-md-2 label-title">শাখার নাম:</label>
										<div class="col-md-4">
											<sf:input path="payment.brunchName" name="payment.brunchName" id="brunchName" class="form-control" placeholder=""/>
											<sf:errors path="payment.brunchName" cssClass="error" />
										</div>
									</div>
								</div>
								<div class="row form-group">
									<label class="col-md-3 label-title">২১. বিভাগীয় প্রার্থী কিনা:</label>
									<div class="col-md-5 user-type">
										<sf:radiobutton path="divisionalCandidateId" name="divisionalCandidateId" value="1" id="yes"/><label for="yes">হাঁ</label> 
										<sf:radiobutton path="divisionalCandidateId" name="divisionalCandidateId" value="2" id="no"/><label for="no">না</label>
										<sf:radiobutton path="divisionalCandidateId" name="divisionalCandidateId" value="3" id="noNeed"/><label for="noNeed">প্রযোজ্য নয়</label>
										<sf:errors path="divisionalCandidateId" cssClass="error" />
									</div>
									<label class="col-md-1 label-title"></label>
									<div class="col-md-3">
										<button type="submit" class="btn btn-primary" id="confirmationToApply">আবেদন নিশ্চিত করুন</button>
									</div>
								</div>
							</div>
						</fieldset>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="modal fade modal-fullscreen  footer-to-bottom"
	id="applicationForm" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg"
		style="border-radius: 10px !important">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<i class="fa fa-times" aria-hidden="true"></i>
				</button>
				<h4 class="modal-title bold">আবেদন নিশ্চিত করুন</h4>
			</div>
			<div class="modal-body">
				
			
			
			
<!-- 				<div class="container"> -->
				<button type="button" class="btn btn-flat btn-default btn-xs" onclick="window.print();"><i class="fa fa-print" aria-hidden="true"></i>&nbsp;Print / PDF</button><br>
					<div class="row">
						<div class="col-sm-12">
<!-- 							<div class="table-responsive"> -->
								<table class="table table-bordered applicationFormTable">
									<tr>
										<td colspan="16" style="border:none!important">
											<img
												src="${pageContext.request.contextPath}/static/images/img_avatar.png"
												alt="Avatar" style="width: 189px;height: 189px	" id="userPhoto_" class="img-thumbnail image pull-right">
										</td>
									</tr>
									<tr>
										<td colspan="1">১.</td>
										<td colspan="15">পদের নাম: <span id="designationName_"></span></td>
									</tr>
									<tr>
										<td colspan="1">২.</td>
										<td colspan="11">বিজ্ঞপ্তির নম্বর: <span id="memorandum_"></span></td>
										<td colspan="1">তারিখ</td>
										<td colspan="1"><span id="applicationStartDateDay"></span></td>
										<td colspan="1"><span id="applicationStartDateMonth"></span></td>
										<td colspan="1"><span id="applicationStartDateYear"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="2">৩.</td>
										<td colspan="2" rowspan="2">প্রার্থীর নাম</td>
										<td colspan="13">বাংলায় : <span id="nameBan_"></span></td>
									</tr>
									<tr>
										<td colspan="13">ইংরেজিতে ( বড় অক্ষরে ): <span id="nameEng_"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="2">৪.</td>
										<td colspan="13">জাতীয় পরিচয় নম্বর : <span id="nidNo_"></span></td>
										<td colspan="2" rowspan="2" class="center">(যে কোনো একটি)</td>
									</tr>
									<tr>
										<td colspan="13">জন্ম নিবন্ধন নম্বর: <span id="bridNo_"></span></td>
									</tr>
									<tr>
										<td colspan="1">৫.</td>
										<td colspan="4">জন্ম তারিখ :</td>
										<td colspan="1"><span id="dobDay_" class="center"></span></td>
										<td colspan="1"><span id="dobMonth_" class="center"></span></td>
										<td colspan="1"><span id="dobYear_" class="center"></span></td>
										<td colspan="8">৬. জন্মস্থান ( জেলা ): <span id="placeOfBirth_"></span></td>
									</tr>
									<tr>
										<td colspan="1">৭.</td>
										<td colspan="6">বিজ্ঞপ্তিতে উল্লেখিত তারিখে প্রার্থীর
											বয়স:</td>
										<td colspan="3"><span id="ageYear_" class="center"></span> বছর</td>
										<td colspan="3"><span id="ageMonth_" class="center"></span> মাস</td>
										<td colspan="3"><span id="ageDay_" class="center"></span> দিন</td>
									</tr>
									<tr>
										<td colspan="1">৮.</td>
										<td colspan="15">মাতার নাম: <span id="motherNameBan_"></span></td>
									</tr>
									<tr>
										<td colspan="1">৯.</td>
										<td colspan="15">পিতার নাম: <span id="fatherNameBan_"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="8">১০.</td>
										<td colspan="5">ঠিকানা:</td>
										<td colspan="5">বর্তমান</td>
										<td colspan="5">স্থায়ী</td>
									</tr>
									<tr>
										<td colspan="5">বাসা ও সড়ক (নাম/নম্বর):</td>
										<td colspan="5"><span id="homeAndRoadCurrnt_"></span></td>
										<td colspan="5"><span id="homeAndRoadPermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="5">গ্রাম/পাড়া/মহল্লা :</td>
										<td colspan="5"><span id="villageCurrnt_"></span></td>
										<td colspan="5"><span id="villagePermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="5">ইউনিয়ন/ওয়ার্ড :</td>
										<td colspan="5"><span id="unionNameCurrnt_"></span></td>
										<td colspan="5"><span id="unionNamePermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="5">ডাকঘর :</td>
										<td colspan="5"><span id="postOfficeCurrent_"></span></td>
										<td colspan="5"><span id="postOfficePermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="5">পোস্টকোড নম্বর :</td>
										<td colspan="5"><span id="postCodeCurrent_"></span></td>
										<td colspan="5"><span id="postCodePermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="5">উপজেলা :</td>
										<td colspan="5"><span id="upazilaIdCurrnt_"></span></td>
										<td colspan="5"><span id="upazilaIdPermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="5">জেলা :</td>
										<td colspan="5"><span id="districtIdCurrnt_"></span></td>
										<td colspan="5"><span id="districtIdPermanant_"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="1">১১.</td>
										<td colspan="5" rowspan="1">যোগাযোগ :</td>
										<td colspan="5" rowspan="1">মোবাইল/ টেলিফোন নম্বর<br><span id="phone_"></span>
										</td>
										<td colspan="5" rowspan="1">ই - মেইল ( যদি থাকে )<br><span id="email_"></span>
										</td>
									</tr>
									<tr>
										<td colspan="1">১২.</td>
										<td colspan="7">জাতীয়তা: <span id="nationality_"></span></td>
										<td colspan="1">১৩.</td>
										<td colspan="7">জেন্ডার: <span id="genderId_"></span></td>
									</tr>
									<tr>
										<td colspan="1">১৪.</td>
										<td colspan="7">ধর্ম : <span id="religionId_"></span></td>
										<td colspan="1">১৫.</td>
										<td colspan="7">পেশা : <span id="occupationId_"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="7">১৬.</td>
										<td colspan="15" class="center">শিক্ষাগত যোগ্যতা:</td>
									</tr>
									<tr>
										<td colspan="3">পরীক্ষার নাম:</td>
										<td colspan="3">বিষয়:</td>
										<td colspan="3">শিক্ষা প্রতিষ্ঠান:</td>
										<td colspan="2">পাশের সন:</td>
										<td colspan="3">বোর্ড/বিশ্ববিদ্যালয়:</td>
										<td colspan="2">গ্রেড/শ্রেণী/বিভাগ:</td>
									</tr>
									<tr>
										<td colspan="3"><span id="educationId1_">&nbsp;</span></td>
										<td colspan="3"><span id="subject1_"></span></td>
										<td colspan="3"><span id="institutionName1_"></span></td>
										<td colspan="2"><span id="passingYear1_"></span></td>
										<td colspan="3"><span id="boardOrUniversity1_"></span></td>
										<td colspan="2"><span id="gradeOrDivision1_"></span></td>
									</tr>
									<tr>
										<td colspan="3"><span id="educationId2_">&nbsp;</span></td>
										<td colspan="3"><span id="subject2_"></span></td>
										<td colspan="3"><span id="institutionName2_"></span></td>
										<td colspan="2"><span id="passingYear2_"></span></td>
										<td colspan="3"><span id="boardOrUniversity2_"></span></td>
										<td colspan="2"><span id="gradeOrDivision2_"></span></td>
									</tr>
									<tr>
										<td colspan="3"><span id="educationId3_">&nbsp;</span></td>
										<td colspan="3"><span id="subject3_"></span></td>
										<td colspan="3"><span id="institutionName3_"></span></td>
										<td colspan="2"><span id="passingYear3_"></span></td>
										<td colspan="3"><span id="boardOrUniversity3_"></span></td>
										<td colspan="2"><span id="gradeOrDivision3_"></span></td>
									</tr>
									<tr>
										<td colspan="3"><span id="educationId4_">&nbsp;</span></td>
										<td colspan="3"><span id="subject4_"></span></td>
										<td colspan="3"><span id="institutionName4_"></span></td>
										<td colspan="2"><span id="passingYear4_"></span></td>
										<td colspan="3"><span id="boardOrUniversity4_"></span></td>
										<td colspan="2"><span id="gradeOrDivision4_"></span></td>
									</tr>
									<tr>
										<td colspan="3"><span id="educationId5_">&nbsp;</span></td>
										<td colspan="3"><span id="subject5_"></span></td>
										<td colspan="3"><span id="institutionName5_"></span></td>
										<td colspan="2"><span id="passingYear5_"></span></td>
										<td colspan="3"><span id="boardOrUniversity5_"></span></td>
										<td colspan="2"><span id="gradeOrDivision5_"></span></td>
									</tr>
									<tr>
										<td colspan="1">১৭.</td>
										<td colspan="15">অতিরিক্ত যোগ্যতা ( যদি থাকে ): <span id="additionalQualification_"></span></td>
									</tr>
									<tr>
										<td colspan="1">১৮.</td>
										<td colspan="15">অভিজ্ঞতার বিবরণ (প্রযোজ্য ক্ষেত্রে): <span id="experience_"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="2">১৯.</td>
										<td colspan="2" rowspan="2">কোটা ( টিক দিন )</td>
										<td colspan="8">মুক্তিযোদ্ধা/ শহীদ মুক্তিযোদ্ধাদের পুত্র-কন্যা/ পুত্র-কন্যার পুত্র-কন্যা <span id="quotaId1_"></span></td>
										<td colspan="5">এতিম/ শারীরিক প্রতিবন্ধী <span id="quotaId2_"></span></td>
									</tr>
									<tr>
										<td colspan="5">ক্ষুদ্র নৃ গোষ্ঠী <span id="quotaId3_"></span></td>
										<td colspan="5">আনসার ও গ্রাম প্রতিরক্ষা সদস্য <span id="quotaId4_"></span></td>
										<td colspan="5">অন্যান্য ( উল্লেখ করুন ) <span id="quotaId5_"></span></td>
									</tr>
									<tr>
										<td colspan="1" rowspan="2">২০.</td>
										<td colspan="11">চালান/ ব্যাঙ্ক ড্রাফট/ পে-অর্ডার নম্বর: <span id="paymentNo_"></span></td>
										<td colspan="1">তারিখ</td>
										<td colspan="1"><span id="paymentDateDay"></span></td>
										<td colspan="1"><span id="paymentDateMonth"></span></td>
										<td colspan="1"><span id="paymentDateYear"></span></td>
									</tr>
									<tr>
										<td colspan="16">ব্যাংক ও শাখার নাম: <span id="bankName_"></span>, <span id="brunchName_"></span></td>
									</tr>
									<tr>
										<td colspan="1">২১.</td>
										<td colspan="6">বিভাগীয় প্রার্থী কিনা:</td>
										<td colspan="3">হাঁ <span id="divisionalCandidateId1_"></span></td>
										<td colspan="3">না <span id="divisionalCandidateId2_"></span></td>
										<td colspan="3">প্রযোজ্য নয় <span id="divisionalCandidateId3_"></span></td>
									</tr>
								</table>
<!-- 							</div> -->
						</div>
					</div>
<!-- 				</div> -->

			</div>
			<div class="modal-footer">
			<div class="buttonsa">
						<a href="#" class="btn" data-toggle="modal" data-target="#applicationForm" contenteditable="false">আবেদন
							নিশ্চিত করুন</a> <a href="/bits" class="btn cancle">বাতিল</a>
					</div>
<!-- 				<a href="#" class="btn" data-toggle="modal" data-target="#applicationForm" contenteditable="false">আবেদন -->
<!-- 							নিশ্চিত করুন</a> -->
<!-- 				<button type="button" class="btn cancle" data-dismiss="modal">Close</button> -->
			</div>
		</div>

	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>
<script>
	$(function () {
		
		$.applyToJob = {
			url: null,
			response: null,
			form: function(){
				return {
					districtId:{
						1:$("select#districtId0").val(),
						2:$("select#districtId1").val()
					}
				};
			},
			ref:{
				districtId:{
					1:$("#districtId0"),
					2:$("#districtId1")
				},
				upazilaId:{
					1:$("#upazilaId0"),
					2:$("#upazilaId1")
				}
			},
		    init: function () {
		    	this.reset();
		    	this.events.bindEvent();
		    },
		    reset: function() {
		    	//Change default zero value
		    	if($("#nidNo").val()=="0") $("#nidNo").val("");
		    	if($("#bridNo").val()=="0") $("#bridNo").val("");
		    	//Change date format and also be bangla
		    	$('#applicationStartDate').val($.app.e2b($.app.convertDate($('#applicationStartDate').val())));
		    	$('.applicationStartDate').html($.app.e2b($.app.convertDate($('.applicationStartDate').html())));
		    	//Set prvious address dropdown value after validate
		    	if(!'${applicant.placeOfBirth}'=="" || !'${applicant.placeOfBirth}'==0 ) $("#placeOfBirth").val('${applicant.placeOfBirth}');
		    	if(!'${applicant.address[0].districtId}'=="" || !'${applicant.address[0].districtId}'== 0 ) $("[name='address[0].districtId']").val('${applicant.address[0].districtId}');
		    	if(!'${applicant.address[0].upazilaId}'=="" || !'${applicant.address[0].upazilaId}'== 0 ) $("[name='address[0].upazilaId']").val('${applicant.address[0].upazilaId}');
		    	if(!'${applicant.address[1].districtId}'=="" || !'${applicant.address[1].districtId}'== 0 ) $("[name='address[1].districtId']").val('${applicant.address[1].districtId}');
		    	if(!'${applicant.address[1].upazilaId}'=="" || !'${applicant.address[1].upazilaId}'== 0 ) $("[name='address[1].upazilaId']").val('${applicant.address[1].upazilaId}');
		    	if(!'${applicant.religionId}'=="" || !'${applicant.religionId}'==0 ) $("#religionId").val('${applicant.religionId}');
		    	if(!'${applicant.occupationId}'=="" || !'${applicant.occupationId}'==0 ) $("#occupationId").val('${applicant.occupationId}');
		    	if(!'${applicant.educationalQualification[0].educationId}'=="" || !'${applicant.educationalQualification[0].educationId}'==0 ) $("[name='educationalQualification[0].educationId']").val('${applicant.educationalQualification[0].educationId}');
		    	if(!'${applicant.educationalQualification[0].passingYear}'=="" || !'${applicant.educationalQualification[0].passingYear}'==0 ) $("[name='educationalQualification[0].passingYear']").val('${applicant.educationalQualification[0].passingYear}');
			},
		    events: {
		        bindEvent: function () {
		        	$.applyToJob.events.loadUpazila();
		        	$.applyToJob.events.addMoreEducation();
		        	$.applyToJob.events.changePhoto();
		        	$.applyToJob.events.changeDOB();
		        	$.applyToJob.events.submitForm();
		        },
		        loadUpazila: function() {
			       	$(document).off('change', '#districtId0').on('change', '#districtId0', function(e){
			       		$.applyToJob.ajax.loadUpazilaSelect($("select#districtId0").val(), 1);
					});
			       	$(document).off('change', '#districtId1').on('change', '#districtId1', function(e){
			       		$.applyToJob.ajax.loadUpazilaSelect($("select#districtId1").val(), 2);
					});
				},
				addMoreEducation: function() {
			       	$(document).off('click', '#addMoreEdu').on('click', '#addMoreEdu', function(e){
			       		var len = $(".education-list li").length;
			       		
			        	if ( len >= 5 ) {
			        		$.toast('error','আপনি পাঁচটার বেশি পরীক্ষা যোগ করতে পারবেন না !');
			        	}else {
			        		
			        		$(".education-list").append($.html.addMoreEducation(len));
			        		$('.education-list li:last').hide().fadeIn();
			        		$.app.loadYear('.passingYear');
			    		}
					});
				},
				changePhoto: function() {
			       	$(document).off('change', '#changePhoto').on('change', '#changePhoto', function(e){
			            var file = $('#changePhoto').val();
			            var ext = file.split(".");
			            ext = ext[ext.length - 1].toLowerCase();
			            var arrayExtensions = ["jpg", "jpeg", "png"];

			            if (arrayExtensions.lastIndexOf(ext) == -1) {
			                toastr.error("<b>Invalid Photo. Only jpg, jpeg, and png accepted</b>");
			                file.val("");
			                return;
			            } 
			            $('#userPhoto').attr('src', window.URL.createObjectURL(this.files[0]));
//			            $.manageProfile.userUpdatedImage = this.files[0];
//			            $("#uploadPhoto").fadeIn("slow");
			        	
					});
				},
				changeDOB: function() {
			       	$(document).off('change', '#dob').on('change', '#dob', function(e){
			        	var age = getAge(getSysDateFormat($('#dob').val()),getDateNow());
			            $('#ageYear').val($.app.e2b(age.years));
			            $('#ageMonth').val($.app.e2b(age.months));
			            $('#ageDay').val($.app.e2b(age.days));
					});
				},
				submitForm: function(){
					$(document).off('submit', '#applyToJob').on('submit', '#applyToJob', function(e){
						$.app.formByName('#applyToJob :input').nidNo==""? $("#nidNo").val("0") : $("#nidNo").val($("#nidNo").val());
						$.app.formByName('#applyToJob :input').bridNo==""? $("#bridNo").val("0") : $("#bridNo").val($("#bridNo").val());
					});
				}
			    
		    },
		    ajax: {
		    	loadUpazilaSelect: function(id, i){
		    		if(id<1 || id==undefined || id==null)
		    			$.toast('error','District not yet selected');
		    		
		    		$.applyToJob.url = $('input[name="url-get-upazila-by-id"]').val();
		    		$.ajax({
		                type: "GET",
		                url: $.applyToJob.url,
		                data: {
	                		id: id
	                	},
		                success: function (result) {
		                	$.applyToJob.response = JSON.parse(result);
		                	
		                    if ($.applyToJob.response.success == true) {
		                    	$.app.loadSelect($.applyToJob.response.data,"উপজেলা সিলেক্ট করুন",$.applyToJob.ref.upazilaId[i]);
		                    	
		                    } else {
		                    	alert($.applyToJob.response.message);
		                    }
		                },
		                error: function (error) {
		                    alert(error);
		                }
		            });
		    	}
		    }
		}
	
		$.applyToJob.init();
		$.app.loadYear('.passingYear');
		window.removeEdu = function removeEdu(context) {
	    	$( context ).closest(".row").parent().fadeOut(300,function(){$(this).remove();});
	    }
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</script>
<script>
$(document).ready(function(){
   
});
</script>
