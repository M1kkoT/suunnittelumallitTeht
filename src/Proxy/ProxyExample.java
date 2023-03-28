package Proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyExample {
    /**
     * Test method
     */
    public static void main(final String[] arguments) {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");
        Image image3 = new ProxyImage("HiRes_10MB_Photo3");
        Image image4 = new ProxyImage("HiRes_10MB_Photo4");

        List<Image> photobook = new ArrayList<>();

        photobook.add(image1);
        photobook.add(image2);
        photobook.add(image3);
        photobook.add(image4);

        //tiedot
        for(Image i : photobook){
            i.showData();
        }

        //selaa kansiota
        for(Image i : photobook){
            i.displayImage();
        }

    }

}
