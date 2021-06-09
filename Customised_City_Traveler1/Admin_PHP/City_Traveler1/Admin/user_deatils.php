

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<?php include ('head.php');?>
<?php include ('config.php');?>

<title>USER-DETAILS</title>
</head>
<body >
<?php include('header.php');?>
<div id="page-wrapper">
  <div class="container-fluid">
  
  
  <br><br>
   <h1 class="text-center"><b>User-Details<b></center></h1>

 <br><br>

<table class="table table-bordered" align="center" id="myTable">
  <tr class="bg-primary">
  <th><b>User Name</b></th>
  <th><b>Email<b></th>
  <th><b>Password</b></th>
   </b>
  <?php
$q=mysqli_query($con,"select * from tbluser");
while ($r=mysqli_fetch_array($q)) {


  ?>


    
      <!-- Card -->
      <div class="card">

        <!-- Card image -->

        <tr>

          <Td> 
            <?php echo $r['uname'];?>
          </td>

           <Td> 
            <?php echo $r['email'];?>
          </td>

          <Td> 
            <?php echo $r['upass'];?>
          </td>
         <?php
       }
       ?>
  </table>
</div>
  </div>
</body>
</html>