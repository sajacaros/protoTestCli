package com.bnpinnovation.prototestcli;

import com.bnpinnovation.proto.SCVServiceGrpc;
import com.bnpinnovation.proto.ScvInfo;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GrpcClient {
    private static final int PORT = 8081;
    public static final String HOST = "localhost";
    private final ManagedChannel channel =
            ManagedChannelBuilder.forAddress(HOST, PORT)
                    .usePlaintext()
                    .build();
    private final SCVServiceGrpc.SCVServiceBlockingStub scvStub = SCVServiceGrpc.newBlockingStub(
            ManagedChannelBuilder.forAddress(HOST, PORT)
            .usePlaintext()
            .build()
    );

    public ScvInfo.SCVResponse getSCV() {
        try {
            return scvStub.withDeadlineAfter(1, TimeUnit.SECONDS).getSCV(com.google.protobuf.Empty.getDefaultInstance());    
        } catch (StatusRuntimeException se) {
            // TODO: 2021-04-13(013)  
            throw new RuntimeException("protobuf timeout");
        }
        
    }
}