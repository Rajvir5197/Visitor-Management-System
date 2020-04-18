
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
<h1 class="h4 text-gray-800">Add New Contact</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white p-3 mb-3">
<div class="row">

<div class="col-lg-12">
<div class="row">
<div class="col-lg-3">
<div class="form-group">
<label>Salutation</label>
<select class="form-control">
<option>Mr.</option>
<option>Mrs.</option>
<option>Smt.</option>
</select>
</div>
</div>

<div class="col-lg-3">
<div class="form-group">
<label>First Name<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-3">
<div class="form-group">
<label>Middle Name<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-3">
<div class="form-group">
<label>Last Name<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>
</div>

<div class="row">
<div class="col-lg-3">
<div class="form-group">
<label>Designation<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-3">
<div class="form-group">
<label>Gender</label>
<select class="form-control">
<option>Male</option>
<option>Female</option>
</select>
</div>
</div>

<div class="col-lg-3">
<div class="form-group">
<label>Company<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-3">
<div class="form-group">
<label>Mobile No.<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>
</div>

<div class="row">
<div class="col-lg-3">
<div class="form-group">
<label>Email<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-9 align-self-center">
<button class="btn btn-primary">Submit</button>
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