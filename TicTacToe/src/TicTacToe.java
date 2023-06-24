import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame(); // declaring frame for the window to play
    JPanel title_panel = new JPanel(); // declaring a panel to hold the title
    JPanel button_panel = new JPanel(); // declaring a panel to hold the buttons
    JLabel textfield = new JLabel(); // declaring a text field to display a message
    JButton[] buttons = new JButton[9]; // declaring buttons to use on the JPanel
    boolean player1_turn;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing the app
        frame.setSize(800, 800); // size of the JFrame
        frame.getContentPane().setBackground(new Color(200, 200, 50)); // color of the under background
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25, 25, 25)); // colors, alignments and other data for the upper text feild
        textfield.setForeground(new Color(25, 255, 255));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout()); // the rectanglar box where the textfield is going
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3)); // button grid
        button_panel.setBackground(new Color(150, 150, 150)); // button color

        for (int i = 0; i < 9; i++) { // adding the buttons to the panel
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); // making buttons "Active"
        }

        // putting everything together
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for (int i = 0; i < 9; i++) { // sorting out turns until all 9 buttons have been pressed or 3 in a row
                                      // achieved
            if (e.getSource() == buttons[i]) { // witch button was pressed
                if (player1_turn) {
                    if (buttons[i].getText() == "") { // if it hasnt been pressed yet
                        buttons[i].setForeground(new Color(255, 0, 0)); // if i press change color
                        buttons[i].setText("X"); // and change to X or O
                        player1_turn = false; // make it O-s turn
                        textfield.setText("O turn");
                        check(); // check if there is a winning manouver

                    }
                } else {
                    if (buttons[i].getText() == "") { // O-s turn and rest is same
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }

                }
            }
        }
    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) { // whos turn will it be (not the wisest solution for this one, i admit)
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    public void check() {
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")

        ) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")

        ) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")

        ) {
            xWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")

        ) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")

        ) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")

        ) {
            xWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")

        ) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")

        ) {
            xWins(2, 4, 6);
        }

        // AND same with O

        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")

        ) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")

        ) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")

        ) {
            oWins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")

        ) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")

        ) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")

        ) {
            oWins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")

        ) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")

        ) {
            oWins(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c) { // change color of buttons if winner has been determined

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");

    }

    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {

            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");

    }

}
