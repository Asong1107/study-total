package com.asong.netty.client;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class ClientSocket {

    public static void main(String[] args) {
        try {
            SocketChannel open = SocketChannel.open();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
