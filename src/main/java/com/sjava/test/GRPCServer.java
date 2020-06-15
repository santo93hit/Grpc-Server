package com.sjava.test;

import java.io.IOException;

import com.sjava.grpc.service.UserService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
		server.start();
		System.out.println("server started at : "+server.getPort());
		server.awaitTermination();
	}

}
