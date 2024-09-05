package src.destinations.sources;

import src.information.Information;

public class SourceFixe extends Source<Boolean> {

    public SourceFixe(String message){
        super();
        informationGeneree = new Information<Boolean>();
        for ( int i = 0; i<message.length(); i++){
            if (message.charAt(i)=='0') informationGeneree.add(false); 
            else if (message.charAt(i)=='1') informationGeneree.add(true);  
        }

    }
    
}
