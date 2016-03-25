package v2.View;

import java.util.Map;

import v2.Controller.Controller;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Settings implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QWidget widget;
    public QTimeEdit startEdit;
    public QTimeEdit endEdit;
    public QTimeEdit lunchStartEdit;
    public QTimeEdit lunchEndEdit;
    public QLabel startLabel;
    public QLabel endLabel;
    public QLabel lustartLabel;
    public QLabel lunEndLabel;
    public QLabel title;
    public QLabel fpl;
    public QTimeEdit secondtime;
    public QTimeEdit firstTime;
    public QLabel spl;
    public QTimeEdit fourthtime;
    public QTimeEdit thirdtime;
    public QLabel tpl;
    public QLabel fopl;
    
    private QDialog dialog;

    public Settings() { super(); }

    public void setupUi(QDialog Dialog)
    {	
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(488, 527).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(488, 527));
        Dialog.setMaximumSize(new QSize(488, 527));
        Dialog.setWindowTitle("Configuration Settings");
        Dialog.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        Dialog.setWindowFlags( Qt.WindowType.WindowContextHelpButtonHint );
        Dialog.setModal(true);
        
        buttonBox = new QDialogButtonBox(Dialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(0, 460, 341, 32));
        buttonBox.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Cancel,com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Save));
        buttonBox.setCenterButtons(false);
       
        widget = new QWidget(Dialog);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(-21, -10, 611, 641));
        widget.setMinimumSize(new QSize(611, 641));
        widget.setMaximumSize(new QSize(611, 641));
        widget.setStyleSheet("QLabel{\n"+
				"	font: 13pt \"Calibri\";\n"+
				"    color: black;\n"+
				"}\n"+
				"\n"+
				"QTimeEdit{\n"+
				"	font: 11pt \"Calibri\";\n"+
				"    color: black;\n"+
				"}\n"+
				"\n"+
				"QSpinBox{\n"+
				"	font: 11pt \"Calibri\";\n"+
				"    color: black;\n"+
				"}\n"+
				"\n"+
				"#title{\n"+
				"	font: 15pt \"Calibri\";\n"+
				"    color: black;\n"+
				"}\n"+
				"\n"+
				"#fpl, #spl, #tpl, #fopl{\n"+
				"	color: red;\n"+
				"}\n"+
				"\n"+
				"#widget{\n"+
				"	background-color: rgba(52,52,52,10);\n"+
				"}");
        
        startEdit = new QTimeEdit(widget);
        startEdit.setObjectName("startEdit");
        startEdit.setGeometry(new QRect(110, 130, 131, 31));
        startEdit.setMaximumTime(new QTime(18, 59));
        startEdit.setMinimumTime(new QTime(7, 0));
        
        endEdit = new QTimeEdit(widget);
        endEdit.setObjectName("endEdit");
        endEdit.setGeometry(new QRect(300, 130, 121, 31));
        endEdit.setMaximumTime(new QTime(18, 59));
        endEdit.setMinimumTime(new QTime(7, 0));
        
        lunchStartEdit = new QTimeEdit(widget);
        lunchStartEdit.setObjectName("lunchStartEdit");
        lunchStartEdit.setGeometry(new QRect(110, 300, 121, 31));
        lunchStartEdit.setMaximumTime(new QTime(19, 59));
        lunchStartEdit.setMinimumTime(new QTime(7, 0));
        lunchEndEdit = new QTimeEdit(widget);
        lunchEndEdit.setObjectName("lunchEndEdit");
        lunchEndEdit.setGeometry(new QRect(300, 300, 121, 31));
        lunchEndEdit.setMaximumTime(new QTime(18, 59));
        lunchEndEdit.setMinimumTime(new QTime(7, 0));
        
        startLabel = new QLabel(widget);
        startLabel.setObjectName("startLabel");
        startLabel.setGeometry(new QRect(110, 100, 131, 31));
        
        endLabel = new QLabel(widget);
        endLabel.setObjectName("endLabel");
        endLabel.setGeometry(new QRect(300, 100, 131, 31));
        
        lustartLabel = new QLabel(widget);
        lustartLabel.setObjectName("lustartLabel");
        lustartLabel.setGeometry(new QRect(110, 270, 121, 31));
        
        lunEndLabel = new QLabel(widget);
        lunEndLabel.setObjectName("lunEndLabel");
        lunEndLabel.setGeometry(new QRect(300, 270, 121, 31));
        
        title = new QLabel(widget);
        title.setObjectName("title");
        title.setGeometry(new QRect(170, 10, 231, 81));
        
        fpl = new QLabel(widget);
        fpl.setObjectName("fpl");
        fpl.setGeometry(new QRect(110, 180, 131, 31));
        
        secondtime = new QTimeEdit(widget);
        secondtime.setObjectName("secondtime");
        secondtime.setGeometry(new QRect(300, 210, 121, 31));
        secondtime.setMaximumTime(new QTime(17, 59));
        secondtime.setMinimumTime(new QTime(6, 0));
        
        firstTime = new QTimeEdit(widget);
        firstTime.setObjectName("firstTime");
        firstTime.setGeometry(new QRect(110, 210, 121, 31));
        firstTime.setMaximumTime(new QTime(17, 59));
        firstTime.setMinimumTime(new QTime(6, 0));
        
        spl = new QLabel(widget);
        spl.setObjectName("spl");
        spl.setGeometry(new QRect(300, 180, 121, 31));
        
        fourthtime = new QTimeEdit(widget);
        fourthtime.setObjectName("fourthtime");
        fourthtime.setGeometry(new QRect(300, 390, 121, 31));
        fourthtime.setMaximumTime(new QTime(17, 59));
        fourthtime.setMinimumTime(new QTime(6, 0));
        
        thirdtime = new QTimeEdit(widget);
        thirdtime.setObjectName("thirdtime");
        thirdtime.setGeometry(new QRect(110, 390, 121, 31));
        thirdtime.setMaximumTime(new QTime(17, 59));
        thirdtime.setMinimumTime(new QTime(6, 0));
        
        tpl = new QLabel(widget);
        tpl.setObjectName("tpl");
        tpl.setGeometry(new QRect(110, 360, 121, 31));
        fopl = new QLabel(widget);
        fopl.setObjectName("fopl");
        fopl.setGeometry(new QRect(300, 360, 111, 31));
        retranslateUi(Dialog);
        buttonBox.accepted.connect(this, "accept()");
        buttonBox.rejected.connect(Dialog, "reject()");

        dialog = Dialog;
        Dialog.connectSlotsByName();
    } // setupUi
    
    public void accept(){
		QMessageBox t = new QMessageBox();
		t.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
    	
    	if( firstTime.time().compareTo(secondtime.time() ) == 1 || firstTime.time().compareTo(secondtime.time() ) == 0){	//period 1 starts after 2
    		t.setText("Check periods 1 and 2");
    		t.setWindowTitle("Error");
    		t.exec();
    	}
    	else if( secondtime.time().compareTo(lunchStartEdit.time() ) == 1 || secondtime.time().compareTo(lunchStartEdit.time() ) == 0 ){ //period 2 starts after lunch
    		t.setText("Check periods 2 and lunch start");
    		t.setWindowTitle("Error");
    		t.exec();
    	}
    	else if( thirdtime.time().compareTo(fourthtime.time() ) == 1 || thirdtime.time().compareTo(fourthtime.time() ) == 0){ //period 3 starts after 4
    		t.setText("Check periods 3 and 4");
    		t.setWindowTitle("Error");
    		t.exec();
    	}
    	else if( fourthtime.time().compareTo(endEdit.time()) == 1 || fourthtime.time().compareTo(endEdit.time()) == 0) { //period 4 starts after school closing
    		t.setText("Check period 4 and school end time");
    		t.setWindowTitle("Error");
    		t.exec();
    	}
    	else{
    		//calculates the 24 hour format time of the entered times by checking whether it is PM or AM and adding 12 accordingly
    		
    		//splits entered time in the form 4:44 AM by :
    		String[] p1 = firstTime.text().split(":");
    		String[] p2 = secondtime.text().split(":");
    		String[] p3 = thirdtime.text().split(":");
    		String[] p4 = fourthtime.text().split(":");
    		String[] lu = lunchStartEdit.text().split(":");
    		String[] en = endEdit.text().split(":");
    		
    		//splits 44 AM by space
    		String[] p11 = p1[1].split(" ");
    		String[] p21 = p2[1].split(" ");
    		String[] p31 = p3[1].split(" ");
    		String[] p41 = p4[1].split(" ");
    		String[] lu1 = lu[1].split(" ");
    		String[] en1 = en[1].split(" ");
    		
    		String p_1 = p11[1].equals("AM")      ? p1[0] : String.valueOf( Integer.valueOf(p1[0]) + 12 );
    		String p_2 = p21[1].equals("AM")      ? p2[0] : String.valueOf( Integer.valueOf(p2[0]) + 12 );
    		String p_3 = p31[1].equals("AM")      ? p3[0] : String.valueOf( Integer.valueOf(p3[0]) + 12 );
    		String p_4 = p41[1].equals("AM")      ? p4[0] : String.valueOf( Integer.valueOf(p4[0]) + 12 );
    		String l_u = lu1[1].equals("AM")      ? lu[0] : String.valueOf( Integer.valueOf(lu[0]) + 12 );
    		String e_n = en1[1].equals("AM")      ? en[0] : String.valueOf( Integer.valueOf(en[0]) + 12 );

    		Controller.getInstance().updateConfig(e_n + ":" + en1[0], p_1+":"+p11[0] , p_1+":"+p11[0] , p_2+":"+p21[0], l_u+":"+lu1[0], p_3+":"+p31[0], p_4+":"+p41[0]);
    		t.setWindowTitle("Success");
    		t.setText("Config file updated");
    		t.exec();
    		Controller.getInstance().work();
    		this.dialog.close();
    	}
    }

    //updates all periods when school start is changed
    public void updateFirst(){
    	firstTime.setTime(startEdit.time());
    	secondtime.setTime(startEdit.time());
    	thirdtime.setTime(startEdit.time());
    	fourthtime.setTime(startEdit.time());
    }
    
    //updates the start time when first period is changed
    public void updateStart(){
    	startEdit.setTime(firstTime.time());
    }
    
    //updates the 3 and 4th period when lunch end is changed
    public void updateThird(){
    	thirdtime.setTime(lunchEndEdit.time());
    	fourthtime.setTime(thirdtime.time());
    }
    
    //updates the 3rd period when lunch is changed
    public void updateLunchEnd(){
    	lunchEndEdit.setTime(thirdtime.time());
    }
    
    //updates 3rd and 4th when lunch end is changed
    public void SecondUpdateAll(){
    	thirdtime.setTime(secondtime.time());
    	fourthtime.setTime(secondtime.time());
    	lunchStartEdit.setTime(secondtime.time());
    }
    
    void retranslateUi(QDialog Dialog)
    {
    	startEdit.timeChanged.connect(this, "updateFirst()");
    	firstTime.timeChanged.connect(this, "updateStart()");
    	lunchEndEdit.timeChanged.connect(this, "updateThird()");
    	thirdtime.timeChanged.connect(this, "updateLunchEnd()");
    	secondtime.timeChanged.connect(this, "SecondUpdateAll()");
    	
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        buttonBox.raise();
        startEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        endEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        lunchStartEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        lunchEndEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        firstTime.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        secondtime.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        thirdtime.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        fourthtime.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        startLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "School Start time:", null));
        endLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "School End time:", null));
        lustartLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Lunch Start:", null));
        lunEndLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Lunch End:", null));
        title.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Configuration Settings", null));
        fpl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "First Period:", null));
        spl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Second Period:", null));
        tpl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Third Period:", null));
        fopl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fourth Period:", null));
        
        Map<String, String> da = Controller.getInstance().getConfigInfo();
        
        startEdit.setTime(QTime.fromString(da.get("first"), "hh:mm"));
        firstTime.setTime(QTime.fromString(da.get("first"), "hh:mm"));
        secondtime.setTime(QTime.fromString(da.get("second"), "hh:mm"));
        thirdtime.setTime(QTime.fromString(da.get("third"), "hh:mm"));
        fourthtime.setTime(QTime.fromString(da.get("fourth"), "hh:mm"));
        endEdit.setTime(QTime.fromString(da.get("end"), "hh:mm"));
        lunchEndEdit.setTime(QTime.fromString(da.get("third"), "hh:mm"));
        lunchStartEdit.setTime(QTime.fromString(da.get("lunch_start"), "hh:mm"));
        
    } // retranslateUi

}

