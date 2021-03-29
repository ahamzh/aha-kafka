package com.halo.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.core.ConsumerFactory;

/**
 * 监听消费者工厂
 *
 * @author shoufeng
 */

@Slf4j
public class HaloConsumerFactoryListener implements ConsumerFactory.Listener {

	/**
	 * 监听消费者添加
	 *
	 * @param id
	 * @param consumer
	 */
	@Override
	public void consumerAdded(String id, Consumer consumer) {
		log.info("创建消费者: id({}), consumer({})", id, consumer);
	}

	/**
	 * 监听消费者移除
	 *
	 * @param id
	 * @param consumer
	 */
	@Override
	public void consumerRemoved(String id, Consumer consumer) {
		log.info("移除消费者: id({}), consumer({})", id, consumer);
	}

}
