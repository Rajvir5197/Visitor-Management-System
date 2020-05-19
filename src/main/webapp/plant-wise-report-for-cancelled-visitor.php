
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
<div class="col-sm-12">
<h1 class="h4 text-gray-800">Plant Wise Report For Cancelled Visitor</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white px-3 pt-3 mb-3">
<div class="row">
<div class="col-lg-3 mb-3">
<div class="row">
<div class="col-sm-4 align-self-center">From Date</div>
<div class="col-sm-8">
<div class="FaIcon">
<i class="fa fa-calendar-alt FloatIcon"></i>
<input type="date" class="form-control">
</div>
</div>
</div>
</div>

<div class="col-lg-3 mb-3">
<div class="row">
<div class="col-sm-4 align-self-center">To Date</div>
<div class="col-sm-8">
<div class="FaIcon">
<i class="fa fa-calendar-alt FloatIcon"></i>
<input type="date" class="form-control">
</div>
</div>
</div>
</div>

<div class="col-lg-3 mb-3">
<div class="row">
<div class="col-sm-4 align-self-center">Select Plant</div>
<div class="col-sm-8">
<select class="form-control">
<option>All Plant</option>
</select>
</div>
</div>
</div>

<div class="col-lg-3 mb-3">
<div class="row">
<div class="col-sm-4 align-self-center">Select Dept.</div>
<div class="col-sm-8">
<select class="form-control">
<option>All Dept.</option>
</select>
</div>
</div>
</div>

<div class="col-lg-12 mb-3 text-right">
<button type="button" class="btn btn-primary">Submit</button>
</div>
</div>
</div>



<div class="bg-white p-3 mb-3">
<div class="table-responsive my-3 px-3">
<table class="table table" id="dataTable" width="100%" cellspacing="0">
<thead>
<tr>
<th>Sr.No.</th>
<th>Visitor Name</th>
<th>Visitor Org</th>
<th>Visit To</th>
<th>Visit Plant</th>
<th>Visit To Dept.</th>
<th>Visit Date</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>Rahul Dev</td>
<td>Start Industry</td>
<td>Rucha Group</td>
<td>Aurangabad</td>
<td>Sales</td>
<td>05-05-2020</td>
</tr>

<tr>
<td>2</td>
<td>Rahul Dev</td>
<td>Start Industry</td>
<td>Rucha Group</td>
<td>Aurangabad</td>
<td>Sales</td>
<td>05-05-2020</td>
</tr>

<tr>
<td>3</td>
<td>Rahul Dev</td>
<td>Start Industry</td>
<td>Rucha Group</td>
<td>Aurangabad</td>
<td>Sales</td>
<td>05-05-2020</td>
</tr>

<tr>
<td>4</td>
<td>Rahul Dev</td>
<td>Start Industry</td>
<td>Rucha Group</td>
<td>Aurangabad</td>
<td>Sales</td>
<td>05-05-2020</td>
</tr>

<tr>
<td>5</td>
<td>Rahul Dev</td>
<td>Start Industry</td>
<td>Rucha Group</td>
<td>Aurangabad</td>
<td>Sales</td>
<td>05-05-2020</td>
</tr>
</tbody>
</table>
</div>
</div>


</div>
<!-- /End Page Content -->



</div>
<!-- End of Main Content -->

<?php include 'include/footer.php';?>