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
<body >
<br><br>
<h1 class="text-center"><b>BOOKING DEATILS</b></h1>

<table class="table table-bordered" >
<tr>
	<th>
		<b>Hotel Name:</b>
	</th>
	<th>
		<b>Price:</b>
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
$q=mysqli_query($con,"select * from tblhotel,tblbroom where tblbroom.hid=tblhotel.hid and tblbroom.uid=".$uid);

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

<div class="container text-center">
	  <a href="view_bill.php?id=<?php echo $uid;?>">
      <button class="btn btn-danger btn-sm rounded-0" type="button" data-toggle="tooltip" data-placement="top" title="Delete">VIEW BILL</button></a>
</div>
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.5.0/mdb.min.js"
></script>
</body>
</html>