package masterdetailsample.eventos.masterdetail;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ton on 9/26/14.
 */
public class MasterDetailEventSource {

    private Collection<MasterEventListener> masterEventListeners = new ArrayList<MasterEventListener>();
    private Collection<DetailEventListener> detailEventListeners = new ArrayList<DetailEventListener>();

    public void inicioCadastro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.inicioCadastro(event);
        }
    }

    public void inicioCadastro(Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.inicioCadastro(event);
        }
    }

    public void gravacaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.gravacaoRegistro(event);
        }
    }

    public void gravacaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.gravacaoRegistro(event);
        }
    }

    public void cancelamentoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.cancelamentoRegistro(event);
        }
    }

    public void cancelamentoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.cancelamentoRegistroDetalhe(event);
        }
    }

    public void insercaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.insercaoRegistro(event);
        }
    }

    public void insercaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.insercaoRegistro(event);
        }
    }

    public void alteracaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void alteracaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void exclusaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.alteracaoRegistro(event);
        }
    }

    public void exclusaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.exclusaoRegistro(event);
        }
    }

    public void pesquisaRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.pesquisaRegistro(event);
        }
    }

    public void pesquisaRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.pesquisaRegistro(event);
        }
    }

    public void insercaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.insercaoRegistroDetalhe(event);
        }
    }

    public void insercaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.insercaoRegistroDetalhe(event);
        }
    }

    public void alteracaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.alteracaoRegistroDetalhe(event);
        }
    }

    public void alteracaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.alteracaoRegistroDetalhe(event);
        }
    }

    public void exclusaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.exclusaoRegistroDetalhe(event);
        }
    }

    public void exclusaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.exclusaoRegistroDetalhe(event);
        }
    }

    public void pesquisaRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.pesquisaRegistroDetalhe(event);
        }
    }

    public void inicioCadastroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.inicioCadastroDetalhe(event);
        }
    }

    public void gravacaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.gravacaoRegistroDetalhe(event);
        }
    }

    public void gravacaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.gravacaoRegistroDetalhe(event);
        }
    }

    public void selecaoDeIten(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.selecaoDeIten(event);
        }
    }

    public void selecaoDeIten() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.selecaoDeIten(event);
        }
    }

    public void selecaoDeItenDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.selecaoDeItenDetalhe(event);
        }
    }

    public void selecaoDeItenDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.selecaoDeItenDetalhe(event);
        }
    }

    public void reiniciaPesquisa() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.reiniciaPesquisa(event);
        }
    }

    public synchronized void addMasterListener(MasterEventListener listener) {
        if (!masterEventListeners.contains(listener)) {
            masterEventListeners.add(listener);
        }
    }

    public synchronized void removeMasterDetailListener(MasterEventListener listener) {
        if (masterEventListeners.contains(listener)) {
            masterEventListeners.remove(listener);
        }
    }

    public synchronized void addDetailListener(DetailEventListener listener) {
        if (!detailEventListeners.contains(listener)) {
            detailEventListeners.add(listener);
        }
    }

    public synchronized void removeDetailListener(DetailEventListener listener) {
        if (detailEventListeners.contains(listener)) {
            detailEventListeners.remove(listener);
        }
    }

    private Collection<MasterEventListener> cloneMasterListeners() {

        synchronized (this) {
            // Clonar para evitar problemas de sincronização
            // durante a propagação
            return (Collection) (((ArrayList) masterEventListeners).clone());
        }
    }

    private Collection<DetailEventListener> cloneDetailListeners() {

        synchronized (this) {
            // Clonar para evitar problemas de sincronização
            // durante a propagação
            return (Collection) (((ArrayList) detailEventListeners).clone());
        }
    }
}
