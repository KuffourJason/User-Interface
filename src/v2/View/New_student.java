package v2.View;
/********************************************************************************
 ** Form generated from reading ui file 'StuDialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import java.util.ArrayList;
import java.util.Map;

import v2.Controller.Controller;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class New_student implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget main;
    public QLineEdit namefedit;
    public QLineEdit nameledit;
    public QLineEdit tagidedit;
    public QLabel fnameLabel;
    public QLabel lnameLabel;
    public QLabel tagLabel;
    public QComboBox fpcombo;
    public QLabel timeLabel;
    public QComboBox spcombo;
    public QComboBox tpcombo;
    public QComboBox fopcombo;
    public QLabel p1Label;
    public QLabel p2Label;
    public QLabel p3Label;
    public QLabel p4Label;
    public QLabel banner;
    public QLabel idLabel;
    public QLineEdit stuidedit;
    public QDialogButtonBox buttonBox;
    public QDialog m;

    public New_student() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(398, 514).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(0, 507));
        Dialog.setMaximumSize(new QSize(497, 600));
        Dialog.setModal(true);
        Dialog.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        main = new QWidget(Dialog);
        main.setObjectName("main");
        main.setGeometry(new QRect(0, 0, 511, 551));
        main.setMinimumSize(new QSize(511, 551));
        main.setMaximumSize(new QSize(511, 551));
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
        namefedit = new QLineEdit(main);
        namefedit.setObjectName("namefedit");
        namefedit.setGeometry(new QRect(140, 80, 191, 21));
        nameledit = new QLineEdit(main);
        nameledit.setObjectName("nameledit");
        nameledit.setGeometry(new QRect(140, 130, 191, 21));
        tagidedit = new QLineEdit(main);
        tagidedit.setObjectName("tagidedit");
        tagidedit.setGeometry(new QRect(140, 180, 191, 21));
        fnameLabel = new QLabel(main);
        fnameLabel.setObjectName("fnameLabel");
        fnameLabel.setGeometry(new QRect(40, 80, 81, 21));
        fnameLabel.setStyleSheet("");
        lnameLabel = new QLabel(main);
        lnameLabel.setObjectName("lnameLabel");
        lnameLabel.setGeometry(new QRect(40, 130, 81, 21));
        tagLabel = new QLabel(main);
        tagLabel.setObjectName("tagLabel");
        tagLabel.setGeometry(new QRect(40, 180, 81, 21));
        fpcombo = new QComboBox(main);
        fpcombo.setObjectName("fpcombo");
        fpcombo.setGeometry(new QRect(50, 340, 121, 22));
        timeLabel = new QLabel(main);
        timeLabel.setObjectName("timeLabel");
        timeLabel.setGeometry(new QRect(160, 280, 171, 21));
        spcombo = new QComboBox(main);
        spcombo.setObjectName("spcombo");
        spcombo.setGeometry(new QRect(220, 340, 121, 22));
        tpcombo = new QComboBox(main);
        tpcombo.setObjectName("tpcombo");
        tpcombo.setGeometry(new QRect(50, 410, 121, 22));
        fopcombo = new QComboBox(main);
        fopcombo.setObjectName("fopcombo");
        fopcombo.setGeometry(new QRect(220, 410, 121, 22));
        p1Label = new QLabel(main);
        p1Label.setObjectName("p1Label");
        p1Label.setGeometry(new QRect(50, 320, 81, 20));
        p2Label = new QLabel(main);
        p2Label.setObjectName("p2Label");
        p2Label.setGeometry(new QRect(220, 320, 81, 20));
        p3Label = new QLabel(main);
        p3Label.setObjectName("p3Label");
        p3Label.setGeometry(new QRect(50, 390, 81, 21));
        p4Label = new QLabel(main);
        p4Label.setObjectName("p4Label");
        p4Label.setGeometry(new QRect(220, 390, 81, 20));
        banner = new QLabel(main);
        banner.setObjectName("banner");
        banner.setGeometry(new QRect(50, 20, 241, 51));
        idLabel = new QLabel(main);
        idLabel.setObjectName("idLabel");
        idLabel.setGeometry(new QRect(40, 230, 81, 21));
        stuidedit = new QLineEdit(main);
        stuidedit.setObjectName("stuidedit");
        stuidedit.setGeometry(new QRect(140, 230, 191, 21));
        buttonBox = new QDialogButtonBox(main);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(30, 450, 251, 61));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Save));
        retranslateUi(Dialog);
        
        m = Dialog;
        
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
    	
    	fopcombo.addItem("-");
    	fopcombo.addItem("Spare");
    	Map<String, String> p4 = Controller.getInstance().getPeriods(4);
    	for( String key: p4.keySet() ){		fopcombo.addItem(p4.get(key), key);     	}
        
        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
    	
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        fnameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "First Name:", null));
        lnameLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Last Name:", null));
        tagLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tag ID:", null));
        timeLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Timetable:", null));
        p1Label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 1:", null));
        p2Label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 2:", null));
        p3Label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 3:", null));
        p4Label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period 4:", null));
        banner.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "                    New Student", null));
        idLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Student id:", null));
    } // retranslateUi

    
    
 public void check(){
    	
		p3Label.setStyleSheet("#label_7{color: black;}");
		lnameLabel.setStyleSheet("#label_2{color: black;}");
		tagLabel.setStyleSheet("#label_3{color: black;}");
		p1Label.setStyleSheet("#p1Label{color: black;}");
		p2Label.setStyleSheet("#label_6{color: black;}");
		fnameLabel.setStyleSheet("#fnameLabel{color: black;}");
		idLabel.setStyleSheet("#idLabel{color: black;}");
		p4Label.setStyleSheet("#p4Label{color: black;}");
		
		boolean check = true;

    	    	
    	if( namefedit.text().isEmpty() ){
    		this.fnameLabel.setStyleSheet("#fnameLabel{color: red;}");
    		check = false;
    	}
    	
    	if( nameledit.text().isEmpty() ){
    		lnameLabel.setStyleSheet("#lnameLabel{color: red;}");
    		check = false;
    	}
    	
    	
    	if( this.tagidedit.text().isEmpty() ){
    		this.tagLabel.setStyleSheet("#tagLabel{color: red;}");
    		check = false;
    	}
    	
    	
    	if( this.stuidedit.text().isEmpty() ){
    		this.idLabel.setStyleSheet("#idLabel{color: red;}");
    		check = false;
    	}
    	
    	if( this.fpcombo.currentText().equals("-") ){
    		this.p1Label.setStyleSheet("#p1Label{color: red;}");
    		check = false;
    	}
    
    	if( spcombo.currentText().equals("-")){
    		p2Label.setStyleSheet("#p2Label{color: red;}");
    		check = false;
    	}
    	if( tpcombo.currentText().equals("-")){
    		p3Label.setStyleSheet("#p3Label{color: red;}");
    		check = false;
    	}
    	
    	if( this.fopcombo.currentText().equals("-") ){
    		p4Label.setStyleSheet("#p4Label{color: red;}");
    		check = false;
    	}
    	
    	if( check ){
    		ArrayList<String> timetable = new ArrayList<String>();
    		timetable.add((String)fpcombo.itemData(fpcombo.currentIndex()) );
    		timetable.add((String)spcombo.itemData(spcombo.currentIndex()));
    		timetable.add((String)tpcombo.itemData(tpcombo.currentIndex()));
    		timetable.add((String)fopcombo.itemData(fopcombo.currentIndex()));
    		boolean add = Controller.getInstance().createStudent(this.tagidedit.text(),this.stuidedit.text(), this.namefedit.text(), this.nameledit.text(), timetable);
    		
    		QMessageBox t = new QMessageBox();
    		t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
    		
    		if(add){
    			t.setText("Student Added");
    			t.setWindowTitle("Success");
    	    	this.m.close();
    	    	Controller.getInstance().updateStudentView();
    	    	t.exec();
    		}
    		else{
    			t.setText("Student not added. Change tag id");
    			t.setWindowTitle("Fail");
    			t.exec();
    		}
    		
    		Controller.getInstance().work();
    	}    	
    }
    
}

