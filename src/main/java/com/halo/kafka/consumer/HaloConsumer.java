package com.halo.kafka.consumer;

import com.halo.kafka.protocol.MessageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author shoufeng
 */
@Component
@Slf4j
public class HaloConsumer {

	@KafkaListener(groupId = "halo_group_comsume_001", topics = {"topic_002"})
	public void consume001(MessageData consumerRecord) {
		log.info("消费消息1: {}", consumerRecord);
	}

	@KafkaListener(groupId = "halo_group_comsume_002", topics = {"topic_002"})
	public void consume002(MessageData consumerRecord) {
		log.info("消费消息2: {}", consumerRecord);
//		throw new RuntimeException("消费者2估计抛出异常");
	}

	@KafkaListener(groupId = "halo_group_comsume_003", topics = {"example"})
	public void consumer003(Object message) {
		log.info("消费canal: {}", message);
	}

}
