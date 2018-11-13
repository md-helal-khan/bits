<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<script>
	//Validation started
	$.validator.setDefaults({
		debug : true,
		success : "valid"
	});
	// Login
	$("#login").validate({
		submitHandler : function(form) {
			if ($(form).valid())
				form.submit();
			return false;
		},

		success : function(label, element) {
			label.parent().removeClass('error');
			label.remove();
		},

		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : "<fmt:message key='NotEmpty.user.username' />"
			},
			password : {
				required : "পাসওয়ার্ড লিখুন"
			}
		}
	});
	
	
	// User Registration
	$.validator.addMethod("usernameRegex",function(value, element, regexp) {
		var patt1 = /^[a-zA-Z0-9_.]+$/;
		return value.match(patt1) != null? true:false;
	},"<fmt:message key='Pattern.user.username' />");
	
	$.validator.addMethod("whitespaceRegex",function(value, element, regexp) {
		var patt1 = /\s/g;
		return value.match(patt1) == null? true:false;
	},"<fmt:message key='Pattern.user.password' />");
	
	$.validator.addMethod("mobileNoRegex",function(value, element, regexp) {
		var patt1 = /^(01)(1|7|8|9|6)[0-9]{8}$/;
		return value.match(patt1) != null? true:false;
	},"<fmt:message key='Pattern.user.phone' />");
	
	$("#userRegistration, #forgotPassword, #setNewPassword").validate({
		submitHandler : function(form) {
			if ($(form).valid())
				form.submit();
			return false;
		},
		rules : {
			'userProfile.firstNameEng' : {
				required : true
			},
			'userProfile.lastNameEng' : {
				required : true
			},
			username : {
				required : true,
				usernameRegex: true,
				minlength: 6,
				maxlength: 30
				
			},
			password : {
				required : true,
				whitespaceRegex: true,
				minlength: 6,
				maxlength: 30
			},
			confirmPassword : {
				equalTo : "#password"
			},
			email : {
				required : true,
				email : true
			},
			phone : {
				required : true,
				number : true,
				mobileNoRegex: true
			}
		},
		messages : {
			'userProfile.firstNameEng' : {
				required : "<fmt:message key='NotEmpty.userProfile.firstNameEng' />"
			},
			'userProfile.lastNameEng' : {
				required : "<fmt:message key='NotEmpty.userProfile.lastNameEng' />"
			},
			username : {
				required : "<fmt:message key='NotEmpty.user.username' />",
				minlength: "<fmt:message key='Size.user.username' />",
				maxlength: "<fmt:message key='Size.user.username' />"
			},
			password : {
				required : "<fmt:message key='NotEmpty.user.password' />",
				minlength: "<fmt:message key='Size.user.password' />",
				maxlength: "<fmt:message key='Size.user.password' />"
			},
			confirmPassword : {
				equalTo : "পাসওয়ার্ড দুইটা একই হতে হবে"
			},
			email : {
				required : "<fmt:message key='NotEmpty.user.email' />",
				email : "<fmt:message key='Email.user.email' />"
			},
			phone : {
				required : "<fmt:message key='NotEmpty.user.email' />",
				number : "অবশ্যই নম্বর দিতে হবে"
			}
		}
	});
	
	
	
	$("#changePassword").validate({
		submitHandler : function(form) {
			if ($(form).valid())
				form.submit();
			return false;
		},
		rules : {
			a : {
				required : true,
				whitespaceRegex: true,
				minlength: 6,
				maxlength: 30
				
			},
			b : {
				required : true,
				whitespaceRegex: true,
				minlength: 6,
				maxlength: 30
			},
			c : {
				equalTo : "#b"
			}
		},
		messages : {
			a : {
				required : "<fmt:message key='NotEmpty.user.password' />",
				minlength: "<fmt:message key='Size.user.password' />",
				maxlength: "<fmt:message key='Size.user.password' />"
			},
			b : {
				required : "<fmt:message key='NotEmpty.user.password' />",
				minlength: "<fmt:message key='Size.user.password' />",
				maxlength: "<fmt:message key='Size.user.password' />"
			},
			c : {
				equalTo : "পাসওয়ার্ড দুইটা একই হতে হবে"
			}
		}
	});

	// Forgot Password
