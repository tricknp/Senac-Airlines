package local.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import local.controller.Sistema;
import local.model.TemplateDosPaineis;
import local.model.database.Avioes;

public class PanelCadastroAviao extends javax.swing.JPanel {

    private Sistema sist;

    private DefaultTableModel tm;

    /**
     * Creates new form PanelCadastroPassageiro
     */
    public PanelCadastroAviao(Sistema sist) {
        initComponents();
        this.sist = sist;
        Object[] colums = {"ID", "EMPRESA", "MODELO", "VELOCIDADE(km/h)", "CAPACIDADE(passageiros)"};
        this.tm = new DefaultTableModel(colums, 0);
        this.jTableAVIOES.setModel(tm);
        jTableAVIOES.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTableAVIOES.rowAtPoint(evt.getPoint());
                int col = jTableAVIOES.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selectRow();
                }
            }
        });
        new TemplateDosPaineis(this.jPanelBackground);
        updateList();
    }

    private void selectRow() {
        String id = jTableAVIOES.getValueAt(jTableAVIOES.getSelectedRow(), 0).toString();
        String empresa = jTableAVIOES.getValueAt(jTableAVIOES.getSelectedRow(), 1).toString();
        String modelo = jTableAVIOES.getValueAt(jTableAVIOES.getSelectedRow(), 2).toString();
        String velocidade = jTableAVIOES.getValueAt(jTableAVIOES.getSelectedRow(), 3).toString();
        String capacidade = jTableAVIOES.getValueAt(jTableAVIOES.getSelectedRow(), 4).toString();
        jTextFieldEmpresa.setText(empresa);
        jTextFieldModelo.setText(modelo);
        jTextFieldVelocidade.setText(velocidade);
        jTextFieldCapacidade.setText(capacidade);
        jTextFieldID.setText(id);
    }

    /**
     *
     * @param id
     * @return retorna um novo aviao se o argumento for um valor != de -1.
     * retorna um aviao do banco de dados se o argumento for o id
     */
    private Avioes newAviao(int id) {
        try {
            //pega os valores que estao nas caixas de texto da view
            String empresa = jTextFieldEmpresa.getText();
            String modelo = jTextFieldModelo.getText();
            int velocidade = Integer.parseInt(jTextFieldVelocidade.getText());
            int capacidade = Integer.parseInt(jTextFieldCapacidade.getText());
            //cria uma entidade aviao com os valores
            Avioes aviao;
            if (id != -1) {
                Integer id2 = Integer.valueOf(jTextFieldID.getText());
                aviao = new Avioes(id2, empresa, modelo, velocidade, capacidade);
            } else {
                aviao = new Avioes(null, empresa, modelo, velocidade, capacidade);
            }
            return aviao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor(es) incorreto(s).");
            return null;
        }
    }

    private void cadastrar() {
        try {
            //chama a classe sistema e manda esse aviao pra la como argumento no metodo cadastrar
            sist.cadastrar(newAviao(-1));
            updateList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ba merda aqi meu");
        }
    }

    private void updateList() {
        List x = sist.select(new Avioes());
        tm.setRowCount(0);
        for (int i = 0; i < x.size(); i++) {
            Avioes aviao = (Avioes) x.get(i);
            Object[] row = {aviao.getId(), aviao.getEmpresa(), aviao.getModelo(), aviao.getVelocidade(), aviao.getCapacidade()};
            tm.addRow(row);
        }
    }

    private void remover() {
        try {
            int selected = jTableAVIOES.getSelectedRow();
            if (selected != -1) {
                int id = (int) jTableAVIOES.getValueAt(selected, 0);
                sist.getJpaAvioes().destroy(id);
                updateList();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ba meu deu merda");
        }
    }

    private void alterar() {
        try {
            int selected = jTableAVIOES.getSelectedRow();
            if (selected != -1) {
                int id = (int) jTableAVIOES.getValueAt(selected, 0);
                sist.getJpaAvioes().edit(newAviao(Integer.parseInt(jTextFieldID.getText())));
                JOptionPane.showMessageDialog(null, "2");
                updateList();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ba meu deu merdaaaaaaa");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jLabelCadastro12 = new javax.swing.JLabel();
        jLabelCadastro13 = new javax.swing.JLabel();
        jLabelCadastrar = new javax.swing.JLabel();
        jTextFieldEmpresa = new javax.swing.JTextField();
        jTextFieldVelocidade = new javax.swing.JTextField();
        jLabelCadastro17 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabelCadastro18 = new javax.swing.JLabel();
        jLabelCadastro14 = new javax.swing.JLabel();
        jTextFieldCapacidade = new javax.swing.JTextField();
        jLabelCancelar1 = new javax.swing.JLabel();
        jLabelCancelar2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAVIOES = new javax.swing.JTable();
        jTextFieldID = new javax.swing.JTextField();

        jPanelBackground.setBackground(new java.awt.Color(36, 89, 133));

        jLabelCadastro12.setBackground(new java.awt.Color(44, 102, 152));
        jLabelCadastro12.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jLabelCadastro12.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCadastro12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCadastro12.setText("Empresa");
        jLabelCadastro12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelCadastro13.setBackground(new java.awt.Color(44, 102, 152));
        jLabelCadastro13.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jLabelCadastro13.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCadastro13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCadastro13.setText("Velocidade");
        jLabelCadastro13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelCadastrar.setBackground(new java.awt.Color(61, 113, 160));
        jLabelCadastrar.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        jLabelCadastrar.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCadastrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCadastrar.setText("Cadastrar Novo");
        jLabelCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 89, 133), 1, true));
        jLabelCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCadastrar.setName("botao"); // NOI18N
        jLabelCadastrar.setOpaque(true);
        jLabelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCadastrarMouseClicked(evt);
            }
        });

        jTextFieldEmpresa.setBackground(new java.awt.Color(10, 59, 102));
        jTextFieldEmpresa.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEmpresa.setText("AZUL");
        jTextFieldEmpresa.setBorder(null);

        jTextFieldVelocidade.setBackground(new java.awt.Color(10, 59, 102));
        jTextFieldVelocidade.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldVelocidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldVelocidade.setText("850");
        jTextFieldVelocidade.setBorder(null);

        jLabelCadastro17.setBackground(new java.awt.Color(44, 102, 152));
        jLabelCadastro17.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jLabelCadastro17.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCadastro17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCadastro17.setText("Modelo");
        jLabelCadastro17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextFieldModelo.setBackground(new java.awt.Color(10, 59, 102));
        jTextFieldModelo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldModelo.setText("ATR 42-500");
        jTextFieldModelo.setBorder(null);

        jLabelCadastro18.setBackground(new java.awt.Color(44, 102, 152));
        jLabelCadastro18.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jLabelCadastro18.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCadastro18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCadastro18.setText("Cadastro/Alteração - Avioes");
        jLabelCadastro18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelCadastro14.setBackground(new java.awt.Color(44, 102, 152));
        jLabelCadastro14.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jLabelCadastro14.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCadastro14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCadastro14.setText("Capacidade");
        jLabelCadastro14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextFieldCapacidade.setBackground(new java.awt.Color(10, 59, 102));
        jTextFieldCapacidade.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCapacidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCapacidade.setText("120");
        jTextFieldCapacidade.setBorder(null);

        jLabelCancelar1.setBackground(new java.awt.Color(61, 113, 160));
        jLabelCancelar1.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        jLabelCancelar1.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCancelar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelar1.setText("Salvar Alteração");
        jLabelCancelar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 89, 133), 1, true));
        jLabelCancelar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCancelar1.setName("botao"); // NOI18N
        jLabelCancelar1.setOpaque(true);
        jLabelCancelar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCancelar1MouseClicked(evt);
            }
        });

        jLabelCancelar2.setBackground(new java.awt.Color(61, 113, 160));
        jLabelCancelar2.setFont(new java.awt.Font("Gisha", 0, 18)); // NOI18N
        jLabelCancelar2.setForeground(new java.awt.Color(232, 233, 232));
        jLabelCancelar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCancelar2.setText("Remover Selecionado");
        jLabelCancelar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 89, 133), 1, true));
        jLabelCancelar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCancelar2.setName("botao"); // NOI18N
        jLabelCancelar2.setOpaque(true);
        jLabelCancelar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCancelar2MouseClicked(evt);
            }
        });

        jTableAVIOES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableAVIOES);

        jTextFieldID.setEditable(false);
        jTextFieldID.setBackground(new java.awt.Color(10, 59, 102));
        jTextFieldID.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldID.setText("ID");
        jTextFieldID.setBorder(null);

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCadastro12, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCadastro17, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                            .addComponent(jLabelCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCadastro13, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(jTextFieldVelocidade, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCadastro14, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                            .addComponent(jLabelCancelar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabelCadastro18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabelCadastro18)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabelCadastro12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                            .addComponent(jLabelCadastro17)
                            .addGap(34, 34, 34)))
                    .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldVelocidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBackgroundLayout.createSequentialGroup()
                            .addComponent(jLabelCadastro13)
                            .addGap(34, 34, 34)))
                    .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                            .addComponent(jLabelCadastro14)
                            .addGap(34, 34, 34))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCancelar1)
                    .addComponent(jLabelCancelar2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCadastrarMouseClicked
        cadastrar();
    }//GEN-LAST:event_jLabelCadastrarMouseClicked

    private void jLabelCancelar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelar2MouseClicked
        remover();
    }//GEN-LAST:event_jLabelCancelar2MouseClicked

    private void jLabelCancelar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCancelar1MouseClicked
        alterar();
    }//GEN-LAST:event_jLabelCancelar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCadastrar;
    private javax.swing.JLabel jLabelCadastro12;
    private javax.swing.JLabel jLabelCadastro13;
    private javax.swing.JLabel jLabelCadastro14;
    private javax.swing.JLabel jLabelCadastro17;
    private javax.swing.JLabel jLabelCadastro18;
    private javax.swing.JLabel jLabelCancelar1;
    private javax.swing.JLabel jLabelCancelar2;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAVIOES;
    private javax.swing.JTextField jTextFieldCapacidade;
    private javax.swing.JTextField jTextFieldEmpresa;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldVelocidade;
    // End of variables declaration//GEN-END:variables
}
