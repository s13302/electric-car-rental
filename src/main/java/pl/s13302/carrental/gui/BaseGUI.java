package pl.s13302.carrental.gui;

import pl.s13302.carrental.service.IApplicationService;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseGUI extends JFrame {

    private static final int INTERVAL = 1000;

    private final IApplicationService applicationService;
    private final Timer timer;

    protected BaseGUI(String title, IApplicationService applicationService) {
        super(title);
        this.applicationService = applicationService;
        this.timer = createTickTimer();
        setSize(600, 160);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                timer.stop();
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
        if (currentWindow != null) {
            currentWindow.dispatchEvent(new WindowEvent(currentWindow, WindowEvent.WINDOW_CLOSING));
        }
        BaseGUI nextWindow = nextWindowClass
                .getConstructor(IApplicationService.class)
                .newInstance(applicationService);
        nextWindow.add(nextWindow.showWindow());
        nextWindow.setVisible(true);
        nextWindow.tick();
        nextWindow.timer.start();
        return nextWindow;
    }

    /**
     * Method to build the window content. Create JPanel first and add everything to this JPanel.
     * @return JPanel with all components on it.
     * @see JPanel
     */
    public abstract JPanel showWindow();

    /**
     * Method which provides ability to change the data. Here you need to implement the change logic.
     */
    public void tick() {}

    private Timer createTickTimer() {
        Timer timer = new Timer(INTERVAL, (event) -> {
            tick();
            this.revalidate();
        });
        return timer;
    }

}
