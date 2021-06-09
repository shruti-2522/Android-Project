<?php
include 'config.php';
$q=mysqli_query($con,"select * from tblmusiam where musiam_id='".$_REQUEST["musiam_id"]."'");

while($r=mysqli_fetch_array($q))
{
	$z[]=$r;
}
echo json_encode($z);

?>