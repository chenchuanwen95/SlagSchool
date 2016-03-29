package cn.ccw.slagschool.utils;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by 陈传稳_95 on 2016/3/29.
 */
public class FileIsSaveUtils {
    /**
     *
     * @param mContext
     * @return 判断当前的目录文件是否存在
     */
    public static boolean isSaveFile(Context mContext){
        File mFile = new File(mContext.getExternalFilesDir("isFileSave")+"/isFile.txt") ;
        if(mFile.exists()&&mFile.isFile()){
            return true ;
        }else{
            try {
                mFile.createNewFile() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true ;
    }
    public static void setFiles(Context mContext,String mString){
        File mFile = new File(mContext.getExternalFilesDir("isFileSave")+"/isFile.txt") ;
        OutputStream out = null;
        try {
            out = new FileOutputStream(mFile) ;
            out.write(mString.getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getFiles(Context mContext){
        File mFile = new File(mContext.getExternalFilesDir("isFileSave")+"/isFile.txt") ;
        InputStream in = null ;
        String text = "" ;
        try {
            in = new FileInputStream(mFile) ;
            byte[] mbyte = new byte[(int)mFile.length()] ;
            in.read(mbyte) ;
            text = new String(mbyte) ;
            return text ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text ;
    }
}
