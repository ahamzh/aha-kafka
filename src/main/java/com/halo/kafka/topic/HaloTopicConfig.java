package com.halo.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

public class HaloTopicConfig {

//	@Bean //springboot 不需要该配置
	public KafkaAdmin admin() {
		Map<String, Object> configs = new HashMap<>();
//		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG);
		return new KafkaAdmin(configs);
	}

	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("thing1")
				.partitions(10)
				.replicas(3)
				.compact()
				.build();
	}

}
