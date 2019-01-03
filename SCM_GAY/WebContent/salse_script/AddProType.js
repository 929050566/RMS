//jQuery(function($){
//	$("#updatetypenamebutton").click(function(){
//		var updatetypename = document.getElementById("updatetypename").value;
//		var originaltypename = document.getElementById("originaltypename").value;
//		$.post("type",{option:"updatetype", typename:updatetypename, originaltype:originaltypename});
//	});
//});
jQuery(function($){
	$("#addtypebutton").click(function(){
		var typename = document.getElementById("typename").value;
		var typecom  = document.getElementById("typecom").value;
		$.post("../salsehtml/ProductServlet",{option:"addtypeone",typename:typename,typecom:typecom},
				function(date){
			alert("添加成功!");
		});
	});
});

jQuery(function($){
	$("#addproduct").click(function(){
		var proname = document.getElementById("proname").value;
		var productType = document.getElementById("productType").value;
		var prounit = document.getElementById("prounit").value;
		var procom = document.getElementById("procom").value;
		var sale = document.getElementById("sale").value;
		$.post("../salsehtml/ProductServlet",{option:"addproduct",proname:proname,productType:productType,prounit:prounit,procom:procom,sale:sale},
				function(date){
			alert("添加成功!");
		});
	});
});