
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
<h1 class="h4 text-gray-800">View Contact</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white p-3 mb-3">
<div class="table-responsive my-3 px-3">
<table class="table table" id="dataTable" width="100%" cellspacing="0">
<thead>
<tr>
<th>Name</th>
<th>Designation</th>
<th>Gender</th>
<th>Company</th>
<th>Mobile No.</th>
<th>Email</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<tr>
<td>Rucha Omkar Deshmuk</td>
<td>Accountant</td>
<td>Female</td>
<td>Rucha Industry Ltd.</td>
<td>9876543234</td>
<td>rucha@gmail.com</td>
<td><span data-toggle="modal" data-target="#viewConDetails"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> <a href="manage-contact-edit.php"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></a> <i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>Rucha Omkar Deshmuk</td>
<td>Accountant</td>
<td>Female</td>
<td>Rucha Industry Ltd.</td>
<td>9876543234</td>
<td>rucha@gmail.com</td>
<td><span data-toggle="modal" data-target="#viewConDetails"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> <a href="manage-contact-edit.php"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></a> <i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>Rucha Omkar Deshmuk</td>
<td>Accountant</td>
<td>Female</td>
<td>Rucha Industry Ltd.</td>
<td>9876543234</td>
<td>rucha@gmail.com</td>
<td><span data-toggle="modal" data-target="#viewConDetails"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> <a href="manage-contact-edit.php"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></a> <i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>Rucha Omkar Deshmuk</td>
<td>Accountant</td>
<td>Female</td>
<td>Rucha Industry Ltd.</td>
<td>9876543234</td>
<td>rucha@gmail.com</td>
<td><span data-toggle="modal" data-target="#viewConDetails"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> <a href="manage-contact-edit.php"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></a> <i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>

<tr>
<td>Rucha Omkar Deshmuk</td>
<td>Accountant</td>
<td>Female</td>
<td>Rucha Industry Ltd.</td>
<td>9876543234</td>
<td>rucha@gmail.com</td>
<td><span data-toggle="modal" data-target="#viewConDetails"><i class="fa fa-eye fa-lg fa-fw Pointer text-dark" data-toggle="tooltip" data-placement="top" title="View"></i></span> <a href="manage-contact-edit.php"><i class="fa fa-edit fa-lg fa-fw Pointer text-primary" data-toggle="tooltip" data-placement="top" title="Edit"></i></a> <i class="fa fa-trash-alt fa-lg fa-fw Pointer text-danger" data-toggle="tooltip" data-placement="top" title="Delete"></i></td>
</tr>
</tbody>
</table>
</div>
</div>


<!--View Details Popup-->
<div class="modal fade" id="viewConDetails" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
<div class="modal-dialog modal-lg" role="document">
<div class="modal-content">
<div class="modal-header">
<h5 class="modal-title BlackTxtColor" id="exampleModalLabel">Contact Details</h5>
<button type="button" class="close" data-dismiss="modal" aria-label="Close">
<span aria-hidden="true">&times;</span>
</button>
</div>
<div class="modal-body">
<div class="row">

<div class="col-lg-6 border-right">
<div class="row">
<div class="col-sm-4 mb-3">Name</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Rucha Omkar Deshmukh</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Designation</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Accountant</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Gender</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Female</div>
</div>
</div>

<div class="col-lg-6">
<div class="row">
<div class="col-sm-4 mb-3">Company</div>
<div class="col-sm-8 BlackTxtColor mb-3">: Rucha Industry Ltd.</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Mobile No.</div>
<div class="col-sm-8 BlackTxtColor mb-3">: 9876543212</div>
</div>

<div class="row">
<div class="col-sm-4 mb-3">Email</div>
<div class="col-sm-8 BlackTxtColor mb-3">: rucha@gmail.com</div>
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
<!--View Details Popup-->


</div>
<!-- /End Page Content -->



</div>
<!-- End of Main Content -->

<?php include 'include/footer.php';?>