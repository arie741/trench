function next(n){
	$("#q" + n).addClass("hidden");
	$("#q" + (n+1)).removeClass("hidden");
};

$("#q1 div:nth-child(1) button").click(function(){
	next(1);
});

$("#q1 div:nth-child(3) button").click(function(){
	next(1);
});