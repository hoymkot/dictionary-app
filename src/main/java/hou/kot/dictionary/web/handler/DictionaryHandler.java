package hou.kot.dictionary.web.handler;

import hou.kot.dictionary.formatter.Formatter;
import hou.kot.dictionary.formatter.WeChatFormatter;
import hou.kot.dictionary.parser.HTMLParser;
import hou.kot.dictionary.parser.Parser;
import hou.kot.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DictionaryHandler {
    @Autowired
    private DictionaryService dictionaryService;
    public Mono<ServerResponse> lookup(ServerRequest request){
        String word = request.pathVariable("word");
        return dictionaryService.getChineseMeaning(word)
                .flatMap(
                        translation -> {

                            Parser p = new HTMLParser();
                            String definition = p.parse(translation);

                            Formatter formatter = WeChatFormatter.getInstance();
                            translation = formatter.format(definition);

                            return ServerResponse.ok()
                                    .header("Content-Type", "text/html; charset=utf-8")
                                        .body(BodyInserters.fromObject(translation));
                        });
    }
}
