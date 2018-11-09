package com.example.ElasticSearchgradledemo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ESConfiguration  {

    private static final Logger logger = LoggerFactory.getLogger(ESConfiguration.class);

    @Bean(name = "client")
    public TransportClient getClient() {
        InetSocketTransportAddress node = null;
        try {
            node = new InetSocketTransportAddress(InetAddress.getByName("192.168.100.212"), 9300);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Settings settings = Settings.builder().put("cluster.name", "docker-cluster").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }
}
