<!DOCTYPE html>
<html lang="en">
<head>
<?php include('head.php');?>
<?php include('config.php');?>

</head>
<body class="sb-nav-fixed">
   
<?php include('header.php');?>
<div id="page-wrapper">
  <br>
<h1 class="text-center"><b>MUSIAM DETAILS</b></h1>
<br>

<?php
$q=mysqli_query($con,"select * from tblmusiam where musiam_id=".$_GET['id']);
while ($r=mysqli_fetch_array($q)) {
  ?>
  <div class="container text-center">
    <br>
<table class="table" align="center" style="width: 60%;">
   <tr>
    <td>
      <b>Musiam Name:</b>
    </td>
   <td>
      <?php echo $r["mname"];?>
    </td>
  </tr>
    <tr>
  <td><b>Start Time:</b></td>
     <td>
     <?php echo $r["stime"];?>
    </td>
  </tr>
    <tr>
  <td><b>End Time:</b></td>
     <td>
      <?php echo $r["etime"];?>
    </td>
  </tr>
    <tr>
  <td><b>Address:</b></td>
     <td>
     <?php echo $r["addr"];?> 
    </td>
  </tr>
  <tr>
  
 

</table>

  <?php
}?>
</table>
<br><br>
<center><button class="btn btn-primary" onclick="window.location.href='musiam.php'"><b>BACK</b></button></center>
</div>
<?php //include('reght_sidebar.php');?>
<?php include('footer.php');?>
             
    </body>
</html>
