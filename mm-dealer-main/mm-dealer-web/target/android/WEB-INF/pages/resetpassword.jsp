<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
	<!-- Global stylesheets -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" rel="stylesheet" type="text/css">
	<link href="resources/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
	<link href="resources/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="resources/assets/css/core.css" rel="stylesheet" type="text/css">
	<link href="resources/assets/css/components.css" rel="stylesheet" type="text/css">
	<link href="resources/assets/css/colors.css" rel="stylesheet" type="text/css">
	<!-- /global stylesheets -->

	<!-- Core JS files -->
	<script type="text/javascript" src="resources/assets/js/plugins/loaders/pace.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/core/libraries/jquery.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/core/libraries/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/plugins/loaders/blockui.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/plugins/ui/nicescroll.min.js"></script>
	<script type="text/javascript" src="resources/assets/js/plugins/ui/drilldown.js"></script>
	<!-- /core JS files -->

	<!-- Theme JS files -->
	<script type="text/javascript" src="resources/assets/js/plugins/forms/styling/uniform.min.js"></script>

	<script type="text/javascript" src="resources/assets/js/core/app.js"></script>
	<script type="text/javascript" src="resources/assets/js/pages/login.js"></script>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
	<!-- /theme JS files -->

</head>

<body class="login-container">

	<!-- Page container -->
	<div class="page-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Advanced login -->
				<form:form role="form" commandName="resetPass" action="resetpassword" method="POST" id="forgot_pass_form">
					<div class="panel panel-body login-form">
						<div class="text-center">
							<div class="icon-object border-slate-300 text-slate-300"><i class="icon-reading"></i></div>
							<h5 class="content-group">Reset Password below</h5>
						</div>
						<c:if test="${error ne null}">
							<div class="alert alert-danger" role="alert">
							  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							  <strong>Error!</strong> ${error}
							</div>
						</c:if>
						<div class="form-group has-feedback has-feedback-left">
							<form:input type="hidden" class="form-control" name="token" path="token"></form:input>
						</div>
						<div class="form-group has-feedback has-feedback-left">
							<form:input type="password" class="form-control" name="password" path="password" placeholder="Password"></form:input>
							<div class="form-control-feedback">
								<i class="icon-user text-muted"></i>
							</div>
						</div>
						<div class="form-group has-feedback has-feedback-left">
							<form:input type="password" class="form-control" name="confirmPassword" path="confirmPassword" placeholder="Re-Enter Password"></form:input>
							<div class="form-control-feedback">
								<i class="icon-user text-muted"></i>
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-block">Submit <i class="icon-circle-right2 position-right"></i></button>
						</div>
					</div>
				</form:form>
				<!-- /advanced login -->

			</div>
			<!-- /main content -->

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->
	<script type="text/javascript">
 
   $(document).ready(function() {
	   window.setTimeout(function() {
		    $(".alert").fadeTo(500, 0).slideUp(500, function(){
		        $(this).remove(); 
		    });
		}, 4000);
    $('#forgot_pass_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	email: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your email'
                    }
                }
            }       		
            }
        });
});
 
</script>
</body>
</html>
