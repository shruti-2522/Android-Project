<?php
include('config.php');
  
 
 $q=mysqli_query($con,"insert into tblbroom(hid,uid,rqty,datep,time)values('".$_REQUEST['hid']."','".$_REQUEST['uid']."', '".$_REQUEST['rqty']."','".$_REQUEST['datep']."','".$_REQUEST['time']."')");
if($q==1)
{
echo "1";
}
else
{
echo "Not added to cart";
}



?>
