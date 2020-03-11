import java.io.*;
import groovy.io.*;
import java.util.Calendar.*;
import java.text.SimpleDateFormat

@NonCPS
def call(Map config=[:]){
    def now = new Date();
    def fmt = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    echo "Date and Time IS: " + fmt.format(date);

    def dir = new File(pwd());
    
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
    
    if (config.changes != "false"){
    	echo "changes";
    }    
}