import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;     
import java.awt.event.*;
import java.io.*;


public class Notepad extends JFrame implements ActionListener {
     JTextArea tArea;
     String text;
     
     
     Notepad(){

           Image icon=Toolkit.getDefaultToolkit().getImage("NoteIcon.png");
          setIconImage(icon);
       
          
          setTitle("Notepad");
          JMenuBar menubar=new JMenuBar();
          JMenu File=new JMenu("File");
          menubar.setBackground(Color.WHITE);//set backgeound color
          File.setFont(new Font("AERIAL",Font.PLAIN,16));//set font size

          JMenuItem New=new JMenuItem("New");
          New.addActionListener(this);
          New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));// for the  shortcut keys
          
          JMenuItem Open=new JMenuItem("Open");
          Open.addActionListener(this);
          Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
          
          JMenuItem Save=new JMenuItem("Save");
          Save.addActionListener(this);
          Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
          

          JMenuItem Print=new JMenuItem("Print");
          Print.addActionListener(this);
          Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

          JMenuItem Exit=new JMenuItem("Exit");
          Exit.addActionListener(this);

          File.add(New);
          File.add(Open);
          File.add(Save);
          File.add(Print);
          File.add(Exit);

          menubar.add(File); 
          
          JMenu Edit= new JMenu("Edit");
          Edit.setFont(new Font("AERIAL",Font.PLAIN,16));

          JMenuItem Cut=new JMenuItem("Cut");
          Cut.addActionListener(this);
          Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
          
          JMenuItem Copy=new JMenuItem("Copy");
          Copy.addActionListener(this);
          Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
          
          JMenuItem Paste=new JMenuItem("Paste");
          Paste.addActionListener(this);
          Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
          
          JMenuItem Find=new JMenuItem("Find");
          Find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));

          JMenuItem Goto=new JMenuItem("GoTo");
          Goto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));

          JMenuItem Delete=new JMenuItem("Delete");
          Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));

          Edit.add(Cut);
          Edit.add(Copy);
          Edit.add(Paste);
          Edit.add(Find);
          Edit.add(Goto);
          Edit.add(Delete);

          menubar.add(Edit);

          JMenu Format= new JMenu("Format");
          Format.setFont(new Font("AERIAL",Font.PLAIN,16));

          JMenuItem Word_Wrap=new JMenuItem("Word Wrap");

          JMenuItem Font=new JMenuItem("Font");
          
          menubar.add(Format);
          Format.add(Font);
          Format.add(Word_Wrap);

          
          JMenu View= new JMenu("View");
          View.setFont(new Font("AERIAL",0,16));

          JMenu Zoom=new JMenu("Zoom");//creating menu  for zoom here:
               JMenuItem ZoomOut=new JMenuItem("Zoom Out");
               ZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
               JMenuItem ZoomIn=new JMenuItem("Zoom In");
               ZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
               JMenuItem Restore=new JMenuItem("Restore Default Zoom");
               Restore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));

                    Zoom.add(ZoomOut);
                    Zoom.add(ZoomIn);
                    Zoom.add(Restore);

          JMenuItem Status_Bar=new JMenuItem("Status Bar");
          
          menubar.add(View);
          View.add(Zoom);
          View.add(Status_Bar);


          JMenu Help=new JMenu("Help");
          Help.setFont(new Font("AERIAL",0,16));
          
           
          JMenuItem View_Help=new JMenuItem("View Help");
          JMenuItem Feedback=new JMenuItem("Send Feedback");
          JMenuItem About=new JMenuItem("About Notepad");
          About.addActionListener(this);

          menubar.add(Help);
          Help.add(View_Help);
          Help.add(Feedback);
          Help.add(About);


          tArea=new JTextArea();
          tArea.setFont(new Font("AERIAL",0,26));
          tArea.setLineWrap(true);
          tArea.setWrapStyleWord(true);
          JScrollPane pane=new JScrollPane(tArea);
          pane.setBorder(null);
          add(pane);//add pane  instead of tarea to the frame as you add textarew on scroll bar pane
          setJMenuBar(menubar);
          setExtendedState(MAXIMIZED_BOTH);//frame will be on its maximum automatically
          setVisible(true);//always use at the end of the construtor

          addWindowListener(new WindowAdapter(){
               public void windowClosing(WindowEvent e) {
               
               dispose();

            }
          });
     }
           
            
     
     
     public void actionPerformed(ActionEvent ae){
               if(ae.getActionCommand().equals("New")){
                    tArea.setText(" ");
               }
               else if(ae.getActionCommand().equals("Open")){
                    JFileChooser Choose=new JFileChooser();//to choose a file
                    Choose.setAcceptAllFileFilterUsed(false);//not all files are acepted
                    FileNameExtensionFilter restrict=new FileNameExtensionFilter("Only .txt files","txt");// to allow only text files
                    Choose.addChoosableFileFilter(restrict);//implement  the restrict to choose file
                    int act=Choose.showOpenDialog(this);//open the dialog box
                    if(act!=JFileChooser.APPROVE_OPTION){
                         return;
                    }
                    File  file= Choose.getSelectedFile();
                         try{
                              BufferedReader read=new BufferedReader(new FileReader(file)); 
                              tArea.read(read, null);
                         }catch (Exception e){
                              e.printStackTrace();// If error occur use exception
                         }
                    }
               
               else if(ae.getActionCommand().equals("Save")){
                    JFileChooser Sav=new JFileChooser();
                         Sav.setApproveButtonText("Save");
                         int act=Sav.showOpenDialog(this);//open the dialog box
                         if(act!=JFileChooser.APPROVE_OPTION){
                         return;
                         }
                         File fileSav=new File(Sav.getSelectedFile()+".txt");
                         BufferedWriter FileWrite=null;
                         try {
                             FileWrite= new BufferedWriter(new FileWriter(fileSav));
                             tArea.write(FileWrite);
                         }
                         catch(Exception e){
                              e.printStackTrace();
                         }
                    }

                    else if(ae.getActionCommand().equals("Exit")){
                        System.exit(0);
                    }

               else if(ae.getActionCommand().equals("Print")){
                         try{
                              tArea.print();
                         }
                         catch(Exception e){
                              e.printStackTrace();
                         }
               }
               else if(ae.getActionCommand().equals("Exit")){
                    System.exit(0);
               }
               else if(ae.getActionCommand().equals("Copy")){
                    text=tArea.getSelectedText();

               }
               else if(ae.getActionCommand().equals("Paste")){
                    tArea.insert(text, tArea.getCaretPosition());

               }
               else if(ae.getActionCommand().equals("Cut")){
                    text=tArea.getSelectedText();
                    tArea.replaceRange(" ", tArea.getSelectionStart(), tArea.getSelectionEnd());
                   
               }
               else if(ae.getActionCommand().equals("About")){
                    

               }
               
          }

     
              
     public static void main(String[] args) {
          new Notepad();
     }
}
