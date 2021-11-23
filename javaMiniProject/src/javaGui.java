
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class javaGui extends JFrame {

    //Jframe components

    private JPanel panel1;
    private JButton submitButton;
    private JTextField textField1;
    private JButton descriptionButton;
    private JLabel hintLabel;
    private JButton hintButton;
    private JLabel desc;
    private JTextArea howToPlayPressTextArea;



    int i = 0,n=0,j,k=0;                    // Array index variables

    String tl;                              // label text string
    String[] t = new String[10];            // string array for hint
    String[] td = new String[10];           // description string array

    public javaGui() {


//*************************************************************************************************************

        // word bank


        String[] tw = new String[10]; // string array for words
        tw[0] = "word";
        tw[1] = "switch";
        tw[2] = "kick";
        tw[3] = "mobile";
        tw[4] = "processor";

        for (int j = 0; j<=4; j++){ // copying contents of 'tw' string array int 't' string array
            t[i] = tw[j];

            i++;
        }
        i=-1;
        j=0;

        howToPlayPressTextArea.setEditable(false);// setting text area of instructions to uneditable

//****************************************************************************************************************

// description bank

        String[] tdw =  new String[10];
        tdw[0] = "A single distinct conceptual unit of language, comprising inflected and variant forms.";
        tdw[1] = "a small button or something similar that you press up or down in order to turn on electricity.";
        tdw[2] = "To hit or move somebody/something with your foot.";
        tdw[3] = "Able to move or be moved easily";
        tdw[5] = "An integrated electronic circuit that performs the calculations that run a computer.";
        td[0] = tdw[0];

        hintLabel.setText(tl); //setting labet text

//****************************************************************************************************************

//Action listener for submit button

        submitButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String t1 = textField1.getText();

//If else statement to check whether inputted word is correct
                if (CharSequence.compare(tw[j], t1) == 0) {
                    JOptionPane.showMessageDialog(null, "It's the correct word !!");

                    if(JOptionPane.OK_OPTION ==0){
                        textField1.setText("");
                        j++;

                        descriptionButton.setEnabled(true);      //enabling the buttons after correct word entered
                        hintButton.setEnabled(true);
                        hintLabel.setText("");                   // Setting label hint to null
                        desc.setText("");                        // setting description label to null

                    }

                } else {       //incorrect guess
                    JOptionPane.showMessageDialog(null, "Incorrect guess!! . Try using Hint if haven't already");

                }
            }
        });

//*****************************************************************************************************************

        // word description button action listner

        descriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                     //description button

                JOptionPane.showMessageDialog(null, td[k]);
                desc.setText(td[k]);                                         // setting description label
                n++;k++;
                td[k] = tdw[n];

                if(JOptionPane.OK_OPTION==0){   // disabling the button till submitting the correct word
                    descriptionButton.setEnabled(false);

                }



            }
        });
//********************************************************************************************************************

// hint button action listener

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = j;
                t[i] = t[i].replaceAll("\\w", String.valueOf('-'));  //replacing the letters of words at the 'i' th index of t array with '-'
                tl= t[i];
                hintLabel.setText(tl);                                         //setting hint label

                if(JOptionPane.OK_OPTION ==0){  // disabling the button till submitting the correct word
                    hintButton.setEnabled(false);


                }
            }
        });


    }
//main function

    public static void main(String[] args) {

        JFrame j = new JFrame("Word Game");
        j.setContentPane(new javaGui().panel1);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        j.pack();


    }
}