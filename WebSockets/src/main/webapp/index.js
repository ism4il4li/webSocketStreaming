var wsUri = "ws://localhost:8080/WebSockets/websocket";
var ws = new WebSocket(wsUri);

ws.onopen = (event)=>{
	print("connected to : " + wsUri);
	ws.send("client sendet....");
	sendEcho();
	console.log("Message ist gesendet")
};

ws.onmessage = (event)=>{
	let msg = event.data;
	print(msg);
};


function print(msg){
	let p = document.getElementById("text");
	p.innerHTML = msg;

}



function sendEcho(){
	ws.send("client sendet....");
	print("client sendet...");
}

/*
ws.onerror = (event)=>{
	print("error");
}



*/
