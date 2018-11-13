<%-- 
    Document   : Home
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="page">
	<div class="container">
		<br />
		<div class="section latest-jobs-ads">
			<div class="heading">
				<c:if test="${fn:length(recruitments) != 0}">
					<h2>নিয়োগ বিজ্ঞপ্তি</h2>
				</c:if>
				<c:if test="${fn:length(recruitments) == 0}">
					<p class="title no-vancy">এই মুহূর্তে কোনো নিয়োগ খালি নাই</p>
					<div class="row">
					  <div class="col-md-3"></div>
					  <div class="col-md-6">
					  	<img class="img-responsive" src="/bits/static/images/job-search.png" alt="Job Search">
					  </div>
					  <div class="col-md-3"></div>
					</div>
				</c:if>
			</div>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade in tab-pane fade in active" id="hot-jobs">
					<c:forEach var="recruitment" items="${recruitments}" varStatus="loop">
						<div class="job-ad-item">
							<div class="item-info">
								<div class="ad-info">
									<span><a class="title bold">${recruitment.designationName}</a></span>
									<div class="ad-meta">
										<ul>
											<li>
												<a><i class="fas fa-map-marker-alt"></i>স্থান: ${recruitment.jobLocation}, বাংলাদেশ</a>
											</li>
											<li>
												<a id="salary${loop.index}"><i class="fas fa-money-bill-alt"></i>টাকা: ৳ ${recruitment.salary}/- (${recruitment.grade} গ্রেড)</a>
											</li>
											<li>
												<a id="posNum${loop.index}"><i class="fas fa-user-tag"></i></i>পদের সংখ্যা: ${recruitment.positionNo} টি </a>
											</li>
										</ul>
									</div>
								</div>
								<div class="button">
									<a href="${pageContext.request.contextPath}/JobDetails?job=${recruitment.recruitmentId}" class="btn btn-primary btn-details"><b>বিস্তারিত</b></a>
									<a href="${pageContext.request.contextPath}/ApplyToJob?job=${recruitment.recruitmentId}" class="btn btn-primary btn-apply"><b>আবেদন করুন</b></a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>
<script>
	$(function() {
		$.home = {
		    init: function () {
		    	for(var i=0;i<'${fn:length(recruitments)}';i++){
					$('#salary'+i).html($.script.e2b($('#salary'+i).html()));
					$('#posNum'+i).html($.script.e2b($('#posNum'+i).html()));
				}
		    }
	    };
		$.home.init();
	});
</script>