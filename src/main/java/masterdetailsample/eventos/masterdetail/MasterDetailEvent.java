package masterdetailsample.eventos.masterdetail;

import java.util.EventObject;

/**
 * Classe implementada com o objetivo de servir de base de eventos para um formulário com sub-formularios ou formulários mestre detalhe
 *
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
