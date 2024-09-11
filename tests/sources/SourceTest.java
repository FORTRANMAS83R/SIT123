package sources;
import destinations.Destination;
import information.InformationNonConformeException;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.Rule;

import java.util.Random;


public class SourceTest {
    private Destination<Boolean> dest = EasyMock.createMock(Destination.class);

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    /**
     * Test de la classe SourceAleatoire
     * Rq: On ne peut tester que la génération de la source aléatoire avec un seed donné.
     */

    public void testConstructorSourceAleatoire(){
        Source<Boolean> src = new SourceAleatoire(10, 10);
        Random expected = new Random(10);
        for (int i = 0; i < 10; i++){
            if(src.informationGeneree.iemeElement(i) != expected.nextBoolean()){
                collector.addError( new AssertionError("Erreur de génération de la source aléatoire"));
            }
        }
    }

    public void testConnecterSourceAleatoire(){
        Source<Boolean> src = new SourceAleatoire(10, 10);
        src.connecter(this.dest);
        if (!src.getDestinationsConnectees().contains(this.dest)){
            collector.addError( new AssertionError("Erreur de connexion de la source aléatoire"));
        }
    }



    public void testConstructorSourceFixe() throws InformationNonConformeException {
        String message = "0101010101";
        Source<Boolean> src = new SourceFixe(message);
        Boolean current;
        for (int i = 0; i < 10; i++){
            if (message.charAt(i) == '0') current = false;
            else if (message.charAt(i) == '1') current = true;
            else {
                collector.addError( new AssertionError("Erreur de génération de la source fixe"));
                return;
            }
            if(src.getInformationGeneree().iemeElement(i) != current){
                collector.addError( new AssertionError("Erreur de génération de la source fixe"));
            }
        }
    }

    public void testConnecterSourceFixe() throws InformationNonConformeException {
        String message = "0101010101";
        Source<Boolean> src = new SourceFixe(message);
        src.connecter(this.dest);
        if (!src.getDestinationsConnectees().contains(this.dest)){
            collector.addError( new AssertionError("Erreur de connexion de la source fixe"));
        }
    }
    @Test
    public void testSourceAleatoire(){
        this.testConstructorSourceAleatoire();
        this.testConnecterSourceAleatoire();
    }
    @Test
    public void testSourceFixe() throws InformationNonConformeException {
        this.testConstructorSourceFixe();
        this.testConnecterSourceFixe();
    }

    public static void main(String[] args) {
        SourceTest test = new SourceTest();


        System.out.println("Hello world!");
    }
}