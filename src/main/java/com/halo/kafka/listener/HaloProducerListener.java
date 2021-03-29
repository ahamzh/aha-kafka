package com.halo.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * 生产者监听器
 *
 * @author shoufeng
 */

@Slf4j
public class HaloProducerListener implements ProducerListener<String, Object> {

	@Override
	public void onSuccess(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
		log.info("生产者发送成功: producerRecord({}), recordMetadata({})", producerRecord, recordMetadata);
	}

	@Override
	public void onError(ProducerRecord<String, Object> producerRecord, Exception exception) {
		log.error("生产者发送失败: producerRecord({}), exception({})", producerRecord, exception);
	}

}
