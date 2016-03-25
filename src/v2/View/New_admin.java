package v2.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import v2.Controller.Controller;

public class New_admin implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget main;
    public QLineEdit firstname;
    public QLineEdit lastname;
    public QLineEdit tagid;
    public QLabel fnamelabel;
    public QLabel lnamelabel;
    public QLabel taglabel;
    public QComboBox fpcombo;
    public QLabel label_4;
    public QComboBox spcombo;
    public QComboBox tpcombo;
    public QComboBox fpcombo_2;
    public QLabel p1label;
    public QLabel p2label;
    public QLabel p3label;
    public QLabel p4label;
    public QLabel banner;
    public QDialogButtonBox buttonBox;
    public QLabel adminidlabel;
    public QLineEdit id;
    public QDialog m;
    public QLabel imStat;
    public String filename;
    public QPushButton im;

    public New_admin() { super(); }

    public void setupUi(QDialog Dialog)
    {
    	filename ="";
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(398, 514).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(398, 551));
        Dialog.setMaximumSize(new QSize(398, 551));
        Dialog.setModal(true);
        Dialog.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        
        main = new QWidget(Dialog);
        main.setObjectName("main");
        main.setGeometry(new QRect(0, 0, 398, 551));
        main.setMaximumSize(new QSize(398, 551));
        main.setStyleSheet("#main{\n"+
				"	background-color: rgba(52,52,52,52);\n"+
				"}\n"+
				"\n"+
				"QLabel{\n"+
				"	color: black;\n"+
				"    font: 13pt \"Calibri\";\n"+
				"}\n"+
				"\n"+
				"QLineEdit{\n"+
				"    font: 13pt \"Calibri\";\n"+
				"}\n"+
				"\n"+
				"#banner{\n"+
				"	 font: 15pt \"Calibri\";\n"+
				"}");
        
        firstname = new QLineEdit(main);
        firstname.setObjectName("firstname");
        firstname.setGeometry(new QRect(140, 80, 191, 21));
        
        lastname = new QLineEdit(main);
        lastname.setObjectName("lastname");
        lastname.setGeometry(new QRect(140, 130, 191, 21));
        
        tagid = new QLineEdit(main);
        tagid.setObjectName("tagid");
        tagid.setGeometry(new QRect(140, 230, 191, 21));
        
        fnamelabel = new QLabel(main);
        fnamelabel.setObjectName("fnamelabel");
        fnamelabel.setGeometry(new QRect(40, 80, 81, 21));
        fnamelabel.setStyleSheet("");
        
        lnamelabel = new QLabel(main);
        lnamelabel.setObjectName("lnamelabel");
        lnamelabel.setGeometry(new QRect(40, 130, 81, 21));
        
        taglabel = new QLabel(main);
        taglabel.setObjectName("taglabel");
        taglabel.setGeometry(new QRect(40, 230, 81, 21));
        
        fpcombo = new QComboBox(main);
        fpcombo.setObjectName("fpcombo");
        fpcombo.setGeometry(new QRect(50, 380, 121, 22));
        
        label_4 = new QLabel(main);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(160, 320, 261, 21));
        label_4.setMinimumSize(new QSize(261, 21));
        
        spcombo = new QComboBox(main);
        spcombo.setObjectName("spcombo");
        spcombo.setGeometry(new QRect(220, 380, 121, 22));
        
        tpcombo = new QComboBox(main);
        tpcombo.setObjectName("tpcombo");
        tpcombo.setGeometry(new QRect(50, 450, 121, 22));
        
        fpcombo_2 = new QComboBox(main);
        fpcombo_2.setObjectName("fpcombo_2");
        fpcombo_2.setGeometry(new QRect(220, 450, 121, 22));
        
        p1label = new QLabel(main);
        p1label.setObjectName("p1label");
        p1label.setGeometry(new QRect(50, 360, 81, 20));
        
        p2label = new QLabel(main);
        p2label.setObjectName("p2label");
        p2label.setGeometry(new QRect(220, 360, 81, 20));
        
        p3label = new QLabel(main);
        p3label.setObjectName("p3label");
        p3label.setGeometry(new QRect(50, 430, 81, 20));
        
        p4label = new QLabel(main);
        p4label.setObjectName("p4label");
        p4label.setGeometry(new QRect(220, 430, 81, 20));
        
        banner = new QLabel(main);
        banner.setObjectName("banner");
        banner.setGeometry(new QRect(20, 20, 281, 51));
        
        buttonBox = new QDialogButtonBox(main);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(90, 490, 191, 61));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Save));
        
        adminidlabel = new QLabel(main);
        adminidlabel.setObjectName("adminidlabel");
        adminidlabel.setGeometry(new QRect(40, 180, 81, 21));
        
        id = new QLineEdit(main);
        id.setObjectName("id");
        id.setGeometry(new QRect(140, 180, 191, 21));
        
        im = new QPushButton(main);
        im.setObjectName("im");
        im.setGeometry(new QRect(40, 280, 81, 23));
        
        imStat = new QLabel(main);
        imStat.setObjectName("imStat");
        imStat.setGeometry(new QRect(155, 282, 171, 21) );
        
        retranslateUi(Dialog);
        buttonBox.accepted.connect(this, "check()");
        buttonBox.rejected.connect(Dialog, "reject()");
        
        fpcombo.addItem("-");
        fpcombo.addItem("Spare");
    	Map<String, String> p1 = Controller.getInstance().getPeriods(1);
    	for( String key: p1.keySet() ){		fpcombo.addItem(p1.get(key), key);     	}
    	
    	spcombo.addItem("-");
    	spcombo.addItem("Spare");
    	Map<String, String> p2 = Controller.getInstance().getPeriods(2);
    	for( String key: p2.keySet() ){		spcombo.addItem(p2.get(key), key);     	}
    	
    	tpcombo.addItem("-");
    	tpcombo.addItem("Spare");
    	Map<String, String> p3 = Controller.getInstance().getPeriods(3);
    	for( String key: p3.keySet() ){		tpcombo.addItem(p3.get(key), key);     	}
    	
    	fpcombo_2.addItem("-");
    	fpcombo_2.addItem("Spare");
    	Map<String, String> p4 = Controller.getInstance().getPeriods(4);
    	for( String key: p4.keySet() ){		fpcombo_2.addItem(p4.get(key), key);     	}
        
        Dialog.connectSlotsByName();
        m = Dialog;
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
    	im.clicked.connect(this, "uploadIm()");

        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        fnamelabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "First Name:", null));
        lnamelabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Last Name:", null));
        taglabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tag id:", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Timetable:", null));
        p1label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 1:", null));
        p2label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 2:", null));
        p3label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 3:", null));
        p4label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 4:", null));
        banner.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "                    New Administrator", null));
        adminidlabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Admin id:", null));
        imStat.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "No picture uploaded", null));
        im.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Picture", null));
    } // retranslateUi

    public void uploadIm(){
   	 this.filename = QFileDialog.getOpenFileName(m,"Open Image", "/home", new QFileDialog.Filter("Image Files (*.png *.jpg *.bmp)"));
   	 imStat.setText("Image Uploaded");
    }
    
    public void check(){
    	
		fnamelabel.setStyleSheet("#fnamelabel{color: black;}");
		lnamelabel.setStyleSheet("#lnamelabel{color: black;}");
		taglabel.setStyleSheet("#taglabel{color: black;}");
		p1label.setStyleSheet("#p1label{color: black;}");
		p2label.setStyleSheet("#p2label{color: red;}");
		p3label.setStyleSheet("#p3label{color: black;}");
		p4label.setStyleSheet("#p4label{color: black;}");
		imStat.setStyleSheet("#imStat{color: black;}");
    	    	
		boolean check = true;
		
    	if( firstname.text().isEmpty() ){
    		fnamelabel.setStyleSheet("#fnamelabel{color: red;}");
    		check = false;
    	}
    	
    	if( lastname.text().isEmpty() ){
    		lnamelabel.setStyleSheet("#lnamelabel{color: red;}");
    		check = false;
    	}
    	
    	if( tagid.text().isEmpty() ){
    		taglabel.setStyleSheet("#taglabel{color: red;}");
    		check = false;
    	}
    	
    	if( id.text().isEmpty() ){
    		adminidlabel.setStyleSheet("#adminidlabel{color: red;}");
    		check = false;
    	}
    	
    	if( fpcombo.currentText().equals("-") ){
    		p1label.setStyleSheet("#p1label{color: red;}");
    		check = false;
    	}
    	
    	if( spcombo.currentText().equals("-")){
    		p2label.setStyleSheet("#p2label{color: red;}");
    		check = false;
    	}
    	if( tpcombo.currentText().equals("-")){
    		p3label.setStyleSheet("#p3label{color: red;}");
    		check = false;
    	}
    	
    	if( fpcombo_2.currentText().equals("-") ){
    		p4label.setStyleSheet("#p4label{color: red;}");
    		check = false;
    	}
    	
    	if( this.filename.equals("") ){
    		imStat.setStyleSheet("#imStat{color: red;}");
    		check = false;
    	}
    	
    	if( check ){
    		ArrayList<String> timetable = new ArrayList<String>();
    		timetable.add((String)fpcombo.itemData(fpcombo.currentIndex()) );
    		timetable.add((String)spcombo.itemData(spcombo.currentIndex()));
    		timetable.add((String)tpcombo.itemData(tpcombo.currentIndex()));
    		timetable.add((String)fpcombo_2.itemData(fpcombo_2.currentIndex()));
    		
    		FileInputStream test = null;
    		try {
				test = new FileInputStream(this.filename);
			} catch (FileNotFoundException e) { }
    		
    		boolean add = Controller.getInstance().createAdmin(this.tagid.text(), this.id.text(), this.firstname.text(), this.lastname.text(), timetable, test);   	

    		QMessageBox t = new QMessageBox();
    		t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
    		
    		if(add){
    			t.setText("Admin Added");
    			t.setWindowTitle("Success");
    	    	this.m.close();
    	    	Controller.getInstance().updateAdminView();
    	    	t.exec();
    		}
    		else{
    			t.setText("Admin not added. Try changing tag id");
    			t.setWindowTitle("Fail");
    			t.exec();
    		}
    		Controller.getInstance().work();
    	}
    	
    }
    
}

