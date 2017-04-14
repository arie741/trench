var qlimit = 0;

function limitcheck(){
	if(qlimit >= 4){
		window.location='http://localhost:3000/session/' + localStorage.answers ;
	}
}

function next(n, as){
	$("#q" + n).addClass("hidden");
	$("#q" + (n+1)).removeClass("hidden");
	if(as == "1"){
		localStorage.answers = localStorage.answers + "1";
		qlimit += 1;
		limitcheck();
	} else {
		localStorage.answers = localStorage.answers + "2";
		qlimit += 1;
		limitcheck();
	};
};
