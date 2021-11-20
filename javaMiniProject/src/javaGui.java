import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class javaGui extends JFrame{

    private JPanel panel1;
    private JButton submitButton;
    private JTextField textField1;
    private JButton hintButton;
    private JLabel Label;


    public javaGui() throws FileNotFoundException {

        File file = new File("E:\\JAVA-Mini-Project\\javaMiniProject\\words.txt");
        Scanner sc = new Scanner(file);

        String t = sc.nextLine ();//text
        String td = sc.nextLine();//text description
        String t2 = t;

        t2 = t2.replaceAll("\\w", String.valueOf('-'));  //printing dashes

        Label.setText(t2); // modifying dashes according to the word
        //System.out.println();


        submitButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String t1 = textField1.getText();
                //correct word
                if (CharSequence.compare(t, t1) == 0){
                        JOptionPane.showMessageDialog(null, "It's the correct word !!");
                }
                else{//incorrect guess
                    JOptionPane.showMessageDialog(null, "incorrect guess");
                }
            }
        });
        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//description button

                JOptionPane.showMessageDialog(null, td);
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
