package v2.View;

import v2.Controller.Controller;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class New_course implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget main;
    public QLineEdit courseName;
    public QLineEdit courseId;
    public QLabel label;
    public QLabel cid;
    public QLabel label_3;
    public QLabel banner;
    public QComboBox periodBox;
    public QLabel periodLabel;
    public QLineEdit locaField;
    public QDialogButtonBox buttonBox;
    
    public QDialog m;

    public New_course() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(444, 337).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(444, 337));
        Dialog.setMaximumSize(new QSize(444, 337));
        Dialog.setModal(true);
        Dialog.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        Dialog.setWindowTitle("New Course");
        
        main = new QWidget(Dialog);
        main.setObjectName("main");
        main.setGeometry(new QRect(0, 0, 511, 511));
        main.setMinimumSize(new QSize(511, 511));
        main.setMaximumSize(new QSize(511, 511));
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
				"	color: black;\n"+
				"    font: 15pt \"Calibri\";\n"+
				"}");
        
        courseName = new QLineEdit(main);
        courseName.setObjectName("courseName");
        courseName.setGeometry(new QRect(180, 80, 191, 21));
        
        courseId = new QLineEdit(main);
        courseId.setObjectName("courseId");
        courseId.setGeometry(new QRect(180, 130, 191, 21));
        
        label = new QLabel(main);
        label.setObjectName("label");
        label.setGeometry(new QRect(60, 80, 101, 21));
        label.setStyleSheet("");
        
        cid = new QLabel(main);
        cid.setObjectName("cid");
        cid.setGeometry(new QRect(60, 130, 81, 21));
        
        label_3 = new QLabel(main);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(60, 180, 81, 21));
        
        banner = new QLabel(main);
        banner.setObjectName("banner");
        banner.setGeometry(new QRect(70, 10, 211, 51));
        
        periodBox = new QComboBox(main);
        periodBox.setObjectName("periodBox");
        periodBox.setGeometry(new QRect(180, 230, 191, 22));
        
        periodLabel = new QLabel(main);
        periodLabel.setObjectName("periodLabel");
        periodLabel.setGeometry(new QRect(60, 230, 81, 21));
        
        locaField = new QLineEdit(main);
        locaField.setObjectName("locaField");
        locaField.setGeometry(new QRect(180, 180, 191, 21));
        
        buttonBox = new QDialogButtonBox(main);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(30, 270, 281, 61));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Save));
        
        m = Dialog;
        retranslateUi(Dialog);
        buttonBox.accepted.connect(this, "accept()");
        buttonBox.rejected.connect(Dialog, "reject()");

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
    	periodBox.addItem("-");
    	periodBox.addItem("1");
    	periodBox.addItem("2");
    	periodBox.addItem("3");
    	periodBox.addItem("4");
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Course Name:", null));
        cid.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Course ID:", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Location:", null));
        banner.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "                    New Class", null));
        periodLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period:", null));
    } // retranslateUi

    
    public void accept(){
    	
    	label.setStyleSheet("#label{color: black;}");
    	label_3.setStyleSheet("#label_3{color: black;}");
    	cid.setStyleSheet("#cid{color: black;}");
    	periodLabel.setStyleSheet("#periodLabel{color: black;}");
    	
    	boolean check = true;
    	
    	if( this.courseName.text().isEmpty() ){
    		label.setStyleSheet("#label{color: red;}");
    		check = false;
    	}
    	
    	if( this.courseId.text().isEmpty() ){
    		cid.setStyleSheet("#cid{color: red;}");
    		check = false;
    	}
    	
    	if( locaField.text().isEmpty() ){
    		label_3.setStyleSheet("#label_3{color: red;}");
    		check = false;
    	}

    	if( this.periodBox.currentText().equals("-") ){
    		periodLabel.setStyleSheet("#periodLabel{color: red}");
    		check = false;
    	}
    	
    	if( check ){
        	boolean status = Controller.getInstance().createCourse(courseId.text(), courseName.text(), this.periodBox.currentText() ,locaField.text() );
        	QMessageBox t = new QMessageBox();
        	t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        	
        	if(status){
        		t.setText("Course added");
        		t.setWindowTitle("Success");
            	this.m.close();
            	Controller.getInstance().updateClassView();
        		t.exec();
        	}
        	else{
           		t.setText("Course not added. Try changing id");
        		t.setWindowTitle("Failed");
        		t.exec();
        	}
    		Controller.getInstance().work();
    	}
    }
    

}

