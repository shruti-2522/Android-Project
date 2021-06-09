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
  
mysqli_query($con,"insert into tblpubs(pub_name)values('$txtpname')");
header("location:show_pubs.php");

}
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>Add Pubs<b></center></h3>
    </div>
     
    <form class="form-group text-center" style="color: #757575;"
      method="post">
      <br><br>
    <table class="table">
        <tr>
      
            <td><b>Enter Pub name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txtpname" class="form-control"required >
              </div>
            </td>
          </tr>
          <tr>
            <td colspan=2 align=center><input type="submit" class="button-btn-suuccess" name="btnadd" value="Add Pub">
            </td>
          </tr>
          
        </table>
        
        <br>
        



</body>
</html>