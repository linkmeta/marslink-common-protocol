package org.marslink.common.protocol.udp.message;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;

/**
 *
 * @author wangzheng
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest implements UdpPayload {

    private long deviceId;

    private String key;

    public static AuthRequest of(long deviceId, String key) {
        return new AuthRequest(deviceId, key);
    }


    @Override
    public String toString() {
        return "{" +
                "deviceId=" + deviceId +
                ", key=" + (new String(key)) +
                '}';
    }

    @Override
    public String getType() {
        return "auth-request";
    }

    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return null;
    }

    public String getDeviceId() {
        return String.valueOf(this.deviceId);
    }
}
