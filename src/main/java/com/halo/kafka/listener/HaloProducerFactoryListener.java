package com.halo.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.ProducerFactory;

/**
 * 监听生产者工厂的创建和移除
 *
 * @author zhihao.mao
 */

@Slf4j
public class HaloProducerFactoryListener implements ProducerFactory.Listener {

	/**
	 * 监听生产者的创建
	 *
	 * @param id
	 * @param producer
	 */
	@Override
	public void producerAdded(String id, Producer producer) {
		log.info("创建生产者: id({}), producer({})", id, producer);
	}

	/**
	 * 监听生产者的移除
	 *
	 * @param id
	 * @param producer
	 */
	@Override
	public void producerRemoved(String id, Producer producer) {
		log.info("移除生产者: id({}), producer({})", id, producer);
	}
	
}
