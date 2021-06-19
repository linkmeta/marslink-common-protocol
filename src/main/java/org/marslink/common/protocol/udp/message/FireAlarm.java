package org.marslink.common.protocol.udp.message;

import io.netty.buffer.ByteBuf;
import lombok.*;

import javax.annotation.Nonnull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FireAlarm implements UdpPayload {

    //设备ID
    private long deviceId;

    //经度
    private float lnt;

    //纬度
    private float lat;

    //点位
    private int point;

    private String bName;

    @Override
    public String getType() {
        return "fire-alarm";
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
