<!DOCTYPE html>
<!-- File index.php -->
<html>
<head>
<title>Hello world</title>
<meta charset="utf-8" />
</head>
<body>
<h1>Hello world: apache/php</h1>
<?php
$load = sys_getloadavg();
$serverTimezone = date_default_timezone_get();
date_default_timezone_set($serverTimezone);
?>
Serverzeit: <?php echo date("Y-m-d H:i:s"); ?><br />
Server utilization (load): <?php echo $load[0]; ?>
</body>
</html>
