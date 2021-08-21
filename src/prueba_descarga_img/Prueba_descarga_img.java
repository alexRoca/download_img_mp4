/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_descarga_img;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author User
 */
public class Prueba_descarga_img {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws MalformedURLException, IOException*/ {
        
        try {
            URL url;
            url = new URL("https://img.redbull.com/images/c_limit,w_1500,h_1000,f_auto,q_auto/redbullcom/2017/07/05/a9713c80-0f5a-475b-bcc6-5d8ea19f0f20/magic-the-gathering.jpg");
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            int contador=0;
            while (-1!=(n=in.read(buf)))
            {
               out.write(buf, 0, n);
               
               contador++;
               System.out.println(contador);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();
            
            FileOutputStream fos = new FileOutputStream("D://imagen_prueba.jpg");
            fos.write(response);
            fos.close();
            
            System.out.println("se descargo con exito");
        } catch (IOException e) {
            System.out.println("error con descarga");
        }
        
        
    }
    
}
