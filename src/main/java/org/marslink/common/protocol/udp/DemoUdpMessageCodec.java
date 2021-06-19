package org.marslink.common.protocol.udp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetlinks.core.message.DeviceMessage;
import org.jetlinks.core.message.codec.*;
import org.jetlinks.core.server.session.DeviceSession;
import org.marslink.common.protocol.tcp.MessageType;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author wangzheng
 * @see
 * @since 1.0
 */
@AllArgsConstructor
@Slf4j
public class DemoUdpMessageCodec implements DeviceMessageCodec {

    @Override
    public Transport getSupportTransport() {
        return DefaultTransport.UDP;
    }

    @Override
    public Flux<DeviceMessage> decode(MessageDecodeContext context) {
        return Flux.defer(() -> {
            FromDeviceMessageContext ctx = ((FromDeviceMessageContext) context);
            DeviceSession session=ctx.getSession();
            EncodedMessage encodedMessage = context.getMessage();
            JSONObject payload = JSON.parseObject(encodedMessage.getPayload().toString(StandardCharsets.UTF_8));
            return Mono
                    .justOrEmpty(org.jetlinks.core.message.MessageType.<DeviceMessage>convertMessage(payload))
//                    .flatMapMany(msg->{
//                       return context
//                                .getDevice(msg.getDeviceId())
//                                .flatMapMany(operator -> operator.getConfig("udp_auth_key")
//                                        .map(Value::asString)
//                                        .filter(key -> key.equals(payload.getString("key")))
//                                        .flatMapMany(ignore -> {
//                                            //认证通过
//                                            return session
//                                                    .send(EncodedMessage.simple(Unpooled.wrappedBuffer("ok".getBytes())))
//                                                    .thenMany(Flux.just(msg));
//                                        }));
//
//                    }) .switchIfEmpty(Mono.defer(() -> session
//                            .send(EncodedMessage.simple(Unpooled.wrappedBuffer("ILLEGAL_ARGUMENTS".getBytes())))
//                            .then(Mono.empty())))
                ;


        });
    }

    @Override
    public Publisher<? extends EncodedMessage> encode(MessageEncodeContext context) {

        return Mono.just(EncodedMessage.simple(Unpooled.wrappedBuffer(context.getMessage().toString().getBytes())));
    }

    @Setter
    @Getter
    @AllArgsConstructor(staticName = "of")
    private static class Response {
        private MessageType type;

        private Object res;

    }

}
