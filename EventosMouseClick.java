package EVentos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase EventosMouseClick: Evalúa modificadores de teclado combinados con el mouse 
 * (Alt, Ctrl, Shift, Clic derecho) y la detección de doble clic mediante getClickCount().
 */
public class EventosMouseClick extends JFrame {

    public EventosMouseClick() {
        // Componentes gráficos de la interfaz
        JLabel lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);
        
        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);
        
        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);
        
        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Definición del listener para eventos de clic detallados
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Validación de combinaciones de teclas con clics del mouse
                if (e.isAltDown()) {
                    lblSaludo.setText("clic + alt");
                    System.out.println("clic + alt");
                } else if (e.isControlDown()) {
                    lblSaludo.setText("clic + Control");
                    System.out.println("clic + Control");
                } else if (e.isShiftDown()) {
                    lblSaludo.setText("clic + Shift");
                    System.out.println("clic + Shift");
                } else if (e.isMetaDown()) {
                    // isMetaDown detecta el botón secundario o clic derecho según el sistema operativo
                    lblSaludo.setText("clic derecho");
                    System.out.println("clic derecho");
                } else {
                    lblSaludo.setText("clic izquierdo");
                    System.out.println("clic izquierdo");
                }

                // Validación para detectar si se realizó un doble clic rápido[cite: 18]
                if (e.getClickCount() == 2) {
                    lblSaludo.setText("doble clic");
                    System.out.println("doble clic");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };

        // Agregar el listener al botón y al campo de texto
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        // Añadir componentes a la ventana
        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);
        
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventosMouseClick objEventoMouse = new EventosMouseClick();
    }
}