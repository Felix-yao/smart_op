<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/pkig-role.tld" prefix="role"%>
        <title>Smart</title>
        <!-- App css -->
        <link href="<%=request.getContextPath()%>/css/tooltipster.bundle.min.css" rel="stylesheet" >
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/core.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/spinkit.css" rel="stylesheet" />
        <link href="<%=request.getContextPath()%>/css/components.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/menu.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/responsive.css" rel="stylesheet" type="text/css" />
        
        <link href="<%=request.getContextPath()%>/css/plugins/datatables/dataTables.bootstrap.min.css" rel="stylesheet" >
        <link href="<%=request.getContextPath()%>/css/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
        <!-- æç¤ºcss -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/notice/toastr.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/notice/toastr.min.css">
        <!-- select2 css -->
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/plugins/select2/select2.min.css">
            <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left">
                    <a href="javascript: newMainLoadData('<%=request.getContextPath() %>/firstPage');" class="logo"><span>Smart<span>.</span></span><i class="mdi mdi-layers"></i></a>
                </div>

                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">

                        <!-- Navbar-left -->
                        <ul class="nav navbar-nav navbar-left nav-menu-left">
                            <li>
                                <button type="button" class="button-menu-mobile open-left waves-effect">
                                    <i class="dripicons-menu"></i>
                                </button>
                            </li>
                        </ul>

                        <!-- Right(Notification) -->
                        <ul class="nav navbar-nav navbar-right">

                            <li class="dropdown user-box">
                                <a href="" class="dropdown-toggle waves-effect user-link" data-toggle="dropdown" aria-expanded="true">
                                    <img src="<%=request.getContextPath()%>/images/users/avatar-1.jpg" alt="user-img" class="img-circle user-img">
                                </a>

                                <ul class="dropdown-menu dropdown-menu-right arrow-dropdown-menu arrow-menu-right user-list notify-list">
                                	<li><a href="javascript:void(0)"><img class="icon-colored" style="width:30px;height:30px;margin:0;padding-right: 5px;" src="<%=request.getContextPath()%>/images/icons/businessman.svg">Profile</a></li>
                                    <li><a href="javascript:void(0)"><img class="icon-colored" style="width:30px;height:30px;margin:0;padding-right: 5px;" src="<%=request.getContextPath()%>/images/icons/support.svg">Reset Password</a></li>
                                    <li><a href="<%=request.getContextPath()%>/logout"><img class="icon-colored" style="width:30px;height:30px;margin:0;padding-right: 5px;" src="<%=request.getContextPath()%>/images/icons/settings.svg">Logout</a></li>
                                </ul>
                            </li>

                        </ul> <!-- end navbar-right -->

                    </div><!-- end container -->
                </div><!-- end navbar -->
            </div>
            <!-- Top Bar End -->
            <!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <div class="slimscroll-menu" id="remove-scroll">
                    <!--- Sidemenu -->
                    <div id="sidebar-menu">
                        <!-- Left Menu Start -->
                        <ul class="metisMenu nav" id="side-menu">
                            <li class="menu-title">NAVIGATION</li>
                            <li id = "menu-0">
                                <a href="javascript: newMainLoadData('<%=request.getContextPath() %>/firstPage');" aria-expanded="true"><i class="dripicons-home"></i><span> Dashboard </span></a>
                            </li>
                            <%-- <role:RoleEqual roleName="SP,AM">
                            <li class="menu-title">MANAGE</li>
                            <li id="menu-1">
                                <a href="javascript: void(0);" aria-expanded="true"><i class="fi-target"></i> <span> Account </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <li id="menu-1-1"><a href="javascript: newMainLoadData('<%=request.getContextPath() %>/employee/query');">Manage Account</a></li>
                                    <li id="menu-1-2"><a href="javascript: newMainLoadData('<%=request.getContextPath() %>/employee/create');">Create Account</a></li>
                                </ul>
                            </li>
                            </role:RoleEqual>
                            <role:RoleEqual roleName="SP,AM,AMA">
                            <li id="menu-2">
                                <a href="javascript: void(0);" aria-expanded="true"><i class="fi-briefcase"></i> <span> DSP </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <li id="menu-2-1"><a href="javascript: newMainLoadData('<%=request.getContextPath() %>/dsp/query');">Manage DSP</a></li>
                                    <li id="menu-2-2"><a href="javascript: newMainLoadData('<%=request.getContextPath() %>/dsp/create');">Create DSP</a></li>
                                </ul>
                            </li>
                            </role:RoleEqual>
                            <role:RoleEqual roleName="SP,PB,AM,AMP,PY">
                            <li id="menu-3">
                                <a href="javascript: void(0);" aria-expanded="true"><i class="fi-box"></i> <span> APP </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <li id="menu-3-1"><a href="<%=request.getContextPath()%>/publisher/app!appListPage">Manage App</a></li>
                                    <li id="menu-3-2"><a href="<%=request.getContextPath()%>/publisher/app!appCreatePage">Create App</a></li>
                                    <li id="menu-3-3"><a href="<%=request.getContextPath()%>/publisher/adPosition!adPositionListPage">Manage ADPosition</a></li>
                                    <li id="menu-3-4"><a href="<%=request.getContextPath()%>/publisher/adPosition!adPositionCreatePage">Create ADPosition</a></li>
                                </ul>
                            </li>
                            </role:RoleEqual>
                            <role:RoleEqual roleName="SP,AM,AMP,PY">
                            <li id="menu-4">
                                <a href="javascript: void(0);" aria-expanded="true"><i class="mdi mdi-account-star"></i> <span> Publisher </span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <role:RoleEqual roleName="SP,AM">
                                    <li id="menu-4-1"><a href="<%=request.getContextPath()%>/publisher/agent!agentListPage">Manage Agent</a></li>
                                    <li id="menu-4-2"><a href="<%=request.getContextPath()%>/publisher/agent!agentCreatePage">Create Agent</a></li>
                                    </role:RoleEqual>
                                    <li id="menu-4-3"><a href="<%=request.getContextPath()%>/publisher/publisher!publisherListPage">Manage Publisher</a></li>
                                    <li id="menu-4-4"><a href="<%=request.getContextPath()%>/publisher/publisher!publisherCreatePage">Create Publisher</a></li>
                                </ul>
                            </li>
                            </role:RoleEqual> --%>
                            <role:RoleEqual roleName="SP">
                            <li class="menu-title"></li>
                            <li id="menu-4">
                                <a href="javascript: void(0);" aria-expanded="true"><i class="fi-bar-graph-2"></i> <span>订单</span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <li id="menu-4-1"><a href="<%=request.getContextPath() %>/order/silverlistPage">银饰</a></li>
                                </ul>
                            </li>
                            </role:RoleEqual>
                            <role:RoleEqual roleName="SP,PB,AM,PY,AMP,DSP,AMA">
                            <li class="menu-title"></li>
                            <li id="menu-5">
                                <a href="javascript: void(0);" aria-expanded="true"><i class="fi-bar-graph-2"></i> <span> 报表</span> <span class="menu-arrow"></span></a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <%-- <role:RoleEqual roleName="SP,AM,DSP,AMA">
                                    <li id="menu-5-1"><a href="<%=request.getContextPath() %>/watchInfo/listPage!listPage">手表</a></li>
                                    </role:RoleEqual> --%>
                                    <role:RoleEqual roleName="PB,SP">
                                    <li id="menu-5-2"><a href="<%=request.getContextPath() %>/data/silverDataPage">银饰</a></li>
                                    </role:RoleEqual>
                                </ul>
                            </li>
                            </role:RoleEqual>
                            
                        </ul>
                    </div>
                    <!-- Sidebar -->
                    <div class="clearfix"></div>
                </div>
                <!-- Sidebar -left -->
            </div>
            <!-- Left Sidebar End -->
        <!-- jQuery  -->
        <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/metisMenu.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/waves.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.slimscroll.js"></script>
         <!-- Tooltipster js -->
        <script src="<%=request.getContextPath()%>/js/tooltipster.bundle.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.tooltipster.js"></script>
        <!-- App js -->
        <script src="<%=request.getContextPath()%>/js/jquery.core.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.app.js"></script>
        <script src="<%=request.getContextPath()%>/js/mobikok.js"></script>
        <!-- datatables js -->
		<script src="<%=request.getContextPath()%>/js/plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/plugins/datatables/dataTables.bootstrap.js"></script>
		<!-- adx main js -->
		<script src="<%=request.getContextPath()%>/js/adxMain.js"></script>
		<!-- æç¤º js -->
		<script src="<%=request.getContextPath()%>/js/notice/ssp.js"></script>
	    <script src="<%=request.getContextPath()%>/js/notice/toastr.js"></script>
	    <script src="<%=request.getContextPath()%>/js/notice/toastr.min.js"></script>
	    <!-- select2 js -->
	    <script src="<%=request.getContextPath()%>/js/plugins/select2/select2.full.min.js"></script>
	    <script src="<%=request.getContextPath()%>/js/plugins/select2/select2.min.js"></script>
	    
