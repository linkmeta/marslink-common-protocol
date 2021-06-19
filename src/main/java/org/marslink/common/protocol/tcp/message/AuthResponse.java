package org.marslink.common.protocol.tcp.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetlinks.core.utils.BytesUtils;
import org.marslink.common.protocol.tcp.TcpPayload;
import org.marslink.common.protocol.tcp.TcpStatus;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class AuthResponse implements TcpPayload {

    private long deviceId;

    private TcpStatus status;

    public static AuthResponse of(byte[] bytes, int offset) {
        AuthResponse response = new AuthResponse();
        response.fromBytes(bytes, offset);
        return response;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[9];
        BytesUtils.numberToLe(bytes, deviceId, 0, 8);
        bytes[8] = status.getStatus();
        return bytes;
    }

    @Override
    public void fromBytes(byte[] bytes, int offset) {
        setDeviceId(BytesUtils.leToLong(bytes, offset, 8));
        setStatus(TcpStatus.of(bytes[offset + 8]).orElse(TcpStatus.UNKNOWN));
    }

    @Override
    public String toString() {
        return "{" +
                "deviceId=" + deviceId +
                ", status=" + status +
                '}';
    }
}
