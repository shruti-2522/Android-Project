<?php
include 'config.php';
$q=mysqli_query($con,"insert into tbluser(uname,upass,email)values('".$_POST["uname"]."','".$_POST["upass"]."','".$_POST["email"]."')");
if($q==1)
{
	echo "1";
}
else
{
	echo "0";
}
z
?>