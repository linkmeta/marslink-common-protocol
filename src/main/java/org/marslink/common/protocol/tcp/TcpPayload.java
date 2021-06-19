package org.marslink.common.protocol.tcp;

import org.jetlinks.core.message.DeviceMessage;

public interface TcpPayload {

    byte[] toBytes();

    void fromBytes(byte[] bytes,int offset);


}
