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
  
  $imagename=$_FILES['simg']['name'];

$tempname=$_FILES['simg']['tmp_name'];
  //echo $tempname;
move_uploaded_file($tempname, "image/$imagename");
 
 mysqli_query($con,"insert into tblhotel(hname,stime,etime,addr,image,price)values('$txthotel','$txtstime','$txtetime','$txtaddr','$imagename','$txtprice')");
 echo "<script>window.location.href='hotel.php';</script>";
    exit;


}
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>ADD HOTEL<b></center></h3>
    </div>
     
    <form class="form-group text-center" method="post" enctype="multipart/form-data">
      <br><br>
    <table class="table">
        <tr style='border:hidden;'>
       <td><b>Enter Hotel Name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txthotel" class="form-control"required >
              </div>
            </td>
          </tr>
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
          <td>

       <tr style='border:hidden;'>
    <td><b>Choose File:</b></td>
              <div class="col-sm-7">
               <td>
        <input type="file" name="simg" required>
      
              </div>
            </td>
          </tr>

  <tr style='border:hidden;'>
    <td><b>Price:</b></td>
            <td>
              <div class="col-sm-6">
                 <input type="text" name="txtprice" class="form-control" required>
              </div>
            </td>
          </tr>
          <td>


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