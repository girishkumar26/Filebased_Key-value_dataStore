import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import org.json.*;
public class FileStore{
 public static String doSave(String key, File dir , JSONobject data){
	 
        String fileName = MD5Utils.md5(key);
        boolean status = writeToFile(dir, fileName, data);
		if(status == true)
		  return "value Saved successfully");
	    else 
		  return "Something error in storing data";
    }

    public static String doRead(File dir,String key){
        String fileName = MD5Utils.md5(key);
        File file = new File(dir,fileName);
        if(!file.exists())
            return null;
       return readFile(dir,fileName);
    }

    public static String readFile(File dir,String fileName){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            StringBuffer sb = new StringBuffer();
            fileReader = new FileReader(new File(dir,fileName));
            bufferedReader = new BufferedReader(fileReader);
            String read;
            while ((read = bufferedReader.readLine())!=null){
                sb.append(read);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean writeToFile(File dir, String fileName, String data){
		// to check whether the size of the file exceeding 1 gb or not
		if(dir.length() >= 1000000000){
			
			return false;
		}
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            if(!dir.exists())
                dir.mkdirs();
            fileWriter = new FileWriter(new File(dir,fileName));
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data,0,data.length());
            bufferedWriter.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}