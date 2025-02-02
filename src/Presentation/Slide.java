package Presentation;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/** <p>A slide. This class has drawing functionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	protected String title; //The title is kept separately
	protected Vector<SlideItem> items; //The SlideItems are kept in a vector

	public Slide() {
		items = new Vector<SlideItem>();
	}

	//Add a Presentation.SlideItem
	public void append(SlideItem anItem) {
		items.addElement(anItem);
	}

	//Return the title of a slide
	public String getTitle() {
		return title;
	}

	//Change the title of a slide
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	//Create a Presentation.TextItem out of a String and add the Presentation.TextItem
	public void append(int level, String message) {
		append(new TextItem(level, message));
	}

	//Returns the Presentation.SlideItem
	public SlideItem getSlideItem(int number) throws OutOfBoundsException{
		try {
			//Error for if an incorrect slide number is given
			if (this.items.contains(items.elementAt(number))){
				throw new OutOfBoundsException();
			}
			return (SlideItem) items.elementAt(number);

		} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	//Return all the SlideItems in a vector
	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	//Returns the size of a slide
	public int getSize() {
		return items.size();
	}

	//Draws the slide
	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
	    int y = area.y;
	//The title is treated separately
	    SlideItem slideItem = new TextItem(0, getTitle());
	    Style style = Style.getStyle(slideItem.getLevel());
	    slideItem.draw(area.x, y, scale, g, style, view);
	    y += slideItem.getBoundingBox(g, view, scale, style).height;
	    for (int number=0; number<getSize(); number++) {
	      slideItem = (SlideItem)getSlideItems().elementAt(number);
	      style = Style.getStyle(slideItem.getLevel());
	      slideItem.draw(area.x, y, scale, g, style, view);
	      y += slideItem.getBoundingBox(g, view, scale, style).height;
	    }
	}

	//Returns the scale to draw a slide
	protected float getScale(Rectangle area) {
		return Math.min(((float)area.width) / ((float)WIDTH), ((float)area.height) / ((float)HEIGHT));
	}
}
