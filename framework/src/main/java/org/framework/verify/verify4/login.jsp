<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<title>login</title>

	<script type="text/javascript" src="js/RSA.js"></script>
	<script type="text/javascript" src="js/BigInt.js"></script>
	<script type="text/javascript" src="js/Barrett.js"></script>
	
	<script type="text/javascript">
function rsalogin(){
	var thisPwd = document.getElementById("password").value;
	setMaxDigits(130);
  	var key = new RSAKeyPair("10001","","8a8e5cf64f3c9f34b8f6bb3186d0b8df44be58ae56c1f46e7042779ec7a7d923eb41373746643cae02481567fa8843f9a0faca3e682c2b5ff55c30f83bfe51f99c0dca336fbf799f1f6f21fac0e9c2994699b643d3b18e14a07f7f12b49d46ddd5fa3e4ea0e2c175ed90e267f5b9641534886a2b9ae354f8bb2320c9f79486dd"); 

	var result = encryptedString(key, encodeURIComponent(thisPwd));
	alert("加密后："+result);
	document.getElementById("passworded").value=result;
}
</script>
</head>

<body>
	<form method="post" name="loginForm" target=_blank>
		<table border="0">
			<tr>
				<td>
					加密前:
				</td>
				<td>
					<input type='text' name="password" id=password style='width:400px' value="my passwd"/><br>
				</td>
			</tr>
			
			<tr>
				<td>
					加密后:
				</td>
				<td>
					<input type='text' name="passworded" id="passworded" style='width:1200px'/><br>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="SUBMIT" onclick="rsalogin();" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html:html>
