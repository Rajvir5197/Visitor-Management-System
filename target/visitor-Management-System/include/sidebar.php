

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

<!-- Sidebar - Brand -->
<a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
<img src="images/rucha-group-logo.png" class="img-fluid" style="height:60px;" />
</a>

<!-- Divider -->
<!--<hr class="sidebar-divider my-0">-->

<!-- Nav Item - Dashboard -->
<li class="nav-item">
<a class="nav-link" href="dashboard.php">
<i class="fas fa-fw fa-users"></i>
<span>Employee Dashboard</span></a>
</li>

<li class="nav-item">
<a class="nav-link" href="security-dashboard.php">
<i class="fas fa-fw fa-user-tie"></i>
<span>Security Dashboard</span></a>
</li>

<li class="nav-item">
<a class="nav-link" href="todays-visits-listing.php">
<i class="fas fa-fw fa-calendar-alt"></i>
<span>Todays Visits Listing</span></a>
</li>


<li class="nav-item">
<a class="nav-link" href="personcheck-out.php">
<i class="fas fa-fw fa-sign-out-alt"></i>
<span>Personcheck Out</span></a>
</li>


<!--New Navigation-->

<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#managePlants" aria-expanded="true" aria-controls="managePlants">
<i class="fas fa-fw fa-industry"></i>
<span>Manage Plants</span>
</a>
<div id="managePlants" class="collapse" aria-labelledby="managePlants" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="manage-plant-view-all.php">View All</a>
</div>
</div>
</li>


<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#manageVisits" aria-expanded="true" aria-controls="manageVisits">
<i class="fas fa-fw fa-file-signature"></i>
<span>Manage Visits</span>
</a>
<div id="manageVisits" class="collapse" aria-labelledby="manageVisits" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="manage-visits-view-all.php">View All</a>
<a class="collapse-item" href="manage-visits-add-new.php">Add/New Visit</a>
</div>
</div>
</li>


<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#manageCheckIn" aria-expanded="true" aria-controls="manageCheckIn">
<i class="fas fa-fw fa-clock"></i>
<span>Manage Check-In</span>
</a>
<div id="manageCheckIn" class="collapse" aria-labelledby="manageCheckIn" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="#">View All (Co Visitor + <br />Asset Details)</a>
</div>
</div>
</li>



<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#manageContact" aria-expanded="true" aria-controls="manageContact">
<i class="fas fa-fw fa-address-card"></i>
<span>Manage Contact</span>
</a>
<div id="manageContact" class="collapse" aria-labelledby="manageContact" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="manage-contact-view-all.php">View All</a>
<a class="collapse-item" href="manage-contact-add-new.php">Add New Contact</a>
</div>
</div>
</li>


<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#empMaster" aria-expanded="true" aria-controls="empMaster">
<i class="fas fa-fw fa-user-cog"></i>
<span>Employee Master</span>
</a>
<div id="empMaster" class="collapse" aria-labelledby="empMaster" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="employee-master-view-all.php">View All</a>
</div>
</div>
</li>

<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#depMaster" aria-expanded="true" aria-controls="empMaster">
<i class="fas fa-fw fa-building"></i>
<span>Department Master</span>
</a>
<div id="depMaster" class="collapse" aria-labelledby="depMaster" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="department-master-view-all.php">View All</a>
</div>
</div>
</li>


<li class="nav-item">
<a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#ReportsMenu" aria-expanded="true" aria-controls="ReportsMenu">
<i class="fas fa-fw fa-file-alt"></i>
<span>Reports</span>
</a>
<div id="ReportsMenu" class="collapse" aria-labelledby="ReportsMenu" data-parent="#accordionSidebar">
<div class="collapse-inner" style="background-color:#3482ae;">
<a class="collapse-item" href="#">Monitoring and Analysis <br />of Visits</a>
<a class="collapse-item" href="#">Plants wise visitor details</a>
<a class="collapse-item" href="employee-report-for-visited-visitor.php">Visitor Details, Date-wise <br />Visit Report</a>
</div>
</div>
</li>


<!-- Divider -->
<hr class="sidebar-divider d-none d-md-block">

<!-- Sidebar Toggler (Sidebar) -->
<div class="text-center d-none d-md-inline">
<button class="rounded-circle border-0" id="sidebarToggle"></button>
</div>

</ul>