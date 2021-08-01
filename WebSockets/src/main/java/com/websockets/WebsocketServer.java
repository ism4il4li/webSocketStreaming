package com.websockets;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import jakarta.websocket.EndpointConfig;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/websocket")
public class WebsocketServer {

	@OnOpen
	public void handleOpen() {
		System.out.println("Client ist verbunden");
	}

 
	@OnMessage
	public void onMessage(String text, Session session) {
	  try {
		  for(int i = 0; i<10; i++) {
	    
	    try {
	    	session.getBasicRemote().sendText("Welcome to Stream Processor Studio " +i);
			Thread.sleep(1000);
			session.getBasicRemote().sendText("Welcome to Stream Processor Studio2 " +i);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		  }
	  } catch (IOException e) {
	   System.out.println("Fehler");
	  }
	}	

	@OnError
	public void handleError(Throwable e) {
		System.out.println("Fehler");
		e.printStackTrace();
	}
	@OnClose
	public void handleClose() {
		System.out.println("Client ist getrennt");
	}
	

}
