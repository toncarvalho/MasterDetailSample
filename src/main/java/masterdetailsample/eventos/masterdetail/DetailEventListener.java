package masterdetailsample.eventos.masterdetail;

import java.util.EventListener;

/**
 * Created by ton on 9/26/14.
 */
public interface DetailEventListener extends EventListener {

    void selecaoDeIten(MasterDetailEvent event);

    void reiniciaPesquisa(MasterDetailEvent event);

    void insercaoRegistroDetalhe(MasterDetailEvent e);

    void alteracaoRegistroDetalhe(MasterDetailEvent e);

    void exclusaoRegistroDetalhe(MasterDetailEvent e);

    void pesquisaRegistroDetalhe(MasterDetailEvent e);

    void gravacaoRegistroDetalhe(MasterDetailEvent e);

    void cancelamentoRegistroDetalhe(MasterDetailEvent e);

    void selecaoDeItenDetalhe(MasterDetailEvent event);

    void inicioCadastroDetalhe(MasterDetailEvent event);
}
