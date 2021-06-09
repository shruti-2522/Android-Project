<?php
include 'config.php';
$q=mysqli_query($con,"select * from tbluser where email='".$_POST["email"]."' and upass='".$_POST["upass"]."'");
if(mysqli_num_rows($q)>0)
{
$ql=mysqli_query($con,"select * from tbluser where email='".$_POST["email"]."'");
$rl=mysqli_fetch_array($ql);
echo $rl["uid"];

}
else
{
echo "0";
}

?>