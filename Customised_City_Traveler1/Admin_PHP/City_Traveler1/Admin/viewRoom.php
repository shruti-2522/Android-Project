<?php
include 'config.php';
$q=mysqli_query($con,"select * from tblbroom,tblhotel where tblhotel.hid=tblbroom.hid and tblbroom.uid='".$_REQUEST["uid"]."'");
while($r=mysqli_fetch_array($q))
{
$z[]=$r;
}
echo json_encode($z);
?>