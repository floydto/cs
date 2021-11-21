/*
 * Copyright (c) Petr Skoda, 2002
 * This source code can be used, modified and distributed without any restrictions.
 */

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

/**
 * ImageHelper contains methods for simple loading of images into memory.
 * The image is fully loaded before method returns.
 * <p>
 * ImageHelper can be used also inside applets and BlueJ IDE.<br>
 * Compatible with JRE 1.3 and later versions.
 * <p>
 * Supported formats: GIF, JPG and PNG
 */
public class ImageHelper {
	private static Component comp; // aux comp for class loading and media tracking
	private static MediaTracker tracker; // tracker of image loading progress

	/*
	 * This class can not be instantiated from outside.
	 */
	private ImageHelper() {
	}

	/*
	 * Static initializer.
	 */
	static {
		comp = new Component() {
		};
		tracker = new MediaTracker(comp);
	}

	/**
	 * Creates image from resource pathname.
	 * 
	 * Resources are part of application (stored in project folder or 
	 * packed into single jar together with class files).
	 * <p>
	 * The resource name is platform independent pathname separated by '/'.
	 * The resource is looked up by corresponding classloader.<br>
	 * Relative resource pathnames are resolved against this class, it means that package
	 * name of this class is prepended and '.' is replaced by '/'.<br>
	 * Absolute resource pathnames start with '/' - denoting root of corresponding package hierarchy.
	 * <p> 
	 * This method waits until the image is fully loaded. Returns null if image can
	 * not be loaded.
	 *
	 * @param name  resource pathname to load image from; absolute or relative.
	 * @return  instance of Image created from resource pathname; null if error.
	 */
	public static Image getImageResource(String name) {
		URL url;
		try {
			url = comp.getClass().getResource(name);
		} catch (Exception ex) {
			System.err.println(
				"Image resource " + name + " can not be found. (Exception: " + ex + ")");
			return null;
		}
		return getImage(url);
	}

	/**
	 * Creates image from arbitrary URL.
	 * <p>
	 * This method waits until the image is fully loaded. Returns null if image can
	 * not be loaded.
	 *
	 * @param url  URL to load image from.
	 * @return  instance of Image created from source URL; null if error.
	 */
	public static Image getImage(URL url) {
		synchronized (comp) {
			Image image;
			try {
				image = Toolkit.getDefaultToolkit().getImage(url);
				tracker.addImage(image, 0);
			} catch (Exception ex) {
				System.err.println(
					"Image " + url.getPath() + " can not be loaded. (Exception: " + ex + ")");
				return null;
			}
			try {
				tracker.waitForAll();
			} catch (InterruptedException e) {
			}
			if (tracker.isErrorAny()) {
				System.err.println("Image " + url.getPath() + " can not be loaded.");
				tracker.removeImage(image);
				return null;
			} else {
				tracker.removeImage(image);
				return image;
			}
		}
	}
}
