package view;

import view.TablePanel.BookPage;
import view.TablePanel.DashboardPage;
import view.TablePanel.ReaderPage;
import view.TablePanel.RentingRecordPage;
import view.other.Dashboard.Dashboard;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private static ContentPanel contentPanel;

    public MainPanel(String username, String role) {
        Dashboard dashboard = new Dashboard(username, role);
        JPanel dashboardPanel = new JPanel(new BorderLayout());
        dashboardPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        dashboardPanel.add(dashboard, BorderLayout.CENTER);
        contentPanel = new ContentPanel();

        // Add dashboard and content panellll
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        add(dashboardPanel, BorderLayout.WEST);
    }

    public static void toPage(String pageName) {
        // Check the current opened item
        if (! (Dashboard.getCurrentItem().getButtonName().equals(pageName))) {
            contentPanel.getCardLayout().show(contentPanel, pageName);
        }
    }

    private static class ContentPanel extends JPanel {
        private final CardLayout cardLayout;

        public ContentPanel() {
            cardLayout = new CardLayout();
            setLayout(cardLayout);
            cardLayout.show(this, "Book Page");     // default page

            // Pages must have the same name as the associated buttons
            DashboardPage dashboardPage = new DashboardPage();
            add(dashboardPage, "Dashboard");
            BookPage bookPage = new BookPage();
            add(bookPage, "Books");
            ReaderPage readerPage = new ReaderPage();
            add(readerPage, "Readers");
            RentingRecordPage rentingRecordPage = new RentingRecordPage();
            add(rentingRecordPage, "Rents");
        }

        public CardLayout getCardLayout() {
            return cardLayout;
        }
    }


}
