<!doctype html>
<html class="fixed">
<head>

	<!-- Basic -->
	<meta charset="UTF-8">

	<title>Dashboard | JSOFT Themes | JSOFT-Admin</title>
	<meta name="keywords" content="HTML5 Admin Template" />
	<meta name="description" content="JSOFT Admin - Responsive HTML5 Template">
	<meta name="author" content="JSOFT.net">

	<!-- Mobile Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	<!-- Web Fonts  -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light" rel="stylesheet" type="text/css">

	<!-- Vendor CSS -->
	<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" href="assets/vendor/magnific-popup/magnific-popup.css" />
	<link rel="stylesheet" href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />

	<!-- Specific Page Vendor CSS -->
	<link rel="stylesheet" href="assets/vendor/jquery-ui/css/ui-lightness/jquery-ui-1.10.4.custom.css" />
	<link rel="stylesheet" href="assets/vendor/bootstrap-multiselect/bootstrap-multiselect.css" />
	<link rel="stylesheet" href="assets/vendor/morris/morris.css" />

	<!-- Theme CSS -->
	<link rel="stylesheet" href="assets/stylesheets/theme.css" />

	<!-- Skin CSS -->
	<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

	<!-- Theme Custom CSS -->
	<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

	<!-- Head Libs -->
	<script src="assets/vendor/modernizr/modernizr.js"></script>

