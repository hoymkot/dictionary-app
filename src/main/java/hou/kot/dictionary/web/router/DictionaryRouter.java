package hou.kot.dictionary.web.router;

import hou.kot.dictionary.web.handler.DictionaryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class DictionaryRouter {

    @Bean
    public RouterFunction<ServerResponse> route (DictionaryHandler dictionaryHandler){
        return RouterFunctions.route(RequestPredicates.GET("/{word}"), dictionaryHandler::lookup);

    }
}
