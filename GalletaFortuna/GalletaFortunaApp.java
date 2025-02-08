import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GalletaFortunaApp extends JFrame {
    private JLabel etiquetaMensaje;
    private JButton botonAbrir;
    private MensajeProvider mensajeProvider;

    public GalletaFortunaApp(MensajeProvider provider) {
        this.mensajeProvider = provider;

        setTitle("Galletas de la Fortuna");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        etiquetaMensaje = new JLabel("Haz clic para ver tu fortuna", SwingConstants.CENTER);
        etiquetaMensaje.setFont(new Font("Arial", Font.PLAIN, 14));
        add(etiquetaMensaje, BorderLayout.CENTER);


        botonAbrir = new JButton("Abrir galleta") {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isContentAreaFilled()) {
                    super.paintComponent(g);
                    return;
                }
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Redondeo
                g2.dispose();
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                g.setColor(getForeground());
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            }
        };


        botonAbrir.setContentAreaFilled(false);
        botonAbrir.setFocusPainted(false);
        botonAbrir.setBorderPainted(false);
        botonAbrir.setBackground(new Color(10, 14, 32));
        botonAbrir.setForeground(Color.BLACK);
        botonAbrir.setFont(new Font("Arial", Font.BOLD, 14));
        botonAbrir.setPreferredSize(new Dimension(150, 40));

        botonAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMensajeAleatorio();
            }
        });


        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout());
        panelBoton.add(botonAbrir);
        add(panelBoton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void mostrarMensajeAleatorio() {
        String mensaje = mensajeProvider.obtenerMensajeAleatorio();
        etiquetaMensaje.setText("<html><div style='text-align: center;'>" + mensaje + "</div></html>");
    }}