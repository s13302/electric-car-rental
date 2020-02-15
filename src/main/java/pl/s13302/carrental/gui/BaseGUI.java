package pl.s13302.carrental.gui;

import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseGUI extends JFrame {

    private final IApplicationService applicationService;
    private static boolean NEXT_WINDOW_OPENING = false;

    protected BaseGUI(String title, IApplicationService applicationService) {
        super(title);
        this.applicationService = applicationService;
        setSize(600, 160);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                NEXT_WINDOW_OPENING = false;
            }

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                if (! NEXT_WINDOW_OPENING) {
                    getApplicationService().finalizeService();
                }
            }

        });
    }

    public IApplicationService getApplicationService() {
        return applicationService;
    }

    /**
     * Creation method which using reflection. Creates the instance from one-parameter constructor with type IApplicationService
     * @see IApplicationService
     * @param currentWindow current window to close
     * @param nextWindowClass Type of window to create.
     * @param applicationService Application service to use
     * @return Instance of created window.
     * @throws Exception
     */
    public static BaseGUI showNextWindow(BaseGUI currentWindow, Class<? extends BaseGUI> nextWindowClass, IApplicationService applicationService) throws Exception {
        assert nextWindowClass != null;
        NEXT_WINDOW_OPENING = true;
        if (currentWindow != null) {
            currentWindow.dispatchEvent(new WindowEvent(currentWindow, WindowEvent.WINDOW_CLOSING));
        }
        BaseGUI nextWindow = nextWindowClass
                .getConstructor(IApplicationService.class)
                .newInstance(applicationService);
        nextWindow.add(nextWindow.showWindow());
        nextWindow.setVisible(true);
        return nextWindow;
    }

    /**
     * Method to build the window content. Create JPanel first and add everything to this JPanel.
     * @return JPanel with all components on it.
     * @see JPanel
     */
    public abstract JPanel showWindow();

    protected void jLabelWithBold(JLabel jLabel) {
        Font font = jLabel.getFont();
        jLabel.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
    }

}
