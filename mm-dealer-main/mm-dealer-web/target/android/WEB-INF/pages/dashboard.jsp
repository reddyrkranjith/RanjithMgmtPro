<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dashboard</title>
<base
	href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<!-- Global stylesheets -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900"
	rel="stylesheet" type="text/css">
<link href="resources/assets/css/icons/icomoon/styles.css"
	rel="stylesheet" type="text/css">
<link href="resources/assets/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="resources/assets/css/core.css" rel="stylesheet"
	type="text/css">
<link href="resources/assets/css/components.css" rel="stylesheet"
	type="text/css">
<link href="resources/assets/css/colors.css" rel="stylesheet"
	type="text/css">
<link href="resources/assets/css/custom.css" rel="stylesheet"
	type="text/css">
<!-- /global stylesheets -->

<!-- Core JS files -->
<script type="text/javascript"
	src="resources/assets/js/core/libraries/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/assets/js/core/libraries/bootstrap.min.js"></script>
<script type="text/javascript"
	src="resources/assets/js/plugins/ui/nicescroll.min.js"></script>
<script type="text/javascript"
	src="resources/assets/js/plugins/ui/drilldown.js"></script>
<!-- /core JS files -->

<!-- Theme JS files -->
<script type="text/javascript"
	src="resources/assets/js/plugins/forms/styling/uniform.min.js"></script>
<script type="text/javascript"
	src="resources/assets/js/plugins/forms/selects/select2.min.js"></script>
<script type="text/javascript" src="resources/assets/js/core/app.js"></script>
<!-- /theme JS files -->
</head>
<body>
	<!-- Fixed navbars wrapper -->
	<jsp:include page="templates/header.jsp" />
	<!-- /fixed navbars wrapper -->




	<!-- Footer -->
	<jsp:include page="templates/footer.jsp"></jsp:include>
	<!-- /footer -->

	<script type="text/javascript">
		$(function() {
			// Select2
			$('.select').select2();
			// Default initialization
			$(".styled").uniform({
				radioClass : 'choice',
				wrapperClass : 'border-primary-600 text-primary-800'
			});
			
		});
	</script>
</body>
</html>