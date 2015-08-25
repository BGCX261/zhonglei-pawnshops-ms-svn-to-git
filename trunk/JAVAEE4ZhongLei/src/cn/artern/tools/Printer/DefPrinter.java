package cn.artern.tools.Printer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

import cn.artern.tools.Interface.DrawCurrentPageText;
import cn.artern.tools.Interface.Printer;

public class DefPrinter implements Printable, Printer {

	private int PAGES = 1;

	private DrawCurrentPageText drawCurrentPageText;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.artern.tools.Printer.Printer#print(java.awt.Graphics,
	 * java.awt.print.PageFormat, int)
	 */
	public int print(Graphics g, PageFormat pf, int page)
			throws PrinterException {
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.black);
		if (page >= PAGES)
			return Printable.NO_SUCH_PAGE;
		g2.translate(pf.getImageableX(), pf.getImageableY());
		drawCurrentPageText.draw(g2, pf, page, this);
		return Printable.PAGE_EXISTS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.artern.tools.Printer.Printer#getPAGES()
	 */
	public int getPAGES() {
		return PAGES;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.artern.tools.Printer.Printer#setPAGES(int)
	 */
	public void setPAGES(int pages) {
		PAGES = pages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.artern.tools.Printer.Printer#setDrawCurrentPageText(cn.artern.tools
	 * .Interface.DrawCurrentPageText)
	 */
	public void setDrawCurrentPageText(DrawCurrentPageText drawCurrentPageText) {
		this.drawCurrentPageText = drawCurrentPageText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.artern.tools.Printer.Printer#printWithoutAsk()
	 */
	public void printWithoutAsk() {
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
	}
}
