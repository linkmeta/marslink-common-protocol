package org.marslink.common.protocol.udp.message;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetlinks.core.message.property.ReportPropertyMessage;

import javax.annotation.Nonnull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ReportProperty implements UdpPayload {
    private ReportPropertyMessage reportPropertyMessage;

    @Override
    public String getDeviceId() {
        return reportPropertyMessage.getDeviceId();
    }

    @Override
    public String getType() {
        return "report-property";
    }

    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return null;
    }
}
