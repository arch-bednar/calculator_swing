import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener{

    GridBagConstraints constraints;
    GridBagLayout bagLayout;
    Container container;
    JTextField field;
    History history;

    Calculator(String title){
        super(title);
        makeFrame();
        makeLayout();
    }

    public void makeFrame(){
        this.setSize(new Dimension(300, 390));
        this.setBackground(Color.GRAY);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);
    }

    public void makeLayout(){
        constraints = new GridBagConstraints();
        bagLayout = new GridBagLayout();
        container = this.getContentPane();
        container.setLayout(bagLayout);

        makeHistory();
        makeField();
        makeButtons();

        container.setBackground(Color.LIGHT_GRAY);
    }

    public void makeHistory(){
        //history = new JLabel();
        history = new History();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        //constraints.ipady = 5;
        //constraints.gridheight = 2;
        constraints.insets = new Insets(5,5,5,5);
        container.add(history, constraints);
    }


    public class History extends JPanel{

        JLabel operation;
        History(){
            //this.setSize(new Dimension(100, 100));
            this.setBackground(Color.RED);
            operation = new JLabel("");
            this.add(operation);
        }

        public void setOperation(String string){
            operation.setText(string);
        }
    }

    public void makeField(){
        field = new JTextField(25);
        field.addActionListener(this);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.gridwidth = 5;
        //constraints.insets = new Insets(5,5,5,5);
        container.add(field, constraints);
    }

    public void makeButtons(){
        makeNumbers();
        makeSigns();
    }

    public void makeNumbers(){

        int[][] numbers = { {7,8,9},
                            {4,5,6},
                            {1,2,3},
                            {0}};

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                JButton button = new JButton(Integer.toString(numbers[i][j]));
                constraints.gridx = 0 + j;
                constraints.gridy = 4 + i;
                constraints.gridheight = 1;
                constraints.gridwidth = 1;
                constraints.insets = new Insets(5,5,5,5);
                container.add(button, constraints);
            }
        }

        JButton button = new JButton(Integer.toString(numbers[3][0]));
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(button, constraints);
    }

    public void makeSigns(){

        JButton sign = new JButton(".");
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("+/-");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);
        sign.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event){
                System.out.println("+/-");
           }
        });

        sign = new JButton("=");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 3;
        //constraints.gridheight = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("C");
        sign.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseReleased(MouseEvent e){
               history.setOperation(field.getText());
               field.setText("");
           }
        });
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("CE");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("%");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("sqrt");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("-");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("/");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("+");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 3;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        sign = new JButton("*");
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 4;
        constraints.gridy = 8;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5,5,5,5);
        container.add(sign, constraints);

        //System.out.println(sign.getText());
    }

    public void actionPerformed(ActionEvent e){
        String text = field.getText();
        System.out.println(text);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
           public void run(){
                Calculator calc = new Calculator("Calculator Swing");
           }
        });
    }
}
