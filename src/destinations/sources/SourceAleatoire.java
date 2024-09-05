package src.destinations.sources;
import java.util.Random;

import src.information.Information;



public class SourceAleatoire extends Source<Boolean> {
    public SourceAleatoire(Integer nbBitsMess, Integer seed){
        super(); 
        informationGeneree = new Information<Boolean>();
        Random rdm = seed == null ? new Random() : new Random(seed);
        for (int i = 0; i<nbBitsMess; i++){
            informationGeneree.add(rdm.nextBoolean());
        }
        System.out.println(informationGeneree);
    }
}
