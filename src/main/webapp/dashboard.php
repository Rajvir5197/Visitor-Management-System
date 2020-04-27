
<?php include 'include/header.php';?>

<!-- Sidebar -->
<?php include 'include/sidebar.php';?>
<!-- End of Sidebar -->

<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

<!-- Main Content -->
<div id="content">

<!-- Topbar -->
<?php include 'include/topbar.php';?>
<!-- End of Topbar -->


<!-- Begin Page Content -->
<div class="container-fluid mt-3">

<!-- Page Heading -->
<div class="row mb-2">
<div class="col-sm-8 align-self-center">
<h1 class="h4 text-gray-800">Dashboard</h1>
</div>

<div class="col-sm-4 text-right">
<!--<button type="button" class="btn btn-primary">Set Visit</button>-->
</div>
</div>
<!-- End Page Heading -->


<div class="row">
<div class="col-lg-3 col-sm-6 mb-3">
<div class="w-100 bg-success text-white p-3">
<div><span class="fa fa-users fa-2x"></span></div>

<div class="row">
<div class="col-sm-7 align-self-center FontSize18">Total Visits</div>
<div class="col-sm-5 text-right FontSize28">1001</div>
</div>
</div>
</div>

<div class="col-lg-3 col-sm-6 mb-3">
<div class="w-100 bg-warning text-white p-3">
<div><span class="fa fa-calendar-alt fa-2x"></span></div>

<div class="row">
<div class="col-sm-7 align-self-center FontSize18">Todays Visit</div>
<div class="col-sm-5 text-right FontSize28">501</div>
</div>
</div>
</div>

<div class="col-lg-3 col-sm-6 mb-3">
<div class="w-100 bg-danger text-white p-3">
<div><span class="fa fa-user-times fa-2x"></span></div>

<div class="row">
<div class="col-sm-7 align-self-center FontSize18">Cancel Visit</div>
<div class="col-sm-5 text-right FontSize28">101</div>
</div>
</div>
</div>

<div class="col-lg-3 col-sm-6 mb-3">
<div class="w-100 bg-info text-white p-3">
<div><span class="fa fa-address-card fa-2x"></span></div>

<div class="row">
<div class="col-sm-7 align-self-center FontSize18">Attended Visit</div>
<div class="col-sm-5 text-right FontSize28">52</div>
</div>
</div>
</div>
</div>


<div class="row">
<div class="col-lg-8">
<div class="row">
<div class="col-lg-6 mb-3">
<div class="w-100 bg-white">
<h2 class="m-0 FontSize22 p-3 TopBarBgColor text-white border-bottom">
<i class="fa fa-bullhorn fa-fw"></i> Upcoming Visits
</h2>
<div class="p-2" style="max-height:360px; overflow-y:scroll; overflow-x:hidden;">
<div class="table-responsive">
<table class="table">
<thead>
<tr>
<th class="BlackTxtColor">Visitor Name</th>
<th class="BlackTxtColor">Visit Date</th>
<th class="BlackTxtColor">Time</th>
</tr>
</thead>

<tbody>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
<tr>
<td>Rahul Dev</td>
<td>15-04-2020</td>
<td>02:30</td>
</tr>
</tbody>
</table>
</div> 
</div>
</div>
</div>

<div class="col-lg-6 mb-3">
<div class="w-100 bg-white">
<h2 class="m-0 FontSize22 p-3 TopBarBgColor text-white border-bottom">
<i class="fa fa-file-alt fa-fw"></i> To do list
</h2>
<div class="p-2" style="max-height:360px; overflow-y:scroll; overflow-x:hidden;">
<ul class="listNew">
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
<li><i class="fa fa-user fa-fw"></i> Omkar Deshmukh</li>
</ul> 
</div>
</div>
</div>
</div>

<div class="row mb-3">
<div class="col-lg-12">
<div class="w-100 bg-white">
<h2 class="m-0 FontSize22 p-3 TopBarBgColor text-white border-bottom">
<i class="fa fa-sliders-h fa-fw"></i> Controls
</h2>
<div class="p-2 text-center">
<ul class="list-inline">
<li class="list-inline-item mr-4"><div class="Circle80 bg-warning m-auto"><i class="fa fa-file-medical fa-2x text-white"></i></div></li>

<li class="list-inline-item mr-4"><div class="Circle80 bg-danger m-auto"><i class="fa fa-chart-pie fa-2x text-white"></i></div></li>

<li class="list-inline-item"><div class="Circle80 bg-info m-auto"><i class="fa fa-info fa-2x text-white"></i></div></li>
</ul>
</div>
</div>
</div>
</div>
</div>

<div class="col-lg-4 mb-3">
<div class="row">
<div class="col-lg-12">
<div class="w-100 bg-white">
<h2 class="m-0 FontSize22 p-3 TopBarBgColor text-white border-bottom">
<i class="fa fa-users fa-fw"></i> Contacts
</h2>

<div class="w-100 px-2 mt-2">
<div class="input-group mb-2">
<input type="text" class="form-control" placeholder="Search">
<div class="input-group-prepend">
<div class="input-group-text rounded-right border-left"><i class="fa fa-search"></i></div>
</div>
</div>
</div>

<div class="p-2" style="max-height:480px; overflow-y:scroll; overflow-x:hidden;">
<ul class="listNew">
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
<li class="Rel"><i class="fa fa-user fa-fw"></i> Omkar Deshmukh <button class="btn btn-primary btn-sm ContFloatingBtn" data-toggle="modal" data-target="#VisitScheduleModal">Set Visit</button></li>
</ul> 
</div>

<!--Visit Schedule Modal-->
<div class="modal fade" id="VisitScheduleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Visit Schedule Form</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<div class="row">

<div class="col-lg-6">
<div class="form-group">
<label>Name</label>
<input type="text" class="form-control">
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Email Id</label>
<input type="text" class="form-control">
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Phone Number</label>
<input type="text" class="form-control">
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Organization Name</label>
<textarea class="form-control" rows="2	"></textarea>
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Meeting Type</label>
<input type="text" class="form-control">
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Visit Date</label>
<div class="FaIcon">
<i class="fa fa-calendar-alt FloatIcon"></i>
<input type="text" class="form-control">
</div>
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Visit Time</label>
<div class="FaIcon">
<i class="fa fa-clock FloatIcon"></i>
<input type="text" class="form-control">
</div>
</div>
</div>

<div class="col-lg-6">
<div class="form-group">
<label>Location</label>
<input type="text" class="form-control">
</div>
</div>

</div>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-primary">Set Visit</button>
<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
<button type="button" class="btn btn-warning">Future Ref.</button>
</div>
</div>
</div>
</div>
<!--//Visit Schedule Modal-->
</div>
</div>
</div>
</div>
</div>


</div>
<!-- /End Page Content -->



</div>
<!-- End of Main Content -->

<?php include 'include/footer.php';?>