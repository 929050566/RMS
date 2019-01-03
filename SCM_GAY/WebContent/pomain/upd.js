function checksuppliername(){
	var suppliername = document.getElementById("suppliername").value;
	if(suppliername == ""){
		document.getElementById("suppliernameresult").innerHTML = "供应商名称不能为空";
		document.getElementById("suppliername").focus();
	}else{
		document.getElementById("suppliernameresult").innerHTML = "";
	}
}
function checkvelaname(){
	var velaname = document.getElementById("velaname").value;
	if(velaname == ""){
		document.getElementById("velanameresult").innerHTML = "联系人不能为空";
		document.getElementById("velaname").focus();
	}else{
		document.getElementById("velanameresult").innerHTML = "";
	}
}
function checkphone(){
	var phone = document.getElementById("phone").value;
	if(phone == ""){
		document.getElementById("phoneresult").innerHTML = "电话不能为空";
		document.getElementById("phone").focus();
	}else{
		document.getElementById("phoneresult").innerHTML = "";
	}
}