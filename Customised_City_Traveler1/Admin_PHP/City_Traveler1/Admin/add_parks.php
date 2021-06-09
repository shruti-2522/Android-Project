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
if(isset($_POST["btnadd"]))
{
extract($_POST);
$imagename=$_FILES['pimg']['name'];

$tempname=$_FILES['pimg']['tmp_name'];
//echo $tempname;
move_uploaded_file($tempname, "image/$imagename");
  
mysqli_query($con,"insert into tblpark(pname,stime,etime,addr,image)values('$park_name','$txtstime','$txtetime','$txtaddr','$imagename')");
 echo "<script>window.location.href='parks.php';</script>";
    exit;

}
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>ADD PARKS<b></center></h3>
    </div>
     
    <form class="form-group text-center" style="color: #757575;"
      method="post" enctype="multipart/form-data">
      <br><br>
    <table class="table">
        <tr style='border:hidden;'>
      
            <td><b>Enter Park Name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="park_name" class="form-control"required >
              </div>
            </td>
          </tr>

              <tr style='border:hidden;'>
    <td><b>Start Time:</b></td>
            <td>
              <div class="col-sm-6">
                <input type="time"  name="txtstime" class="form-control"required >
              </div>
            </td>
          </tr>
          </tr>
          <tr>
      
       <tr style='border:hidden;'>
    <td><b>End Time:</b></td>
            <td>
              <div class="col-sm-6">
                <input type="time"  name="txtetime" class="form-control"required >
              </div>
            </td>
          </tr>
          </tr>
          <tr>
      
          <tr style='border:hidden;'>
    <td><b>Address:</b></td>
            <td>
              <div class="col-sm-6">
                 <textarea name="txtaddr" class="form-control" required ></textarea>
              </div>
            </td>
          </tr>
          </tr>
          <tr style='border:hidden;'>
      
            <td><b>Choose File:</b></td>
            <td>
              <div class="col-sm-6">
                 <input type="file" name="pimg" required>
      
              </div>
            </td>


<center>
  <div class="col-sm-8">
          <tr style='border:hidden;'>
            <td colspan="8"><input type="submit" class="btn btn-primary
              " name="btnadd" value="ADD">
            </td>
          </tr>
        </div>
        </center>
         
          
        </table>
        
        <br>
        



</body>
</html>