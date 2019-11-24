package actors;

import reactor.core.publisher.Mono;

public interface CoinbaseService {

    public Mono<CoinbaseResponse> getCryptoPrice(String priceName)  ;
}
