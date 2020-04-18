
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
<div class="col-lg-4">
<div class="form-group">
<label>Name<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-4">
<div class="form-group">
<label>Email Id<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-4">
<div class="form-group">
<label>Phone No.<span class="text-danger">*</span></label>
<input class="form-control" />
</div>
</div>
</div>

<div class="row">
<div class="col-lg-4">
<div class="form-group">
<label>Organization Name<span class="text-danger">*</span></label>
<textarea class="form-control" rows="1"></textarea>
</div>
</div>

<div class="col-lg-4">
<div class="form-group">
<label>Meeting type<span class="text-danger">*</span></label>
<select class="form-control">
<option>Meeting Type 1</option>
<option>Meeting Type 2</option>
</select>
</div>
</div>

<div class="col-lg-4">
<div class="form-group">
<label>Visit Date<span class="text-danger">*</span></label>
<div class="FaIcon">
<i class="fa fa-calendar-alt FloatIcon"></i>
<input type="date" class="form-control">
</div>
</div>
</div>
</div>

<div class="row">
<div class="col-lg-4">
<div class="form-group">
<label>Visit Time<span class="text-danger">*</span></label>
<div class="FaIcon">
<i class="fa fa-clock FloatIcon"></i>
<input type="text" class="form-control">
</div>
</div>
</div>

<div class="col-lg-4">
<div class="form-group">
<label>Location<span class="text-danger">*</span></label>
<input type="text" class="form-control">
</div>
</div>
</div>


<div class="row">
<div class="col-lg-12 align-self-center">
<button type="button" class="btn btn-primary mr-3">Set Visit</button>
<button type="button" class="btn btn-secondary mr-3" data-dismiss="modal">Cancel</button>
<button type="button" class="btn btn-warning mr-3">Future Ref.</button>
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