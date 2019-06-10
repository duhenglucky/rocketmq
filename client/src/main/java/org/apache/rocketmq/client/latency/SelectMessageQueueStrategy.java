/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.client.latency;

import org.apache.rocketmq.client.impl.producer.TopicPublishInfo;
import org.apache.rocketmq.common.message.MessageQueue;

public interface SelectMessageQueueStrategy {
    /**
     * When send a message to target {@link MessageQueue} failed, this method will be invoked to update fault item.
     * <p>
     *
     * @param brokerName origin broker name
     * @param currentLatency current send message latency
     * @param isolation is need to isolate this broker
     */
    void updateFaultItem(final String brokerName, final long currentLatency, boolean isolation);

    /**
     * Select one {@link MessageQueue} from all the message queue related to the target topic
     * @param topicPublishInfo all message queue metadata related to the target topic
     * @param lastBrokerName last time's broker name
     * @return target message queue will be sent the message
     */
    MessageQueue selectOneMessageQueue(final TopicPublishInfo topicPublishInfo, final String lastBrokerName);

}
