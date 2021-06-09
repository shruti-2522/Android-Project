<?php
include 'config.php';
$q=mysqli_query($con,"select * from tblhotel where hid='".$_REQUEST["hid"]."'");

while($r=mysqli_fetch_array($q))
{
	$z[]=$r;
}
echo json_encode($z);

?>