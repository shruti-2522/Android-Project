<!DOCTYPE html>
<html>
<head>
  <title></title>
    <?php  include('head.php');?>

        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 
  <?php include('config.php');?>
</head>
<body>
  <?php include('header.php');?>
  <div id="page-wrapper">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
<br>

  <h2 class="w3-container"><b>PARKS DETAILS</b></h2>
    <div class="container">
<div class="row">   
  <div class="col-sm-2"></div>
<div class="col-sm-5">
<input type="text" id="myInput" placeholder="Search for names.." title="Type in a name" class="form-control"></a>
</div>
</div>
</div>
<br>
        <div class="container w3-bordered">
  <div class="row">
    <div class="col-sm-2"></div>
 <div class="col-sm-6">
<table class="w3-table" align="center" id="myTable">
  <th><b>Park Name</b></th>
  <th><b>Delete<b></th>
  <th><b>Edit</b></th>
 <?php


  $q1=mysqli_query($con,"select * from tblpark"); 

     while ($r=mysqli_fetch_array($q1)) 

{
    ?>


    <form method="post" enctype="multipart/form-data">

       <tr>
    <td> <a href="show_park1.php?id=<?php echo $r['pid'];?>">
      <?php echo $r["pname"];?></td></a>
    
   
      <Td>
      <a href="delete_park.php?id=<?php echo $r['pid'];?>">
      <button class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete">DELETE</button></a>
    </td>
    <Td>
      <a href="edit_park.php?id=<?php echo $r['pid'];?>">

        <button class="btn btn-success btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Edit">EDIT</i></button>
      </a>
    </td>
    
    </tr>
    
    
          <?php
       }?>

      </table>
    </form>

    <br><br>
    <center><button class="btn btn-primary" onclick="window.location.href='add_parks.php'"><b>ADD</b></button></center>

</body>
</html>
