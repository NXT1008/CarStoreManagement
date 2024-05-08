
package Views.OtherForm.component.PieChart;

import DAO.chartDAO;
import Models.pieChartXeModel;
import java.awt.Color;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;


public class fPieChart extends javax.swing.JPanel {

    String month = "", year = "";
    public fPieChart() {
        initComponents();
        loadYear();
        loadMonth(year);
    }
    
    private void loadMonth(String year){
        List<String> list = chartDAO.getInstance().listMonthByYear_HoaDon(year);
        String[] data = new String[list.size()];
        for (int i = 0; i<list.size(); i++){
            data[i] = list.get(i);
        }
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(data);
        cbbMonth.setModel(model);
    }
    
    private void loadYear(){
        String[] data = new String[]{"2021", "2022", "2023", "2024"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(data);
        cbbYear.setModel(model);
    }

    private void showData(String month, String year){
        pieChart.clearData();
        List<pieChartXeModel> list = chartDAO.getInstance().listChartXe(month, year);
            for (int i=0; i<list.size(); i++){
                pieChart.addData(new ModelPieChart(list.get(i).getTenXe(), list.get(i).getTotal(), getColor(i)));
            }
    }
    
    private Color getColor(int index){
        Color[] color = new Color[]{
            new Color(255,102,102), 
            new Color(227, 0, 159), 
            new Color(189, 9, 0), 
            new Color(29,184,85), 
            new Color(94,217,214), 
            new Color(43,45,250), 
            new Color(200,169,86),
            new Color(183, 83, 247),
            new Color(74, 126, 247),
            new Color(158, 85, 106),
            new Color(65, 62, 80),
            new Color(20, 87, 120),
            new Color(166, 0, 88),
            new Color(209, 80, 0),
            new Color(124, 92, 158),
            new Color(1, 145, 97),
            new Color(76, 37, 217),
            new Color(194, 60, 194),
            new Color(105, 6, 158),
            new Color(158, 5, 115),
            new Color(166, 51, 57),
            new Color(0, 207, 151)
        };
        return color[index];
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbMonth = new Views.OtherForm.component.Combobox.Combobox();
        cbbYear = new Views.OtherForm.component.Combobox.Combobox();
        pieChart = new Views.OtherForm.component.PieChart.PieChart();

        cbbMonth.setLabeText("Tháng");
        cbbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMonthActionPerformed(evt);
            }
        });

        cbbYear.setLabeText("Năm");
        cbbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(cbbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(pieChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMonthActionPerformed
        month = cbbMonth.getSelectedItem().toString();
        showData(month, year);
    }//GEN-LAST:event_cbbMonthActionPerformed

    private void cbbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbYearActionPerformed
       year = cbbYear.getSelectedItem().toString();
       loadMonth(year);
    }//GEN-LAST:event_cbbYearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.OtherForm.component.Combobox.Combobox cbbMonth;
    private Views.OtherForm.component.Combobox.Combobox cbbYear;
    private Views.OtherForm.component.PieChart.PieChart pieChart;
    // End of variables declaration//GEN-END:variables
}
