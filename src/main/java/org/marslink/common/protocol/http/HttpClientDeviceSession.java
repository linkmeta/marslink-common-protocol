package org.marslink.common.protocol.http;

import lombok.Setter;
import org.jetlinks.core.device.DeviceOperator;
import org.jetlinks.core.message.codec.DefaultTransport;
import org.jetlinks.core.message.codec.EncodedMessage;
import org.jetlinks.core.message.codec.Transport;
import org.jetlinks.core.server.session.DeviceSession;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;
import java.time.Duration;

public class HttpClientDeviceSession implements DeviceSession {

    private final DeviceOperator deviceOperator;

    private long lastPingTime = System.currentTimeMillis();

    private final long connectTime = System.currentTimeMillis();

    @Setter
    private boolean closed;

    private long keepaliveTimeout = Duration.ofMinutes(10).toMillis();

    public HttpClientDeviceSession(DeviceOperator deviceOperator) {
        this.deviceOperator = deviceOperator;
    }

    @Override
    public String getId() {
        return getDeviceId();
    }

    @Override
    public String getDeviceId() {
        return deviceOperator.getDeviceId();
    }

    @Nullable
    @Override
    public DeviceOperator getOperator() {
        return deviceOperator;
    }

    @Override
    public long lastPingTime() {
        return lastPingTime;
    }

    @Override
    public long connectTime() {
        return connectTime;
    }

    @Override
    public Mono<Boolean> send(EncodedMessage encodedMessage) {
        return Mono.empty();
    }

    @Override
    public Transport getTransport() {
        return DefaultTransport.TCP;
    }

    @Override
    public void close() {

    }

    @Override
    public void ping() {
        lastPingTime = System.currentTimeMillis();
    }

    @Override
    public void setKeepAliveTimeout(Duration timeout) {
        keepaliveTimeout = timeout.toMillis();
    }

    @Override
    public boolean isAlive() {
        return !closed && System.currentTimeMillis() - lastPingTime < keepaliveTimeout;
    }

    @Override
    public void onClose(Runnable call) {

    }
}
