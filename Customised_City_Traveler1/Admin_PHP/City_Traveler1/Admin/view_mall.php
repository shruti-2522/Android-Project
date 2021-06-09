<?php
include 'config.php';
$q=mysqli_query($con,"select * from tblmall where mid='".$_REQUEST["mid"]."'");

while($r=mysqli_fetch_array($q))
{
	$z[]=$r;
}
echo json_encode($z);

?>