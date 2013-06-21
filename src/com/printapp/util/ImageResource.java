package com.printapp.util;

import javax.swing.*;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: nasgor
 * Date: 6/17/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageResource {
    public static ImageIcon getImageIcon(String imageName) {
        try {
            URL imgURL = URL.class.getResource("/com/printapp/img/" +
                    imageName);

            return new MyImageIcon(imgURL);
        } catch (Exception e) {
        }
        return null; // crazy compiler requires it, on't remove
    }

    public static class MyImageIcon extends ImageIcon {
        URL url;

        private MyImageIcon(URL url) {
            super(url);
            this.url = url;
        }

        public URL getUrl() {
            return url;
        }
    }
}
