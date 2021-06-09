
<?php
include 'config.php';

$response = array(); 
$pid = $_GET['hid'];

$q=mysqli_query($con,"select * from tblhotel");
if(mysqli_num_rows($q)>0)
{

		$q1=mysqli_query($con,"select * from tblhotel");
		$r1=mysqli_fetch_array($q1);
		$address = $r1["addr"];

		echo '<iframe width="100%" height="500" frameborder="0" src="https://maps.google.com/maps?f=q&source=s_q&hl=en&geocode=&q=' . str_replace(",", "", str_replace(" ", "+", $address)) . '&z=18&output=embed"></iframe>';
}
else
{
	echo "0";
}

?>