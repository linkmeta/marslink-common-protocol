package org.marslink.common.protocol.tcp.message;

import org.apache.commons.codec.binary.Hex;
import org.hswebframework.web.id.IDGenerator;
import org.marslink.common.protocol.tcp.TcpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthResponseTest {

    @Test
    void test() {
        AuthResponse response = AuthResponse.of(IDGenerator.SNOW_FLAKE.generate(), TcpStatus.SUCCESS);

        byte[] encode = response.toBytes();
        System.out.println(Hex.encodeHexString(encode));
        System.out.println(response);

        AuthResponse decode = AuthResponse.of(encode, 0);

        assertEquals(response.getDeviceId(), decode.getDeviceId());
        Assertions.assertEquals(response.getStatus(), decode.getStatus());


    }

}