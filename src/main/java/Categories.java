import com.sun.org.apache.bcel.internal.generic.SWITCH;

/**
 * Created by Yanuar Wicaksana on 10/15/15.
 */
public enum Categories {

    GREEN_WASTE, RECYCLABLE_WASTE, GENERAL_WASTE;

    public String toString(){
        switch (this){
            case GREEN_WASTE: return "Green Waste";
            case RECYCLABLE_WASTE: return "Recyclable Waste";
            case GENERAL_WASTE: return "General Waste";
            default: return "unspecified";
        }
    }
}
