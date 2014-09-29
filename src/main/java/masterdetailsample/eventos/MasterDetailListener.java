package masterdetailsample.eventos;

import java.util.EventListener;

/**
 * Created by ton on 9/26/14.
 */
public interface MasterDetailListener extends EventListener {

    void inicioCadastro(MasterDetailEvent e);

    void gravacaoRegistro(MasterDetailEvent e);

    void cancelamentoRegistro(MasterDetailEvent e);

    void insercaoRegistro(MasterDetailEvent e);

    void alteracaoRegistro(MasterDetailEvent e);

    void exclusaoRegistro(MasterDetailEvent e);

    void pesquisaRegistro(MasterDetailEvent e);

    void insercaoRegistroDetalhe(MasterDetailEvent e);

    void alteracaoRegistroDetalhe(MasterDetailEvent e);

    void exclusaoRegistroDetalhe(MasterDetailEvent e);

    void pesquisaRegistroDetalhe(MasterDetailEvent e);

    void gravacaoRegistroDetalhe(MasterDetailEvent e);

    void cancelamentoRegistroDetalhe(MasterDetailEvent e);
}
