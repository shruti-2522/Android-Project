<!DOCTYPE html>
<html>
<head>
	<?php include  'config.php';?>
	<title></title>
	<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.5.0/mdb.min.css"
  rel="stylesheet"
/>
</head>
<body class="bg-info">
<br><br>

<h1 class="text-center text-white"><b>MY BILL</b></h1>

<?php

$uid=$_GET['id'];
$q=mysqli_query($con,"select * from tbluser where uid=".$uid);

while($r1=mysqli_fetch_array($q))
{
	

?>


<table class="table ">
	<tr>
		<td><font color="black"><b>Name:</b></font></td>
		<td><font color="black"><?php echo $r1['uname'];?></font>

		<td><font color="black"><b>Email:</b></font></td>
		<td><font color="black"><?php echo $r1['email'];?></font>




	</tr>

	</table>
<?php
}
?>


<table class="table table-bordered" border="1">
<tr>
	<th>
		<b>Hotel Name</b>
	</th>
	<th>
		<b>Price</b>
	</th>
	<th>
		<b>Date:</b>
	</th>
	<th>
		<b>Time:</b>
	</th>
	</tr>

<?php

$uid=$_GET['id'];
$q=mysqli_query($con,"select * from tblhotel,tblbroom where tblbroom.rqty and tblbroom.hid=tblhotel.hid and tblbroom.uid=".$uid);

while($r=mysqli_fetch_array($q))
{
	
 
	
?>

	<tr>
		
		<td>
			<?php echo $r['hname'];?>
		</td>
	
		
		<td>
			<?php echo $r['price'];?>
		</td>

			<td>
			<?php echo $r['datep'];?>
		</td>
	
		
		<td>
			<?php echo $r['time'];?>
		</td>

		
	</tr>

<?php
}


?>

</table>


<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.5.0/mdb.min.js"
></script>
</body>
</html>