package org.acme.springboothazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.config.YamlConfigBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TestConfig {

    @Test
    public void testConfig() throws FileNotFoundException {
        String configfile="hazelcast-config.yaml";
        //yaml config not yet working
        YamlConfigBuilder yamlConfigBuilder=new YamlConfigBuilder(configfile);
        Config config=yamlConfigBuilder.build();
        assertNotNull(config);
    }

    @Test
    public void testConfigXML() throws FileNotFoundException {
        String xmlConfig="hazelcast.xml";
        Config config=new FileSystemXmlConfig(xmlConfig);
        assertNotNull(config);
    }
}
