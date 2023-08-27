package com.zelex.handrpc.handrpcclient.remoteservice;

import com.zelex.handrpc.serverstub.genmsg.HelloReply;
import com.zelex.handrpc.serverstub.genmsg.HelloRequest;
import com.zelex.handrpc.serverstub.genmsg.RpcServerServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class RpcClientService {
    @GrpcClient("rpc-server")
    private RpcServerServiceGrpc.RpcServerServiceBlockingStub serverServiceStub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response = serverServiceStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
