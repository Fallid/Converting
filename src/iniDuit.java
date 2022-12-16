import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iniDuit extends JFrame {
    private JPanel Main;
    private JPanel Title;
    private JTextField inputIDR;
    private JButton buttonClear;
    private JButton convertButton;
    private JComboBox <String> itemConvert;
    private JTextField outputConvert;
    private JPanel IDRPanel;
    private JLabel IDRText;
    private JLabel TitleText;
    private JButton exitButton;
    private JPanel ButtonPanel;
    private JButton showButton;

    public iniDuit() {
        itemConvert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD", "RM", "SGD", "EURO", "YEN", "POND" }));
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputIDR.setText("");
                outputConvert.setText("");
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String boxItems =(String)itemConvert.getSelectedItem();
                    String filter = inputIDR.getText();
                    double parseInput = Double.parseDouble(inputIDR.getText());
                    if (boxItems.equals("USD") && parseInput != 0){
                        double USDResult = parseInput * 0.00007407407;
                        outputConvert.setText(String.valueOf(USDResult));
                    }
                    else if (boxItems.equals("RM") && parseInput != 0){
                        double RMResult = parseInput * 0.000333333;
                        outputConvert.setText(String.valueOf(RMResult));
                    }else if (boxItems.equals("SGD") && parseInput != 0){
                        double SGDResult = parseInput * 0.0001;
                        outputConvert.setText(String.valueOf(SGDResult));
                    }else if (boxItems.equals("EURO") && parseInput != 0){
                        double EUROResult = parseInput * 0.0005;
                        outputConvert.setText(String.valueOf(EUROResult));
                    }else if (boxItems.equals("YEN") && parseInput != 0){
                        double YENResult = parseInput * 0.00876;
                        outputConvert.setText(String.valueOf(YENResult));
                    }else if (boxItems.equals("POND") && parseInput != 0){
                        double PONDResult = parseInput * 0.00005;
                        outputConvert.setText(String.valueOf(PONDResult));
                    }
                }catch (Exception error){
                    if (inputIDR.getText().matches("^.*[,].*$")){
                        JOptionPane.showMessageDialog(convertButton ,"Gunakan \".\" untuk bilangan pecahan \n" + error);
                    }else if (inputIDR.getText().matches("[a-zA-Z]+")) {
                        JOptionPane.showMessageDialog(convertButton, "Gunakan bilangan angka \n" + error);
                    }else if (inputIDR.getText().isEmpty()){
                        JOptionPane.showMessageDialog(convertButton, "Masukkan jumlah uang IDR terlebih dahulu \n" + error);
                    }else if (inputIDR.getText().matches("^.*[~!@#$%^&()_+=\\-{}\\[\\]|:;“’<>?๐฿].*$")){
                        JOptionPane.showMessageDialog(convertButton, "Tidak bisa mengkonversi spesial karakter \n" + error);
                    }
                    else {
                        JOptionPane.showMessageDialog(convertButton, error);
                    }
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(100);
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAll gktau = new showAll();
                gktau.showAll();
            }
        });
    }

    public static void main(String[] args) {
        iniDuit obj = new iniDuit();
        obj.setContentPane(obj.Main);
        obj.setTitle("Converting Money Application");
        obj.setSize(500,500);
        obj.setVisible(true);
    }

}
