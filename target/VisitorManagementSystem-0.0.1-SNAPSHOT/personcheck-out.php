
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
<h1 class="h4 text-gray-800">Person Check-out</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white p-3 mb-3">
<div class="border px-3 pt-3 mb-3">
<div class="row">
<div class="col-lg-6">
<div class="row">
<div class="col-sm-5 mb-3">Visit No.</div>
<div class="col-sm-7 BlackTxtColor mb-3">: 1234567890</div>
</div>

<div class="row">
<div class="col-sm-5 mb-3">Visitor Name</div>
<div class="col-sm-7 BlackTxtColor mb-3">: Sylvester Stallone</div>
</div>

<div class="row">
<div class="col-sm-5 mb-3">Visitor From</div>
<div class="col-sm-7 BlackTxtColor mb-3">: Start Industry Ltd.</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-5 mb-3">Meeting Type</div>
<div class="col-sm-7 BlackTxtColor mb-3">: Vendor</div>
</div>

<div class="row">
<div class="col-sm-5 mb-3">Visit Time</div>
<div class="col-sm-7 BlackTxtColor mb-3">: 12:00 PM</div>
</div>

<div class="row">
<div class="col-sm-5 mb-3">Visitor Phone</div>
<div class="col-sm-7 BlackTxtColor mb-3">: 9876543234</div>
</div>
</div>
</div>
</div>

<div class="border bg-light px-3 pt-3 mb-3">
<div class="row">
<div class="col-lg-4">
<div class="row">
<div class="col-sm-5 mb-3">Meeting with</div>
<div class="col-sm-7 BlackTxtColor mb-3">: Rahul Dev</div>
</div>
</div>

<div class="col-lg-4">
<div class="row">
<div class="col-sm-5 mb-3">Check Out Time</div>
<div class="col-sm-7 BlackTxtColor mb-3">: 03:00 PM</div>
</div>
</div>

<div class="col-lg-4">
<div class="row">
<div class="col-sm-5 mb-3">Remark</div>
<div class="col-sm-7 BlackTxtColor mb-3">: No remark</div>
</div>
</div>
</div>
</div>

<div class="row">
<div class="col-lg-3 mb-3">
<img src="images/profile-pic.jpg" class="img-fluid border p-2" />
</div>

<div class="col-lg-9 mb-3">
<h2 class="m-0 FontSize22 p-3 bg-light BlackTxtColor border border-bottom-0">Co-Visitor Information</h2>
<div class="table-responsive">
<table class="table table-bordered">
<thead>
<tr>
<th>Visitor Name</th>
<th>Phone No.</th>
<th>Asset</th>
<th>Check Out</th>
</tr>
</thead>

<tbody>
<tr>
<td>Sylvester Stallone</td>
<td>9876543212</td>
<td><button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#viewAssetModal"><i class="fa fa-eye fa-fw fa-lg"></i> View</button></td>
<td><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#checkoutModal">Check Out</button></td>
</tr>

<tr>
<td>Sylvester Stallone</td>
<td>9876543212</td>
<td><button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#viewAssetModal"><i class="fa fa-eye fa-fw fa-lg"></i> View</button></td>
<td><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#checkoutModal">Check Out</button></td>
</tr>

<tr>
<td>Sylvester Stallone</td>
<td>9876543212</td>
<td><button type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#viewAssetModal"><i class="fa fa-eye fa-fw fa-lg"></i> View</button></td>
<td><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#checkoutModal">Check Out</button></td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
</div>


<!--Assets List Check Out-->
<div class="modal fade" id="viewAssetModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Assets List Check Out</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<div class="table-responsive">
<table class="table table-bordered">
<thead>
<tr>
<th>Asset Name</th>
<th>Asset Count</th>
<th>Asset Status</th>
</tr>
</thead>

<tbody>
<tr>
<td>Laptop</td>
<td>1</td>
<td><button type="button" class="btn btn-success btn-sm"><i class="fa fa-check fa-fw fa-lg"></i> Delivered</button></td>
</tr>

<tr>
<td>Mobile</td>
<td>1</td>
<td><button type="button" class="btn btn-success btn-sm"><i class="fa fa-check fa-fw fa-lg"></i> Delivered</button></td>
</tr>

<tr>
<td>Pen Drive</td>
<td>1</td>
<td><button type="button" class="btn btn-danger btn-sm"><i class="fa fa-times fa-fw fa-lg"></i> Not Delivered</button></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
</div>
</div>
</div>
</div>
<!--//Assets List Check Out-->


<!--CheckOut-->
<div class="modal fade" id="checkoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Check Out</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<div class="row">
<div class="col-lg-12">
<div class="form-group">
<label>Remarks if any</label>
<textarea class="form-control" rows="3"></textarea>
</div>
</div>
</div>
</div>
<div class="modal-footer">
<button type="button" class="btn btn-primary">Check Out</button>
<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
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