package com.halo.kafka.producer;

import com.halo.kafka.protocol.MessageData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * @author shoufeng
 */

@Slf4j
@Component
public class HaloProducer {

	@Resource
	private KafkaTemplate<Object, Object> kafkaTemplate;

	//	@PostConstruct
	public void sendSync() throws ExecutionException, InterruptedException {
		SendResult<Object, Object> sendResult = kafkaTemplate.send("topic_002", 0, "key_001", "测试数据001").get();

		log.info("发送情况: {}", sendResult);
	}

	public void sendExecute() {
		kafkaTemplate.execute(new KafkaOperations.ProducerCallback<Object, Object, Object>() {
			@Override
			@SneakyThrows
			public Object doInKafka(org.apache.kafka.clients.producer.Producer<Object, Object> producer) {

				return null;
			}
		});
	}

	//	@PostConstruct
	public void send() {

		kafkaTemplate.send("topic_002", new MessageData(new Date(), "测试失败情况")).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
			@Override
			public void onFailure(Throwable throwable) {
				log.error("失败: ", throwable);
			}

			@Override
			public void onSuccess(SendResult<Object, Object> objectObjectSendResult) {
				log.info("成功: {}", objectObjectSendResult);
			}
		});

	}

	public void sendWithCallBack() {
		ListenableFuture<SendResult<Object, Object>> listenableFuture = kafkaTemplate.send("topic_003", 1, System.currentTimeMillis(), "key", "topic_003的一条消息");

		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {
			@Override
			public void onFailure(Throwable ex) {

			}

			@Override
			public void onSuccess(SendResult<Object, Object> result) {

			}
		});

		listenableFuture.addCallback(new SuccessCallback<SendResult<Object, Object>>() {
			@Override
			public void onSuccess(SendResult<Object, Object> result) {

			}
		}, new FailureCallback() {
			@Override
			public void onFailure(Throwable ex) {

			}
		});
	}

	public void sendWithTransaction(){
		kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback<Object, Object, Object>() {
			@Override
			public Object doInOperations(KafkaOperations<Object, Object> operations) {
				operations.send(new Message<Object>() {
					@Override
					public Object getPayload() {
						return null;
					}

					@Override
					public MessageHeaders getHeaders() {
						return null;
					}
				});
				return true;
			}
		});
	}

}
