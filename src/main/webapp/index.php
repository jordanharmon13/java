

<?php 
set_time_limit(0);
ini_set('default_socket_timeout', 300);
session_start();

define("clientID", '8e92bafbcdcc4c849fdca959b0daba81');
define("clientSecret", '024355aaf3d34ba995cdd7dcde5a6bef');
define("websiteURI", 'http://java-jordanharmon.rhcloud.com/');
define("imageDirectory", 'pics/');
?>
<!DOCTYPE html>
<html>
<body>
	<a href="https://api.instagram.com/oauth/authorize/?client_id=<?php echo clientID; ?>&redirect_url=<?php echo websiteURI; ?>&response_type=code">Login</a>
</body>
</html>