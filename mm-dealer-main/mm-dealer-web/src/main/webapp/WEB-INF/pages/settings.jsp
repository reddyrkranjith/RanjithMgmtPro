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
	<jsp:include page="templates/header.jsp" />
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
							<div class="panel-heading">
								<h6 class="panel-title">
									Settings<a class="heading-elements-toggle"><i
										class="icon-more"></i></a>
								</h6>
								<!--
								<div class="heading-elements">
									<ul class="icons-list">
				                		<li><a data-action="collapse"></a></li>
				                		<li><a data-action="reload"></a></li>
				                		<li><a data-action="close"></a></li>
				                	</ul>
			                	</div>-->
							</div>

							<div class="panel-body">


								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Branch</label> <select data-placeholder="Branch"
												class="select  select2-hidden-accessible"
												data-minimum-results-for-search="Infinity" tabindex="-1"
												aria-hidden="true">
												<option>Select</option>
												<c:if test="${not empty departments}">
													<c:forEach items="${departments}" var="departmentItem">
														<option>${departmentItem.department}</option>
													</c:forEach>
												</c:if>
											</select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="display-block text-semibold"
												style="margin-bottom: 14px;">Select Year</label> <label
												class="radio-inline"> <input type="radio"
												name="rd_year" class="styled" value="1<sup>st</sup> Year"
												checked> 1<sup>st</sup> Year
											</label> <label class="radio-inline"> <input type="radio"
												name="rd_year" class="styled" value="2<sup>nd</sup> Year">
												2<sup>nd</sup> Year
											</label> <label class="radio-inline"> <input type="radio"
												name="rd_year" class="styled" value="3<sup>rd</sup> Year">
												3<sup>rd</sup> Year
											</label> <label class="radio-inline"> <input type="radio"
												name="rd_year" class="styled" value="4<sup>th</sup> Year">
												4<sup>th</sup> Year
											</label>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="display-block text-semibold"
												style="margin-bottom: 14px;">Select Semester</label> <label
												class="radio-inline"> <input type="radio"
												name="rd_sem" class="styled" value="1<sup>st</sup> Sem"
												checked> 1<sup>st</sup> Semester
											</label> <label class="radio-inline"> <input type="radio"
												name="rd_sem" class="styled" value="2<sup>nd</sup> Sem">
												2<sup>nd</sup> Semester
											</label>
										</div>
									</div>
								</div>

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

											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Subject</label> <select data-placeholder="Subject"
															class="select  select2-hidden-accessible"
															data-minimum-results-for-search="Infinity" tabindex="-1"
															aria-hidden="true">
															<option>Select</option>
															<c:if test="${not empty departments}">
															<c:forEach items="${departments}" var="department">
															<c:if test="${not empty department.subject}">
																<c:forEach items="${department.subject}" var="subject">
																	<option>${subject.subjectName}</option>
																</c:forEach>
															</c:if>
															</c:forEach>
															</c:if>
															<!-- <option>English - I</option>
															<option>Mathematics - I</option>
															<option>Applied Chemistry</option>
															<option>Engineering Mechanics</option>
															<option>Computer Programming</option>
															<option>Environmental Studies</option>
															<option>Chemistry Lab</option>
															<option>Communication Skills Lab</option>
															<option>Computer Programming Lab</option>
															<option>English - II</option>
															<option>Mathematics - II</option>
															<option>Mathematics - III</option>
															<option>Applied Physics</option>
															<option>Electrical Circuit Analysis</option>
															<option>Engineering Drawiing</option> -->
														</select>

													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-12">
													<select multiple="multiple"
														class="form-control listbox-no-selection"
														style="display: none;">
														<option selected class="text-left">07BK1A0208</option>
														<option class="text-left">07BK1A0209</option>
														<option class="text-left">07BK1A0210</option>
														<option class="text-left">07BK1A0211</option>
														<option class="text-left">07BK1A0212</option>
														<option class="text-left">07BK1A0213</option>
														<option selected class="text-left">07BK1A0214</option>
														<option class="text-left">07BK1A0215</option>
														<option class="text-left">07BK1A0216</option>
														<option class="text-left">07BK1A0217</option>
														<option class="text-left">07BK1A0218</option>
														<option selected class="text-left">07BK1A0219</option>
														<option class="text-left">07BK1A0220</option>
														<option class="text-left">07BK1A0221</option>
														<option class="text-left">07BK1A0222</option>
														<option class="text-left">07BK1A0223</option>
														<option class="text-left">07BK1A0224</option>
														<option class="text-left">07BK1A0225</option>
														<option class="text-left">07BK1A0226</option>
														<option selected class="text-left">07BK1A0227</option>
														<option class="text-left">07BK1A0228</option>
														<option class="text-left">07BK1A0229</option>
														<option class="text-left">07BK1A0230</option>
														<option class="text-left">07BK1A0231</option>
														<option class="text-left">07BK1A0232</option>
														<option class="text-left">07BK1A0233</option>

													</select>
												</div>
											</div>

										</div>

										<div class="tab-pane" id="ulm-tab2">
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Subject</label> <input class="form-control"
															type="text" placeholder="Enter Subject Name...">
													</div>
												</div>
												<div class="col-md-2" style="text-align: left;">
													<div class="form-group">
														<label style="display: block; visibility: hidden;">Submit</label>
														<button type="button" class="btn btn-info">Add</button>
													</div>
												</div>

											</div>

											<div class="row"
												style="margin-bottom: -20px; margin-left: -20px; margin-right: -20px;">
												<div class="table-responsive">
													<table
														class="table table-striped table-xxs table-hover text-center">
														<thead>
															<tr>
																<th width="10%" class="text-center">S No.</th>
																<th width="70%" class="text-left">Subject</th>
																<th width="20%" class="text-center">Actions</th>
															</tr>
														</thead>
														<tbody>
															<c:if test="${not empty departments}">
																<c:forEach items="${departments}" var="department">
																	<c:if test="${not empty department.subject}">
																		<c:forEach items="${department.subject}" var="subject" varStatus="subjectCount">
																			<tr>
																				<td>${subjectCount.count}</td>
																				<td class="text-left">${subject.subjectName}</td>
																				<td><a title="" data-popup="tooltip"
																					data-placement="left" data-original-title="Edit"><i
																						class="icon-pencil3 position-left text-primary"></i></a><a
																					title="" data-popup="tooltip"
																					data-placement="right" data-original-title="Delete"><i
																						class="icon-trash position-right text-danger"></i></a></td>
																			</tr>
																		</c:forEach>
																	</c:if>
																</c:forEach>
															</c:if>
														</tbody>
													</table>

												</div>
											</div>

										</div>

										<div class="tab-pane" id="ulm-tab3">
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label>Topic Name</label> <input class="form-control"
															type="text" placeholder="Enter Topic Name...">
													</div>
												</div>
												<div class="col-md-2" style="text-align: left;">
													<div class="form-group">
														<label style="display: block; visibility: hidden;">Submit</label>
														<button type="button" class="btn btn-info">Add</button>
													</div>
												</div>

											</div>

											<div class="row"
												style="margin-bottom: -20px; margin-left: -20px; margin-right: -20px;">
												<div class="table-responsive">
													<table
														class="table table-striped table-xxs table-hover text-center">
														<thead>
															<tr>
																<th width="10%" class="text-center">S No.</th>
																<th width="35%" class="text-left">Topic Name</th>
																<th width="35%" class="text-left">Subject</th>
																<th width="20%" class="text-center">Actions</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td>1</td>
																<td class="text-left">Laplace transforms</td>
																<td class="text-left">Mathematics - I</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>2</td>
																<td class="text-left">Partial differentiation</td>
																<td class="text-left">Mathematics - I</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>3</td>
																<td class="text-left">Fuel technology</td>
																<td class="text-left">Applied Chemistry</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>4</td>
																<td class="text-left">Solid state chemistry</td>
																<td class="text-left">Applied Chemistry</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>5</td>
																<td class="text-left">Moment of Inertia</td>
																<td class="text-left">Engineering Mechanics</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>6</td>
																<td class="text-left">Kinematics</td>
																<td class="text-left">Engineering Mechanics</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>7</td>
																<td class="text-left">Work – Energy Method</td>
																<td class="text-left">Engineering Mechanics</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>8</td>
																<td class="text-left">History and Hardware</td>
																<td class="text-left">Computer Programming</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>9</td>
																<td class="text-left">Arrays &amp; Strings</td>
																<td class="text-left">Computer Programming</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>10</td>
																<td class="text-left">Pointers, Structures, Files</td>
																<td class="text-left">Computer Programming</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>11</td>
																<td class="text-left">Interpolation</td>
																<td class="text-left">Mathematics - II</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>12</td>
																<td class="text-left">Fourier Series</td>
																<td class="text-left">Mathematics - II</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>13</td>
																<td class="text-left">Fourier Transforms</td>
																<td class="text-left">Mathematics - II</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>14</td>
																<td class="text-left">Network topology</td>
																<td class="text-left">Electrical Circuit Analysis</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td>15</td>
																<td class="text-left">Magnetic Circuit</td>
																<td class="text-left">Electrical Circuit Analysis</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
														</tbody>
													</table>

												</div>
											</div>


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
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>1</td>
																<td>07BK1A0208</td>
																<td>Yon Yeater</td>
																<td>9844708286</td>
																<td>yeater.yon@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0208</td>
																<td>7V%NKCfr</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>2</td>
																<td>07BK1A0209</td>
																<td>Arlyne Ables</td>
																<td>9844709414</td>
																<td>ables.arlyne@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0209</td>
																<td>P6A&amp;%q?Z</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>3</td>
																<td>07BK1A0210</td>
																<td>Diamond Dalrymple</td>
																<td>9844702481</td>
																<td>dalrymple.diamond@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0210</td>
																<td>y4$KPHrc</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>4</td>
																<td>07BK1A0211</td>
																<td>Moon Mazza</td>
																<td>9844704712</td>
																<td>mazza.moon@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0211</td>
																<td>WZRs@T^4</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>5</td>
																<td>07BK1A0212</td>
																<td>Patria Pegram</td>
																<td>9844700912</td>
																<td>pegram.patria@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0212</td>
																<td>AVC42?B^</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>6</td>
																<td>07BK1A0213</td>
																<td>Grover Girardin</td>
																<td>9844706429</td>
																<td>girardin.grover@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0213</td>
																<td>BTJ&gt;j3av</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>7</td>
																<td>07BK1A0214</td>
																<td>Fleta Fritze</td>
																<td>9844703049</td>
																<td>fritze.fleta@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0214</td>
																<td>9BYUUjN#</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>8</td>
																<td>07BK1A0215</td>
																<td>Damon Damon</td>
																<td>9844700074</td>
																<td>damon.damon@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0215</td>
																<td>Z22!#bVJ</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>9</td>
																<td>07BK1A0216</td>
																<td>Kazuko Kenyon</td>
																<td>9844704570</td>
																<td>kenyon.kazuko@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0216</td>
																<td>3+59jA9&gt;</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>10</td>
																<td>07BK1A0217</td>
																<td>Rubye Rettig</td>
																<td>9844706447</td>
																<td>rettig.rubye@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0217</td>
																<td>46?$9WcG</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>11</td>
																<td>07BK1A0218</td>
																<td>Launa Luckey</td>
																<td>9844704084</td>
																<td>luckey.launa@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0218</td>
																<td>DX?J~BF6</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>12</td>
																<td>07BK1A0219</td>
																<td>Tenesha Turnage</td>
																<td>9844700846</td>
																<td>turnage.tenesha@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0219</td>
																<td>Y~m36Ch?</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>13</td>
																<td>07BK1A0220</td>
																<td>Irish Infantino</td>
																<td>9844704348</td>
																<td>infantino.irish@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0220</td>
																<td>Zvu9%KcK</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>14</td>
																<td>07BK1A0221</td>
																<td>Kristel Kelliher</td>
																<td>9844702735</td>
																<td>kelliher.kristel@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0221</td>
																<td>^97dQ!5Y</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>15</td>
																<td>07BK1A0222</td>
																<td>Allen Alfrey</td>
																<td>9844705757</td>
																<td>alfrey.allen@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0222</td>
																<td>?5XcJGXM</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>16</td>
																<td>07BK1A0223</td>
																<td>Curt Cirilo</td>
																<td>9844706270</td>
																<td>cirilo.curt@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0223</td>
																<td>R8Q7jwH^</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>17</td>
																<td>07BK1A0224</td>
																<td>Tisa Triano</td>
																<td>9844709640</td>
																<td>triano.tisa@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0224</td>
																<td>UVP96C&amp;C</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>18</td>
																<td>07BK1A0225</td>
																<td>Jodie Jepson</td>
																<td>9844700518</td>
																<td>jepson.jodie@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0225</td>
																<td>P%U4z~pJ</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>19</td>
																<td>07BK1A0226</td>
																<td>Marilee Midkiff</td>
																<td>9844709386</td>
																<td>midkiff.marilee@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0226</td>
																<td>F#Y~Ge&amp;8</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
															<tr>
																<td><input type="checkbox" class="styled"></td>
																<td>20</td>
																<td>07BK1A0227</td>
																<td>Tamar Tomasello</td>
																<td>9844702048</td>
																<td>tomasello.tamar@email.com</td>
																<td>1<sup>st</sup> Year - 1<sup>st</sup> Sem
																</td>
																<td>07BK1A0227</td>
																<td>JZ@S~5RN</td>
																<td><a title="" data-popup="tooltip"
																	data-placement="left" data-original-title="Edit"><i
																		class="icon-pencil3 position-left text-primary"></i></a><a
																	title="" data-popup="tooltip" data-placement="right"
																	data-original-title="Delete"><i
																		class="icon-trash position-right text-danger"></i></a></td>
															</tr>
														</tbody>
													</table>

												</div>
											</div>

										</div>

									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- /main content -->

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->

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