/**
 * 
 */
package Service;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author Jodan Bustos
 *
 */
public class FiltreFichier extends FileFilter {

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File fich) {
		
		/* accepte les repertoires. */
		boolean reponse = fich.isDirectory() ; 
		if (!reponse)
		{	/* recherche de l’extension. */
			int pos = fich.getAbsolutePath().lastIndexOf(".");
			String extension = fich.getAbsolutePath().substring(pos+1) ;
			reponse = extension.equals("pers") ;
		}
		return reponse ;
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "*.pers";
	}

}
