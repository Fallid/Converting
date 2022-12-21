import javax.swing.*;

public class showAll extends JFrame {
    private JLabel TitleText;
    private JButton backButton;
    private JPanel second;
    private JTextField RMTextField;
    private JTextField SGDTextField;
    private JTextField EUROTextField;
    private JTextField YENTextField;
    private JTextField PONDTextField;
    private JTextField USDTextField;
    private JLabel RMText;
    private JLabel SGDText;
    private JLabel EUROText;
    private JLabel YENText;
    private JLabel PONDText;
    private JLabel USDText;

    public JTextField getRMTextField() {
        return RMTextField;
    }
    public JPanel getSecond() {
        return second;
    }
    public JTextField getPONDTextField() {
        return PONDTextField;
    }
    public JTextField getSGDTextField() {
        return SGDTextField;
    }

    public JTextField getEUROTextField() {
        return EUROTextField;
    }

    public JTextField getYENTextField() {
        return YENTextField;
    }

    public JTextField getUSDTextField() {
        return USDTextField;
    }

    public showAll() {
        backButton.addActionListener(e -> {
            iniDuit mainObj = new iniDuit();
            mainObj.setVisible(true);
            mainObj.setSize(500,500);
            mainObj.setContentPane(mainObj.getMain());
            dispose();
        });
    }


    public static void main(String[] args) {
        showAll obj = new showAll();
        obj.setContentPane(obj.second);
        obj.setTitle("Converting Money Application");
        obj.setSize(500,500);
        obj.setVisible(true);
    }
}
