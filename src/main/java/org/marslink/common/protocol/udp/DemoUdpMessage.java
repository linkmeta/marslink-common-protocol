package org.marslink.common.protocol.udp;

import org.jetlinks.core.message.codec.EncodedMessage;

/**
 * @author wangzheng
 * @see
 * @since 1.0
 */

public interface DemoUdpMessage extends EncodedMessage {

    String getType();

    String getDeviceId();


}
