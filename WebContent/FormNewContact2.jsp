<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="html-el" uri="http://struts.apache.org/tags-html-el"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>New Contact</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="main.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>CM</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">Contact Manager</span>
    </a>
    
	<!--     Script  -->
		<script type="text/javascript">
		function isEntreprise() {
			var x = document.getElementById('prenom');
			var y = document.getElementById('siret');
			x.style.visibility = 'hidden';
			y.style.visibility = 'visible';
		}

		function isPersonne() {
			var x = document.getElementById('prenom');
			var y = document.getElementById('siret');
			x.style.visibility = 'visible';
			y.style.visibility = 'hidden';
		}
	</script>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
          <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-plus"></i>
                </a>
                <ul class="dropdown-menu">
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- start message -->
                        <a href="#">
                          <div class="pull-left">
                              <medium><i class="fa fa-user"></i></medium>
                          </div>
                          <h4>
                            Add Contact
                          </h4>
                        </a>
                      </li>
                      <!-- end message -->
                      <li>
                        <a href="addNewGroup.jsp">
                            <div class="pull-left">
                              <medium><i class="fa fa-group"></i></medium>
                            </div>
                            <h4>
                              Add Group
                            </h4>
                          </a>
                      </li>
                    </ul>
                  </li>
                </ul>
              </li>
            </ul>
        </div>
      </nav>
      <!-- Navbar Right Menu -->

    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">



      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Menu</li>
        <!-- Optionally, you can add icons to the links -->
        <li><a href="main2.jsp"><i class="fa fa-home"></i> <span>Home</span></a></li>
        <li><a href="ViewContactsForm.do"><i class="fa fa-user"></i> <span>Contacts</span></a></li>
        <li><a href="ViewGroupsForm.do"><i class="fa fa-group"></i> <span>Groups</span></a></li>
    </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Add New Contact
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="row">
            <!-- left column -->
            <div class="col-xs-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                      <h3 class="box-title"><font color="red"><html:errors /></font></h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                      <form role="form" action="NewContactForm.do">
                      	 <!-- radio -->
                        <div class="form-group">
                          <div class="radio">
                            <label>
                              <input type="radio" name="typeContact" value="Personne" onclick="isPersonne()">
                              Person
                            </label>
                            <label>
                              <input type="radio" name="typeContact" value="Entreprise" onclick="isEntreprise()">
                              Company
                            </label>
                        </div>
                        </div>
                        <!-- text input -->
                         <div class="form-group" id="siret">
                          <label><bean:message key="siret" />&nbsp;*</label>
                          <input type="text" name="siretEtp" class="form-control" placeholder="Siret n°">
                        </div>
                        <div class="form-group" id="prenom">
                          <label>First name &nbsp;*</label>
                          <input type="text" name="prenom" class="form-control" placeholder="First name">
                        </div>

                        <div class="form-group">
                            <label>Last name &nbsp;*</label>
                            <input type="text" name="nom" class="form-control" placeholder="Last name">
                        </div>

                        <div class="form-group">
                            <label>Mail &nbsp;*</label>
                            <input type="text" name="mail" class="form-control" placeholder="name@exemple.fr">
                        </div>
                        
                         <div class="form-group" >
                            <label>Phone Number &nbsp;*</label>
                            <input type="text" name="tel" class="form-control" placeholder="0100000000">
                        </div>
                        
                         <div class="form-group" style="tel2">
                            <label>Other Phone</label>
                            <input type="text" name="tel2" class="form-control" placeholder="0100000000">
                        </div>

                        <div class="form-group">
                            <label>Street &nbsp;*</label>
                            <input type="text" name="adresse" class="form-control" placeholder="Street">
                        </div>

                        <div class="form-group">
                            <label>City &nbsp;*</label>
                            <input type="text" name="ville" class="form-control" placeholder="City">
                        </div>

                        <div class="form-group">
                            <label>Zip &nbsp;*</label>
                            <input type="text" name="code_postal" class="form-control" placeholder="75012">
                        </div>

                        <div class="form-group">
                            <label>Country &nbsp;*</label>
                            <input type="text" name="pays" class="form-control" placeholder="Country">
                        </div>
        
                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
        
                      </form>
                    </div>
                    <!-- /.box-body -->
                  </div>
            </div>
        </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>