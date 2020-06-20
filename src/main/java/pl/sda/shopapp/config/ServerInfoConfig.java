package pl.sda.shopapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ServerInfoConfig {

    private int serverPort;

    public ServerInfoConfig(@Value("${server.port}") int serverPort) {
        this.serverPort = serverPort;
    }

    @Bean
    int ServerPort(){
        return serverPort;
    }
}
