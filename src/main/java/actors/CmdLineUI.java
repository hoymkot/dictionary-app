package actors;

import akka.actor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CmdLineUI implements CommandLineRunner {

    @Autowired
    CoinbaseService coinbaseService;

    @Override
    public void run(String... args) throws  Exception{
        final ActorSystem system = ActorSystem.create("hello_akka");
        System.out.println("Actor Example");

        final ActorRef printer =  system.actorOf(Printer.props(), "printer");
        final ActorRef priceRequestor =  system.actorOf(PriceRequestor.props(printer, coinbaseService), "requestor");
        final ActorRef poller = system.actorOf(Poller.props("BTC-USD", priceRequestor), "poller");

        final ActorRef eth_poller = system.actorOf(Poller.props("ETH-USD", priceRequestor), "poller");

    }
}
