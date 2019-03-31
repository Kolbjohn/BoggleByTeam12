import java.util.ArrayList;
import java.util.Collections;

public class Die {
    private ArrayList<String> sides;
    
    public Die(String[] sides){
    	this.sides = new ArrayList<String>();
    	
    	for (String side : sides) {
    		this.sides.add(side);
    	}
    }
    
    public String randomize() {
    	Collections.shuffle(sides);
    	return getTop();
    }
    
    public String getTop() {
    	return sides.get(0);
    }
}