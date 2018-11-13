$(function () {
    $.html = {
		addMoreEducation :  function (index) {
			
			var one =  '<li>\
			<div class="row form-group">\
			<label class="col-md-2 label-title">পরীক্ষার নাম :</label>\
			<div class="col-md-4">\
				<sf:select class="form-control" path="educationalQualification['+index+'].educationId" name="educationalQualification['+index+'].educationId" id="educationId">\
					<option value="">পরীক্ষার নাম সিলেক্ট করুন</option>\
					<option value="1">৫ম শ্রেণী </option>\
					<option value="2">৮ম শ্রেণী </option>\
					<option value="3">এস এস সি</option>\
					<option value="4">এইচ এস সি</option>\
					<option value="5">অনার্স</option>\
					<option value="6">মাস্টার্স</option>\
				</sf:select>\
				<sf:errors path="educationalQualification['+index+'].educationId" cssClass="error" />\
			</div>\
			<label class="col-md-2 label-title">বিষয় :</label>\
			<div class="col-md-4">\
				<sf:input type="text" path="educationalQualification['+index+'].subject" name="educationalQualification['+index+'].subject" id="subject" class="form-control" placeholder="" />\
				<sf:errors path="educationalQualification['+index+'].subject" cssClass="error" />\
			</div>\
		</div>\
		<div class="row form-group">\
			<label class="col-md-2 label-title">শিক্ষা প্রতিষ্ঠান :</label>\
			<div class="col-md-4">\
				<sf:input type="text" path="educationalQualification['+index+'].institutionName" name="educationalQualification['+index+'].institutionName" id="institutionName" class="form-control" placeholder="" />\
				<sf:errors path="educationalQualification['+index+'].institutionName" cssClass="error" />\
			</div>\
			<label class="col-md-2 label-title">পাশের সন :</label>\
			<div class="col-md-4">\
				<sf:select class="form-control passingYear" path="educationalQualification['+index+'].passingYear" name="educationalQualification['+index+'].passingYear" id="passingYear">\
					<option value="1">2018</option>\
				</sf:select>\
				<sf:errors path="educationalQualification['+index+'].passingYear" cssClass="error" />\
			</div>\
		</div>\
		<div class="row form-group">\
			<label class="col-md-2 label-title">বোর্ড/বিশ্ববিদ্যালয় :</label>\
			<div class="col-md-4">\
				<sf:input type="text" path="educationalQualification['+index+'].boardOrUniversity" name="educationalQualification['+index+'].boardOrUniversity" id="boardOrUniversity" class="form-control" placeholder=""/>\
				<sf:errors path="educationalQualification['+index+'].boardOrUniversity" cssClass="error" />\
			</div>\
			<label class="col-md-2 label-title">গ্রেড/শ্রেণী/বিভাগ :</label>\
			<div class="col-md-4">\
				<sf:input type="text" path="educationalQualification['+index+'].gradeClassDivision" name="educationalQualification['+index+'].gradeClassDivision" id="gradeOrDivision" class="form-control" placeholder=""/>\
				<sf:errors path="educationalQualification['+index+'].gradeClassDivision" cssClass="error" />\
			</div>\
		</div>\
	</li>';
			
			
			
			
	        var two =  '<li class="edu">'
								+'<div class="row form-group">'
								+'<div class="col-md-1 col-md-offset-11"><button type="button" onclick="removeEdu(this)" class="form-control btn-link edu-remove"><i class="fa fa-window-close" aria-hidden="true"></i></button></div>'
//								+'<div class="col-md-12 col-md-offset-8 close"><button type="button" onclick="removeEdu(this)" class="form-control btn btn-sm btn-danger delete-edu"><b><i class="fa fa-times-circle-o" aria-hidden="true"></i></b></button></div>'
								+'<label class="col-md-2 label-title">পরীক্ষার নাম :</label>'
								+'<div class="col-md-4">'
									+'<select class="form-control" name="educationalQualification['+index+'].educationId" id="educationId'+index+'">'
										+'<option value="">পরীক্ষার নাম সিলেক্ট করুন</option>'
										+'<option value="1">৫ম শ্রেণী </option>'
										+'<option value="2">৮ম শ্রেণী </option>'
										+'<option value="3">এস এস সি</option>'
										+'<option value="4">এইচ এস সি</option>'
										+'<option value="5">অনার্স</option>'
										+'<option value="6">মাস্টার্স</option>'
										+'</select>'
								+'</div>'
								+'<label class="col-md-2 label-title">বিষয় :</label>'
								+'<div class="col-md-4">'
									+'<input type="text" name="educationalQualification['+index+'].subject" id="subject'+index+'" class="form-control" placeholder="">'
								+'</div>'
								+'</div>'
								+'<div class="row form-group">'
									+'<label class="col-md-2 label-title">শিক্ষা প্রতিষ্ঠান :</label>'
									+'<div class="col-md-4">'
										+'<input type="text" name="educationalQualification['+index+'].institutionName" id="institutionName'+index+'" class="form-control" placeholder="">'
									+'</div>'
									+'<label class="col-md-2 label-title">পাশের সন :</label>'
									+'<div class="col-md-4">'
										+'<select class="form-control passingYear" name="educationalQualification['+index+'].passingYear" id="passingYear'+index+'">'
											+'<option value="1">2018</option>'
										+'</select>'
									+'</div>'
								+'</div>'
						
								+'<div class="row form-group">'
									+'<label class="col-md-2 label-title">বোর্ড/বিশ্ববিদ্যালয় :</label>'
									+'<div class="col-md-4">'
										+'<input type="text" name="educationalQualification['+index+'].boardOrUniversity" id="boardOrUniversity'+index+'" class="form-control" placeholder="">'
									+'</div>'
									+'<label class="col-md-2 label-title">গ্রেড/শ্রেণী/বিভাগ :</label>'
									+'<div class="col-md-4">'
										+'<input type="text" name="educationalQualification['+index+'].gradeClassDivision" id="gradeClassDivision'+index+'" class="form-control" placeholder="">'
									+'</div>'
								+'</div>'
							+'</li>';
	        
	        return two;
	    }
    };
});