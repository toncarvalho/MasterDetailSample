package masterdetailsample.eventos.masterdetail;

import java.util.EventObject;

/**
 * Created by ton on 9/26/14.
 */
public class MasterDetailEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     *
     * @throws IllegalArgumentException if source is null.
     */
    public MasterDetailEvent(final Object source) {
        super(source);
    }
}
