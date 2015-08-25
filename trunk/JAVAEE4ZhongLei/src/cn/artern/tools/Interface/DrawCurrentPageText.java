package cn.artern.tools.Interface;

import java.awt.Graphics2D;
import java.awt.print.PageFormat;

public interface DrawCurrentPageText {

	public void draw(Graphics2D g2, PageFormat pf, int page, Printer defP);

	public int getPagesCount(String curStr, Printer defP);

}
