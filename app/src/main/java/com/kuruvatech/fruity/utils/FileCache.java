package com.kuruvatech.fruity.utils;

/**
 * Created by dganeshappa on 7/5/2016.
 */
import java.io.File;
import android.content.Context;

public class FileCache {

    private File cacheDir;

    public FileCache(Context context){

        //Find the dir at SDCARD to save cached images

        if (true)
        {
            //if SDCARD is mounted (SDCARD is present on device and mounted)
            cacheDir = new File(
                    context.getFilesDir().getPath(),"LazyList");
        }
//        else
//        {
//            // if checking on simulator the create cache dir in your application context
//            cacheDir=context.getCacheDir();
//        }

        if(!cacheDir.exists()){
            // create cache dir in your application context
            cacheDir.mkdirs();
        }
    }

    public File getFile(String url){
        //Identify images by hashcode or encode by URLEncoder.encode.
        String filename=String.valueOf(url.hashCode());

        File f = new File(cacheDir, filename);
        return f;

    }

    public void clear(){
        // list all files inside cache directory
        File[] files=cacheDir.listFiles();
        if(files==null)
            return;
        //delete all cache directory files
        for(File f:files)
            f.delete();
    }

}
