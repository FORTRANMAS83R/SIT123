package sources;

import information.Information;

public class SourceFixe extends Source<Boolean> {

    public SourceFixe(String message) {
        super();
        informationGeneree = new Information<>();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '0') informationGeneree.add(false);
            else if (message.charAt(i) == '1') informationGeneree.add(true);
        }
    }

}
