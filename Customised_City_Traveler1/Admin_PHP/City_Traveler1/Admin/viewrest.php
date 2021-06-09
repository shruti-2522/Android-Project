<?php
include 'config.php';
$q=mysqli_query($con,"select * from tblrest where rid='".$_REQUEST["rid"]."'");

while($r=mysqli_fetch_array($q))
{
	$z[]=$r;
}
echo json_encode($z);

?>