//@SpringBootTest
//@RunWith(SpringRunner.class)
class TestKafkaConfig {

    /*@ClassRule
    // By default it creates two partitions.
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, TOPIC_NAME);

    private static String TOPIC_NAME = "testTopic";

    @Test
    public void testKafkaConfig() throws InterruptedException, ExecutionException {

        Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);

        KafkaProducer<Integer, String> producer = new KafkaProducer<>(senderProps);
        producer.send(new ProducerRecord<>(TOPIC_NAME, 0, 0, "ABC")).get();
        producer.send(new ProducerRecord<>(TOPIC_NAME, 0, 1, "XYZ")).get();


        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testConsumer", "false", embeddedKafka);
        consumerProps.put("auto.offset.reset", "earliest");

        final List<String> receivedMessages = Lists.newArrayList();
        final CountDownLatch latch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            KafkaConsumer<Integer, String> kafkaConsumer = new KafkaConsumer<>(consumerProps);
            kafkaConsumer.subscribe(Collections.singletonList(TOPIC_NAME));
            try {
                while (true) {
                    ConsumerRecords<Integer, String> records = kafkaConsumer.poll(100);
                    records.iterator().forEachRemaining(record -> {
                        receivedMessages.add(record.value());
                        latch.countDown();
                    });
                }
            } finally {
                kafkaConsumer.close();
            }
        });

        latch.await(10, TimeUnit.SECONDS);
        assertTrue(receivedMessages.containsAll(Arrays.asList("ABC", "XYZ")));
    }*/
}