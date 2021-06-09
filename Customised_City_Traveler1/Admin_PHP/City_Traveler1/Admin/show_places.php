<?php
include 'config.php';
$q=mysqli_query($con,"select * from tblplaces");

while($r=mysqli_fetch_array($q))
{
  $z[]=$r;
}
echo json_encode($z);
?>
<!-- <!DOCTYPE html>
<html>
<head>
<title></title>
<?php include 'head.php';?>

<?php include 'config.php';?>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
<?php include 'header.php';?>
<center>
  <div id="page-wrapper">

    <div class="w3-container w3-card w3-white"  style="width:50%">

    <header class=" w3-container w3-blue">
  <h4><center><b>PLACES<b><center></h4>
</header>
<?php
$q=mysqli_query($con,"select * from tblplaces");
while ($r=mysqli_fetch_array($q)) {


  ?>


  <div class="row">
  <div class="col-sm-2"></div>
  <div class="col-sm-2">

<table  class="w3-table">
  <tr class="header">
    <tr>
    <td><b>Hotel Name:</b></td>
     <td>
      <?php echo $r["hname"];?>
    </td>
  </tr>

  <tr>
    <td><b>Restaurent Name:</b></td>
     <td>
      <?php echo $r["rname"];?>
    </td>
  </tr>

  <tr>
    <td><b>Mall Name:</b></td>
     <td>
      <?php echo $r["mall_name"];?>
    </td>
  </tr>


   <tr>
    <td><b>Pub name:</b></td>
     <td>
      <?php echo $r["pub_name"];?>
    </td>
  </tr>

<tr>
    <td><b>Temple Name:</b></td>
     <td>
      <?php echo $r["temp_name"];?>
    </td>
  </tr>

  <tr>
    <td><b>Musiam Name:</b></td>
     <td>
      <?php echo $r["musiam_name"];?>
    </td>
  </tr>

   
  
 <tr>
 <td>  
<center><button class="w3-button w3-blue w3-round"><a href="add_places.php">BACK</button>
</td></tr></center>
</td>
</tr>


    

    
</table>
  
</div>



  </div>
</div>
</div><br><br>
</center>
<?php
}


?>
  
</body>
</html> -->