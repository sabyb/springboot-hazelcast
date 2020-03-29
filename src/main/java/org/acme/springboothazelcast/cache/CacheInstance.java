package org.acme.springboothazelcast.cache;

import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class CacheInstance {

    private static final String INSTANCE_NAME = "validation";


    @Bean
    public Config config() throws FileNotFoundException {
        String hazelcastConfig = System.getProperty("hazelcast.config");
        Config config = new FileSystemXmlConfig(new File(hazelcastConfig));
        return config; // Set up any non-default config here
    }


    HazelcastInstance get() {
        Hazelcast.getAllHazelcastInstances().forEach(i -> {
            System.out.println(i.getName());
        });

        return Hazelcast.getHazelcastInstanceByName(INSTANCE_NAME);
    }
}
