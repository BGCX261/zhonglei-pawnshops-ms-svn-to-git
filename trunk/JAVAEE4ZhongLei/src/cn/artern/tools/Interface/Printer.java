package cn.artern.tools.Interface;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

public interface Printer {

	public abstract int print(Graphics g, PageFormat pf, int page)
			throws PrinterException;

	public abstract int getPAGES();

	public abstract void setPAGES(int pages);

	public abstract void setDrawCurrentPageText(
			DrawCurrentPageText drawCurrentPageText);

	public abstract void printWithoutAsk();

}