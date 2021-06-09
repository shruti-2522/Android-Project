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

  mysqli_query($con,"update tbltemp set temp_name='$txttname',otime='$txtopen',ctime='$txtclos',loc='$txtlocation' where tid=".$_GET["id"]);

  echo "<script>window.location.href='temples.php';</script>";
    exit;
}
  $q1=mysqli_query($con,"select * from tbltemp where tid=".$_GET["id"]);

  $r1=mysqli_fetch_array($q1);
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>EDIT TEMPLES<b></center></h3>
    </div>
     
    <form class="form-group text-center" style="color: #757575;"
      method="post" enctype="multipart/form-data">
      <br><br>
    <table class="table">
        <tr>
      
            <td><b>Enter Temple Name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txttname" class="form-control" value='<?php echo $r1['temp_name'] ?>'>
              </div>
            </td>
          </tr>
          <tr>

              <td><b>Opening Time:</b></td>
            <td>
              <div class="col-sm-6">
                <input type="time"  name="txtopen" class="form-control" value='<?php echo $r1['otime'] ?>'>
              </div>
            </td>
          </tr>
          </tr>
          <tr>

              <td><b>Closing Time:</b></td>
            <td>
              <div class="col-sm-6">
                <input type="time"  name="txtclose" class="form-control" value='<?php echo $r1['ctime'] ?>'>
              </div>
            </td>
          </tr>
          </tr>
          <tr>

              <td><b>Address:</b></td>
            <td>
              <div class="col-sm-6">
                <textarea name="txtlocation" class="form-control"><?php echo $r1['loc'] ?></textarea>
              </div>
            </td>
          </tr>
          </tr>
          <tr>

      
       
          </tr>
            <td colspan=2 align=center><input type="submit" class="btn btn-primary" name="btnsave" value="UPDATE">
            </td>
          </tr>
          
        </table>
        
        <br>
        



</body>
</html>