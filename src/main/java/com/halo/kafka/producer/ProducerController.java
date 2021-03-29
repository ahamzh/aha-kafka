package com.halo.kafka.producer;

import com.halo.kafka.protocol.MessageData;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/produce")
public class ProducerController {

	@Autowired
	private KafkaTemplate<String, MessageData> kafkaTemplate;

	@SneakyThrows
	@GetMapping("message")
	public void sendMessage(@RequestParam String message) {

		kafkaTemplate.send("topic_002", MessageData.builder().sendDate(new Date()).context(message).build());
	}

}
