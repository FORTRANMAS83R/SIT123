package src.transmetteurs;

import src.destinations.DestinationInterface;
import src.information.Information;
import src.information.InformationNonConformeException;

public class TransmetteurParfait<R> extends Transmetteur<R,R> {
    public TransmetteurParfait(){
        super();
    }

    @Override
    public void recevoir(Information<R> information) throws InformationNonConformeException {
        informationRecue = information; 
        emettre();
    }

    @Override
    public void emettre() throws InformationNonConformeException {
           	// émission vers les composants connectés
	    for (DestinationInterface<R> destinationConnectee : destinationsConnectees) {
                destinationConnectee.recevoir(informationRecue);
	    }
	    this.informationEmise = informationRecue;   			 			      
        }
    }



