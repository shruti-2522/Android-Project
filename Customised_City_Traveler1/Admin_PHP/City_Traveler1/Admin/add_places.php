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
  
mysqli_query($con,"insert into tblplaces(hname,rname,mall_name,pub_name,temp_name,musiam_name)values('$txthname','$txtrname','$txtmname','$txtpubname','$txttname','$txtmusiam')");
header("location:show_places.php");

}
?>

<div id="page-wrapper">
   <br>
  <div class="row">

    <h3><center><b>ADD  PLACES<b></center></h3>
    </div>
     
    <form class="form-group text-center" style="color: #757575;"
      method="post">
      <br><br>
    <table class="table">
        <tr>
      
            <td><b>Enter Hotel name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txthname" class="form-control"required >
              </div>
            </td>
          </tr>

           <tr>
      
            <td><b>Enter Restaurent name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txtrname" class="form-control"required >
              </div>
            </td>
          </tr>

           <tr>
      
            <td><b>Enter Mall name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txtmname" class="form-control"required >
              </div>
            </td>
          </tr>


            <td><b>Enter Pubs name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txtpubname" class="form-control"required >
              </div>
            </td>
          </tr>


            <td><b>Enter Temples name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txttemp" class="form-control"required >
              </div>
            </td>
          </tr>
         

             <td><b>Enter Musiam name:</b></prtd>
            <td>
              <div class="col-sm-6">
                <input type="text"  name="txtmusiam" class="form-control"required >
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