</head>
<body>
<section class="body">

	<!-- start: header -->
	<header class="header">
		<div class="logo-container">
			<a href="../" class="logo">
				<img src="assets/images/logo.png" height="35" alt="JSOFT Admin" />
			</a>
			<div class="visible-xs toggle-sidebar-left" data-toggle-class="sidebar-left-opened" data-target="html" data-fire-event="sidebar-left-opened">
				<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
			</div>
		</div>

		<!-- start: search & user box -->
		<div class="header-right">

			<form action="pages-search-results.html" class="search nav-form">
				<div class="input-group input-search">
					<input type="text" class="form-control" name="q" id="q" placeholder="Search...">
					<span class="input-group-btn">
								<button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
							</span>
				</div>
			</form>

			<span class="separator"></span>

			<ul class="notifications">
				<li>
					<a href="#" class="dropdown-toggle notification-icon" data-toggle="dropdown">
						<i class="fa fa-tasks"></i>
						<span class="badge">3</span>
					</a>

					<div class="dropdown-menu notification-menu large">
						<div class="notification-title">
							<span class="pull-right label label-default">3</span>
							Tasks
						</div>

						<div class="content">
							<ul>
								<li>
									<p class="clearfix mb-xs">
										<span class="message pull-left">Generating Sales Report</span>
										<span class="message pull-right text-dark">60%</span>
									</p>
									<div class="progress progress-xs light">
										<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
									</div>
								</li>

								<li>
									<p class="clearfix mb-xs">
										<span class="message pull-left">Importing Contacts</span>
										<span class="message pull-right text-dark">98%</span>
									</p>
									<div class="progress progress-xs light">
										<div class="progress-bar" role="progressbar" aria-valuenow="98" aria-valuemin="0" aria-valuemax="100" style="width: 98%;"></div>
									</div>
								</li>

								<li>
									<p class="clearfix mb-xs">
										<span class="message pull-left">Uploading something big</span>
										<span class="message pull-right text-dark">33%</span>
									</p>
									<div class="progress progress-xs light mb-xs">
										<div class="progress-bar" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: 33%;"></div>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li>
					<a href="#" class="dropdown-toggle notification-icon" data-toggle="dropdown">
						<i class="fa fa-envelope"></i>
						<span class="badge">4</span>
					</a>

					<div class="dropdown-menu notification-menu">
						<div class="notification-title">
							<span class="pull-right label label-default">230</span>
							Messages
						</div>

						<div class="content">
							<ul>
								<li>
									<a href="#" class="clearfix">
										<figure class="image">
											<img src="assets/images/!sample-user.jpg" alt="Joseph Doe Junior" class="img-circle" />
										</figure>
										<span class="title">Joseph Doe</span>
										<span class="message">Lorem ipsum dolor sit.</span>
									</a>
								</li>
								<li>
									<a href="#" class="clearfix">
										<figure class="image">
											<img src="assets/images/!sample-user.jpg" alt="Joseph Junior" class="img-circle" />
										</figure>
										<span class="title">Joseph Junior</span>
										<span class="message truncate">Truncated message. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sit amet lacinia orci. Proin vestibulum eget risus non luctus. Nunc cursus lacinia lacinia. Nulla molestie malesuada est ac tincidunt. Quisque eget convallis diam, nec venenatis risus. Vestibulum blandit faucibus est et malesuada. Sed interdum cursus dui nec venenatis. Pellentesque non nisi lobortis, rutrum eros ut, convallis nisi. Sed tellus turpis, dignissim sit amet tristique quis, pretium id est. Sed aliquam diam diam, sit amet faucibus tellus ultricies eu. Aliquam lacinia nibh a metus bibendum, eu commodo eros commodo. Sed commodo molestie elit, a molestie lacus porttitor id. Donec facilisis varius sapien, ac fringilla velit porttitor et. Nam tincidunt gravida dui, sed pharetra odio pharetra nec. Duis consectetur venenatis pharetra. Vestibulum egestas nisi quis elementum elementum.</span>
									</a>
								</li>
								<li>
									<a href="#" class="clearfix">
										<figure class="image">
											<img src="assets/images/!sample-user.jpg" alt="Joe Junior" class="img-circle" />
										</figure>
										<span class="title">Joe Junior</span>
										<span class="message">Lorem ipsum dolor sit.</span>
									</a>
								</li>
								<li>
									<a href="#" class="clearfix">
										<figure class="image">
											<img src="assets/images/!sample-user.jpg" alt="Joseph Junior" class="img-circle" />
										</figure>
										<span class="title">Joseph Junior</span>
										<span class="message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sit amet lacinia orci. Proin vestibulum eget risus non luctus. Nunc cursus lacinia lacinia. Nulla molestie malesuada est ac tincidunt. Quisque eget convallis diam.</span>
									</a>
								</li>
							</ul>

							<hr />

							<div class="text-right">
								<a href="#" class="view-more">View All</a>
							</div>
						</div>
					</div>
				</li>
				<li>
					<a href="#" class="dropdown-toggle notification-icon" data-toggle="dropdown">
						<i class="fa fa-bell"></i>
						<span class="badge">3</span>
					</a>

					<div class="dropdown-menu notification-menu">
						<div class="notification-title">
							<span class="pull-right label label-default">3</span>
							Alerts
						</div>

						<div class="content">
							<ul>
								<li>
									<a href="#" class="clearfix">
										<div class="image">
											<i class="fa fa-thumbs-down bg-danger"></i>
										</div>
										<span class="title">Server is Down!</span>
										<span class="message">Just now</span>
									</a>
								</li>
								<li>
									<a href="#" class="clearfix">
										<div class="image">
											<i class="fa fa-lock bg-warning"></i>
										</div>
										<span class="title">User Locked</span>
										<span class="message">15 minutes ago</span>
									</a>
								</li>
								<li>
									<a href="#" class="clearfix">
										<div class="image">
											<i class="fa fa-signal bg-success"></i>
										</div>
										<span class="title">Connection Restaured</span>
										<span class="message">10/10/2014</span>
									</a>
								</li>
							</ul>

							<hr />

							<div class="text-right">
								<a href="#" class="view-more">View All</a>
							</div>
						</div>
					</div>
				</li>
			</ul>

			<span class="separator"></span>

			<div id="userbox" class="userbox">
				<a href="#" data-toggle="dropdown">
					<figure class="profile-picture">
						<img src="assets/images/!logged-user.jpg" alt="Joseph Doe" class="img-circle" data-lock-picture="assets/images/!logged-user.jpg" />
					</figure>
					<div class="profile-info" data-lock-name="John Doe" data-lock-email="johndoe@JSOFT.com">
						<span class="name">John Doe Junior</span>
						<span class="role">administrator</span>
					</div>

					<i class="fa custom-caret"></i>
				</a>

				<div class="dropdown-menu">
					<ul class="list-unstyled">
						<li class="divider"></li>
						<li>
							<a role="menuitem" tabindex="-1" href="pages-user-profile.html"><i class="fa fa-user"></i> My Profile</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="#" data-lock-screen="true"><i class="fa fa-lock"></i> Lock Screen</a>
						</li>
						<li>
							<a role="menuitem" tabindex="-1" href="pages-signin.html"><i class="fa fa-power-off"></i> Logout</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- end: search & user box -->
	</header>
	<!-- end: header -->

	<div class="inner-wrapper">
		<!-- start: sidebar -->
		<#include "sidebar.ftl">
		<!-- end: sidebar -->

		<section role="main" class="content-body">
			<header class="page-header">
				<h2>Dashboard</h2>

				<div class="right-wrapper pull-right">
					<ol class="breadcrumbs">
						<li>
							<a href="index.html">
								<i class="fa fa-home"></i>
							</a>
						</li>
						<li><span>Dashboard</span></li>
					</ol>

					<a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
				</div>
			</header>

			<div class="row">
				<div class="col-md-6">
					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
								<a href="#" class="fa fa-times"></a>
							</div>

							<h2 class="panel-title">Best Seller</h2>
							<p class="panel-subtitle">Customize the graphs as much as you want, there are so many options and features to display information using JSOFT Admin Template.</p>
						</header>
						<div class="panel-body">

							<!-- Flot: Basic -->
							<div class="chart chart-md" id="flotDashBasic"></div>
							<script>

								var flotDashBasicData = [{
									data: [
										[0, 170],
										[1, 169],
										[2, 173],
										[3, 188],
										[4, 147],
										[5, 113],
										[6, 128],
										[7, 169],
										[8, 173],
										[9, 128],
										[10, 128]
									],
									label: "Series 1",
									color: "#0088cc"
								}, {
									data: [
										[0, 115],
										[1, 124],
										[2, 114],
										[3, 121],
										[4, 115],
										[5, 83],
										[6, 102],
										[7, 148],
										[8, 147],
										[9, 103],
										[10, 113]
									],
									label: "Series 2",
									color: "#2baab1"
								}, {
									data: [
										[0, 70],
										[1, 69],
										[2, 73],
										[3, 88],
										[4, 47],
										[5, 13],
										[6, 28],
										[7, 69],
										[8, 73],
										[9, 28],
										[10, 28]
									],
									label: "Series 3",
									color: "#734ba9"
								}];

								// See: assets/javascripts/dashboard/examples.dashboard.js for more settings.

							</script>

						</div>
					</section>
				</div>
				<div class="col-md-6">
					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
								<a href="#" class="fa fa-times"></a>
							</div>
							<h2 class="panel-title">Server Usage</h2>
							<p class="panel-subtitle">It's easy to create custom graphs on JSOFT Admin Template, there are several graph types that you can use, such as lines, bars, pie charts, etc...</p>
						</header>
						<div class="panel-body">

							<!-- Flot: Curves -->
							<div class="chart chart-md" id="flotDashRealTime"></div>

						</div>
					</section>
				</div>
			</div>

			<!-- start: page -->

			<div class="row">

				<div class="col-xl-3 col-lg-6">
					<section class="panel panel-transparent">
						<header class="panel-heading">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
								<a href="#" class="fa fa-times"></a>
							</div>

							<h2 class="panel-title">My Stats</h2>
						</header>
						<div class="panel-body">
							<section class="panel">
								<div class="panel-body">
									<div class="small-chart pull-right" id="sparklineBarDash"></div>
									<script type="text/javascript">
										var sparklineBarDashData = [5, 6, 7, 2, 0, 4 , 2, 4, 2, 0, 4 , 2, 4, 2, 0, 4];
									</script>
									<div class="h4 text-bold mb-none">488</div>
									<p class="text-xs text-muted mb-none">Average Profile Visits</p>
								</div>
							</section>
							<section class="panel">
								<div class="panel-body">
									<div class="circular-bar circular-bar-xs m-none mt-xs mr-md pull-right">
										<div class="circular-bar-chart" data-percent="45" data-plugin-options='{ "barColor": "#2baab1", "delay": 300, "size": 50, "lineWidth": 4 }'>
											<strong>Average</strong>
											<label><span class="percent">45</span>%</label>
										</div>
									</div>
									<div class="h4 text-bold mb-none">12</div>
									<p class="text-xs text-muted mb-none">Working Projects</p>
								</div>
							</section>
							<section class="panel">
								<div class="panel-body">
									<div class="small-chart pull-right" id="sparklineLineDash"></div>
									<script type="text/javascript">
										var sparklineLineDashData = [15, 16, 17, 19, 10, 15, 13, 12, 12, 14, 16, 17];
									</script>
									<div class="h4 text-bold mb-none">89</div>
									<p class="text-xs text-muted mb-none">Pending Tasks</p>
								</div>
							</section>
						</div>
					</section>
					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
								<a href="#" class="fa fa-times"></a>
							</div>

							<h2 class="panel-title">
								<span class="label label-primary label-sm text-normal va-middle mr-sm">198</span>
								<span class="va-middle">Friends</span>
							</h2>
						</header>
						<div class="panel-body">
							<div class="content">
								<ul class="simple-user-list">
									<li>
										<figure class="image rounded">
											<img src="assets/images/!sample-user.jpg" alt="Joseph Doe Junior" class="img-circle">
										</figure>
										<span class="title">Joseph Doe Junior</span>
										<span class="message truncate">Lorem ipsum dolor sit.</span>
									</li>
									<li>
										<figure class="image rounded">
											<img src="assets/images/!sample-user.jpg" alt="Joseph Junior" class="img-circle">
										</figure>
										<span class="title">Joseph Junior</span>
										<span class="message truncate">Lorem ipsum dolor sit.</span>
									</li>
									<li>
										<figure class="image rounded">
											<img src="assets/images/!sample-user.jpg" alt="Joe Junior" class="img-circle">
										</figure>
										<span class="title">Joe Junior</span>
										<span class="message truncate">Lorem ipsum dolor sit.</span>
									</li>
								</ul>
								<hr class="dotted short">
								<div class="text-right">
									<a class="text-uppercase text-muted" href="#">(View All)</a>
								</div>
							</div>
						</div>
						<div class="panel-footer">
							<div class="input-group input-search">
								<input type="text" class="form-control" name="q" id="q" placeholder="Search...">
								<span class="input-group-btn">
											<button class="btn btn-default" type="submit"><i class="fa fa-search"></i>
											</button>
										</span>
							</div>
						</div>
					</section>
				</div>
				<div class="col-xl-6 col-lg-12">
					<section class="panel">
						<header class="panel-heading panel-heading-transparent">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
								<a href="#" class="fa fa-times"></a>
							</div>

							<h2 class="panel-title">Company Activity</h2>
						</header>
						<div class="panel-body">
							<div class="timeline timeline-simple mt-xlg mb-md">
								<div class="tm-body">
									<div class="tm-title">
										<h3 class="h5 text-uppercase">November 2013</h3>
									</div>
									<ol class="tm-items">
										<li>
											<div class="tm-box">
												<p class="text-muted mb-none">7 months ago.</p>
												<p>
													It's awesome when we find a good solution for our projects, JSOFT Admin is <span class="text-primary">#awesome</span>
												</p>
											</div>
										</li>
										<li>
											<div class="tm-box">
												<p class="text-muted mb-none">7 months ago.</p>
												<p>
													Checkout! How cool is that!
												</p>
												<div class="thumbnail-gallery">
													<a class="img-thumbnail lightbox" href="assets/images/projects/project-4.jpg" data-plugin-options='{ "type":"image" }'>
														<img class="img-responsive" width="215" src="assets/images/projects/project-4.jpg">
														<span class="zoom">
																	<i class="fa fa-search"></i>
																</span>
													</a>
												</div>
											</div>
										</li>
									</ol>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<section class="panel">
						<header class="panel-heading panel-heading-transparent">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
								<a href="#" class="fa fa-times"></a>
							</div>

							<h2 class="panel-title">Projects Stats</h2>
						</header>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped mb-none">
									<thead>
									<tr>
										<th>#</th>
										<th>Project</th>
										<th>Status</th>
										<th>Progress</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>1</td>
										<td>JSOFT - Responsive HTML5 Template</td>
										<td><span class="label label-success">Success</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded m-none mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
													100%
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>2</td>
										<td>JSOFT - Responsive Drupal 7 Theme</td>
										<td><span class="label label-success">Success</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded m-none mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
													100%
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>3</td>
										<td>Tucson - Responsive HTML5 Template</td>
										<td><span class="label label-warning">Warning</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded m-none mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
													60%
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>4</td>
										<td>Tucson - Responsive Business WordPress Theme</td>
										<td><span class="label label-success">Success</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded m-none mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
													90%
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>5</td>
										<td>JSOFT - Responsive Admin HTML5 Template</td>
										<td><span class="label label-warning">Warning</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded m-none mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 45%;">
													45%
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>6</td>
										<td>JSOFT - Responsive HTML5 Template</td>
										<td><span class="label label-danger">Danger</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded m-none mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
													40%
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>7</td>
										<td>JSOFT - Responsive Drupal 7 Theme</td>
										<td><span class="label label-success">Success</span></td>
										<td>
											<div class="progress progress-sm progress-half-rounded mt-xs light">
												<div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 95%;">
													95%
												</div>
											</div>
										</td>
									</tr>
									</tbody>
								</table>
							</div>
						</div>
					</section>
				</div>
			</div>
			<!-- end: page -->
		</section>
	</div>

	<#include "sidebar-right.ftl">
