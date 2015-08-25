package cn.artern.tools.Printer.TestTool;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Properties;
import java.awt.font.FontRenderContext;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

import cn.artern.tools.Printer.TestTool.common.SystemProperties;

import java.io.*;

public class PrintTest extends JFrame implements ActionListener, Printable {
	private JButton printTextButton = new JButton("Print Text");
	private JButton previewButton = new JButton("Print Preview");
	private JButton printText2Button = new JButton("Print Text2");
	private JButton printFileButton = new JButton("Print File");
	private JButton printFrameButton = new JButton("Print Frame");
	private JButton exitButton = new JButton("Exit");
	private JLabel tipLabel = new JLabel("");
	private JTextArea area = new JTextArea();
	private JScrollPane scroll = new JScrollPane(area);
	private JPanel buttonPanel = new JPanel();

	private int PAGES = 0;
	private String printStr;

	public PrintTest() {
		this.setTitle("Print Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int) ((SystemProperties.SCREEN_WIDTH - 800) / 2),
				(int) ((SystemProperties.SCREEN_HEIGHT - 600) / 2), 800, 600);
		initLayout();
	}

	private void initLayout() {
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(scroll, BorderLayout.CENTER);
		printTextButton.setMnemonic('P');
		printTextButton.addActionListener(this);
		buttonPanel.add(printTextButton);
		previewButton.setMnemonic('v');
		previewButton.addActionListener(this);
		buttonPanel.add(previewButton);
		printText2Button.setMnemonic('e');
		printText2Button.addActionListener(this);
		buttonPanel.add(printText2Button);
		printFileButton.setMnemonic('i');
		printFileButton.addActionListener(this);
		buttonPanel.add(printFileButton);
		printFrameButton.setMnemonic('F');
		printFrameButton.addActionListener(this);
		buttonPanel.add(printFrameButton);
		exitButton.setMnemonic('x');
		exitButton.addActionListener(this);
		buttonPanel.add(exitButton);
		this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == printTextButton)
			printTextAction();
		else if (src == previewButton)
			previewAction();
		else if (src == printText2Button)
			printText2Action();
		else if (src == printFileButton)
			printFileAction();
		else if (src == printFrameButton)
			printFrameAction();
		else if (src == exitButton)
			exitApp();
	}

	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.black);
		if (page >= PAGES)
			return Printable.NO_SUCH_PAGE;
		g2.translate(pf.getImageableX(), pf.getImageableY());
		drawCurrentPageText(g2, pf, page);
		return Printable.PAGE_EXISTS;
	}

	/*
	 * private void drawCurrentPageText(Graphics2D g2, PageFormat pf, int page)
	 * { Font f = area.getFont(); String s = getDrawText(printStr)[page]; String
	 * drawText; float ascent = 16; int k, i = f.getSize(), lines = 0;
	 * while(s.length() > 0 && lines < 54) { k = s.indexOf('\n'); if (k != -1) {
	 * lines += 1; drawText = s.substring(0, k); g2.drawString(drawText, 0,
	 * ascent); if (s.substring(k + 1).length() > 0) { s = s.substring(k + 1);
	 * ascent += i; } } else { lines += 1; drawText = s; g2.drawString(drawText,
	 * 0, ascent); s = ""; } } }
	 */

	/*
	 * private void drawCurrentPageText(Graphics2D g2, PageFormat pf, int page){
	 * 
	 * g2.drawString("天津市众磊典当有限责任公司", 30,47); g2.drawString("天津市河西区聚鑫园底商1号",
	 * 30,61); g2.drawString("4006-116655", 325,47); g2.drawString("安然",30,76);
	 * g2.drawString("15822884286",325,76);
	 * g2.drawString("天津市南开区红旗南路263号，公寓城3好楼2门102 1室".substring(0,18),30,90);
	 * g2.drawString("安然",325,90); g2.drawString("身份证",30,105);
	 * g2.drawString("130124198711100035",325,105);
	 * 
	 * 
	 * g2.drawString("金戒指",0,153); g2.drawString("200 克", 100, 153);
	 * g2.drawString("1", 185, 153); g2.drawString("1000", 200, 153);
	 * g2.drawString(0.045100+"", 255, 153); g2.drawString("金戒指",0,168);
	 * g2.drawString("200 克", 100, 168); g2.drawString("1", 185, 168);
	 * g2.drawString("1000", 200, 168); g2.drawString(0.045100+"", 255, 168);
	 * g2.drawString("金戒指",0,183); g2.drawString("200 克", 100, 183);
	 * g2.drawString("1", 185, 183); g2.drawString("1000", 200, 183);
	 * g2.drawString(0.045100+"", 255, 183); String a="8888888888"; int k=439;
	 * for(char b:a.toCharArray()){ g2.drawString(b+"", k, 183); k=k-16; }
	 * g2.drawString("零壹贰叁肆伍陆柒捌玖拾佰", 0, 199); g2.drawString("零壹贰叁肆伍陆柒捌玖拾佰", 0,
	 * 214); g2.drawString("1234567", 218, 214);
	 * 
	 * g2.drawString("2008   10   10", 0, 244); g2.drawString("2008   10   10",
	 * 140, 244); String
	 * s[]="零壹贰叁肆伍陆柒捌玖拾佰\n零壹贰叁肆伍陆柒捌玖拾佰\n零壹贰叁肆伍陆柒捌玖拾佰\n零壹贰叁肆伍陆柒捌玖拾佰\n"
	 * .split("\n"); if(s.length>4) s[3]+="  (省略)"; for(int i=0;i<4;i++){
	 * g2.drawString(s[i], 0, 259+i12); }
	 * 
	 * g2.drawString("22",50,312); g2.drawString("2008    10    10 ",359,312);
	 * g2.drawString("20:59:46 ",359,324);
	 * 
	 * }
	 */

	private void drawCurrentPageText(Graphics2D g2, PageFormat pf, int page) {
		g2.drawString("天津市众磊典当有限责任公司", 30, 25);
		g2.drawString("06016847", 325, 25);
		g2.drawString("安然", 30, 40);
		g2.drawString("安然", 325, 40);
		g2.drawString("零壹贰叁肆伍陆柒捌玖拾佰", 80, 55);
		g2.drawString("零壹贰叁肆伍陆柒捌玖拾佰", 80, 70);
		g2.drawString("123456789", 325, 55);
		g2.drawString("123456789", 325, 70);
		g2.drawString("2008    10    10", 30, 112);
		g2.drawString("2008    10    10", 190, 112);
		g2.drawString("4.5", 0, 128);
		g2.drawString("22", 100, 158);
		g2.drawString("2008    10    10 ", 300, 158);
		g2.drawString("20:59:46 ", 300, 170);

	}

	public String[] getDrawText(String s) {
		String[] drawText = new String[PAGES];
		for (int i = 0; i < PAGES; i++)
			drawText[i] = "";

		int k, suffix = 0, lines = 0;
		while (s.length() > 0) {
			if (lines < 54) {
				k = s.indexOf('\n');
				if (k != -1) {
					lines += 1;
					drawText[suffix] = drawText[suffix] + s.substring(0, k + 1);
					if (s.substring(k + 1).length() > 0)
						s = s.substring(k + 1);
				} else {
					lines += 1;
					drawText[suffix] = drawText[suffix] + s;
					s = "";
				}
			} else {
				lines = 0;
				suffix++;
			}
		}
		return drawText;
	}

	public int getPagesCount(String curStr) {
		int page = 0;
		int position, count = 0;
		String str = curStr;
		while (str.length() > 0) {
			position = str.indexOf('\n');
			count += 1;
			if (position != -1)
				str = str.substring(position + 1);
			else
				str = "";
		}

		if (count > 0)
			page = count / 54 + 1;

		return page;
	}

	private void printTextAction() {
		printStr = area.getText().trim();
		if (printStr != null && printStr.length() > 0) {
			PAGES = getPagesCount(printStr);
			PrinterJob myPrtJob = PrinterJob.getPrinterJob();
			PageFormat pageFormat = myPrtJob.defaultPage();
			myPrtJob.setPrintable(this, pageFormat);
			if (myPrtJob.printDialog()) {
				try {
					myPrtJob.print();
				} catch (PrinterException pe) {
					pe.printStackTrace();
				}
			}
		} else {
			JOptionPane.showConfirmDialog(null,
					"Sorry, Printer Job is Empty, Print Cancelled!", "Empty",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void previewAction() {
		printStr = area.getText().trim();
		PAGES = getPagesCount(printStr);
		(new PrintPreviewDialog(this, "Print Preview", true, this, printStr))
				.setVisible(true);
	}

	private void printText2Action() {
		printStr = area.getText().trim();
		if (printStr != null && printStr.length() > 0) {
			PAGES = getPagesCount(printStr);
			DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
			PrintService printService = PrintServiceLookup
					.lookupDefaultPrintService();
			DocPrintJob job = printService.createPrintJob();
			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			DocAttributeSet das = new HashDocAttributeSet();
			Doc doc = new SimpleDoc(this, flavor, das);

			try {
				job.print(doc, pras);
			} catch (PrintException pe) {
				pe.printStackTrace();
			}
		} else {
			JOptionPane.showConfirmDialog(null,
					"Sorry, Printer Job is Empty, Print Cancelled!", "Empty",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
		}
	}

	private void printFileAction() {
		JFileChooser fileChooser = new JFileChooser(SystemProperties.USER_DIR);
		// fileChooser.setFileFilter(new com.szallcom.file.JavaFilter());
		int state = fileChooser.showOpenDialog(this);
		if (state == fileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			PrintService printService[] = PrintServiceLookup
					.lookupPrintServices(flavor, pras);
			PrintService defaultService = PrintServiceLookup
					.lookupDefaultPrintService();
			PrintService service = ServiceUI.printDialog(null, 200, 200,
					printService, defaultService, flavor, pras);
			if (service != null) {
				try {
					DocPrintJob job = service.createPrintJob();
					FileInputStream fis = new FileInputStream(file);
					DocAttributeSet das = new HashDocAttributeSet();
					Doc doc = new SimpleDoc(fis, flavor, das);
					job.print(doc, pras);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void printFrameAction() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Properties props = new Properties();
		props.put("awt.print.printer", "durango");
		props.put("awt.print.numCopies", "2");
		if (kit != null) {
			PrintJob printJob = kit.getPrintJob(this, "Print Frame", props);
			if (printJob != null) {
				Graphics pg = printJob.getGraphics();
				if (pg != null) {
					try {
						this.printAll(pg);
					} finally {
						pg.dispose();
					}
				}
				printJob.end();
			}
		}
	}

	private void exitApp() {
		this.setVisible(false);
		this.dispose();
		System.exit(0);
	}

	public static void main(String[] args) {
		(new PrintTest()).setVisible(true);
	}
}
