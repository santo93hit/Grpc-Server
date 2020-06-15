package com.sjava.grpc.service;

import com.sjava.grpc.User.ApiResponse;
import com.sjava.grpc.User.Empty;
import com.sjava.grpc.User.LoginRequest;
import com.sjava.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<ApiResponse> responseObserver) {
		String userName = request.getUsername();
		String passWord = request.getPassword();
		ApiResponse.Builder response = ApiResponse.newBuilder();
		if(userName.equalsIgnoreCase(passWord)) {
			response.setResponseCode("200 OK").setResponseMessage("successfully login.");
		}else {
			response.setResponseCode("400").setResponseMessage("Invalid Password.");
		}
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<ApiResponse> responseObserver) {
		ApiResponse.Builder response = ApiResponse.newBuilder();
		response.setResponseCode("200 OK").setResponseMessage("successfully logout.");
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}
	
	

}
