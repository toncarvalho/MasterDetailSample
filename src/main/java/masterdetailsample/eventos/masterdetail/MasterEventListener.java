package masterdetailsample.eventos.masterdetail;

import java.util.EventListener;

/**
 * Interface que define os eventos que devem ser disparados e observados por formulários MESTRES, ou formulário principais bem como seus
 * sub-formularios. Através da observação destes eventos o formulários e sub-formulários podem executar ações alterando os estados dos
 * objetos correspondentes a elementos da interface gráfica, temos eventos que exigem alterações tanto nos formulários principais quanto em
 * seus sub-formulários paralelamente.
 */
public interface MasterEventListener extends EventListener {

    /**
     * Método ouvinte para o evento de inicio de cadastro em formulários principais.
     *
     * @param e
     */
    void startFormListener(MasterDetailEvent e);

    /**
     * Método ouvinte para o evento de gravação de registro de formulários principais.
     *
     * @param e
     */
    void persistListener(MasterDetailEvent e);

    void cancelListener(MasterDetailEvent e);

    void insertListener(MasterDetailEvent e);

    void changeItemListener(MasterDetailEvent e);

    void deleteListener(MasterDetailEvent e);

    void searchListener(MasterDetailEvent e);

    void selectListener(MasterDetailEvent event);

    void restartSearchListener(MasterDetailEvent event);
}