</section>

<!-- Vendor -->
<script src="assets/vendor/jquery/jquery.js"></script>
<script src="assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
<script src="assets/vendor/nanoscroller/nanoscroller.js"></script>
<script src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="assets/vendor/magnific-popup/magnific-popup.js"></script>
<script src="assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>

<!-- Specific Page Vendor -->
<script src="assets/vendor/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
<script src="assets/vendor/jquery-ui-touch-punch/jquery.ui.touch-punch.js"></script>
<script src="assets/vendor/jquery-appear/jquery.appear.js"></script>
<script src="assets/vendor/bootstrap-multiselect/bootstrap-multiselect.js"></script>
<script src="assets/vendor/jquery-easypiechart/jquery.easypiechart.js"></script>
<script src="assets/vendor/flot/jquery.flot.js"></script>
<script src="assets/vendor/flot-tooltip/jquery.flot.tooltip.js"></script>
<script src="assets/vendor/flot/jquery.flot.pie.js"></script>
<script src="assets/vendor/flot/jquery.flot.categories.js"></script>
<script src="assets/vendor/flot/jquery.flot.resize.js"></script>
<script src="assets/vendor/jquery-sparkline/jquery.sparkline.js"></script>
<script src="assets/vendor/raphael/raphael.js"></script>
<script src="assets/vendor/morris/morris.js"></script>
<script src="assets/vendor/gauge/gauge.js"></script>
<script src="assets/vendor/snap-svg/snap.svg.js"></script>
<script src="assets/vendor/liquid-meter/liquid.meter.js"></script>
<script src="assets/vendor/jqvmap/jquery.vmap.js"></script>
<script src="assets/vendor/jqvmap/data/jquery.vmap.sampledata.js"></script>
<script src="assets/vendor/jqvmap/maps/jquery.vmap.world.js"></script>
<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.africa.js"></script>
<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.asia.js"></script>
<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.australia.js"></script>
<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.europe.js"></script>
<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.north-america.js"></script>
<script src="assets/vendor/jqvmap/maps/continents/jquery.vmap.south-america.js"></script>

<!-- Theme Base, Components and Settings -->
<script src="assets/javascripts/theme.js"></script>

<!-- Theme Custom -->
<script src="assets/javascripts/theme.custom.js"></script>

<!-- Theme Initialization Files -->
<script src="assets/javascripts/theme.init.js"></script>


<!-- Examples -->
<script src="assets/javascripts/dashboard/examples.dashboard.js"></script>
</body>
</html>