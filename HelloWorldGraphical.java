import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorldGraphical extends JFrame implements ActionListener {
    private JPanel panel1, panel2, panel3;
    private JButton en, fr, de, es, exit;
    private JLabel textLabel;
    
    /**
     *  Construction of 'HelloWorldGraphical' class
     */
    public HelloWorldGraphical(String title){
        
        // Create the window as a frame and initialize panels
        JFrame window = new JFrame (title);
        topPanel();
        midPanel();
        bottomPanel();
        
        window.setSize(new Dimension(300, 350));
        window.setMinimumSize(new Dimension(300, 350));     // Window can not be smaller than 300x350 pixels
        window.setLocationRelativeTo(null);                 // The window appears in the center of the screen
        window.setLayout(new BorderLayout());
        
        // Add panels to the window frame
        window.add(panel1, BorderLayout.PAGE_START);
        window.add(panel2, BorderLayout.CENTER);
        window.add(panel3, BorderLayout.PAGE_END);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Application ends when the window is closed

        window.setVisible(true);                                    // Makes the window visible
    }
    
    /** 
     *  Creates topPanel
     */
    public void topPanel(){
        //Initializes panel and buttons included
        panel1 = new JPanel();
        deButton();
        enButton();
        frButton();
        esButton();
        
        /*
         *  Add a vertical BoxLayout
         *  'createRigidArea' creates empty spaces of Dimensions (x,y) between buttons
         */
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(Box.createRigidArea(new Dimension(0,30)));
        panel1.add(de);
        panel1.add(Box.createRigidArea(new Dimension(0,10)));
        panel1.add(en);
        panel1.add(Box.createRigidArea(new Dimension(0,10)));
        panel1.add(fr);
        panel1.add(Box.createRigidArea(new Dimension(0,10)));
        panel1.add(es);
        panel1.add(Box.createRigidArea(new Dimension(0,30)));
        
        panel1.setVisible(true);
    }
    
    /**
     *  creates midPanel
     */
    public void midPanel(){
        panel2 = new JPanel();
        textLabel = new JLabel("Hello!");   // Initializes the text of the label as "Hello!"
        
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(Box.createRigidArea(new Dimension(30,0)));
        panel2.add(textLabel);
        
        panel2.setVisible(true);
    }
    
    /**
     *  creates bottompanel
     */
    public void bottomPanel(){
        panel3 = new JPanel();
        exButton();
        
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel3.add(Box.createHorizontalGlue());     // places the remaining space of the BoxLayout
        panel3.add(exit);
        panel3.add(Box.createRigidArea(new Dimension(10,0)));
        
        panel3.setVisible(true);
    }
    
    /**
     *  Creates english button
     */
    public void enButton(){
        en = new JButton("English");
        en.setAlignmentX(Component.CENTER_ALIGNMENT);
        en.addActionListener(this);
    }
    
    /**
     *  Creates french button
     */
    public void frButton(){
        fr = new JButton("Français");
        fr.setAlignmentX(Component.CENTER_ALIGNMENT);
        fr.addActionListener(this);
    }
    
    /**
     *  Creates german button
     */
    public void deButton(){
        de = new JButton("Deutsch");
        de.setAlignmentX(Component.CENTER_ALIGNMENT);
        de.addActionListener(this);
    }
    
    /**
     *  Creates spanish button
     */
    public void esButton(){
        es = new JButton("Español");
        es.setAlignmentX(Component.CENTER_ALIGNMENT);
        es.addActionListener(this);
    }

    /**
     *  Creates exit button
     */
    public void exButton(){
        exit = new JButton("Exit");
        exit.setForeground(Color.red);
        exit.addActionListener(this);
    }
    
    /**
     *  ActionEvent listener implemented for all the buttons using the instruction getSource();
     */
    public void actionPerformed(ActionEvent e) {
        
        /*
         *  Every time a button is pressed, the label and the exit button update their texts language
         *  'getSource()' gives a reference to the object that the event came from
         */
        if (e.getSource()==en){
            textLabel.setText("Hello!");
            textLabel.setVisible(true);
            exit.setText("Exit");
            exit.setVisible(true);
        }
        else if (e.getSource()==fr){
            textLabel.setText("Bonjour!");
            textLabel.setVisible(true);
            exit.setText("Sortie");
            exit.setVisible(true);
        }
        else if (e.getSource()==de){
            textLabel.setText("Guten Tag!");
            textLabel.setVisible(true);
            exit.setText("Beenden");
            exit.setVisible(true);
        }
        else if (e.getSource()==es){
        	textLabel.setText("¡Hola!");
            textLabel.setVisible(true);
            exit.setText("Salir");
            exit.setVisible(true);
        }
        else if (e.getSource()==exit)
            System.exit(0);     // Exits the application
    }
    
    /**
     *  Main function that calls HellowWorldGraphical
     */
    public static void main(String[] args) {
        HelloWorldGraphical window = new HelloWorldGraphical("Hello GUI");
    }
}
