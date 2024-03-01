/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javazoom.jl.player.Player;
/**
 *
 * @author sidra
 */



public class Mp3Player extends javax.swing.JFrame {

    
    private Player myplayer;
    private File fileCurrentlyPlaying;
    private ArrayList <File> filePlaylist = new ArrayList();
    private final File playlistPhysicalFile = new File("playlist.txt");
    private static Thread a;
    private static int iterator;
    private static boolean RepeatMode;
    private boolean Browsed;

    private Thread b;
    
    public Mp3Player() {
        initComponents();
        this.ReadPlaylistFile();
        this.DrawPlaylist();
        this.setSize(377, 800);
        this.Browsed = false;
        playingAnimation.setVisible(false);
        if(fileCurrentlyPlaying==null)
        {
            this.playingfile.setText("No file selected!");
        }
        playlist.setFocusable(false);
        playlist.setOpaque(false);
       playlist.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(playlist);
       playlist.getAccessibleContext().setAccessibleName("");
       
        this.Pause.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {
                String value = playlist.getSelectedValue();
                
                if(filePlaylist!=null && !filePlaylist.isEmpty() && !Browsed)
                {
          
                   for(File s : filePlaylist)
                    {
                        if(value!=null)
                        {
                           if(s.getName().compareTo(value)==0)
                           {    
                                fileCurrentlyPlaying = s;
                                
                                
                                
                              
                           }
                        }
                   }
                }

           }
            
        });
        iterator = 0;
        javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a!=null&&RepeatMode&&filePlaylist!=null)
                {
                    if(!Mp3Player.a.isAlive() && !filePlaylist.isEmpty())
                    {
                        a = new Thread ()
                        {
                            public void run()
                            {  
                                try
                                {
                                    FileInputStream buff;
                                    if(filePlaylist.size()-1>=iterator)
                                    {
                                        fileCurrentlyPlaying = filePlaylist.get(iterator);
                                        buff = new FileInputStream(fileCurrentlyPlaying);
                                        iterator++;
                                        playingfile.setText(filePlaylist.get(iterator).getName());
                                    }
                                    else
                                    {
                                        iterator=0;
                                        fileCurrentlyPlaying = filePlaylist.get(iterator);
                                        buff = new FileInputStream(fileCurrentlyPlaying);
                                        playingfile.setText(filePlaylist.get(iterator).getName());
                                    }
                                    if(buff!=null)
                                    {
                                        myplayer = new Player(buff);
                                        if (myplayer != null)
                                        {
                                             myplayer.play();
                                             playingfile.setText("Playing: " + fileCurrentlyPlaying.getName());
                                        }
                                    }
                               }
                                catch(Exception e)
                                {
                                    System.out.printf("Error autoselection: %s\n", e);
                                } 
                            }

                        };
                         a.start();
                    }
                }
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Pause = new javax.swing.JButton();
        Browse = new javax.swing.JButton();
        AddToPlaylist = new javax.swing.JButton();
        NextSong = new javax.swing.JButton();
        playingfile = new javax.swing.JTextField();
        PreviousSong = new javax.swing.JButton();
        RepeatModeon = new javax.swing.JButton();
        Shuffle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        playlist = new javax.swing.JList<>();
        clearplaylist = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        playingAnimation = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java MP3 Player");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1500, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/play.png"))); // NOI18N
        Pause.setText("p");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });
        getContentPane().add(Pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 670, 50, 48));

        Browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });
        getContentPane().add(Browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 10, -1, -1));

        AddToPlaylist.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddToPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        AddToPlaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add (1).png"))); // NOI18N
        AddToPlaylist.setBorder(null);
        AddToPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToPlaylistActionPerformed(evt);
            }
        });
        getContentPane().add(AddToPlaylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 670, 40, 40));

        NextSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        NextSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextSongActionPerformed(evt);
            }
        });
        getContentPane().add(NextSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 670, 40, 50));

        playingfile.setEditable(false);
        playingfile.setBackground(new java.awt.Color(102, 102, 102));
        playingfile.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        playingfile.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playingfile.setToolTipText("");
        playingfile.setAutoscrolls(false);
        playingfile.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        playingfile.setEnabled(false);
        playingfile.setName(""); // NOI18N
        playingfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playingfileActionPerformed(evt);
            }
        });
        getContentPane().add(playingfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 672, 362, 48));

        PreviousSong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        PreviousSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousSongActionPerformed(evt);
            }
        });
        getContentPane().add(PreviousSong, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 670, 46, 48));

        RepeatModeon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/repeat.png"))); // NOI18N
        RepeatModeon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepeatModeonActionPerformed(evt);
            }
        });
        getContentPane().add(RepeatModeon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 670, 45, 48));

        Shuffle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Shuffle.png"))); // NOI18N
        Shuffle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShuffleActionPerformed(evt);
            }
        });
        getContentPane().add(Shuffle, new org.netbeans.lib.awtextra.AbsoluteConstraints(784, 670, 50, 50));

        playlist.setBackground(new java.awt.Color(102, 0, 153));
        playlist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        playlist.setForeground(new java.awt.Color(255, 255, 255));
        playlist.setFocusable(false);
        playlist.setVerifyInputWhenFocusTarget(false);
        playlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playlistMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playlistMouseReleased(evt);
            }
        });
        playlist.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                none(evt);
            }
        });
        jScrollPane2.setViewportView(playlist);
        playlist.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 280, 710));

        clearplaylist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove (1).png"))); // NOI18N
        clearplaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearplaylistActionPerformed(evt);
            }
        });
        getContentPane().add(clearplaylist, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 670, 50, 40));

        jLabel1.setBackground(new java.awt.Color(204, 0, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Playlist");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 186, -1));

        playingAnimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playing1.gif"))); // NOI18N
        getContentPane().add(playingAnimation, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images (4) (1).jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void DrawPlaylist() 
    {
        String[] myString = new String[1000];
        int i=0;
        if( filePlaylist!=null)
        {
            for(File s : filePlaylist)
            {
                if(s!=null)
                {
                    myString[i] = s.getName();
                    i++;
                }
            }
        }
        playlist.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return myString.length; }
            public String getElementAt(int i) { return myString[i]; }
        });

    }
    
  
    
    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
           if(a!=null)
           {
                if(this.Pause.getText().compareTo("P")==0)
                {
                    this.Pause.setText("R");
                    
                     a.suspend();
                     playingAnimation.setVisible(false);
                     if(fileCurrentlyPlaying!=null)
                     {
                        this.playingfile.setText("Paused on: " + fileCurrentlyPlaying.getName());
                     }
                }
                else
                {
                    this.Pause.setText("P");
                    this.playingfile.setText("Playing: " + fileCurrentlyPlaying.getName());
                    a.resume();
                    playingAnimation.setVisible(true);
                }
           }
    }//GEN-LAST:event_PauseActionPerformed

    
    
    
    private void PlaySongFile()
    {
       
        if(a!=null)
        {
            if(a.isAlive())
            {
                a.stop();
            }
        }
       a = new Thread ()
       {
           public void run()
           {  
               try
               {   
                   if(fileCurrentlyPlaying!=null)
                   {
                       FileInputStream buff = new FileInputStream(fileCurrentlyPlaying);
                       myplayer = new Player(buff);
                       if (myplayer != null)
                       {
                           playingfile.setText("Playing: " + fileCurrentlyPlaying.getName());
                           myplayer.play();
                           Browsed = false;
                       }
                   }
              }
               catch(Exception e)
               {
                   System.out.printf("Error Playing File: %s\n", e);
               } 
           }

       };
   
       a.start();
    }    private void ReadPlaylistFile()
    {
        if(filePlaylist!=null)
        {
            filePlaylist.clear();
            try{
               FileInputStream fi = new FileInputStream(playlistPhysicalFile);
               ObjectInputStream oi = new ObjectInputStream(fi);
               while(true) //this loop will terminate when the catch block will terminate, and the catch block will
                   //terminate then EOFException will be thrown.
               {
                   filePlaylist = (ArrayList) oi.readObject();
                     //this will read until the file ends. 
                  //When it cannot read any more object from the file it will throw an EOFException that needs
                 //to be catched, and handled, otherwise the program will terminate.

               }
           }
           catch(EOFException b) { }
           catch(IOException e) { }
           catch (ClassNotFoundException e) {}
            
        }
    }
    
  
    
    
    private void WritePlaylistFile()
    {
        if(filePlaylist!=null)
        {
            try{
                FileOutputStream fs = new FileOutputStream(playlistPhysicalFile);
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(filePlaylist);
                os.close();
                fs.close();
            }
            catch(FileNotFoundException e)
            {
                System.out.printf("FileNotFoundException: %s\n", e);
            }
            catch(IOException e)
            {
                System.out.printf("IOException: %s\n", e);
            }
        }
    }
    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser("C:\\Users\\sidra\\Downloads\\Video\\audio");
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          fileCurrentlyPlaying = fileChooser.getSelectedFile();
          this.playingfile.setText("Selected: " + fileCurrentlyPlaying.getName());
          this.Browsed = true;
          this.PlaySongFile();
          playingAnimation.setVisible(true);
           
          // load from file
        }
        this.Browsed=false;
       
    }//GEN-LAST:event_BrowseActionPerformed

    private void AddToPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToPlaylistActionPerformed

        boolean GoFurther = true;
        this.ReadPlaylistFile(); //refresh the playlist.
        if(fileCurrentlyPlaying!=null)
        {
            if(filePlaylist==null)
            {
                filePlaylist = new ArrayList();
            }
            if(!filePlaylist.isEmpty())
            {
               for(File s : filePlaylist)
               {
                   if(s.compareTo(fileCurrentlyPlaying)==0)
                   {
                       GoFurther = false;
                       break;
                   }
               }
            }
            if(GoFurther)
                {
                    filePlaylist.add(fileCurrentlyPlaying);
                    this.WritePlaylistFile();
                    this.DrawPlaylist();
                }
                else
                {
                    System.out.printf("File: %s is already in the playlist.\n", fileCurrentlyPlaying.getName());
                }
        }
        else
        {
            System.out.printf("Please, select a file first!\n");
        }
    }//GEN-LAST:event_AddToPlaylistActionPerformed

    private void NextSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextSongActionPerformed
        if(fileCurrentlyPlaying!=null && !filePlaylist.isEmpty())
        {
            boolean selectionDone = false;
            for(File s: filePlaylist)
            {
                if(s.compareTo(fileCurrentlyPlaying)==0)
                {
                    int futureIndex = filePlaylist.indexOf(s);
                    if(futureIndex<filePlaylist.size()-1)
                    {
                        fileCurrentlyPlaying = filePlaylist.get(futureIndex+1);
                    }
                    else
                    {
                        fileCurrentlyPlaying = filePlaylist.get(0);
                    }
                    selectionDone = true;
                    break;
                }
            }
            if(!selectionDone)
            {
                fileCurrentlyPlaying = filePlaylist.get(0);
            }
        }
        if(a!=null && fileCurrentlyPlaying!=null)
        {
            this.PlaySongFile();
        }
    }//GEN-LAST:event_NextSongActionPerformed

    private void playingfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playingfileActionPerformed

    }//GEN-LAST:event_playingfileActionPerformed

    
    
    
    
    private void PreviousSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousSongActionPerformed

        if(fileCurrentlyPlaying!=null && !filePlaylist.isEmpty())
        {
            boolean selectionDone = false;
            for(File s: filePlaylist)
            {
                if(s.compareTo(fileCurrentlyPlaying)==0)
                {
                    int futureIndex = filePlaylist.indexOf(s)-1;
                    if(futureIndex<0)
                    {
                        int index = filePlaylist.size()-1;
                        fileCurrentlyPlaying = filePlaylist.get(index);
                    }
                    else if(futureIndex<filePlaylist.size()-1)
                    {
                        int index = futureIndex;
                        fileCurrentlyPlaying = filePlaylist.get(futureIndex);
                    }
                    selectionDone = true;
                    break;
                }
            }
            if(!selectionDone)
            {
                fileCurrentlyPlaying = filePlaylist.get(0);
            }
        }
        if(a!=null && fileCurrentlyPlaying!=null)
        {
            this.PlaySongFile();
        }
    }//GEN-LAST:event_PreviousSongActionPerformed

    private void RepeatModeonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepeatModeonActionPerformed
        if(this.RepeatModeon.getText().compareTo("Repeat Mode is ON!")==0)
        {
            this.RepeatModeon.setText("Repeat Mode is OFF!");
            Mp3Player.RepeatMode = false;
        }
        else
        {
            this.RepeatModeon.setText("Repeat Mode is ON!");
            Mp3Player.RepeatMode = true;
        }
    }//GEN-LAST:event_RepeatModeonActionPerformed

    private void ShuffleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShuffleActionPerformed
        if(filePlaylist!=null)
        {
            Random rnd = new Random();
            if(filePlaylist.size()>2)
            {
                int choice = rnd.nextInt(filePlaylist.size());
                fileCurrentlyPlaying = filePlaylist.get(choice);
                this.PlaySongFile();
            }
            else
            {
                System.out.printf("You cannot shuffle a playlist with less than 3 songs.\n");
            }
        }
    }//GEN-LAST:event_ShuffleActionPerformed

    private void clearplaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearplaylistActionPerformed
        if(filePlaylist!=null)
        {
            filePlaylist.clear();
            this.WritePlaylistFile();
            this.DrawPlaylist();
        }
    }//GEN-LAST:event_clearplaylistActionPerformed

    
    
    
    private void playlistMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistMouseReleased
        // TODO add your handling code here:
     
                String value = playlist.getSelectedValue();
                if(filePlaylist!=null && !filePlaylist.isEmpty() && !Browsed)
                {
                   for(File s : filePlaylist)
                    {
                        if(value!=null)
                        {
                           if(s.getName().compareTo(value)==0)
                           {    
                                fileCurrentlyPlaying = s;
                                if(fileCurrentlyPlaying!=null)
                                {
                                    
                                     PlaySongFile();
                                     playingAnimation.setVisible(true);
                                   break;
                                }
                           }
                        }
                   }
                
    }
       
    }//GEN-LAST:event_playlistMouseReleased

    private void none(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_none

    }//GEN-LAST:event_none

    private void playlistMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playlistMousePressed
     
    }//GEN-LAST:event_playlistMousePressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mp3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mp3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mp3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mp3Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mp3Player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToPlaylist;
    private javax.swing.JButton Browse;
    private javax.swing.JButton NextSong;
    private javax.swing.JButton Pause;
    private javax.swing.JButton PreviousSong;
    private javax.swing.JButton RepeatModeon;
    private javax.swing.JButton Shuffle;
    private javax.swing.JButton clearplaylist;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel playingAnimation;
    private javax.swing.JTextField playingfile;
    private javax.swing.JList<String> playlist;
    // End of variables declaration//GEN-END:variables
}
