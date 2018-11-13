<%-- 
    Document   : Home
    Created on : May 14, 2018, 07:40:08 PM
    Author     : Helal | m.helal.k@gmail.com
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/Header.jsp"%>

<section class="job-bg page job-details-page">
	<div class="container">

		<div class="job-details">
			<div class="section job-ad-item">
				<div class="item-info">
<!-- 					<div class="item-image-box"> -->
<!-- 						<div class="item-image"> -->
<!-- 							<img src="https://demo.themeregion.com/jobs-updated/images/job/7.png" alt="Image" class="img-responsive"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="ad-info">
						<span><a href="#" class="title">${job.designationName}</a></span>
						<div class="ad-meta">
							<ul>
								<li><a href="#"><i class="fa fa-map-marker" aria-hidden="true"></i>${job.jobLocation}, বাংলাদেশ</a></li>
								<li><a href="#"><i class="fa fa-clock-o" aria-hidden="true"></i>পূর্ণকাল</a></li>
								<li><i class="fa fa-money" aria-hidden="true"></i>৳ টাকা  ১১,০০০ ২৬,৫৯০/- (১৩ গ্রেড)</li>
								<li><a href="#"><i class="fa fa-tags" aria-hidden="true"></i> পদের সংখ্যা: ০৩ ( তিন টি ) </a></li>
								<li><i class="fa fa-hourglass-start" aria-hidden="true"></i>আবেদনের শেষ সময় : জানুয়ারি ১০, ২০১৮</li>
							</ul>
							<!-- 
								<ul>
									<li><a href="#"><i class="fa fa-map-marker" aria-hidden="true"></i> ঢাকা, বাংলাদেশ</a></li>
									<li><a href="#"><i class="fa fa-clock-o" aria-hidden="true"></i>পূর্ণকাল</a></li>
									<li><a href="#"><i class="fa fa-money" aria-hidden="true"></i>৳ টাকা ১১,০০০ ২৬,৫৯০/- (১৩ গ্রেড)</a></li>
									<li><a href="#"><i class="fa fa-tags" aria-hidden="true"></i>পদের সংখ্যা: ০৩ ( তিন টি )</a></li>
									<li><i class="fa fa-hourglass-start" aria-hidden="true"></i>Application Deadline : Jan 10, 2017</li>
								</ul> -->
						</div>
						<!-- ad-meta -->
					</div>
					<!-- ad-info -->
				</div>
				<!-- item-info -->
				<div class="social-media">
					<div class="button">
						<a href="${pageContext.request.contextPath}/ApplyToJob?job=<c:out value = "${param.job}" />" class="btn btn-primary"><i
							class="fa fa-briefcase" aria-hidden="true"></i>বিজ্ঞপ্তিতে আবেদন
							করুন</a> 
							<a class="btn btn-primary bookmark not-clickable">স্মারক নংঃ স্থাসবি/ রেজেকা/ জমিনি/ জনবল নিয়োগ-১৫১/২০১৬-৭৩</a>
					</div>
					
					
