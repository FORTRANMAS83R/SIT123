package simulateur;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import destinations.DestinationFinaleTest;
import sources.SourceTest;
import transmetteurs.TransmetteurParfaitTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DestinationFinaleTest.class, TransmetteurParfaitTest.class, SourceTest.class })
public class AllTests {
}