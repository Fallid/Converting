import javax.swing.*;
import java.util.Objects;

public class iniDuit extends JFrame {
    public JPanel getMain() {
        return Main;
    }

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
    private double parseInput;

    public iniDuit() {
        itemConvert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD", "RM", "SGD", "EURO", "YEN", "POND" }));
        buttonClear.addActionListener(e -> {
            inputIDR.setText("");
            outputConvert.setText("");
        });
        convertButton.addActionListener(e -> {
            try {
                String boxItems =(String)itemConvert.getSelectedItem();
                String filter = inputIDR.getText().replace(".", "");
                String Lfilter = filter.replace(",",".");
                setParseInput(Double.parseDouble(Lfilter));

                if (Objects.equals(boxItems, "USD") && parseInput != 0){
                    outputConvert.setText(String.valueOf(USDConv()));
                }
                else if (Objects.equals(boxItems, "RM") && parseInput != 0){
                    outputConvert.setText(String.valueOf(RMConv()));
                }else if (Objects.equals(boxItems, "SGD") && parseInput != 0){
                    outputConvert.setText(String.valueOf(SGDConv()));
                }else if (Objects.equals(boxItems, "EURO") && parseInput != 0){
                    outputConvert.setText(String.valueOf(EUROConv()));
                }else if (Objects.equals(boxItems, "YEN") && parseInput != 0){
                    outputConvert.setText(String.valueOf(YENConv()));
                }else if (Objects.equals(boxItems, "POND") && parseInput != 0){
                    outputConvert.setText(String.valueOf(PONDConv()));
                }
            }catch (Exception error){
                if (inputIDR.getText().matches("[a-zA-Z]+")) {
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
        });
        exitButton.addActionListener(e -> System.exit(100));
        showButton.addActionListener(e -> {

            showAll gktau = new showAll();
            gktau.setSize(500,500);
            gktau.setVisible(true);
            gktau.setContentPane(gktau.getSecond());
            gktau.getUSDTextField().setText(String.valueOf(USDConv()));
            gktau.getRMTextField().setText(String.valueOf(RMConv()));
            gktau.getSGDTextField().setText(String.valueOf(SGDConv()));
            gktau.getEUROTextField().setText(String.valueOf(EUROConv()));
            gktau.getYENTextField().setText(String.valueOf(YENConv()));
            gktau.getPONDTextField().setText(String.valueOf(PONDConv()));
            dispose();
        });
    }
    public double getParseInput() {return parseInput;}
    public void setParseInput(double parseInput) {this.parseInput = parseInput;}

    public double USDConv(){return getParseInput() * 0.00007407407;}
    public double RMConv(){return getParseInput() * 0.000333333;}
    public double SGDConv(){return  getParseInput() * 0.0001;}
    public double EUROConv(){return getParseInput() * 0.0005;}
    public double YENConv(){return getParseInput() * 0.00876;}
    public double PONDConv(){return getParseInput() * 0.00005;}

//    public double
    public static void main(String[] args) {
        iniDuit obj = new iniDuit();
        obj.setContentPane(obj.Main);
        obj.setSize(500,500);
        obj.setTitle("Converting Money Application");
        obj.setVisible(true);
    }

}
