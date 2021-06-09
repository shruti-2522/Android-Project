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
<h1 class="text-center"><b>TEMPLES DETAILS</b></h1>
<br>

<?php
$q=mysqli_query($con,"select * from tbltemp where tid=".$_GET['id']);
while ($r=mysqli_fetch_array($q)) {
  ?>
  <div class="container text-center">
    <br>
<table class="table" align="center" style="width: 60%;">
   <tr>
    <td>
      <b>Temple Name:</b>
    </td>
   <td>
      <?php echo $r["temp_name"];?>
    </td>
  </tr>
    <tr>
  <td><b>Opening Time:</b></td>
     <td>
     <?php echo $r["otime"];?>
    </td>
  </tr>
    <tr>
  <td><b>Closing Time:</b></td>
     <td>
      <?php echo $r["ctime"];?>
    </td>
  </tr>
    <tr>
  <td><b>Address:</b></td>
     <td>
     <?php echo $r["loc"];?> 
    </td>
  </tr>
  <tr>
  
 

</table>

  <?php
}?>
</table>
<br><br>
<center><button class="btn btn-primary" onclick="window.location.href='temples.php'"><b>BACK</b></button></center>
</div>
<?php //include('reght_sidebar.php');?>
<?php include('footer.php');?>
             
    </body>
</html>
