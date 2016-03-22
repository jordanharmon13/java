<?php 
set_time_limit(0);
ini_set('default_socket_timeout', 300);
session_start();

define("clientID", '8e92bafbcdcc4c849fdca959b0daba81');
define("clientSecret", '024355aaf3d34ba995cdd7dcde5a6bef');
define("redirectURI", 'http://java-jordanharmon.rhcloud.com/');
define("imageDirectory", 'pics/');

// connect with instagram
function connectToInstagram() {
    $ch = curl_init();

    curl_setopt_array($ch, array(
        CURLOPT_URL => $url,
		CURLOPT_RETURNTRANSFER => true,
		CURLOPT_SSL_VERIFYPEER => false,
		CURLOPT_SSL_VERIFYHOST => 2
    ));
	
	$result = curl_exec($ch);
	curl_close($ch);
	
	return $result;
}

//get user id
function getUserID($userName) {
	$url = 'https://api.instagram.com/v1/users/search?q=' . $userName . '&client_id=' . clientID;
	$instagramInfo = connectToInstagram($url);
	$results = json_decode($instagramInfo, true);
	return $results['data'][0]['id'];
}

function printImages($userID) {
	$url = 'https://api.instagram.com/v1/users/' . $userID . '/media/recent?client_id=' . clientID . '&count=10';
	$instagramInfo = connectToInstagram($url);
	$results = json_decode($instagramInfo, true);
	
	// parse through results
	foreach($results['data'] as $items) {
		$image_url = $items['images']['low_resolution']['url'];
		echo '<img src=" ' . $image_url . ' " /><br>';
	}
}

if($_GET['code']) {
	$code = $_GET['code'];
	$url = 'https://api.instagram.com/oauth/access_token';
	$access_token_settings = array (
		'clientID' 		=> clientID,
		'client+secret' => clientSecret,
		'grant_type' 	=> 'authorize_code',
		'redirect_uri' 	=> redirectURI,
		'code' 			=> $code
 	);
	$curl = curl_init($url);
	curl_setopt($curl, CURLOPT_POST);
	curl_setopt($curl, CURLOPT_POSTFIELDS, $access_token_settings);
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
	curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
	
	$results = curl_exec($curl);
	curl_close($curl);
	
	$results = json_decode($results, true);
	$userName = $results['user']['username'];
	$userID = getUserID($userName);
	printImages($userID);
} else { ?>
<!DOCTYPE html>
<html>
<body>
	<a href="https://api.instagram.com/oauth/authorize/?client_id=<?php echo clientID; ?>&redirect_uri=<?php echo redirectURI; ?>&response_type=code">Login</a>
</body>
</html>
<?php } ?>