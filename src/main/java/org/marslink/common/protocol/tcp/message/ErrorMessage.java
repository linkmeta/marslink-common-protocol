package org.marslink.common.protocol.tcp.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.marslink.common.protocol.tcp.TcpPayload;
import org.marslink.common.protocol.tcp.TcpStatus;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ErrorMessage implements TcpPayload {

    TcpStatus status;

    @Override
    public byte[] toBytes() {
        return new byte[]{status.getStatus()};
    }

    @Override
    public void fromBytes(byte[] bytes, int offset) {
        status = TcpStatus.of(bytes[offset]).orElse(TcpStatus.UNKNOWN);
    }
}
