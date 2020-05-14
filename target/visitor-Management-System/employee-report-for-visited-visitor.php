
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
<h1 class="h4 text-gray-800">Employee Report For Visited Visitor</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white px-3 pt-3 mb-3">
<div class="row">
<div class="col-lg-4 mb-3">
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

<div class="col-lg-4 mb-3">
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

<div class="col-lg-4 mb-3">
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
<th>Visitor Org.</th>
<th>Visitor Phone</th>
<th>Visit Date</th>
<th>Visit Time</th>
<th>View Details</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>Rahul Dev</td>
<td>Rucha Group</td>
<td>9638527412</td>
<td>05-05-2020</td>
<td>12:30 PM</td>
<td>
<span data-toggle="modal" data-target="#viewDetailsModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="" data-original-title="View"></i></span>
</td>
</tr>
<tr>
<td>2</td>
<td>Rahul Dev</td>
<td>Rucha Group</td>
<td>9638527412</td>
<td>05-05-2020</td>
<td>12:30 PM</td>
<td>
<span data-toggle="modal" data-target="#viewDetailsModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="" data-original-title="View"></i></span>
</td>
</tr>
<tr>
<td>3</td>
<td>Rahul Dev</td>
<td>Rucha Group</td>
<td>9638527412</td>
<td>05-05-2020</td>
<td>12:30 PM</td>
<td>
<span data-toggle="modal" data-target="#viewDetailsModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="" data-original-title="View"></i></span>
</td>
</tr>
<tr>
<td>4</td>
<td>Rahul Dev</td>
<td>Rucha Group</td>
<td>9638527412</td>
<td>05-05-2020</td>
<td>12:30 PM</td>
<td>
<span data-toggle="modal" data-target="#viewDetailsModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="" data-original-title="View"></i></span>
</td>
</tr>
<tr>
<td>5</td>
<td>Rahul Dev</td>
<td>Rucha Group</td>
<td>9638527412</td>
<td>05-05-2020</td>
<td>12:30 PM</td>
<td>
<span data-toggle="modal" data-target="#viewDetailsModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="" data-original-title="View"></i></span>
</td>
</tr>
</tbody>
</table>
</div>
</div>

<!--CheckOut-->
<div class="modal fade" id="viewDetailsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Employee Report For Visited Visitor</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">

<div class="row mb-3">
<div class="col-lg-12">
<h5 class="BlackTxtColor border-bottom pb-2 text-info">Visitor Details</h5>
</div>
</div>


<div class="row">
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Visitor Name</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Rahul Dev</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Mail Id</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: rahul@gmail.com</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Phone No.</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: 9638527412</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Org. Name</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Rucha Group</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Photo</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: <img src="images/profile-pic.jpg" width="80px" class="border p-1" /></div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Visit No.</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: 101</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Visit At Plant</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Rucha Group</div>
</div>
</div>
</div>


<div class="row mb-3">
<div class="col-lg-12">
<h5 class="BlackTxtColor border-bottom pb-2 text-info">Visit Details</h5>
</div>
</div>


<div class="row">
<div class="col-lg-12"><h6 class="BlackTxtColor"><strong>Visit set details</strong></h6></div>
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Set Date</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: 05-05-2020</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Set Time</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: 12:30 PM</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Meeting Type</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Official meeting</div>
</div>
</div>
</div>

<div class="row">
<div class="col-lg-12"><h6 class="BlackTxtColor"><strong>Visit Check in/out details</strong></h6></div>
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Sec. check in date</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Sec. check in time</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Sec. check in date</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Time</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>
</div>
</div>

<div class="row">
<div class="col-lg-12"><h6 class="BlackTxtColor"><strong>Check In check out by me</strong></h6></div>
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Check in date</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">In time</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Check in date</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Time</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Remark</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>
</div>
</div>


<div class="row mb-3">
<div class="col-lg-12">
<h5 class="BlackTxtColor border-bottom pb-2 text-info">Co- visitor Details</h5>
</div>
</div>

<div class="row">
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Names of co-visitors</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Rahul Dev</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Reason</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: -</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Total person with count</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: 2</div>
</div>
</div>
</div>


<div class="row mb-3">
<div class="col-lg-12">
<h5 class="BlackTxtColor border-bottom pb-2 text-info">Security Details</h5>
</div>
</div>


<div class="row">
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Security code</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: 123445</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Check in sec. name</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Rahul Dev</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Check out sec. name</div>
<div class="col-sm-8 mb-3 BlackTxtColor">: Rahul Dev</div>
</div>
</div>
</div>



</div>
<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
</div>
</div>
</div>
</div>
<!--//CheckOut-->

</div>
<!-- /End Page Content -->



</div>
<!-- End of Main Content -->

<?php include 'include/footer.php';?>