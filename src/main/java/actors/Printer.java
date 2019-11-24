package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class Printer extends AbstractActor {

    public Printer() {
    }
    public static Props props() {
        return Props.create(Printer.class, () -> new Printer());
    }


    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(CryptoPrice.class, msg -> msg.message.subscribe(coinbaseResponse ->
                        System.out.println("[" + LocalDateTime.now() + "]"
                                + coinbaseResponse.getData().getBase() +
                                " Buy Price: $" + coinbaseResponse.getData().getAmount() +
                                " " + coinbaseResponse.getData().getCurrency())))
                .build();

    }

    public static class CryptoPrice{
        public final Mono<CoinbaseResponse> message;


        public CryptoPrice(Mono<CoinbaseResponse> message) {
            this.message = message;
        }
    }
}
