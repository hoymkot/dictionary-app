package hou.kot.dictionary.service;

import hou.kot.dictionary.model.DictionaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<String> getChineseMeaning(String englishWord){
        return webClient
                .get()
                .uri("http://dict.youdao.com/w/eng/{englishWord}", englishWord)
                .retrieve().bodyToMono(String.class);

    }
}
