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

  mysqli_query($con,"update tblmusiam set mname='$musiam_name',stime='$txtstime',etime='$txtetime',addr='$txtaddr' where musiam_id=".$_GET["id"]);

  echo "<script>window.location.href='musiam.php';</script>";
    exit;
}
  $q1=mysqli_query($con,"select * from tblmusiam where musiam_id=".$_GET["id"]);

  $r1=mysqli_fetch_array($q1);
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>EDIT MUSIAMS<b></center></h3>
    </div>
     
    <form class="form-group text-center"
      method="post">
      <br><br>
    <table class="table">
        <tr style='border:hidden;'>
       <td><b>Enter Musiam Name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="musiam_name" class="form-control"  value='<?php echo $r1['mname'];?>'>
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