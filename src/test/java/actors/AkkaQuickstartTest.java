package actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AkkaQuickstartTest {
    static ActorSystem system;

    @BeforeClass
    public static void setup(){
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown()
    {
        TestKit.shutdownActorSystem(system);
        system=null;
    }

    @Test
    public void testGreeting(){

    }

}

