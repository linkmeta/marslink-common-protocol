package org.marslink.common.protocol.tcp.message;

import org.marslink.common.protocol.tcp.TcpPayload;

public class Ping implements TcpPayload {
    @Override
    public byte[] toBytes() {
        return new byte[0];
    }

    @Override
    public void fromBytes(byte[] bytes, int offset) {

    }
}
