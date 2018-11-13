﻿$(document).ready(function(){
	/*

     var form = {
    		userPhoto: $('#userPhoto').attr('src'),
    		designationName: $('#designationName').val(),
    		memorandum: $('#memorandum').val(),
    		applicationStartDate: $('#applicationStartDate').val(),
    		nameBan: $('#nameBan').val(),
    		nameEng: $('#nameEng').val(),
    		nidNo: $('#nidNo').val(),
    		bridNo:$('#bridNo').val(),
    		dob:$('#dob').val(),
    		placeOfBirthId: $('#placeOfBirth').val(),
    		placeOfBirth: $('#placeOfBirth :selected').text(),
    		ageYear: $('#ageYear').val(),
    		ageMonth: $('#ageMonth').val(),
    		ageDay: $('#ageDay').val(),
    		motherNameBan: $('#motherNameBan').val(),
    		fatherNameBan: $('#fatherNameBan').val(),
    		homeAndRoadCurrnt: $('#homeAndRoadCurrnt').val(),
    		homeAndRoadPermanant: $('#homeAndRoadPermanant').val(),
    		villageCurrnt: $('#villageCurrnt').val(),
    		villagePermanant: $('#villagePermanant').val(),
    		unionNameCurrnt: $('#unionNameCurrnt').val(),
    		unionNamePermanant: $('#unionNamePermanant').val(),
    		postOfficeCurrent: $('#postOfficeCurrent').val(),
    		postOfficePermanant: $('#postOfficePermanant').val(),
    		postCodeCurrent: $('#postCodeCurrent').val(),
    		postCodePermanant: $('#postCodePermanant').val(),
    		upazilaIdCurrnt: $('#upazilaIdCurrnt').val(),
    		upazilaIdPermanant: $('#upazilaIdPermanant').val(),
    		districtIdCurrnt: $('#districtIdCurrnt').val(),
    		districtIdPermanant: $('#districtIdPermanant').val(),
    		phone: $('#phone').val(),
    		email: $('#email').val(),
    		nationality: $('#nationality').val(),
    		
    		genderId: $("input[name='genderId']:checked").val(),
    		gender: $("input[name='genderId']:checked").next('label').text(),
    		
    		religionId: $('#religionId').val(),
    		religion: $('#religionId :selected').text(),
    		occupationId: $('#occupationId').val(),
    		occupation: $('#occupationId :selected').text(),
    		
    		additionalQualification:$('#additionalQualification').val(),
    		experience:$('#experience').val(),
    		
    		quotaId: $("input[name='quotaId']:checked").val(),
    		
    		paymentNo:$('#paymentNo').val(),
    		paymentDate:$('#paymentDate').val(),
    		
    		
    		bankName:$('#bankName').val(),
    		brunchName:$('#brunchName').val(),
    		
    		divisionalCandidateId:$('#divisionalCandidateId').val(),
    		
    		memorandum:$('#memorandum').val(),
    		memorandum:$('#memorandum').val(),
    		memorandum:$('#memorandum').val(),
    		memorandum:$('#memorandum').val(),
    		memorandum:$('#memorandum').val(),
    		memorandum:$('#memorandum').val()
			};
    
    $("#confirmationToApply").click(function(){
    	 $('#userPhoto_').attr('src',$('#userPhoto').attr('src'));
    	 
    	$('#designationName_').html(form.designationName);
    	$('#memorandum_').html(form.memorandum);
    	var applicationStartDate = form.applicationStartDate.split('/');
    	$('#applicationStartDateDay').html(e2b(applicationStartDate[0]));
    	$('#applicationStartDateMonth').html(e2b(applicationStartDate[1]));
    	$('#applicationStartDateYear').html(e2b(applicationStartDate[2]));
    	$('#nameBan_').html($('#nameBan').val());
    	$('#nameEng_').html($('#nameEng').val());
    	$('#nidNo_').html($('#nidNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	var dob = getDateJson($('#dob').val());
    	$('#dobYear_').html(e2b(dob.year));
    	$('#dobMonth_').html(e2b(dob.month));
    	$('#dobDay_').html(e2b(dob.day));
    	$('#placeOfBirth_').html($('#placeOfBirth :selected').text());
    	$('#ageYear_').html(e2b($('#ageYear').val()));
    	$('#ageMonth_').html(e2b($('#ageMonth').val()));
    	$('#ageDay_').html(e2b($('#ageDay').val()));
    	$('#motherNameBan_').html($('#motherNameBan').val());
    	$('#fatherNameBan_').html($('#fatherNameBan').val());
    	$('#homeAndRoadCurrnt_').html($('#homeAndRoadCurrnt').val());
    	$('#homeAndRoadPermanant_').html($('#homeAndRoadPermanant').val());
    	$('#villageCurrnt_').html($('#villageCurrnt').val());
    	$('#villagePermanant_').html($('#villagePermanant').val());
    	$('#unionNameCurrnt_').html($('#unionNameCurrnt').val());
    	$('#unionNamePermanant_').html($('#unionNamePermanant').val());
    	$('#postOfficeCurrent_').html($('#postOfficeCurrent').val());
    	$('#postOfficePermanant_').html($('#postOfficePermanant').val());
    	$('#postCodeCurrent_').html($('#postCodeCurrent').val());
    	$('#postCodePermanant_').html($('#postCodePermanant').val());
    	$('#upazilaIdCurrnt_').html($('#upazilaIdCurrnt').val());
    	$('#upazilaIdPermanant_').html($('#upazilaIdPermanant').val());
    	$('#districtIdCurrnt_').html($('#districtIdCurrnt').val());
    	$('#districtIdPermanant_').html($('#districtIdPermanant').val());
    	$('#phone_').html($('#phone').val());
    	$('#email_').html($('#email').val());
    	$('#nationality_').html($('#nationality').val());
    	$('#genderId_').html($("input[name='genderId']:checked").next('label').text());
    	$('#religionId_').html($('#religionId :selected').text());
    	$('#occupationId_').html($('#occupationId :selected').text());
    	
    	//Clear previous education data
    	for(var i=0; i<5; i++){
    		var id = i+1;
    		$('#educationId'+id+'_').html("&nbsp;");
    		$('#subject'+id+'_').html("");
    		$('#institutionName'+id+'_').html("");
    		$('#boardOrUniversity'+id+'_').html("");
    		$('#passingYear'+id+'_').html("");
    		$('#gradeOrDivision'+id+'_').html("");
    	}
    	for(var i=0; i<$(".education-list li").length; i++){
    		var id = i+1;
    		$('#educationId'+id+'_').html($(".education-list li:eq("+i+")").find('#educationId :selected').text());
    		
    		$('#subject'+id+'_').html($(".education-list li:eq("+i+")").find('#subject').val());
    		$('#institutionName'+id+'_').html($(".education-list li:eq("+i+")").find('#institutionName').val());
    		$('#boardOrUniversity'+id+'_').html($(".education-list li:eq("+i+")").find('#boardOrUniversity').val());
    		$('#passingYear'+id+'_').html($(".education-list li:eq("+i+")").find('#passingYear :selected').text());
    		$('#gradeOrDivision'+id+'_').html($(".education-list li:eq("+i+")").find('#gradeOrDivision').val());
    	}
    	
    	
    	
    	$('#additionalQualification_').html($('#additionalQualification').val());
    	$('#experience_').html($('#experience').val());
    	
    	
    	//Clear previous quota data
    	for(var i=0; i<5; i++){
    		var id = i+1;
    		$('#quotaId'+id+'_').html("");
    	}
    	$('#quotaId'+parseInt($("input[name='quotaId']:checked").val())+'_').html("✔");
    	
    	
    		
    	$('#paymentNo_').html($('#paymentNo').val());
    	
    	var paymentDate = $('#paymentDate').val().split('/');
    	$('#paymentDateDay').html(e2b(paymentDate[0]));
    	$('#paymentDateMonth').html(e2b(paymentDate[1]));
    	$('#paymentDateYear').html(e2b(paymentDate[2]));
    	
    	
    	$('#bankName_').html($('#bankName').val());
    	$('#brunchName_').html($('#brunchName').val());
    	
    	//Clear previous quota data
    	for(var i=0; i<3; i++){
    		var id = i+1;
    		$('#divisionalCandidateId'+id+'_').html("");
    	}
    	$('#divisionalCandidateId'+parseInt($("input[name='divisionalCandidateId']:checked").val())+'_').html("✔");
    	
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	$('#bridNo_').html($('#bridNo').val());
    	
    	
    	//$('#applicationForm').modal('show');
    	
    });
    
    */
});





