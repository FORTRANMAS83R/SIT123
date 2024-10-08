package destinations;

import information.Information;
import information.InformationNonConformeException;

public class DestinationFinale<T> extends Destination<T> {

    public DestinationFinale() {
        super();
    }

    @Override
    public void recevoir(Information<T> information) throws InformationNonConformeException {
        informationRecue = information;
    }
}
