package com.example.tomcat;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
public class NativeController {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("test", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response;
            String requestMethod = t.getRequestMethod();
            if ("GET".equals(requestMethod)) {
                response = "it is a get method";
            } else if ("POST".equals(requestMethod)) {
                response = "it is a post method";
            } else if ("DELETE".equals(requestMethod)) {
                response = "it is a delete method";
            } else {
                response = "Unsupported method";
            }
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