// 	$("#forgotPassword").validate({
// 		submitHandler : function(form) {
// 			if ($(form).valid())
// 				form.submit();
// 			return false;
// 		},
// 		rules : {
// 			email : {
// 				required : true,
// 				email : true
// 			}
// 		},
// 		messages : {
// 			email : {
// 				required : "<fmt:message key='NotEmpty.user.email' />",
// 				email : "<fmt:message key='Email.user.email' />"
// 			}
// 		}
// 	});
	
	//Event based validation
	$(function() {
		$.validation = {
		    init: function () {
		    	this.events.bindEvent();
		    },
		    url:null,
		    events: {
		        bindEvent: function () {
		        	$.validation.events.checkExistance();
		        },
		        checkExistance: function(){
					$(document).off('blur', '#userRegistration #username').on('blur', '#userRegistration #username', function(e){
						$.validation.url = $('input[name="url-check-username"]').val();
						$.get($.validation.url, { username: this.value } )
						 .done(function( response ) {
							 if(JSON.parse(response).data){
								$('#userRegistration #username').next('label').remove();
		                		$('#userRegistration #username').after('<label id="username-error" class="error" for="username"><fmt:message key="DuplicateKey.user.username" /></label>');
					 		}
					  	  })
					  	 .fail(function() {
					  		 console.log("Username can't check");
					  	  });
					});
					$(document).off('blur', '#userRegistration #email').on('blur submit', '#userRegistration #email', function(e){
						$.validation.url = $('input[name="url-check-email"]').val();
						$.get($.validation.url, { email: this.value } )
						 .done(function( response ) {
							 if(JSON.parse(response).data){
							 	$('#userRegistration #email').next('label').remove();
		                		$('#userRegistration #email').after('<label id="username-error" class="error" for="username"><fmt:message key="DuplicateKey.user.email" /></label><br/>');
							 }
						 })
					  	 .fail(function() {
					  		 console.log("Email can't check");
					  	  });
					});
				}
			    
		    }
		}
		$.validation.init();
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Applytojob Validation
	$.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	//Custom Validator
	$.validator.addMethod("past", function(value, element) {
	    var dob = $('#dob').val();
	    return parseInt(now.replace(/-/g,""),10) > parseInt($('#dob').val().replace(/-/g,""),10);
	}, "Please enter only past date");
    $.validator.addMethod('integer', function(value, element) {
        return (value != 0) && (value == parseInt(value, 10));
    }, 'Please enter a non zero integer value!');
    $.validator.addMethod('radio', function(value, element) {
        return (value != 0) || (value != undefined)
    }, 'select the item');
    
	$( "#applyToJob" ).validate({
		rules: {
			userPhoto:{
				required: true
			},
			nameBan: {
				required: true
			},
			nameEng: {
				required: true
			},
			nidNo: {
				required: true,
				number: true
			},
			bridNo: {
				required: true,
				number: true
			},
			dob: {
				required: true,
				past:true
			},
			placeOfBirth: {
				required: true,
				integer: true
				
			},
			motherName: {
				required: true
			},
			fatherName: {
				required: true
			},
			'address[0].districtId': {
				required: true,
				integer: true
            },
            'address[0].upazilaId': {
				required: true,
				integer: true
			},
			'address[0].postCode': {
				required: true,
				number:true
			},
			'address[0].postOffice': {
				required: true
			},
			'address[0].unionName': {
				required: true
			},
			'address[0].village': {
				required: true
			},
			'address[0].homeAndRoadNo': {
				required: true
			},
			'address[1].districtId': {
				required: true,
				integer: true
            },
            'address[1].upazilaId': {
				required: true,
				integer: true
			},
			'address[1].postCode': {
				required: true,
				number:true
			},
			'address[1].postOffice': {
				required: true
			},
			'address[1].unionName': {
				required: true
			},
			'address[1].village': {
				required: true
			},
			'address[1].homeAndRoadNo': {
				required: true
			},
			'user.phone': {
				required : true,
				number : true,
				mobileNoRegex: true
			},
			'user.email': {
				required : true,
				email : true
			},
			nationality: {
				required: true
			},
			genderId: {
				required: true
			},
			religionId: {
				required: true,
				integer: true
			},
			occupationId: {
				required: true,
				integer: true
			},
			//Education-1
            'educationalQualification[0].educationId': {
				required: true,
				integer: true
			},
			'educationalQualification[0].subject': {
				required: true
			},
			'educationalQualification[0].institutionName': {
				required: true
			},
			'educationalQualification[0].passingYear': {
				required: true,
				integer: true
			},
			'educationalQualification[0].boardOrUniversity': {
				required: true
			},
			'educationalQualification[0].gradeClassDivision': {
				required: true
			},
			//Education-2
            'educationalQualification[1].educationId': {
				required: true,
				integer: true
			},
			'educationalQualification[1].subject': {
				required: true
			},
			'educationalQualification[1].institutionName': {
				required: true
			},
			'educationalQualification[1].passingYear': {
				required: true,
				integer: true
			},
			'educationalQualification[1].boardOrUniversity': {
				required: true
			},
			'educationalQualification[1].gradeClassDivision': {
				required: true
			},
			//Education-3
            'educationalQualification[2].educationId': {
				required: true,
				integer: true
			},
			'educationalQualification[2].subject': {
				required: true
			},
			'educationalQualification[2].institutionName': {
				required: true
			},
			'educationalQualification[2].passingYear': {
				required: true,
				integer: true
			},
			'educationalQualification[2].boardOrUniversity': {
				required: true
			},
			'educationalQualification[2].gradeClassDivision': {
				required: true
			},
			//Education-4
            'educationalQualification[3].educationId': {
				required: true,
				integer: true
			},
			'educationalQualification[3].subject': {
				required: true
			},
			'educationalQualification[3].institutionName': {
				required: true
			},
			'educationalQualification[3].passingYear': {
				required: true,
				integer: true
			},
			'educationalQualification[3].boardOrUniversity': {
				required: true
			},
			'educationalQualification[3].gradeClassDivision': {
				required: true
			},
			//Education-5
            'educationalQualification[4].educationId': {
				required: true,
				integer: true
			},
			'educationalQualification[4].subject': {
				required: true
			},
			'educationalQualification[4].institutionName': {
				required: true
			},
			'educationalQualification[4].passingYear': {
				required: true,
				integer: true
			},
			'educationalQualification[4].boardOrUniversity': {
				required: true
			},
			'educationalQualification[4].gradeClassDivision': {
				required: true
			},
			additionalQualification: {
				required: true
			},
			experience: {
				required: true
			},
			quotaId: {
				required: true
			},
			'payment.paymentNo': {
				required: true
			},
			'payment.paymentDate': {
				required: true,
				past:true
			},
			'payment.bankName': {
				required: true
			},
			'payment.brunchName': {
				required: true
			},
			divisionalCandidateId: {
				required: true
			}
			
		},
		messages: {
			userPhoto:{
				required: "ছবি সংযোজন করুন"
			},
			nameBan: {
				required: "<fmt:message key='NotEmpty.applicant.nameBan' />"
			},
			nameEng: {
				required: "<fmt:message key='NotEmpty.applicant.nameEng' />"
			},
			nidNo:{
				required: "<fmt:message key='NotEmpty.applicant.nidNo' />",
				number: "<fmt:message key='Pattern.applicant.nidNo' />"
			},
			bridNo:{
				required: "<fmt:message key='NotEmpty.applicant.bridNo' />",
				number: "<fmt:message key='Pattern.applicant.bridNo' />"
			},
			dob:{
				required: "<fmt:message key='NotNull.applicant.dob' />",
				past: "<fmt:message key='Past.applicant.dob' />"
			},
			placeOfBirth:{
				required: "<fmt:message key='NotNull.applicant.placeOfBirth' />",
				integer: "<fmt:message key='Positive.applicant.placeOfBirth' />"
			},
			motherName:{
				required: "<fmt:message key='NotEmpty.applicant.fatherName' />"
			},
			fatherName:{
				required: "<fmt:message key='NotEmpty.applicant.motherName' />"
			},
			'address[0].districtId':{
				required: "<fmt:message key='NotNull.address.districtId' />",
				integer: "<fmt:message key='Positive.address.districtId' />"
			},
			'address[0].upazilaId':{
				required: "<fmt:message key='NotNull.address.upazilaId' />",
				integer: "<fmt:message key='Positive.address.upazilaId' />"
			},
			'address[0].postCode':{
				required: "<fmt:message key='NotEmpty.address.postCode' />",
				number: "<fmt:message key='Pattern.address.postCode' />"
			},
			'address[0].postOffice':{
				required: "<fmt:message key='NotEmpty.address.postOffice' />"
			},
			'address[0].unionName':{
				required: "<fmt:message key='NotEmpty.address.unionName' />"
			},
			'address[0].village':{
				required: "<fmt:message key='NotEmpty.address.village' />"
			},
			'address[0].homeAndRoadNo':{
				required: "<fmt:message key='NotEmpty.address.homeAndRoadNo' />"
			},
			'address[1].districtId':{
				required: "<fmt:message key='NotNull.address.districtId' />",
				integer: "<fmt:message key='Positive.address.districtId' />"
			},
			'address[1].upazilaId':{
				required: "<fmt:message key='NotNull.address.upazilaId' />",
				integer: "<fmt:message key='Positive.address.upazilaId' />"
			},
			'address[1].postCode':{
				required: "<fmt:message key='NotEmpty.address.postCode' />",
				number: "<fmt:message key='Pattern.address.postCode' />"
			},
			'address[1].postOffice':{
				required: "<fmt:message key='NotEmpty.address.postOffice' />"
			},
			'address[1].unionName':{
				required: "<fmt:message key='NotEmpty.address.unionName' />"
			},
			'address[1].village':{
				required: "<fmt:message key='NotEmpty.address.village' />"
			},
			'address[1].homeAndRoadNo':{
				required: "<fmt:message key='NotEmpty.address.homeAndRoadNo' />"
			},
			'user.phone':{
				required : "<fmt:message key='NotEmpty.user.email' />",
				number : "অবশ্যই নম্বর দিতে হবে"
			},
			'user.email':{
				required : "<fmt:message key='NotEmpty.user.email' />",
				email : "<fmt:message key='Email.user.email' />"
			},
			nationality:{
				required: "<fmt:message key='NotEmpty.applicant.nationality' />"
			},
			genderId:{
				required: "<fmt:message key='NotNull.applicant.genderId' />"
			},
			religionId:{
				required: "<fmt:message key='NotNull.applicant.religionId' />",
				integer: "<fmt:message key='Positive.applicant.religionId' />"
			},
			occupationId:{
				required: "<fmt:message key='NotNull.applicant.occupationId' />",
				integer: "<fmt:message key='Positive.applicant.occupationId' />"
			},
			//Education-1
            'educationalQualification[0].educationId': {
            	required: "<fmt:message key='NotNull.educationalQualification.educationId' />",
				integer: "<fmt:message key='Positive.educationalQualification.educationId' />"
			},
			'educationalQualification[0].subject': {
				required: "<fmt:message key='NotEmpty.educationalQualification.subject' />"
			},
			'educationalQualification[0].institutionName': {
				required: "<fmt:message key='NotEmpty.educationalQualification.institutionName' />"
			},
			'educationalQualification[0].passingYear': {
				required: "<fmt:message key='NotNull.educationalQualification.passingYear' />",
				integer: "<fmt:message key='Positive.educationalQualification.passingYear' />"
			},
			'educationalQualification[0].boardOrUniversity': {
				required: "<fmt:message key='NotEmpty.educationalQualification.boardOrUniversity' />"
			},
			'educationalQualification[0].gradeClassDivision': {
				required: "<fmt:message key='NotEmpty.educationalQualification.gradeClassDivision' />"
			},
			//Education-2
            'educationalQualification[1].educationId': {
            	required: "<fmt:message key='NotNull.educationalQualification.educationId' />",
				integer: "<fmt:message key='Positive.educationalQualification.educationId' />"
			},
			'educationalQualification[1].subject': {
				required: "<fmt:message key='NotEmpty.educationalQualification.subject' />"
			},
			'educationalQualification[1].institutionName': {
				required: "<fmt:message key='NotEmpty.educationalQualification.institutionName' />"
			},
			'educationalQualification[1].passingYear': {
				required: "<fmt:message key='NotNull.educationalQualification.passingYear' />",
				integer: "<fmt:message key='Positive.educationalQualification.passingYear' />"
			},
			'educationalQualification[1].boardOrUniversity': {
				required: "<fmt:message key='NotEmpty.educationalQualification.boardOrUniversity' />"
			},
			'educationalQualification[1].gradeClassDivision': {
				required: "<fmt:message key='NotEmpty.educationalQualification.gradeClassDivision' />"
			},
			//Education-3
            'educationalQualification[2].educationId': {
            	required: "<fmt:message key='NotNull.educationalQualification.educationId' />",
				integer: "<fmt:message key='Positive.educationalQualification.educationId' />"
			},
			'educationalQualification[2].subject': {
				required: "<fmt:message key='NotEmpty.educationalQualification.subject' />"
			},
			'educationalQualification[2].institutionName': {
				required: "<fmt:message key='NotEmpty.educationalQualification.institutionName' />"
			},
			'educationalQualification[2].passingYear': {
				required: "<fmt:message key='NotNull.educationalQualification.passingYear' />",
				integer: "<fmt:message key='Positive.educationalQualification.passingYear' />"
			},
			'educationalQualification[2].boardOrUniversity': {
				required: "<fmt:message key='NotEmpty.educationalQualification.boardOrUniversity' />"
			},
			'educationalQualification[2].gradeClassDivision': {
				required: "<fmt:message key='NotEmpty.educationalQualification.gradeClassDivision' />"
			},
			//Education-4
            'educationalQualification[3].educationId': {
            	required: "<fmt:message key='NotNull.educationalQualification.educationId' />",
				integer: "<fmt:message key='Positive.educationalQualification.educationId' />"
			},
			'educationalQualification[3].subject': {
				required: "<fmt:message key='NotEmpty.educationalQualification.subject' />"
			},
			'educationalQualification[3].institutionName': {
				required: "<fmt:message key='NotEmpty.educationalQualification.institutionName' />"
			},
			'educationalQualification[3].passingYear': {
				required: "<fmt:message key='NotNull.educationalQualification.passingYear' />",
				integer: "<fmt:message key='Positive.educationalQualification.passingYear' />"
			},
			'educationalQualification[3].boardOrUniversity': {
				required: "<fmt:message key='NotEmpty.educationalQualification.boardOrUniversity' />"
			},
			'educationalQualification[3].gradeClassDivision': {
				required: "<fmt:message key='NotEmpty.educationalQualification.gradeClassDivision' />"
			},
			//Education-5
            'educationalQualification[4].educationId': {
            	required: "<fmt:message key='NotNull.educationalQualification.educationId' />",
				integer: "<fmt:message key='Positive.educationalQualification.educationId' />"
			},
			'educationalQualification[4].subject': {
				required: "<fmt:message key='NotEmpty.educationalQualification.subject' />"
			},
			'educationalQualification[4].institutionName': {
				required: "<fmt:message key='NotEmpty.educationalQualification.institutionName' />"
			},
			'educationalQualification[4].passingYear': {
				required: "<fmt:message key='NotNull.educationalQualification.passingYear' />",
				integer: "<fmt:message key='Positive.educationalQualification.passingYear' />"
			},
			'educationalQualification[4].boardOrUniversity': {
				required: "<fmt:message key='NotEmpty.educationalQualification.boardOrUniversity' />"
			},
			'educationalQualification[4].gradeClassDivision': {
				required: "<fmt:message key='NotEmpty.educationalQualification.gradeClassDivision' />"
			},
			additionalQualification:{
				required: "<fmt:message key='NotEmpty.applicant.additionalQualification' />"
			},
			experience:{
				required: "<fmt:message key='NotEmpty.applicant.experience' />"
			},
			quotaId:{
				required: "<fmt:message key='NotNull.applicant.quotaId' />"
			},
			'payment.paymentNo':{
				required: "<fmt:message key='NotEmpty.payment.paymentNo' />"
			},
			'payment.paymentDate':{
				required: "<fmt:message key='NotNull.payment.paymentDate' />",
				past: "<fmt:message key='Past.payment.paymentDate' />"
			},
			'payment.bankName':{
				required: "<fmt:message key='NotEmpty.payment.bankName' />"
			},
			'payment.brunchName':{
				required: "<fmt:message key='NotEmpty.payment.brunchName' />"
			},
			divisionalCandidateId:{
				required: "<fmt:message key='NotNull.applicant.divisionalCandidateId' />"
			}
		}
	});
</script>