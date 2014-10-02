package masterdetailsample.eventos.masterdetail;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ton on 9/26/14.
 */
public class MasterDetailEventSource {

    private Collection<MasterDetailEventListener> listeners = new ArrayList<MasterDetailEventListener>();

    public void inicioCadastro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.inicioCadastro(event);
        }
    }

    public void inicioCadastro(Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.inicioCadastro(event);
        }
    }

    public void gravacaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.gravacaoRegistro(event);
        }
    }

    public void gravacaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.gravacaoRegistro(event);
        }
    }

    public void cancelamentoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.cancelamentoRegistro(event);
        }
    }

    public void cancelamentoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.cancelamentoRegistroDetalhe(event);
        }
    }

    public void insercaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.insercaoRegistro(event);
        }
    }

    public void insercaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.insercaoRegistro(event);
        }
    }

    public void alteracaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void alteracaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void exclusaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void exclusaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.exclusaoRegistro(event);
        }
    }

    public void pesquisaRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.pesquisaRegistro(event);
        }
    }

    public void pesquisaRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.pesquisaRegistro(event);
        }
    }

    public void insercaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.insercaoRegistroDetalhe(event);
        }
    }

    public void insercaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.insercaoRegistroDetalhe(event);
        }
    }

    public void alteracaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.alteracaoRegistroDetalhe(event);
        }
    }

    public void alteracaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.alteracaoRegistroDetalhe(event);
        }
    }

    public void exclusaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.exclusaoRegistroDetalhe(event);
        }
    }

    public void exclusaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.exclusaoRegistroDetalhe(event);
        }
    }

    public void pesquisaRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.pesquisaRegistroDetalhe(event);
        }
    }

    public void selecaoDeIten(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.selecaoDeIten(event);
        }
    }

    public void selecaoDeIten() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.selecaoDeIten(event);
        }
    }

    public void selecaoDeItenDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.selecaoDeIten(event);
        }
    }

    public void selecaoDeItenDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.selecaoDeIten(event);
        }
    }

    public void reiniciaPesquisa() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterDetailEventListener listener : cloneListeners()) {
            listener.reiniciaPesquisa(event);
        }
    }

    public synchronized void addMasterDetailListener(MasterDetailEventListener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public synchronized void removeMasterDetailListener(MasterDetailEventListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    private Collection<MasterDetailEventListener> cloneListeners() {

        synchronized (this) {
            // Clonar para evitar problemas de sincronização
            // durante a propagação
            return (Collection) (((ArrayList) listeners).clone());
        }
    }
}
