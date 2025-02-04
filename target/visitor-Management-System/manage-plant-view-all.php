
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
<h1 class="h4 text-gray-800">View Plants</h1>
</div>

<div class="col-sm-4 text-right">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addNewPlantModal">Add New Plant</button>
</div>
</div>

<!--Add New Plant Popup-->
<div class="modal fade" id="addNewPlantModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Add New Plant</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">

<div class="row">
<div class="col-lg-6 border-right">
<div class="row">

<div class="col-lg-12">
<div class="form-group">
<label>Plant Code</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Name</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Address</label>
<textarea class="form-control" rows="1"></textarea>
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant City</label>
<select class="form-control">
<option selected>Aurangabad</option>
</select>
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Pincode</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant State</label>
<select class="form-control">
<option selected>Maharashtra</option>
</select>
</div>
</div>

</div>
</div>

<div class="col-lg-6">
<div class="row">

<div class="col-lg-12">
<div class="form-group">
<label>Plant Country</label>
<select class="form-control">
<option selected>India</option>
</select>
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant GST</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Pan</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Maplink</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant CIN</label>
<input class="form-control">
</div>
</div>

</div>
</div>
</div>

</div>
<div class="modal-footer">
<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
</div>
</div>
</div>
</div>
<!-- End Page Heading -->


<!--Edit Plant Popup-->
<div class="modal fade" id="editPlantModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Edit Plant</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">

<div class="row">
<div class="col-lg-6 border-right">
<div class="row">

<div class="col-lg-12">
<div class="form-group">
<label>Plant Code</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Name</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Address</label>
<textarea class="form-control" rows="1"></textarea>
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant City</label>
<select class="form-control">
<option selected>Aurangabad</option>
</select>
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Pincode</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant State</label>
<select class="form-control">
<option selected>Maharashtra</option>
</select>
</div>
</div>

</div>
</div>

<div class="col-lg-6">
<div class="row">

<div class="col-lg-12">
<div class="form-group">
<label>Plant Country</label>
<select class="form-control">
<option selected>India</option>
</select>
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant GST</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Pan</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant Maplink</label>
<input class="form-control">
</div>
</div>

<div class="col-lg-12">
<div class="form-group">
<label>Plant CIN</label>
<input class="form-control">
</div>
</div>

</div>
</div>
</div>

</div>
<div class="modal-footer">
<button type="button" class="btn btn-primary">Submit</button>
<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
</div>
</div>
</div>
</div>
<!--Edit Plant Popup-->


<!--View Plant Popup-->
<div class="modal fade" id="viewPlantModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">View Plant Details</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">

<div class="row">
<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Plant Code</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 1001</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant Name</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Rucha Engineers Pvt. Ltd. Unit-1</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant Address</div>
<div class="col-sm-8 BlackTxtColor mb-3">: K-249, MIDC, WalujWALUJ K-249A, K-252-54 MIDC Waluj</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant City</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Aurangabad</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant Pincode</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 431136</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant State</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Maharashtra</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant Country</div>
<div class="col-sm-8 BlackTxtColor mb-3">: India</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Plant GST</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 27AABCR0931M1ZB</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant Pan</div>
<div class="col-sm-8 BlackTxtColor mb-3">: AABCR0931M</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant Maplink</div>
<div class="col-sm-8 BlackTxtColor mb-3">: -</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Plant CIN</div>
<div class="col-sm-8 BlackTxtColor mb-3">: U29299PN2004PTC</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Reg by</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 100782</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Reg Date</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 4/11/2020</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Reg Time</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 4:00:00 PM</div>
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
<!--View Plant Popup-->


<div class="bg-white p-3 mb-3">
<div class="table-responsive my-3 px-3">
<table class="table table" id="dataTable" width="100%" cellspacing="0">
<thead>
<tr>
<th>Plant Code</th>
<th>Plant Name</th>
<th>Plant Address</th>
<th>Plant City</th>
<th>Action</th>	
</tr>
</thead>
<tbody>
<tr>
<td>1001</td>
<td>Rucha Engineers Pvt. Ltd. Unit-1</td>
<td>K-249, MIDC, WalujWALUJ K-249A, K-252-54 MIDC Waluj</td>
<td>Aurangabad</td>
<td><span data-toggle="modal" data-target="#editPlantModal"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></span> 
<span data-toggle="modal" data-target="#viewPlantModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> 
<i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>1001</td>
<td>Rucha Engineers Pvt. Ltd. Unit-1</td>
<td>K-249, MIDC, WalujWALUJ K-249A, K-252-54 MIDC Waluj</td>
<td>Aurangabad</td>
<td><span data-toggle="modal" data-target="#editPlantModal"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></span> 
<span data-toggle="modal" data-target="#viewPlantModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> 
<i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>1001</td>
<td>Rucha Engineers Pvt. Ltd. Unit-1</td>
<td>K-249, MIDC, WalujWALUJ K-249A, K-252-54 MIDC Waluj</td>
<td>Aurangabad</td>
<td><span data-toggle="modal" data-target="#editPlantModal"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></span> 
<span data-toggle="modal" data-target="#viewPlantModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> 
<i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>1001</td>
<td>Rucha Engineers Pvt. Ltd. Unit-1</td>
<td>K-249, MIDC, WalujWALUJ K-249A, K-252-54 MIDC Waluj</td>
<td>Aurangabad</td>
<td><span data-toggle="modal" data-target="#editPlantModal"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></span> 
<span data-toggle="modal" data-target="#viewPlantModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> 
<i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>1001</td>
<td>Rucha Engineers Pvt. Ltd. Unit-1</td>
<td>K-249, MIDC, WalujWALUJ K-249A, K-252-54 MIDC Waluj</td>
<td>Aurangabad</td>
<td><span data-toggle="modal" data-target="#editPlantModal"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></span> 
<span data-toggle="modal" data-target="#viewPlantModal"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> 
<i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
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