<div class="navbar navbar-inverse bg-indigo">
	<div class="navbar-header">
		<a class="navbar-brand" href="javascript:void(0)">LOGO</a>
		<ul class="nav navbar-nav pull-right visible-xs-block">
			<li><a data-toggle="collapse" data-target="#navbar-mobile"><i
					class="icon-tree5"></i></a></li>
		</ul>
	</div>

	<div class="navbar-collapse collapse" id="navbar-mobile">
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown dropdown-user"><a class="dropdown-toggle"
				data-toggle="dropdown"> <img
					src="resources/assets/images/image.png" alt="">
					<span>
						<security:authorize access="isAuthenticated()">
						   <security:authentication property="principal.username" /> 
						</security:authorize>
					</span>
					<i class="caret"></i>
			</a>
				<ul class="dropdown-menu dropdown-menu-right">
					<li><a href="settings"><i class="icon-cog5"></i>Settings</a></li>
					<li><a href="logout"><i class="icon-switch2"></i> Logout</a></li>
				</ul></li>
		</ul>
	</div>
</div>