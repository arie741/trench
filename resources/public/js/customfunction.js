window.onload = function() {
  if (typeof(Storage) !== "undefined") {
    	localStorage.setItem("answers", "");
	} else {
    	alert("Browser anda terlalu kuno untuk menjalani aplikasi ini! Mohon update browser anda ke versi yang paling baru terlebih dulu.");
	}
};
