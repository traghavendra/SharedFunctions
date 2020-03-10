import java.io.*;
import groovy.io.*;

def call(Map config=[:]){
    def dir = new File(pwd());
    
    echo "Preparing releasenotes.txt at " + dir;
    
    new File('var/home/jenkins_home/workspace/HelloPipeline/releasenotes.txt').withWriter('utf-8') 
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