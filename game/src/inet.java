import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

public class inet implements ActionListener {
    private final int size = 8;
    private int sindex = 0;

    JFrame jrf = new JFrame("Student Registration Form");
    JMenuBar jmb = new JMenuBar();

    JMenuItem jmi_new = new JMenuItem("New");
    JMenuItem jmi_set = new JMenuItem("Setting");

    JLabel jlfname = new JLabel("Email        ");
    JLabel jlname = new JLabel("First Name    ");
    JLabel jlpass = new JLabel("Password      ");

    JTextField jtname = new JTextField(20);
    JTextField jtfname = new JTextField(20);
    JTextField[] jtempty = new JTextField[size];

    JPasswordField jp = new JPasswordField(20);

    JButton jb_sub = new JButton("Submit");
    JButton jb_clear = new JButton("Clear");
    JButton jb_view = new JButton("View All");

    inet() {
        createForm();
    }

    public void emptyTextField() {
        for (int i = 0; i < size; i++) {
            jtempty[i] = new JTextField(25);
            jtempty[i].setEditable(false);
            jtempty[i].setBorder(null);
            jtempty[i].setBackground(Color.ORANGE);
        }
    }
    public void createForm() {
        emptyTextField();
        jrf.setJMenuBar(jmb);
        jrf.add(jlname);
        jrf.add(jtname);
        jrf.add(jtempty[0]);
        jrf.add(jlfname);
        jrf.add(jtfname);
        jrf.add(jtempty[1]);
        jrf.add(jlpass);
        jrf.add(jp);
        jrf.add(jtempty[2]);
        jtempty[7].setColumns(30);
        jrf.add(jtempty[7]);
        jrf.add(jtempty[3]);
        jrf.add(jtempty[4]);
        jrf.add(jtempty[5]);
        jrf.add(jtempty[6]);
        jrf.add(jb_sub);
        jrf.add(jb_clear);
        jrf.add(jb_view);
        jb_sub.addActionListener(this);
        jb_clear.addActionListener(this);
        jb_view.addActionListener(this);
        jrf.setLayout(new FlowLayout());
        jrf.setSize(350, 600);
        // setResizable allow to not extend the frame size
        jrf.setResizable(false);
        // jrf.setBounds(100,0,350,700);
        jrf.setVisible(true);
        jrf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jrf.getContentPane().setBackground(Color.ORANGE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jb_sub)) {
            // JOptionPane.showMessageDialog(null, "Do you want to Submit Application");
            submitData();
        } else if (e.getSource().equals(jb_clear)) {
            // JOptionPane.showMessageDialog(null,"It will remove Data","Student Regirstaion
            // Data",JOptionPane.WARNING_MESSAGE);
            clearForm();
        }
    }
    void clearForm() {
        jtname.setText("");
        jtfname.setText("");
        jp.setText("");
        ;
    }
    void submitData() {
        String name = jtname.getText();
        String fname = jtfname.getText();
        String pass = String.valueOf(jp.getPassword());

        clearForm();
        jrf.setVisible(false);
    }
    public static void main(String[] args) {
        inet rf = new inet();
    }
}

