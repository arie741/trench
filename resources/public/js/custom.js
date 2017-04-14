function next(n, as){
	$("#q" + n).addClass("hidden");
	$("#q" + (n+1)).removeClass("hidden");
	if(as == "1"){
		localStorage.answers = localStorage.answers + "1";
		document.getElementById("answers").innerHTML = localStorage.getItem("answers");
	} else {
		localStorage.answers = localStorage.answers + "2";
		document.getElementById("answers").innerHTML = localStorage.getItem("answers");
	};
};
