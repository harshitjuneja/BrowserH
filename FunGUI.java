/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browserh;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author harshit
 */
public class FunGUI implements ActionListener {
    
    JTextField inpurl;
    JPanel pan;
    JLabel URL;
    JButton go;
    JEditorPane ep;
    String url;
    JScrollPane jsp;
            
    public void actionPerformed(ActionEvent e){
        url = inpurl.getText();
        try {
            getURLcontent(url);
        } catch (Exception ex) {
            Logger.getLogger(FunGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void getURLcontent(String url) throws Exception{
        //String html = "";
        url = "http://"+url;
        URL web = new URL(url);
        //BufferedReader in = new BufferedReader( new InputStreamReader(web.openStream()));
        //while(in.readLine()!= null){
        //    html = html +in.readLine();
        //}
        
        ep.setPage(web);
        //System.out.println(html);
        ep.setEditable(false);
        
    }
    
    
    FunGUI(){
    
        JFrame browfr = new JFrame("BrowserH");
        browfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browfr.setLocationRelativeTo(null);
        
        Container content = browfr.getContentPane();
        content.setLayout(new FlowLayout());
        
        //GridBagConstraints c = new GridBagConstraints();
        
        //c.fill=GridBagConstraints.HORIZONTAL;
        
        inpurl = new JTextField(40);
        inpurl.setHorizontalAlignment(JTextField.LEFT);
        URL = new JLabel("URL");
        
        //c.weightx=0;
        //c.gridx=0;
        //c.gridy=0;       
        
        content.add(URL);
        //c.fill=GridBagConstraints.HORIZONTAL;
        
        content.add(inpurl);
        go = new JButton("GO");
        content.add(go);
        go.addActionListener(this);
        ep = new JEditorPane();
        ep.setContentType("text/html");
        content.add(ep);
        
        
        
        browfr.pack();
        browfr.setVisible(true);
        browfr.setSize(500,500);
        
    }
    
}
