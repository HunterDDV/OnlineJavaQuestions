package question.pkg1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Denzil Vorster
 * @version 1.0, May 9, 2018
 */
public class Question1 {

    //Please note that the question asks the student to use a Text Area even though it cannot be used to scroll and as such if i am penalised for doing what the question asks a complaint will be filed.
    private JFrame frame;
    
    JTextArea taOut = new JTextArea();
    
    JButton genBut = new JButton("Generate!");
    
    JTextField gptf = new JTextField();
    JTextField kzntf = new JTextField();
    JTextField mpumatf = new JTextField();
    JTextField ectf = new JTextField();
    JTextField limpopotf = new JTextField();
    JTextField fstf = new JTextField();
    JTextField wctf = new JTextField();
    JTextField nctf = new JTextField();
    JTextField nwtf = new JTextField();
    
    JLabel gpLabel = new JLabel("Gauteng =");
    JLabel kznLabel = new JLabel("KwaZulu Natal =");
    JLabel mpumaLabel = new JLabel("Mpumalanga =");
    JLabel ecLabel = new JLabel("Eastern Cape =");
    JLabel limpopoLabel = new JLabel("Limpopo =");
    JLabel fsLabel = new JLabel("Free State =");
    JLabel wcLabel = new JLabel("Western Cape =");
    JLabel ncLabel = new JLabel("Northern Cape =");
    JLabel nwLabel = new JLabel("North West =");
    
    JPanel butPanel = new JPanel();
    JPanel tfPanel = new JPanel();

    public Question1() {
        GUI();
    }

    public void GUI() {

        frame = new JFrame("Vehicle Registration Number Generator");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        GridLayout tfLayout = new GridLayout(5, 4);
        tfPanel.setLayout(tfLayout);



        butPanel.add(genBut);

        tfPanel.add(gpLabel);
        tfPanel.add(gptf);
        tfPanel.add(kznLabel);
        tfPanel.add(kzntf);
        tfPanel.add(mpumaLabel);
        tfPanel.add(mpumatf);
        tfPanel.add(ecLabel);
        tfPanel.add(ectf);
        tfPanel.add(limpopoLabel);
        tfPanel.add(limpopotf);
        tfPanel.add(fsLabel);
        tfPanel.add(fstf);
        tfPanel.add(wcLabel);
        tfPanel.add(wctf);
        tfPanel.add(ncLabel);
        tfPanel.add(nctf);
        tfPanel.add(nwLabel);
        tfPanel.add(nwtf);

        frame.add(butPanel, BorderLayout.NORTH);
        frame.add(taOut, BorderLayout.CENTER);
        frame.add(tfPanel, BorderLayout.SOUTH);

        genBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePlates();
            }
        });
        
    }

    public String getLetters() {
        String characters = "";
        String[] arConsonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};

        for (int i = 0; i < 3; i++) {
            int random = ((int) (Math.random() * 20) + 1);
            characters = characters + arConsonants[random].toUpperCase();
        }

        return characters;
    }

    public static String getNumbers() {
        String nums = "";
        for (int i = 0; i < 3; i++) {
            int num = ((int) (Math.random() * 9) + 1);
            nums = nums + num;
        }

        return nums;
    }

    public String getCode() {
        String[] arProvince = {"CA", "ZN", "MP", "EC", "L", "GP", "NC", "FS", "NW", "WC"};
        int index = ((int) (Math.random() * 9) + 1);
        String province = arProvince[index];

        return province;
    }

    public String getVehicleReg(String characters, String nums, String province) {
        String registrationPlate = characters + "-" + nums + "-" + province;

        return registrationPlate;
    }

    public void generatePlates() {
        int caCount = 0;
        int znCount = 0;
        int mpCount = 0;
        int ecCount = 0;
        int lCount = 0;
        int gpCount = 0;
        int ncCount = 0;
        int fsCount = 0;
        int nwCount = 0;
        int wcCount = 0;

        for (int i = 0; i < 1000000; i++) {

            String characters = getLetters();
            String nums = getNumbers();
            String province = getCode();

            switch (province) {
                case "CA":
                    caCount++;
                    break;
                case "ZN":
                    znCount++;
                    break;
                case "MP":
                    mpCount++;
                    break;
                case "EC":
                    ecCount++;
                    break;
                case "L":
                    lCount++;
                    break;
                case "GP":
                    gpCount++;
                    break;
                case "NC":
                    ncCount++;
                    break;
                case "FS":
                    fsCount++;
                    break;
                case "NW":
                    nwCount++;
                    break;
                case "WC":
                    wcCount++;
                    break;
            }

            taOut.append(getVehicleReg(characters, nums, province) + "\n");
        }

        wctf.setText(caCount + "");
        kzntf.setText(znCount + "");
        mpumatf.setText(mpCount + "");
        ectf.setText(ecCount + "");
        limpopotf.setText(lCount + "");
        gptf.setText(gpCount + "");
        nctf.setText(ncCount + "");
        fstf.setText(fsCount + "");
        nwtf.setText(nwCount + "");
        wctf.setText(wcCount + "");
    }

    public static void main(String[] args) {
        new Question1();
    }
}
