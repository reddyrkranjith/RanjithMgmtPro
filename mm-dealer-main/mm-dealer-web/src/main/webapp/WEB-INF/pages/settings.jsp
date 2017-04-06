<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
<script type="text/javascript"
	src="resources/assets/js/plugins/forms/inputs/duallistbox.min.js"></script>
<!-- /core JS files -->

<!-- Theme JS files -->
<script type="text/javascript"
	src="resources/assets/js/plugins/forms/styling/uniform.min.js"></script>
<script type="text/javascript"
	src="resources/assets/js/plugins/forms/selects/select2.min.js"></script>
<script type="text/javascript" src="resources/assets/js/core/app.js"></script>

<style>
#user_table  td:nth-child(3) {
	text-align: left;
}

#user_table  td:nth-child(4) {
	text-align: left;
}

#user_table  td:nth-child(5) {
	text-align: left;
}

#user_table  td:nth-child(6) {
	text-align: left;
}

#user_table  td:nth-child(7) {
	text-align: left;
}

#user_table  td:nth-child(8) {
	text-align: left;
}

#user_table  td:nth-child(9) {
	text-align: left;
}
</style>

</head>
<body class="navbar-top-md-md">
	<!-- Fixed navbars wrapper -->
	<%@ include file="templates/header.jsp" %>
	<!-- /fixed navbars wrapper -->
	
	<!-- Page container -->
	<div class="page-container">
		<!-- Page content -->
		<div class="page-content">
			<!-- Main content -->
			<div class="content-wrapper">
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-flat">
							<!-- Panel heading -->
							<div class="panel-heading">
								<h6 class="panel-title">
									Settings<a class="heading-elements-toggle"><i
										class="icon-more"></i></a>
								</h6>
							</div>
							<!-- /Panel heading -->
							<!-- Panel body start -->
							<form modelAttribute="searchform" id="formSearch" action="#">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Branch</label>
											<form:select data-placeholder="Branch"
												class="select  select2-hidden-accessible"
												data-minimum-results-for-search="Infinity" tabindex="-1"
												aria-hidden="true" path="searchForm.department">
												<c:if test="${not empty departments}">
													<c:forEach items="${departments}" var="departmentItem">
														<option value="${departmentItem.deptId}">${departmentItem.deptName}</option>
													</c:forEach>
												</c:if>
											</form:select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="display-block text-semibold" style="margin-bottom: 14px;">Select Year</label>
											<c:if test="${not empty acadamicYears}">
												<c:forEach items="${acadamicYears}" var="yearItem" varStatus="count">
												<label class="radio-inline">
												<form:radiobutton path="searchForm.year" name="year" class="styled" value="${yearItem}" checked="checked"/>
													${yearItem.description}
												</label>
												</c:forEach>
											</c:if>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="display-block text-semibold" style="margin-bottom: 14px;">Select Semester</label>
											<c:if test="${not empty acadamicSemisters}">
												<c:forEach items="${acadamicSemisters}" var="semisterItem" varStatus="count">
													<label class="radio-inline">
													<form:radiobutton  path="searchForm.semister" name="semister" class="styled" value="${semisterItem}" checked="checked"/>
														${semisterItem.description}
													</label>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</div>
								<!-- Tabs Panel -->
								<div class="tabbable">
									<ul class="nav nav-tabs nav-tabs-bottom"
										style="margin-left: -20px; margin-right: -20px;">
										<li class="active"><a href="#ulm-tab1" data-toggle="tab"
											aria-expanded="true">User Assignments</a></li>
										<li class=""><a href="#ulm-tab2" data-toggle="tab"
											aria-expanded="false">Subjects</a></li>
										<li class=""><a href="#ulm-tab3" data-toggle="tab"
											aria-expanded="false">Topics</a></li>
										<li class=""><a href="#ulm-tab4" data-toggle="tab"
											aria-expanded="false">Users</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active" id="ulm-tab1">
										</div>
										<div class="tab-pane" id="ulm-tab4">
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>User ID</label> <input class="form-control"
															type="text" placeholder="Enter User ID...">
													</div>
												</div>
												<div class="col-md-2" style="text-align: left;">
													<div class="form-group">
														<label style="display: block; visibility: hidden;">Submit</label>
														<button type="button" class="btn btn-info">Add</button>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="display-block">Data Upload</label>
														<div class="uploader">
															<input type="file" class="file-styled">
														</div>
														<span class="help-block">Accepted formats: xls,
															xlsx, txt, csv. Max file size 2Mb</span>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-2" style="text-align: left;">
													<div class="form-group">
														<label style="display: block; visibility: hidden;">Send
															Email</label>
														<button type="button" class="btn btn-primary">
															Send Email</button>
														<button type="button" class="btn btn-default">
															Cancel</button>
													</div>
												</div>
											</div>
											<div class="row"
												style="margin-bottom: -20px; margin-left: -20px; margin-right: -20px;">
												<div class="table-responsive">
													<table
														class="table table-striped table-xxs table-hover text-center"
														id="user_table">
														<thead>
															<tr>
																<th width="5%" class="text-center"><input
																	type="checkbox" class="styled"></th>
																<th width="5%" class="text-center">S No.</th>
																<th width="10%" class="text-left">User ID</th>
																<th width="15%" class="text-left">Name</th>
																<th width="5%" class="text-left">Mobile</th>
																<th width="15%" class="text-left">Email</th>
																<th width="10%" class="text-left">Year</th>
																<th width="10%" class="text-left">Unique Id</th>
																<th width="10%" class="text-left">Password</th>
																<th width="10%" class="text-center">Actions</th>
															</tr>
														</thead>
														<tbody>
															
														</tbody> 
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /Tabs Panel -->
							</div>
							</form>
							<!-- /Panel body start -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file="templates/footer.jsp" %>
	<!-- /footer -->
	
	<script type="text/javascript" src="resources/custom/js/settings.js"></script>
	<script type="text/javascript">
		$(function() {
			// Select2
			$('.select').select2();
			// Default initialization
			$(".styled").uniform({
				radioClass : 'choice',
				wrapperClass : 'border-primary-600 text-primary-800'
			});
			// Multiple selection
			$('.listbox-no-selection').bootstrapDualListbox({
				nonSelectedListLabel : 'Avaliable Users',
				selectedListLabel : 'Assigned Users',
				preserveSelectionOnMove : 'moved',
				moveOnSelect : false
			});

			// File input
			$(".file-styled").uniform({
				fileButtonClass : 'action btn bg-pink-400'
			});

			userYearTableGen();

			$('input[name=rd_year]').change(function() {
				userYearTableGen();
			});

			$('input[name=rd_sem]').change(function() {
				userYearTableGen();
			});
		});

		function userYearTableGen() {
			var year = $('input[name=rd_year]:checked').val();
			var sem = $('input[name=rd_sem]:checked').val();

			$('#user_table tbody tr td:nth-child(7)').html(year + " - " + sem);
		}
	</script>
</body>
</html>