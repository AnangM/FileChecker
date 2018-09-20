/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filechecksum;

import java.io.FileInputStream;
import java.security.MessageDigest;
/**
 *
 * @author AnangM
 */
public class Hash {
    String generate(String dataFile, String hashType){
        String hash = null;
        try{
        String file = dataFile;
        FileInputStream fis = new FileInputStream(file);
        System.out.println("File : " + file);
        MessageDigest md = MessageDigest.getInstance(hashType);
        byte[] dataBytes = new byte[1024];
        
        int nRead = 0;
        
        while((nRead = fis.read(dataBytes)) != -1){
            md.update(dataBytes, 0, nRead);
        }
        
        byte[] mdBytes = md.digest();
        //System.out.println(mdBytes.toString());
        StringBuffer sb = new StringBuffer("");
        for(int i = 0;i < mdBytes.length;i++){
            sb.append(Integer.toString((mdBytes[i] & 0xff)+0x100,16).substring(1));
        }
        
        hash = sb.toString();
        System.out.println(hashType + " : " + hash);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
        return hash;
    }
}
