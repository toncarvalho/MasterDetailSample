package masterdetailsample.eventos.masterdetail;

import java.util.EventListener;

/**
 * Interface que define os métodos que são disparados e ouvidos pelos sub-formulários em um cadastro com vários sub-formulários.
 */
public interface DetailEventListener extends EventListener {

    /**
     * Método ouvinte para o evento disparado no momento em que o usuário seleciona um item em uma grid de um formulário pai, deve ser
     * implementado em classes que por qualquer motivo precisem ser notificadas quando um registro em um formulário pai for selecionadas a
     * fim de executar alguma ação.
     *
     * @param event
     */
    void selectDetailListener(MasterDetailEvent event);

    /**
     * Método ouvinte para evento disparado quando o usuário acessa algum controle de interface gráfica que exige reinício total do
     * formulário, originalmente refere-se à pesquisa de formulários principais.
     *
     * @param event
     */
    void restartSearchInDetails(MasterDetailEvent event);

    /**
     * Método ouvinte para evento disparado quando o usuário inicía a inserção de algum registro em um sub-formulário, deve ser implementado
     * em classes que controlam o sub-formulário, mais precisamente a interface de cadastro do detalhe. Pois quando uma nova inserção se
     * inicia é necessário limpar a tela, ajustar a barra de status, ajustar os botões na barra de ferramentas correspondente.
     *
     * @param e
     */
    void insertDetailListener(MasterDetailEvent e);

    /**
     * Método ouvinte para evento de edição de item do detalhe, deve ser também implementado em todos os elementos que devem ter seu estados
     * alterado quando um usuário inicia a edição de itens de um sub-formulário.
     *
     * @param e
     */
    void changeDetailListener(MasterDetailEvent e);

    /**
     * Ouvinte para a ação de exclusão de itens de um sub-formuláio disparada pelo usuário.
     *
     * @param e
     */
    void deleteDetailListener(MasterDetailEvent e);

    /**
     * Ouvinte para a ação de pesquisa em itens de um sub-formulário detalhe.
     *
     * @param e
     */
    void searchDetailListener(MasterDetailEvent e);

    /**
     * Método ouvinte pra o evento de gravação de um item de detalhe, neste modelo de implementação é usado o mesmo evento de gravação tanto
     * para inserir um novo objeto quando para atualizar um existente, a diferenciação entre um novo objeto ou um objeto que deve ser
     * somente atualizado em memória fica a cargo de classe especial para tal fim.
     *
     * @param e
     */
    void persistDetailListener(MasterDetailEvent e);

    /**
     * Método ouvinte para os controles de cancelamento de alguma operação relativa a um registro de um sub-formulário, é disparado por meio
     * de interação do usuário através de botão de controle disposto na barra de ferramentas. Este método deve ser implementado em todos os
     * elementos de interface gráfica que precisam responder de alguma forma a um cancelamento de inserção ou alteração de um registro no
     * sub-formulário.
     *
     * @param e
     */
    void cancelDetailListener(MasterDetailEvent e);

    /**
     * Método ouvinte para o evento de seleção de item de detalhe, ou seja quando o usuário clica na grid, e seleciona um determinado
     * registro este evento é disparado, deve ser implementado em todas as classes de controle e elementos que precisem ser notificados e
     * executar alguma ação quando um item de detalhe for selecionado.
     *
     * @param event
     */
    void selectMasterItemListener(MasterDetailEvent event);

    /**
     * Método ouvinte para o evento de inicio do processo de um novo item em um sub-formulário. Algumas ações devem ser executadas ao se
     * iniciar um novo cadastro, por exemplo, os campos de entradas de dados devem ser reiniciados e ter seu conteudo liberado, a barra de
     * status do formulário deve ter seu texto alterado e também os botões das barras de ferramentas devem ser atualizados.
     *
     * @param event
     */
    void startNewDetailListener(MasterDetailEvent event);
}
