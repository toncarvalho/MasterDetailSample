package masterdetailsample.eventos.masterdetail;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe responsável por conter os diversos listener da aplicação, implementada segundo o padrão observer deve funcionar como uma classe
 * disparadora de eventos, até o momento responsável por controlar o disparo de eventos tanto dos formularios principais quando dos
 * sub-formularios.
 */
public class MasterDetailEventSource {

    /**
     * estrutura de lista que contem os metodos ouvintes para formulários principais.
     */
    private Collection<MasterEventListener> masterEventListeners = new ArrayList<MasterEventListener>();
    /**
     * estrutura de lista que contém os métodos ouvintes para sub-formulários.
     */
    private Collection<DetailEventListener> detailEventListeners = new ArrayList<DetailEventListener>();

    public void inicioCadastro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.startFormListener(event);
        }
    }

    public void inicioCadastro(Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.startFormListener(event);
        }
    }

    public void gravacaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.persistListener(event);
        }
    }

    public void gravacaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.persistListener(event);
        }
    }

    public void cancelamentoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.cancelListener(event);
        }
    }

    public void cancelamentoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.cancelDetailListener(event);
        }
    }

    public void insercaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.insertListener(event);
        }
    }

    public void insercaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.insertListener(event);
        }
    }

    public void alteracaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.changeItemListener(event);
        }
    }

    public void alteracaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.changeItemListener(event);
        }
    }

    public void exclusaoRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.changeItemListener(event);
        }
    }

    public void exclusaoRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.deleteListener(event);
        }
    }

    public void pesquisaRegistro() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.searchListener(event);
        }
    }

    public void pesquisaRegistro(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.searchListener(event);
        }
    }

    public void insercaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.insertDetailListener(event);
        }
    }

    public void insercaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.insertDetailListener(event);
        }
    }

    public void alteracaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.changeDetailListener(event);
        }
    }

    public void alteracaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.changeDetailListener(event);
        }
    }

    public void exclusaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.deleteDetailListener(event);
        }
    }

    public void exclusaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.deleteDetailListener(event);
        }
    }

    public void pesquisaRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.searchDetailListener(event);
        }
    }

    public void inicioCadastroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.startNewDetailListener(event);
        }
    }

    public void gravacaoRegistroDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.persistDetailListener(event);
        }
    }

    public void gravacaoRegistroDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.persistDetailListener(event);
        }
    }

    public void selecaoDeIten(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.selectListener(event);
        }
    }

    public void selecaoDeIten() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (MasterEventListener listener : cloneMasterListeners()) {
            listener.selectListener(event);
        }
    }

    public void selecaoDeItenDetalhe(final Object source) {
        MasterDetailEvent event = new MasterDetailEvent(source);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.selectMasterItemListener(event);
        }
    }

    public void selecaoDeItenDetalhe() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.selectMasterItemListener(event);
        }
    }

    public void reiniciaPesquisa() {
        MasterDetailEvent event = new MasterDetailEvent(this);
        for (DetailEventListener listener : cloneDetailListeners()) {
            listener.restartSearchInDetails(event);
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
