import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class GUIForm extends JDialog {
    private int realColCnt;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton добавитьButton;
    private JButton удалитьButton;
    private JButton вычислитьButton;
    private JTable table1;
    private JButton заполнитьButton;
    private JButton очиститьButton;


    ////////////////////////////////////ПЕРЕМЕННЫЕ/////////////////////////////////////////////////
    private double[] dataT = new double[4];
    int num =1;
    public RecIntegral[] dataListObject = new RecIntegral[10];
    DefaultTableModel model = (DefaultTableModel) table1.getModel();

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public GUIForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Лаба 1");

        createTable();
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        добавитьButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                добавитьButton();
            }
        });
        удалитьButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { удалитьButton();
            }
        });

        вычислитьButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                вычислитьButton();
            }
        });
        заполнитьButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                заполнитьButton();
            }
        });
        очиститьButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                очиститьButton();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        createTable();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    ////////////////////////////////////РАБОТА С ДАННЫМИ/////////////////////////////////////////////////
    private void добавитьButton() {
        dataListObject[num-1]= new RecIntegral();

        dataListObject[num-1].setDataA(Double.valueOf(
                textField1.getText()));

        dataListObject[num-1].setDataB(Double.valueOf(
                textField3.getText()));

        dataListObject[num-1].setDataC(Double.valueOf(
                textField2.getText()));

        dataListObject[num-1].setDataD(0.0);

        model.addRow(dataListObject[num-1].getDataList());

        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }
    private void удалитьButton() {
        int rowNamber;
        rowNamber=table1.getSelectedRow();
        model.removeRow(rowNamber);
        dataListObject[rowNamber].clearObject();

        num--;
    }

    private void заполнитьButton() {
        int countData = dataListObject[num].getCount();

        num=1;
        for(int i=0; i<countData;i++) {
            model.addRow(dataListObject[i].getDataList());
            num++;
        }
    }

    private void очиститьButton() {

        model.setRowCount(0);
    }
    private void вычислитьButton() {

        dataListObject[num-1].Trap();

        model.removeRow(num-1);
        model.addRow(dataListObject[num-1].getDataList());
        num++;

    }

    public void createTable(){

            model.addColumn("Верхняя граница интегрирования");
            model.addColumn("Нижняя граница интегрирования");
            model.addColumn("Шаг интегрирования");
            model.addColumn("Результат");
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        GUIForm dialog = new GUIForm();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setName("laba1");

        System.exit(0);
    }
}

