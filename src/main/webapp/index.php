

<?php 
set_time_limit(0);
ini_set('default_socket_timeout', 300);
session_start();

define("clientID", '8e92bafbcdcc4c849fdca959b0daba81');
define("clientSecret", '024355aaf3d34ba995cdd7dcde5a6bef');
define("redirectURI", 'http://java-jordanharmon.rhcloud.com/');
define("imageDirectory", 'pics/');
?>
<!DOCTYPE html>
<html>
<body>
	<a href="https://api.instagram.com/oauth/authorize/?client_id=8e92bafbcdcc4c849fdca959b0daba81&redirect_url=http://java-jordanharmon.rhcloud.com/&response_type=code">Login</a>
</body>
</html>