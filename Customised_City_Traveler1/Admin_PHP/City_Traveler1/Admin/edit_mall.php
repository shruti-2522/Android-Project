<!DOCTYPE html>
<html>
<head>
  <?php  include('head.php');?>
   <?php  include('config.php');?>
  <title></title>
</head>
<body>
<?php include('header.php');?>

      
<?php
if(isset($_POST["btnsave"]))
{
  extract($_POST);

  mysqli_query($con,"update tblmall set mname='$txtmname',stime='$txtstime',etime='$txtetime',addr='$txtaddr' where mid=".$_GET["id"]);

  echo "<script>window.location.href='malls.php';</script>";
    exit;
}
  $q1=mysqli_query($con,"select * from tblmall where mid=".$_GET["id"]);

  $r1=mysqli_fetch_array($q1);
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>EDIT MALLS<b></center></h3>
    </div>
     
    <form class="form-group text-center"
      method="post">
      <br><br>
    <table class="table">
        <tr style='border:hidden;'>
       <td><b>Enter Mall Name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txtmname" class="form-control"  value='<?php echo $r1['mname'];?>'>
              </div>
            </td>
          </tr>
          </tr>
           <tr style='border:hidden;'>
    <td><b>Start Time:</b></td>
            <td>
              <div class="col-sm-6">
                <input type="time"  name="txtstime" class="form-control"  value='<?php echo $r1['stime'];?>'>
              </div>
            </td>
          </tr>
          </tr>
          <tr>
      
       <tr style='border:hidden;'>
    <td><b>End Time:</b></td>
            <td>
              <div class="col-sm-6">
                <input type="time"  name="txtetime" class="form-control"  value='<?php echo $r1['etime'];?>'>
              </div>
            </td>
          </tr>
          </tr>
          <tr>
      
          <tr style='border:hidden;'>
    <td><b>Address:</b></td>
            <td>
              <div class="col-sm-6">
                 <textarea name="txtaddr" class="form-control"><?php echo $r1['addr']?> </textarea>
              </div>
            </td>
          </tr>
          </tr>
       
<center>
  <div class="col-sm-8">
          <tr style='border:hidden;'>
            <td colspan="8"><input type="submit" class="btn btn-primary " name="btnsave" value="UPDATE">
            </td>
          </tr>
        </div>
        </center>
          
        </table>
        
        <br>
        

</body>
</html>