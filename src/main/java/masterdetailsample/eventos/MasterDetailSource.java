package masterdetailsample.eventos;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ton on 9/26/14.
 */
public class MasterDetailSource {

    private Collection<MasterDetailListener> listeners = new ArrayList<>();


    public void inicioCadastro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.inicioCadastro(event);
        }
    }

    public void fimCadastro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.fimCadastro(event);
        }
    }

    public void insercaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.insercaoRegistro(event);
        }
    }

    public void alteracaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void exclusaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void pesquisaRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.pesquisaRegistro(event);
        }
    }

    public void insercaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.insercaoRegistroDetalhe(event);
        }
    }

    public void alteracaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.alteracaoRegistroDetalhe(event);
        }
    }

    public void exclusaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.exclusaoRegistroDetalhe(event);
        }
    }

    public void pesquisaRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailListener listener : cloneListeners()) {
            listener.pesquisaRegistroDetalhe(event);
        }
    }

    public synchronized void addMasterDetailListener(MasterDetailListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public synchronized void removeMasterDetailListener(MasterDetailListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    private Collection<MasterDetailListener> cloneListeners() {

        synchronized (this) {
            // Clonar para evitar problemas de sincronização
            // durante a propagação
            return (Collection) (((ArrayList) listeners).clone());
        }
    }
}
