package Until;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageHelper {

	
	    // array of supported extensions (use a List if you prefer)
	     final String[] EXTENSIONS = new String[]{
	        "gif", "png", "bmp" // and other formats you need
	    };
	    
	    final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

	        @Override
	        public boolean accept(final File dir, final String name) {
	            for (final String ext : EXTENSIONS) {
	                if (name.endsWith("." + ext)) {
	                    return (true);
	                }
	            }
	            return (false);
	        }
	    };
	    
	    public ArrayList<Image> getAllImagesFromDirectory(String path){
	    	File dir = new File(path);
	    	ArrayList<Image>images=new ArrayList<>();
	    	 if (dir.isDirectory()) { // make sure it's a directory
		            for (final File f : dir.listFiles(IMAGE_FILTER)) {
		                BufferedImage img = null;

		                try {
		                    img = ImageIO.read(f);
		                    images.add(img);
		                    
		                } catch (final IOException e) {
		               }
		            }
		        }
	    	return images;
	    	
	    }

	    
}
