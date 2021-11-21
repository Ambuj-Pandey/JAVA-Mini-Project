
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;



public class javaGui extends JFrame {

    private JPanel panel1;
    private JButton submitButton;
    private JTextField textField1;
    private JButton descriptionButton;
    private JLabel Label;
    private JButton hintButton;
    private JLabel desc;
    private JTextArea howToPlayPressTextArea;


    int i = 0,n=0,j=0,k=0;
    String tl;
    public javaGui() throws FileNotFoundException {

       // File file = new File("E:\\JAVA-Mini-Project\\javaMiniProject\\words.txt");
        Scanner sc = new Scanner(System.in);

      // word bank

        final String[] t = new String[10];
        final String[] td = new String[10];
        String[] tw = new String[10];
        tw[0] = "word";
        tw[1] = "switch";
        tw[2] = "kick";
        tw[3] = "mobile";
        tw[4] = "processor";

        for (int j = 0; j<=4; j++){
            t[i] = tw[j];

            i++;
        }
        i=-1;
        j=0;

       howToPlayPressTextArea.setEditable(false);// setting text area of instructions to uneditable

        //description bank

        String[] tdw =  new String[10];
        tdw[0] = "A single distinct conceptual unit of language, comprising inflected and variant forms.";
        tdw[1] = "a small button or something similar that you press up or down in order to turn on electricity.";
        tdw[2] = "To hit or move somebody/something with your foot.";
        tdw[3] = "Able to move or be moved easily";
        tdw[5] = "An integrated electronic circuit that performs the calculations that run a computer.";
        td[0] = tdw[0];


        Label.setText(tl);
        submitButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String t1 = textField1.getText();
                //correct word

                if (CharSequence.compare(tw[j], t1) == 0) {
                    JOptionPane.showMessageDialog(null, "It's the correct word !!");
                    int a =0;
                    if(a==JOptionPane.OK_OPTION){
                        textField1.setText("");
                        j++;

                        descriptionButton.setEnabled(true);  //enabling the buttons after correct word entered
                        hintButton.setEnabled(true);
                        Label.setText("");
                        desc.setText("");

                    }

                } else {//incorrect guess
                    JOptionPane.showMessageDialog(null, "incorrect guess");

                }
            }
        });
        // word description
        descriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//description button

                JOptionPane.showMessageDialog(null, td[k]);
                desc.setText(td[k]);
                n++;k++;
                td[k] = tdw[n];
                int b =0;
                if(b==JOptionPane.OK_OPTION){   // disabling the button till submitting the correct word
                    descriptionButton.setEnabled(false);

                }



            }
        });
        // hint
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                t[i] = t[i].replaceAll("\\w", String.valueOf('-'));
                tl= t[i];
                Label.setText(tl);
                int b =0;
                if(b==JOptionPane.OK_OPTION){  // disabling the button till submitting the correct word
                    hintButton.setEnabled(false);

                }
            }
        });


    }

    public static void main(String[] args) throws FileNotFoundException {

        JFrame j = new JFrame("Word Game");
        j.setContentPane(new javaGui().panel1);
        j.setContentPane(new javaGui().panel1);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();


    }
}
