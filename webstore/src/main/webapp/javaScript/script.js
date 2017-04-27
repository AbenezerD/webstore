$(function() {
	ajax_call();
	//setInterval(ajax_call, 1000*30);

	function ajax_call(){
		var time = 1000*1;
		setTimeout(function(){
			$.ajax({
				url: "Home",
				type: "POST",
				data: {"action": "listProducts"},
				success: ajaxSuccess,
				complete: ajax_call
			});
		}, time);
//		$.get("ProductController.do", {"action": "listProducts"})
//		 .done(ajaxSuccess)
//		 .fail(ajaxFailure);
		
		function ajaxSuccess(data){
			//var objs = 
			$("#listProducts").empty();
			$.each(data, function() {
				console.log("name: "+this.name + ", price: " + this.price + ", image: " + this.image)
				var img = $("<img>", {
					"style": "float:left",
					"alt": "product_image",
					"src": this.image,
					"height": "100px",
					"width": "100px"
				});
				var a = $("<a>", {
					"style": "float:left",
					"href": "ProductDetail?productId="+this.productId
				});
				a.append(img);
				var prName = $("<p>").html("<strong>" + this.name + "</strong>");
				var prPrice= $("<p>").html("<em>" + this.price + "</em>");
				var prLeft= $("<p>", {"style":"clear:left"}).html(this.quantity +" left in store");
				
				var div = $("<div>");//.append(a).append(prName).append(prPrice).append(prLeft);
				div.append(a);
				div.append(prName);
				div.append(prPrice);
				div.append(prLeft);
				$("#listProducts").append(div);
				//$("#listProducts").append("name: "+this.name + ", price: " + this.price + ", image: " + this.image);
			});
		}
	}	
});