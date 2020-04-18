
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
<h1 class="h4 text-gray-800">Edit Plants</h1>
</div>
</div>
<!-- End Page Heading -->



<div class="bg-white p-3 mb-3">
<div class="row">

<div class="col-lg-12 mb-3">
<div class="form-group">
<label>Name Of Plant</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-12 mb-3">
<div class="row">
<div class="col-lg-8 align-self-center">
<div class="form-group">
<label>Upload Logo</label>
<div class="custom-file">
<input type="file" class="custom-file-input" id="customFile">
<label class="custom-file-label" for="customFile">Upload Logo</label>
</div>
</div>
</div>

<div class="col-lg-4 text-right">
<img src="images/RUCHA-LOGO.png" class="img-fluid border p-1" width="100px" />
</div>
</div>
</div>

<div class="col-lg-12 mb-3">
<div class="form-group">
<label>Mobile No.</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-12 mb-3">
<div class="form-group">
<label>Email Address</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-12 mb-3">
<div class="form-group">
<label>Google Map Link</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-12">
<div class="row">
<div class="col-lg-6 mb-3">
<div class="form-group">
<label>Google Map Lat</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-6 mb-3">
<div class="form-group">
<label>Google Map Long</label>
<input class="form-control" />
</div>
</div>
</div>
</div>

<div class="col-lg-12 mb-3">
<div class="form-group">
<label>Address</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-12 mb-3">
<div class="form-group">
<label>Pin Code</label>
<input class="form-control" />
</div>
</div>

<div class="col-lg-12 mb-3 mt-3 text-center">
<button class="btn btn-primary">Submit</button>
</div>

</div>
</div>



</div>
<!-- /End Page Content -->



</div>
<!-- End of Main Content -->

<?php include 'include/footer.php';?>