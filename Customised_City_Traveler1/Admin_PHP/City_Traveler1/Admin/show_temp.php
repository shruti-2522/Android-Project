<?php
include 'config.php';
$q=mysqli_query($con,"select * from tbltemp");

while($r=mysqli_fetch_array($q))
{
	$z[]=$r;
}
echo json_encode($z);
?>