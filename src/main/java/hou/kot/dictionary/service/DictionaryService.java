package hou.kot.dictionary.service;

import hou.kot.dictionary.model.DictionaryResponse;
import reactor.core.publisher.Mono;

public interface DictionaryService {


    Mono<String> getChineseMeaning(String englishWord);

}
