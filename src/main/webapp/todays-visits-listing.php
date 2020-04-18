
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
<h1 class="h4 text-gray-800">Todays Visits Listing</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white p-3 mb-3">
<div class="table-responsive my-3 px-3">
<table class="table table" id="dataTable" width="100%" cellspacing="0">
<thead>
<tr>
<th>Sr.No.</th>
<th>Visitor Name</th>
<th>Visitor Phone</th>
<th>Total Co-Visitor</th>
<th>Checkin Gate</th>
<th>Check-In</th>
<th>Cancel</th>
<th>Check-Out</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>Balaji Gahire</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>2</td>
<td>Omkar Patil</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>3</td>
<td>Balaji Gahire</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>4</td>
<td>Omkar Patil</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>5</td>
<td>Balaji Gahire</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>6</td>
<td>Omkar Patil</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>7</td>
<td>Balaji Gahire</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>8</td>
<td>Omkar Patil</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>9</td>
<td>Balaji Gahire</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>

<tr>
<td>10</td>
<td>Omkar Patil</td>
<td>1234567890</td>
<td>2</td>
<td>12:00 PM</td>
<td><button class="btn btn-success btn-sm">Check In</button></td>
<td><button class="btn btn-danger btn-sm">Cancel</button></td>
<td><button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#CheckOutModal">Check Out</button></td>
</tr>
</tbody>
</table>
</div>
</div>

<!--CheckOut-->
<div class="modal fade" id="CheckOutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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