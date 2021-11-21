
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

    int i = 0,n=0,j=0,k=0;
    String tl;
    public javaGui() throws FileNotFoundException {

       // File file = new File("E:\\JAVA-Mini-Project\\javaMiniProject\\words.txt");
        Scanner sc = new Scanner(System.in);

        final String[] t = new String[10];
        final String[] td = new String[10];
        String[] tw = new String[10];
        tw[0] = "word";
        tw[1] = "switch";
        tw[2] = "kick";
        tw[3] = "mobile";
        tw[4] = "vehicle";

        for (int j = 0; j<=4; j++){
            t[i] = tw[j];

            System.out.println(t[i]);
            i++;
        }
      i=-1;
        j=0;
        String[] tdw =  new String[10];
        tdw[0] = "A single distinct conceptual unit of language, comprising inflected and variant forms.";
        tdw[1] = "sample1";
        tdw[2] = "sample2";
        tdw[3] = "sample3";
        tdw[5] = "sample4";
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

                        descriptionButton.setEnabled(true);
                        hintButton.setEnabled(true);
                        Label.setText("");
                        desc.setText("");

                    }

                } else {//incorrect guess
                    JOptionPane.showMessageDialog(null, "incorrect guess");

                }
            }
        });
        descriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//description button

                JOptionPane.showMessageDialog(null, td[k]);
                desc.setText(td[k]);
                n++;k++;
                td[k] = tdw[n];
                int b =0;
                if(b==JOptionPane.OK_OPTION){
                    descriptionButton.setEnabled(false);

                }



            }
        });

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i++;
                t[i] = t[i].replaceAll("\\w", String.valueOf('-'));
                tl= t[i];
                Label.setText(tl);
                System.out.println(i);
                int b =0;
                if(b==JOptionPane.OK_OPTION){
                    hintButton.setEnabled(false);

                }
            }
        });


    }

    public static void main(String[] args) throws FileNotFoundException {

        javaGui j = new javaGui();
        j.setContentPane(new javaGui().panel1);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();


    }
}
