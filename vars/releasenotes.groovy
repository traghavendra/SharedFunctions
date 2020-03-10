import java.io.*;
import groovy.io.*;

echo "TEST***";

def call(Map config=[:]){
    
    println('***TEST');
    def dir = new File(pwd());
    
    echo "Preparing releasenotes.txt at " + dir;
    
   
    new File(dir.path + '/releasenotes.txt').withWriter('utf-8') 
    { 
    	writer -> 
                dir.eachFileRecurse(FileType.ANY){ file ->
    		if (file.isDirectory()){
    			writer.writeLine(file.name);            
    		}
    		else
    		{
    			writer.writeLine('\t' + file.name + '\t' + file.length());
    		}
           }
    }
}