<!-- 					<ul class="share-social"> -->
<!-- 						<li>বিজ্ঞপ্তিটি শেয়ার করুন</li> -->
<!-- 						<li><a href="#"><i class="fa fa-facebook-official" -->
<!-- 								aria-hidden="true"></i></a></li> -->
<!-- 						<li><a href="#"><i class="fa fa-twitter-square" -->
<!-- 								aria-hidden="true"></i></a></li> -->
<!-- 						<li><a href="#"><i class="fa fa-google-plus-square" -->
<!-- 								aria-hidden="true"></i></a></li> -->
<!-- 						<li><a href="#"><i class="fa fa-linkedin-square" -->
<!-- 								aria-hidden="true"></i></a></li> -->
<!-- 						<li><a href="#"><i class="fa fa-pinterest-square" -->
<!-- 								aria-hidden="true"></i></a></li> -->
<!-- 						<li><a href="#"><i class="fa fa-tumblr-square" -->
<!-- 								aria-hidden="true"></i></a></li> -->
<!-- 					</ul> -->
					
					
				</div>
			</div>
			<!-- job-ad-item -->

			<div class="job-details-info">
				<div class="row">
					<div class="col-sm-8">
						<div class="section job-description">
							<div class="description-info">
								<h1>
									<b>বিবরণ:</b>
								</h1>
								<p>
									<span>Lorem ipsum dolor sit amet, consectetur
										adipisicing elit, sed do eiusmod tempor incididunt ut labore
										et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo
										consequat. Duis aute irure dolor in reprehenderit in voluptate
										velit esse cillum dolore eu fugiat nulla pariatur. Excepteur
										sint occaecat cupidatat non proident, sunt in culpa qui
										officia deserunt mollit anim id est laborum.</span>
								</p>
								<p>Sed ut perspiciatis unde omnis iste natus error sit
									voluptatem accusantium doloremque laudantium, totam rem
									aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
									architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam
									voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed
									quia consequuntur magni।</p>
							</div>
							<div class="responsibilities">
								<h1>
									<b>মূল দায়িত্ব:</b>
								</h1>
								<p>-Execute all visual design stages of website design from
									concept to final hand-off to development-Create print
									advertisements, social media advertisements, client collateral
									& digital resizes according to Client demands With direction of
									the Creative team, input into new design ideas for client
									branding-Update & keep all agency collateral materials,
									including keeping records of Client's logos, fonts, images,
									etc.</p>
							</div>
							<div class="requirements">
								<h1>
									<b>সর্বনিম্ন যোগ্যতা</b>
								</h1>
								<ul>
									<li>Bachelor's Degree</li>
									<li>2-5 years of relevant experience ( or equivalent
										educational experience)</li>
									<li>Experience developing in Wordpress and other web
										design platforms</li>
									<li>HTML, CSS and JavaScript experience a plus</li>
									<li>In depth knowledge & technical experience of
										Photoshop, Illustrator, InDesign, Adobe PDF, Keynote,
										PowerPoint, Microsoft Word & Excel</li>
									<li>Exceptional eye for design, deep understanding of
										creativity and ability to recognize fresh approaches to
										Advertising</li>
									<li>Must be fluent in Spanish; working written and spoken
										proficiency</li>
									<li>**All applicants must be eligible to work in the U.S.
										without sponsorship</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="section job-short-info">
							<h1 class="bold">সংক্ষিপ্ত তথ্য</h1>
							<ul>
								<li><span class="icon"><i class="fa fa-bolt"
										aria-hidden="true"></i></span>Posted: 1 day ago</li>
								<li><span class="icon"><i class="fa fa-user-plus"
										aria-hidden="true"></i></span> Job poster: <a href="#">Lance
										Ladaga</a></li>
								<li><span class="icon"><i class="fa fa-industry"
										aria-hidden="true"></i></span>Industry: <a href="#">Marketing and
										Advertising</a></li>
								<li><span class="icon"><i class="fa fa-line-chart"
										aria-hidden="true"></i></span>Experience: <a href="#">Entry level</a></li>
								<li><span class="icon"><i class="fa fa-key"
										aria-hidden="true"></i></span>Job function: Advertising,Design,
									Art/Creative</li>
							</ul>
						</div>
						<div class="section company-info">
							<h1 class="bold">প্রতিষ্ঠানের তথ্য</h1>
							<ul>
								<li>Compnay Name: <a href="#">Dropbox Inc</a></li>
								<li>Address: London, United Kingdom</li>
								<li>Compnay SIze: 2k Employee</li>
								<li>Industry: <a href="#">Technology</a></li>
								<li>Phone: +1234 567 8910</li>
								<li>Email: <a href="#">info@dropbox.com</a></li>
								<li>Website: <a href="#">www.dropbox.com</a></li>
							</ul>
							<ul class="share-social">
								<li><a href="#"><i class="fa fa-facebook-official"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter-square"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus-square"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin-square"
										aria-hidden="true"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- row -->
			</div>
			<!-- job-details-info -->
		</div>
		<!-- job-details -->
	</div>
	<!-- container -->
</section>
<!-- job-details-page -->
<%@include file="/WEB-INF/views/layouts/Footer.jsp"%>