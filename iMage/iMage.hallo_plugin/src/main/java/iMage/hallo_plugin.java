package iMage;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.iMage.plugins.JmjrstPlugin;
import org.jis.Main;
import org.kohsuke.MetaInfServices;

@MetaInfServices
public class hallo_plugin extends JmjrstPlugin {
    @Override
    public String getMenuText() {
        return null;
    }

    @Override
    public String getName() {
        return "hallo_plugin";
    }

    @Override
    public void init(Main main) {
    	System.out.println("Ich initialisiere mich fleißig!");
    }

    @Override
    public void run() {
    	System.out.println("iMage - nur echt mit JMJRST!");
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public void configure() {
    	JFrame pluginFrame = new JFrame(getName());
    	pluginFrame.setSize(100, 100);
    	pluginFrame.setVisible(true);
    	pluginFrame.setLocationRelativeTo(null);
    	JLabel pluginName = new JLabel(getName(), JLabel.CENTER);
    }
}
    
