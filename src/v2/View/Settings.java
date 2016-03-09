package v2.View;

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
    public QLabel durLabel;
    public QLabel graceLabel;
    public QLabel lustartLabel;
    public QLabel lunEndLabel;
    public QSpinBox durEdit;
    public QSpinBox graceEdit;
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
        Dialog.resize(new QSize(488, 610).expandedTo(Dialog.minimumSizeHint()));
        Dialog.setMinimumSize(new QSize(488, 610));
        Dialog.setMaximumSize(new QSize(488, 610));
        Dialog.setWindowTitle("Configuration Settings");
        Dialog.setWindowIcon(new QIcon(new QPixmap("classpath:admin_resource/eot_icon.png")));
        Dialog.setWindowFlags( Qt.WindowType.WindowContextHelpButtonHint );
        Dialog.setModal(true);
        
        buttonBox = new QDialogButtonBox(Dialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(0, 560, 341, 32));
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
        startEdit.setMaximumTime(new QTime(18, 59, 59));
        startEdit.setMinimumTime(new QTime(7, 0, 0));
        
        endEdit = new QTimeEdit(widget);
        endEdit.setObjectName("endEdit");
        endEdit.setGeometry(new QRect(300, 130, 121, 31));
        endEdit.setMaximumTime(new QTime(18, 59, 59));
        endEdit.setMinimumTime(new QTime(7, 0, 0));
        
        lunchStartEdit = new QTimeEdit(widget);
        lunchStartEdit.setObjectName("lunchStartEdit");
        lunchStartEdit.setGeometry(new QRect(110, 490, 121, 31));
        lunchStartEdit.setMaximumTime(new QTime(19, 59, 59));
        lunchStartEdit.setMinimumTime(new QTime(7, 0, 0));
        lunchEndEdit = new QTimeEdit(widget);
        lunchEndEdit.setObjectName("lunchEndEdit");
        lunchEndEdit.setGeometry(new QRect(300, 490, 121, 31));
        lunchEndEdit.setMaximumTime(new QTime(18, 59, 59));
        lunchEndEdit.setMinimumTime(new QTime(7, 0, 0));
        
        startLabel = new QLabel(widget);
        startLabel.setObjectName("startLabel");
        startLabel.setGeometry(new QRect(110, 100, 131, 31));
        
        endLabel = new QLabel(widget);
        endLabel.setObjectName("endLabel");
        endLabel.setGeometry(new QRect(300, 100, 131, 31));
        
        durLabel = new QLabel(widget);
        durLabel.setObjectName("durLabel");
        durLabel.setGeometry(new QRect(110, 190, 131, 31));
        
        graceLabel = new QLabel(widget);
        graceLabel.setObjectName("graceLabel");
        graceLabel.setGeometry(new QRect(300, 190, 121, 31));
        
        lustartLabel = new QLabel(widget);
        lustartLabel.setObjectName("lustartLabel");
        lustartLabel.setGeometry(new QRect(110, 460, 121, 31));
        
        lunEndLabel = new QLabel(widget);
        lunEndLabel.setObjectName("lunEndLabel");
        lunEndLabel.setGeometry(new QRect(300, 460, 111, 31));
        
        durEdit = new QSpinBox(widget);
        durEdit.setObjectName("durEdit");
        durEdit.setGeometry(new QRect(110, 220, 121, 31));
        durEdit.setMinimum(1);
        durEdit.setMaximum(120);
        
        graceEdit = new QSpinBox(widget);
        graceEdit.setObjectName("graceEdit");
        graceEdit.setGeometry(new QRect(300, 220, 121, 31));
        graceEdit.setMinimum(1);
        graceEdit.setMaximum(10);
        
        title = new QLabel(widget);
        title.setObjectName("title");
        title.setGeometry(new QRect(170, 10, 231, 81));
        
        fpl = new QLabel(widget);
        fpl.setObjectName("fpl");
        fpl.setGeometry(new QRect(110, 280, 131, 31));
        
        secondtime = new QTimeEdit(widget);
        secondtime.setObjectName("secondtime");
        secondtime.setGeometry(new QRect(300, 310, 121, 31));
        secondtime.setMaximumTime(new QTime(17, 59, 59));
        secondtime.setMinimumTime(new QTime(6, 0, 0));
        
        firstTime = new QTimeEdit(widget);
        firstTime.setObjectName("firstTime");
        firstTime.setGeometry(new QRect(110, 310, 121, 31));
        firstTime.setMaximumTime(new QTime(17, 59, 59));
        firstTime.setMinimumTime(new QTime(6, 0, 0));
        
        spl = new QLabel(widget);
        spl.setObjectName("spl");
        spl.setGeometry(new QRect(300, 280, 121, 31));
        
        fourthtime = new QTimeEdit(widget);
        fourthtime.setObjectName("fourthtime");
        fourthtime.setGeometry(new QRect(300, 400, 121, 31));
        fourthtime.setMaximumTime(new QTime(17, 59, 59));
        fourthtime.setMinimumTime(new QTime(6, 0, 0));
        
        thirdtime = new QTimeEdit(widget);
        thirdtime.setObjectName("thirdtime");
        thirdtime.setGeometry(new QRect(110, 400, 121, 31));
        thirdtime.setMaximumTime(new QTime(17, 59, 59));
        thirdtime.setMinimumTime(new QTime(6, 0, 0));
        
        tpl = new QLabel(widget);
        tpl.setObjectName("tpl");
        tpl.setGeometry(new QRect(110, 370, 121, 31));
        fopl = new QLabel(widget);
        fopl.setObjectName("fopl");
        fopl.setGeometry(new QRect(300, 370, 121, 31));
        retranslateUi(Dialog);
        buttonBox.accepted.connect(this, "accept()");
        buttonBox.rejected.connect(Dialog, "reject()");

        dialog = Dialog;
        Dialog.connectSlotsByName();
    } // setupUi
    
    public void accept(){
    	Controller.getInstance().hello(this.durEdit.text());
    	this.dialog.close();
    }

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        buttonBox.raise();
        startEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        endEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        lunchStartEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        lunchEndEdit.setDisplayFormat(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "h:mm AP", null));
        startLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "School Start time:", null));
        endLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "School End time:", null));
        durLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Period Duration:", null));
        graceLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Grace Period:", null));
        lustartLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Lunch Start:", null));
        lunEndLabel.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Lunch End:", null));
        title.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Configuration Settings", null));
        fpl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "First Period:", null));
        spl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Second Period:", null));
        tpl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Third Period:", null));
        fopl.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fourth Period:", null));
    } // retranslateUi

}

